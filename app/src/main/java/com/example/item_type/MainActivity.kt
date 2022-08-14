package com.example.item_type

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.sharedprfs.managers.PrefsManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    fun initView() {
        var save = findViewById<Button>(R.id.save)
        var load = findViewById<Button>(R.id.load)
        var edit = findViewById<EditText>(R.id.et_txt)
        var text = findViewById<TextView>(R.id.text)



        save.setOnClickListener {


            PrefsManager.getInstance(this).savedata("text", read(edit.text))
            Toast.makeText(this, "Save data", Toast.LENGTH_SHORT).show()
        }

        load.setOnClickListener {

           text.text= PrefsManager.getInstance(this).loaddata("text").toString()
            Toast.makeText(this, "Load data", Toast.LENGTH_SHORT).show()
        }

    }

    inline fun <reified T : Any>read(item:T): HashSet<T> {
        var set=HashSet<T>()

        set.add(item)



    return set
    }

}