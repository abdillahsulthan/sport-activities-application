package com.dicoding.sportapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.dicoding.sportapplication.databinding.ActivityUkorDetailBinding

class UkorDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUkorDetailBinding

    companion object {
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESCRIPTION = "extra_description"
        const val EXTRA_LOCATION = "extra_location"
        const val EXTRA_SUPERVISOR = "extra_supervisor"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUkorDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "UKOR Fasilkom UI"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val name = intent.getStringExtra(EXTRA_NAME)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION)
        val supervisor = intent.getStringExtra(EXTRA_SUPERVISOR)
        val location = intent.getStringExtra(EXTRA_LOCATION)
        val photo = intent.getStringExtra(EXTRA_PHOTO)

        val imageView: ImageView = binding.imageView
        val textViewName: TextView = binding.textViewName
        val textViewDescription: TextView = binding.textViewDescription
        val textViewSupervisor: TextView = binding.textViewSupervisor
        val textViewLocation: TextView = binding.textViewLocation

        Glide.with(this)
            .load(photo)
            .into(imageView)

        textViewName.text = name
        textViewDescription.text = description
        textViewSupervisor.text = getString(R.string.supervisor_template, supervisor)
        textViewLocation.text = getString(R.string.location_template, location)
    }
}