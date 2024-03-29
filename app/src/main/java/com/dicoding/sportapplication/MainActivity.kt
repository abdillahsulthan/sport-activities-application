package com.dicoding.sportapplication

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.sportapplication.databinding.ActivityMainBinding
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Ukor>()
    private lateinit var rvUkors: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "UKOR Fasilkom UI"

        rvUkors = binding.rvUkors
        rvUkors.setHasFixedSize(true)

        initializeLayoutManager()
        list.addAll(listUkors)
        showRecyclerList()
    }

    private fun initializeLayoutManager() {
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvUkors.layoutManager = GridLayoutManager(this, 2)
        } else {
            rvUkors.layoutManager = LinearLayoutManager(this)
        }
    }

    private fun showRecyclerList() {
        val listUkorAdapter = ListUkorAdapter(list)
        rvUkors.adapter = listUkorAdapter
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        initializeLayoutManager()
    }

    private val listUkors: ArrayList<Ukor>
        get() {
            val dataName = resources.getStringArray(R.array.data_name)
            val dataDescription = resources.getStringArray(R.array.data_description)
            val dataPhoto = resources.getStringArray(R.array.data_photo)
            val dataSupervisor = resources.getStringArray(R.array.data_supervisor)
            val dataLocation = resources.getStringArray(R.array.data_location)
            val listUkor = ArrayList<Ukor>()
            for (i in dataName.indices) {
                val ukor = Ukor(
                    name = dataName[i],
                    description = dataDescription[i],
                    supervisor = dataSupervisor[i],
                    location = dataLocation[i],
                    photo = dataPhoto[i]
                )
                listUkor.add(ukor)
            }
            return listUkor
        }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_navbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.profile -> {
                startActivity(Intent(this, AboutMeActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}