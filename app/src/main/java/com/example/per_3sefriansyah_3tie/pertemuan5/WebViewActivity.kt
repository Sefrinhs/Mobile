package com.example.per_3sefriansyah_3tie.pertemuan5

import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.per_3sefriansyah_3tie.R
import com.example.per_3sefriansyah_3tie.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        binding = ActivityWebViewBinding.inflate(layoutInflater)
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

        // Mengatur WebView
        binding.webview.webViewClient = WebViewClient()

        binding.webview.settings.javaScriptEnabled = true

        binding.webview.loadUrl("https://merdeka.com")
    }

    // Tombol Back Android
    override fun onBackPressed() {
        if (binding.webview.canGoBack()) {
            binding.webview.goBack()
        } else {
            super.onBackPressed()
        }
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