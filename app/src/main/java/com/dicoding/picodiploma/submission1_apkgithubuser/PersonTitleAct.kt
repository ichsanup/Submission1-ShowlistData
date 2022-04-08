package com.dicoding.picodiploma.submission1_apkgithubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class PersonTitleAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_title)

        supportActionBar?.title = "Detail User"
        val person = intent.getParcelableExtra<Person>(MainActivity.INTENT_PARCELABLE) as Person
        val img_item_photo =  findViewById<ImageView>(R.id.img_item_photo)
        val textviewusername = findViewById<TextView>(R.id.textviewusername)
        val textviewname = findViewById<TextView>(R.id.textviewname)
        val textviewfollower = findViewById<TextView>(R.id.textviewfollower)
        val textviewfollowing = findViewById<TextView>(R.id.textviewfollowing)
        val textviewcompany = findViewById<TextView>(R.id.textviewcompany)
        val textviewlocation = findViewById<TextView>(R.id.textviewlocation)
        val textviewrepository = findViewById<TextView>(R.id.textviewrepository)


        img_item_photo.setImageResource(person?.avatar!!)
        textviewusername.text = person.username
        textviewname.text = person.name
        textviewfollower.text = person.follower
        textviewfollowing.text = person.following
        textviewcompany.text = person.company
        textviewlocation.text = person.location
        textviewrepository.text = person.repository
    }
}