package com.bothty.homework_profile

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.bothty.homework_profile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //register for activity new username
    private val activityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {

        val newUserName = it.data?.getStringExtra(USER_NAME)

        binding.profileName.text = "$newUserName"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editIc.setOnClickListener {
            goToEditProfile()
        }
    }

    private fun goToEditProfile() {
        val intent = Intent(this, EditProfileActivity::class.java)

        val userName = binding.profileName.text.toString()

        intent.putExtra(USER_NAME, userName)

        activityLauncher.launch(intent)
    }

    companion object{
        const val USER_NAME = "userName"
    }

}


