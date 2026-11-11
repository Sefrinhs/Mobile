package com.example.per_3sefriansyah_3tie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.per_3sefriansyah_3tie.Home.FragmentHome

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FragmentHome())
                .commit()
        }
    }
}
