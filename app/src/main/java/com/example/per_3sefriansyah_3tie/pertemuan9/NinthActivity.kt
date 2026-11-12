package com.example.per_3sefriansyah_3tie.pertemuan9

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColorInt
import com.example.per_3sefriansyah_3tie.databinding.ActivityNinthBinding
import com.google.android.material.chip.Chip

class NinthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNinthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNinthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        binding.btnLogin.setOnClickListener {
            val initialColor = binding.btnLogin.backgroundTintList?.defaultColor
                ?: "#6200EE".toColorInt()
            val targetColor = "#4CAF50".toColorInt()

            val colorAnim = ValueAnimator.ofObject(
                ArgbEvaluator(),
                initialColor,
                targetColor,
                initialColor
            )
            colorAnim.duration = 600
            colorAnim.addUpdateListener { animator ->
                binding.btnLogin.backgroundTintList = ColorStateList.valueOf(animator.animatedValue as Int)
            }
            colorAnim.start()

            val email = binding.etEmail.text?.toString() ?: ""
            if (email.isEmpty()) {
                binding.textInputLayout.error = "Email tidak boleh kosong!"
            } else {
                binding.textInputLayout.error = null
                Toast.makeText(this, "Login dengan $email", Toast.LENGTH_SHORT).show()
            }
        }

        binding.chipGroupFilter.setOnCheckedStateChangeListener { group, checkedIds ->
            val selectedChipId = checkedIds.firstOrNull()
            if (selectedChipId != null) {
                val chip = group.findViewById<Chip>(selectedChipId)
                if (chip != null) {
                    Toast.makeText(this, "Filter: ${chip.text}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
