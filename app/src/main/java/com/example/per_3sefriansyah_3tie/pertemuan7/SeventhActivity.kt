package com.example.per_3sefriansyah_3tie.pertemuan7

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.pertemuan_7.R

class SeventhActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seventh)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        toolbar.setNavigationIcon(
            androidx.appcompat.R.drawable.abc_ic_ab_back_material
        )

        toolbar.setNavigationOnClickListener {
            finish()
        }
    }
}