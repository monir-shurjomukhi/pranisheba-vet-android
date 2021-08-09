package com.pranisheba.vet.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pranisheba.vet.R
import com.pranisheba.vet.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

  private lateinit var binding: ActivityLoginBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityLoginBinding.inflate(layoutInflater)
    setContentView(binding.root)

    binding.nextButton.setOnClickListener {
      login()
    }

    binding.signUpTextView.setOnClickListener {
      startActivity(Intent(this, SignUpActivity::class.java))
    }
  }

  private fun login() {
    val mobileNumber = binding.mobileLayout.editText?.text.toString()
    if (mobileNumber.isEmpty()) {
      binding.mobileLayout.error = getString(R.string.mobile_number_required)
      return
    }


  }
}