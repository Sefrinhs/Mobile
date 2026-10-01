package com.example.per_3sefriansyah_3tie.pertemuan5

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.per_3sefriansyah_3tie.R
import com.example.per_3sefriansyah_3tie.databinding.ActivityFifthBinding
import com.example.per_3sefriansyah_3tie.pertemuan5.WebViewActivity

class FifthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFifthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityFifthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(
                WindowInsetsCompat.Type.systemBars()
            )

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }

        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            title = "Activity Fifth"
            subtitle = "Ini adalah subtitle"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.outline_arrow_back_ios_new_24)
        }

        binding.btnWebView.setOnClickListener {
            startActivity(
                Intent(this, WebViewActivity::class.java)
            )
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }

            R.id.action_search -> {
                Toast.makeText(
                    this,
                    "Search Clicked",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }

            R.id.action_settings -> {
                Toast.makeText(
                    this,
                    "Settings Clicked",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}