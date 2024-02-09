package com.example.travelinsurance

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.travelinsurance.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonNext.setOnClickListener {
            val intent = Intent(this, StartActivityTwo::class.java)
            startActivity(intent)
            animateTransition()
        }
    }

    private fun animateTransition() {
        val targetView: View = findViewById(android.R.id.content)
        val slideAnimator = ObjectAnimator.ofFloat(targetView, "translationX", 0f, -targetView.width.toFloat())
        slideAnimator.duration = 1000 // Adjust the duration as needed
        slideAnimator.start()
    }
}
