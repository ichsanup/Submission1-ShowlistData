package com.dicoding.picodiploma.submission1_apkgithubuser

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    companion object {
        const val INTENT_PARCELABLE = "extra_user"
    }
    private lateinit var rvPerson: RecyclerView
    private val list =ArrayList<Person>()
    private fun showSelectedHero(person: Person){
        Toast.makeText(this, "Kamu Memilih" + person.company, Toast.LENGTH_SHORT).show()
        var intent = Intent(this@MainActivity, PersonTitleAct::class.java)
        intent.putExtra(INTENT_PARCELABLE, person)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Github Ichsan"

        rvPerson = findViewById(R.id.rv_person)
        rvPerson.setHasFixedSize(true)
        rvPerson.layoutManager = GridLayoutManager(this,2)
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvPerson.layoutManager = GridLayoutManager(this, 2)
        } else {
            rvPerson.layoutManager = LinearLayoutManager(this)
        }

        list.addAll(listPerson)
        showRecylerList()
    }
    private val listPerson: ArrayList<Person>
        get(){
            val dataName = resources.getStringArray(R.array.name)
            val dataUsername = resources.getStringArray(R.array.username)
            val dataAvatar = resources.obtainTypedArray(R.array.avatar)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataLocation = resources.getStringArray(R.array.location)
            val dataRepository = resources.getStringArray(R.array.repository)
            val dataFollower = resources.getStringArray(R.array.followers)
            val dataFollowing = resources.getStringArray(R.array.following)
            val listPerson = ArrayList<Person>()
            for (i in dataUsername.indices){
                val person = Person(dataUsername[i],dataName[i],dataAvatar.getResourceId(i, -1),
                    dataCompany[i],dataLocation[i],dataRepository[i],dataFollower[i],dataFollowing[i])
                listPerson.add(person)
            }
            return listPerson
        }

    private fun showRecylerList(){
        rvPerson.layoutManager = LinearLayoutManager(this)
        val listPersonAdapter = ListPersonAdapter(list)
        rvPerson.adapter = listPersonAdapter
        listPersonAdapter.setOnItemClickCallback(object : ListPersonAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Person) {
                showSelectedHero(data)
            }
        })
    }
}