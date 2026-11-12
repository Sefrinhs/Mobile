package com.example.per_3sefriansyah_3tie.pertemuan2

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.per_3sefriansyah_3tie.databinding.ActivitySecondBinding
import com.example.per_3sefriansyah_3tie.pertemuan4.FourthActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        binding.button2.setOnClickListener {
            val name = binding.editTextText2.text.toString().trim()
            if (name.isNotEmpty()) {
                Toast.makeText(this, "Halo $name!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Nama belum diisi", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnToFourth.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java).apply {
                putExtra("name", binding.editTextText2.text.toString().trim())
                putExtra("from", "Pertemuan 2")
                putExtra("age", 20)
            }
            startActivity(intent)
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
