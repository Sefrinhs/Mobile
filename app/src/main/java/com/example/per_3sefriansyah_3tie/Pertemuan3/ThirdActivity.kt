package com.example.per_3sefriansyah_3tie.pertemuan3

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.per_3sefriansyah_3tie.databinding.ActivityThirdactivityBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityThirdactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        binding.btnKirim.setOnClickListener {
            val nomorTujuan = binding.inputNoTujuan.text.toString()
            val intent = Intent(this, ThirdResultActivity::class.java).apply {
                putExtra("EXTRA_NOMOR_TUJUAN", nomorTujuan)
            }
            startActivity(intent)

            Toast.makeText(
                this,
                "Pesan berhasil dikirim ke $nomorTujuan",
                Toast.LENGTH_SHORT
            ).show()
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
