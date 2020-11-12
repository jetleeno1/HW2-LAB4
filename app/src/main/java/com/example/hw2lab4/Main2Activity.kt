package com.example.hw2lab4

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        findViewById<View>(R.id.btn_send).setOnClickListener { v: View? ->
            if (ed_drink.length() < 1) Toast.makeText(this@Main2Activity, "請輸入飲料名稱", Toast.LENGTH_SHORT).show() else {
                val b = Bundle()
                b.putString("drink", ed_drink.getText().toString())
                b.putString("sugar", (radioGroup.findViewById<View>(radioGroup.getCheckedRadioButtonId()) as RadioButton).text.toString())
                b.putString("ice", (radioGroup2.findViewById<View>(radioGroup2.getCheckedRadioButtonId()) as RadioButton).text.toString())
                setResult(RESULT_OK, Intent().putExtras(b))
                finish()
            }
        }
    }
}