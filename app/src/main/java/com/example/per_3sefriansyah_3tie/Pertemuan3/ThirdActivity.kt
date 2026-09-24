package com.example.per_3sefriansyah_3tie.Pertemuan3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.per_3sefriansyah_3tie.databinding.ActivityThirdactivityBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityThirdactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnKirim.setOnClickListener {
            val intent = Intent(this, ThirdResultActivity::class.java)
            startActivity(intent)
            val nomorTujuan = binding.inputNoTujuan.text.toString()

            Toast.makeText(
                this,
                "Pesan berhasil dikirim ke $nomorTujuan",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}