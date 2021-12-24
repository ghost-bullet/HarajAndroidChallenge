package com.example.harajtask

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.harajtask.databinding.ActivityDetailsBinding
import com.squareup.picasso.Picasso

 class DetailsActivity : AppCompatActivity() {

    lateinit var data: DataHaraj
    lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        data = intent.extras?.getSerializable("Data") as DataHaraj

        Picasso.with(this).load(data.thumbURL).placeholder(R.drawable.ic_search).into(binding.image)
        binding.title.text = data.title
        binding.time.text = Helper().getDateString(data.date)
        binding.userName.text = data.username
        binding.cityName.text = data.city
        binding.body.text = data.body

        binding.share.setOnClickListener {
            shareTitle()
        }
    }

    private fun shareTitle(): Unit {
        val intent = Intent()
        intent.action = Intent.ACTION_SEND
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, data.title)
        startActivity(Intent.createChooser(intent,"Share !"))
    }
}