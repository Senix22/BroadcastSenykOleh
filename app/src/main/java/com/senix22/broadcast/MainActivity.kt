package com.senix22.broadcast

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView1.setOnClickListener {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.mainActivity, SumFragment.newInstance())
                    .commit()
            startService(Intent(this, SumService::class.java))
        }

    }

}
