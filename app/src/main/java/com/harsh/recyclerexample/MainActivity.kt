package com.harsh.recyclerexample

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.ActivityResult
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.Serializable

data class Person(val name: String, val age: Int): Serializable

class MainActivity : AppCompatActivity() {
    private val CODE = 100
    lateinit var rec:RecyclerView
    lateinit var contact:MutableList<Person>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rec = findViewById(R.id.recView)
        contact = createContacts()
        rec.adapter=ContactsAdapter(this,contact)
        rec.layoutManager = LinearLayoutManager(this)

    }

    private fun createContacts():MutableList<Person>{
        val contacts: MutableList<Person> = mutableListOf()
        for(i in 1..100)
            contacts.add(Person("Person $i",i))
        return contacts
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_values, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.add){
            val intent = Intent(this,Details::class.java)
            startActivityForResult(intent,CODE)
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == CODE && resultCode == Activity.RESULT_OK){
            val pers = data?.getSerializableExtra("person") as Person
            contact.add(1, pers)
            rec.adapter?.notifyDataSetChanged()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}