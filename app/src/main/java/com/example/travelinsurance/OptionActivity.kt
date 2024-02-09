package com.example.travelinsurance

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.travelinsurance.databinding.ActivityOptionBinding
import com.google.firebase.auth.FirebaseAuth

class OptionActivity : AppCompatActivity(){
    private lateinit var binding: ActivityOptionBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        binding = ActivityOptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.accident.setOnClickListener{
            val intent = Intent(this, CameraActivity::class.java)
            startActivity(intent)
        }
        binding.lost.setOnClickListener{
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }
        binding.health.setOnClickListener{
            val intent = Intent(this,InsuranceActivity::class.java)
            startActivity(intent)
        }

    }
}