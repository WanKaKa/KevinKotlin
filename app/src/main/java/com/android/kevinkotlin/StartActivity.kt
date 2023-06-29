package com.android.kevinkotlin

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("HelloWord")

        findViewById<TextView>(R.id.title).setOnClickListener {
            Log.d("WanKaiLLog", "Ha")
            Toast.makeText(this, "YuKi HaHaHa", Toast.LENGTH_SHORT).show()
        }
    }
}