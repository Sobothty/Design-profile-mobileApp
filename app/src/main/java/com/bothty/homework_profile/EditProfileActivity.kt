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
        val userName = intent.getStringExtra("userName")

        //Set fullName to EditText
        binding.editUsername.setText(userName)

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
        val newUserName = binding.editUsername.text.toString()

        val dataIntent = Intent()
        dataIntent.putExtra(MainActivity.USER_NAME, newUserName)
        setResult(RESULT_OK, dataIntent)
        finish()
    }
}