package com.example.per_3sefriansyah_3tie.pertemuan4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.per_3sefriansyah_3tie.MainActivity
import com.example.per_3sefriansyah_3tie.databinding.ActivityFourthBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class FourthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFourthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        val name = intent.getStringExtra("name")
        val from = intent.getStringExtra("from")
        val age = intent.getIntExtra("age", 0)
        Log.e("Data Intent", "Nama: $name , Usia: $age, Asal: $from")

        if (!name.isNullOrEmpty() || !from.isNullOrEmpty()) {
            binding.tvIntentData.text = "Data Intent: Nama=$name, Asal=$from, Usia=$age"
        } else {
            binding.tvIntentData.text = ""
        }

        binding.btn1.setOnClickListener {
            Toast.makeText(this, "Tombol Buy diklik!", Toast.LENGTH_SHORT).show()
        }

        binding.btnKembali.setOnClickListener {
            if (isTaskRoot) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            finish()
        }

        binding.btnShowAlertDialog.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin melanjutkan?")
                .setPositiveButton("Ya") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("Info Dialog", "Anda memilih Ya!")
                    Toast.makeText(this, "Anda memilih Ya!", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                    Log.e("Info Dialog", "Anda memilih Tidak!")
                    Toast.makeText(this, "Anda memilih Batal!", Toast.LENGTH_SHORT).show()
                }
                .show()
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
