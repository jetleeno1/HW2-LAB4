package com.example.hw2lab4

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null) return
        if (requestCode == 1 && resultCode == RESULT_OK) {
            val b = data.extras
            tv_meal!!.text = String.format("飲料: %s\n\n甜度: %s\n\n冰塊: %s\n\n", b.getString("drink"),
                    b.getString("sugar"), b.getString("ice"))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.btn_choice).setOnClickListener { v: View? ->
            startActivityForResult(Intent(this@MainActivity, Main2Activity::class.java), 1)
        }
    }
}