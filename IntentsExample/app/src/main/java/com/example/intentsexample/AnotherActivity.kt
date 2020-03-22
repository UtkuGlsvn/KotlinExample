package com.example.intentsexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class AnotherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another)
        val txtView = findViewById<TextView>(R.id.txtView);
        val bundle = intent.extras
        if(bundle!=null)
        {
            txtView.text=bundle.getString("text")
        }
    }
}
