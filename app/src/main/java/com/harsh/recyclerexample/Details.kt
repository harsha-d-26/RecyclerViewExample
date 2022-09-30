package com.harsh.recyclerexample

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class Details : AppCompatActivity() {
    lateinit var name: EditText
    lateinit var num: EditText
    lateinit var save: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        name = findViewById(R.id.name)
        num = findViewById(R.id.detail)
        save = findViewById(R.id.save)
        save.setOnClickListener { onclick(save) }

    }
    fun onclick(v:View){
        when(v){
            save -> {
                        intent = Intent(this, MainActivity::class.java)
                        val pName = name.text.toString()
                        val pNum = num.text.toString().toInt()
                        val person = Person(pName,pNum)
                        intent.putExtra("person",person)
                        setResult(Activity.RESULT_OK, intent)
                        finish()
                    }
        }
    }
}