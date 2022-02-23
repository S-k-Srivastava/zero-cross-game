package com.skdevstudio.zerocross

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.skdevstudio.zerocross.databinding.ActivitySelectModeBinding

class SelectMode : AppCompatActivity() {

    private lateinit var binding: ActivitySelectModeBinding
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectModeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.offlineModeBtn.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

        auth = Firebase.auth

        binding.logoutBtn.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this,GoogleAuthentication::class.java))
            finish()
        }

        binding.onlineModeBtn.setOnClickListener {
            startActivity(Intent(this,OnlineRoom::class.java))
        }


    }
}