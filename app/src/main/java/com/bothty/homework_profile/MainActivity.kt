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

        if(it.resultCode != RESULT_OK){
            return@registerForActivityResult
        }
        val newFirstName = it.data?.getStringExtra(FIRST_NAME)
        val newUserName = it.data?.getStringExtra(USER_NAME)
        val newGeneration = it.data?.getStringExtra(GENERATION)

        binding.firstName.text = "$newFirstName"
        binding.profileName.text = "$newUserName"
        binding.Generation.text = "$newGeneration"
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

        val firstName = binding.firstName.text.toString()
        val userName = binding.profileName.text.toString()
        val generation = binding.Generation.text.toString()

        intent.putExtra(FIRST_NAME, firstName)
        intent.putExtra(USER_NAME, userName)
        intent.putExtra(GENERATION, generation)

        activityLauncher.launch(intent)
    }

    companion object{
        const val FIRST_NAME = "firstName"
        const val USER_NAME = "userName"
        const val GENERATION = "generation"
    }

}


