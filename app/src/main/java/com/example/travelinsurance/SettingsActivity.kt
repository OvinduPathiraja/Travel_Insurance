package com.example.travelinsurance

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import com.example.travelinsurance.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingsBinding
    private lateinit var modeSwitch: SwitchCompat
    private var sharedPreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        modeSwitch = findViewById(R.id.mode_switch)
        sharedPreferences = getSharedPreferences("MODE", MODE_PRIVATE)

        // Retrieve the night mode state
        val nightMode = sharedPreferences?.getBoolean("night", true) ?: true
        modeSwitch.isChecked = nightMode

        // Set the default night mode based on the saved state
        setNightMode(nightMode)

        // Listen for changes in the switch state
        modeSwitch.setOnCheckedChangeListener { _, isChecked ->
            setNightMode(isChecked)

            // Save the state of night mode
            sharedPreferences?.edit()?.putBoolean("night", isChecked)?.apply()
        }

        binding.logoButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }

    private fun setNightMode(isNightMode: Boolean) {
        if (isNightMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
}
