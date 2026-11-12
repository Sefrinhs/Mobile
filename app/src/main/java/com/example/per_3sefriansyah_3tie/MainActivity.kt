package com.example.per_3sefriansyah_3tie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.per_3sefriansyah_3tie.databinding.ActivityMainBinding
import com.example.per_3sefriansyah_3tie.home.FragmentHome

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FragmentHome())
                .commit()
        }
    }
}
