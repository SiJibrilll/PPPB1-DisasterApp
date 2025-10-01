package com.example.hambalangdisasterapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hambalangdisasterapp.adapter.DisasterAdapter
import com.example.hambalangdisasterapp.databinding.ActivityMainBinding
import com.example.hambalangdisasterapp.model.Disaster

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = generateDummy()

        val disasterAdapter = DisasterAdapter(list) { disaster ->
            Toast.makeText(this, "You clicked on ${disaster.nameDisaster}", Toast.LENGTH_SHORT).show()
        }

        with(binding.rvDisaster) {
            adapter = disasterAdapter
            layoutManager = GridLayoutManager(this@MainActivity, 2) // 2 = number of columns
        }
    }

    private fun generateDummy(): List<Disaster> {
        return listOf(
            Disaster("Tsunami", "Natural", R.drawable.outline_local_fire_department_24),
            Disaster("Volcanic Eruption", "Natural", R.drawable.outline_local_fire_department_24),
            Disaster("Earthquake", "Natural", R.drawable.outline_local_fire_department_24),
            Disaster("Flood", "Natural", R.drawable.outline_local_fire_department_24),
            Disaster("Fire", "Natural", R.drawable.outline_local_fire_department_24), // 🔥 real icon
            Disaster("Nuclear Accident", "Man-made", R.drawable.outline_local_fire_department_24),
            Disaster("Terrorist Attack", "Man-made", R.drawable.outline_local_fire_department_24),
            Disaster("War", "Man-made", R.drawable.outline_local_fire_department_24)
        )
    }

}
