package com.bothty.homework_profile

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bothty.homework_profile.databinding.ActivityEditProfileBinding

class EditProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Get fullName from profile
        val firstName = intent.getStringExtra(MainActivity.FIRST_NAME)
        val userName = intent.getStringExtra(MainActivity.USER_NAME)
        val generation = intent.getStringExtra(MainActivity.GENERATION)

        //Set fullName to EditText
        binding.editFirstname.setText(firstName)
        binding.editUsername.setText(userName)
        binding.editGeneration.setText(generation)

        //Close activity
        binding.closeBtn.setOnClickListener{
            finish()
        }

        //Save new username
        binding.saveBtn.setOnClickListener{
            editProfile()
        }
    }
    private fun editProfile(){
        val newFirstName = binding.editFirstname.text.toString()
        val newUserName = binding.editUsername.text.toString()
        val newGeneration = binding.editGeneration.text.toString()

        val dataIntent = Intent()
        dataIntent.putExtra(MainActivity.FIRST_NAME, newFirstName)
        dataIntent.putExtra(MainActivity.USER_NAME, newUserName)
        dataIntent.putExtra(MainActivity.GENERATION, newGeneration)
        setResult(RESULT_OK, dataIntent)
        finish()
    }
}