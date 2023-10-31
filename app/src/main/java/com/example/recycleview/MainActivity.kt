package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycleview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        val adapterDisaster = DisasterAdapter(generateDummy()) {
            Toast.makeText(this@MainActivity, "telah diklik", Toast.LENGTH_SHORT).show()
        }
        with(binding) {
            rvDisaster.apply {
                adapter = adapterDisaster
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }

    fun generateDummy(): List<Disaster> {
        return listOf(
            Disaster(nameDisaster = "Tsunami", typeDisaster = "Natural"),
            Disaster(nameDisaster = "Volcanic Eruption", typeDisaster = "Natural"),
            Disaster(nameDisaster = "Earthquake", typeDisaster = "Natural"),
            Disaster(nameDisaster = "Flood", typeDisaster = "Natural"),
            Disaster(nameDisaster = "Fire", typeDisaster = "Natural"),
            Disaster(nameDisaster = "Nuclear Accident", typeDisaster = "Man-made"),
            Disaster(nameDisaster = "Terrorist Attack", typeDisaster = "Man-made"),
            Disaster(nameDisaster = "War", typeDisaster = "Man-made")
        )
    }

}