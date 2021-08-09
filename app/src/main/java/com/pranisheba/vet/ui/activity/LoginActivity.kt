package com.pranisheba.vet.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.pranisheba.vet.R
import com.pranisheba.vet.databinding.ActivityLoginBinding
import com.pranisheba.vet.ui.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

  private lateinit var binding: ActivityLoginBinding
  private lateinit var viewModel: LoginViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityLoginBinding.inflate(layoutInflater)
    setContentView(binding.root)

    viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

    binding.nextButton.setOnClickListener {
      login()
    }

    binding.signUpTextView.setOnClickListener {
      startActivity(Intent(this, SignUpActivity::class.java))
    }

    viewModel.loginResponse.observe(this, {
      if (it.success == true) {
        binding.otpLayout.visibility = VISIBLE
      }
    })
  }

  private fun login() {
    if (binding.otpLayout.isVisible) {
      val otp = binding.otpLayout.editText?.text.toString()
      if (otp.isEmpty()) {
        binding.mobileLayout.error = getString(R.string.otp_required)
        return
      }

      viewModel.verifyOtp(otp)
    } else {
      val mobileNumber = binding.mobileLayout.editText?.text.toString()
      if (mobileNumber.isEmpty()) {
        binding.mobileLayout.error = getString(R.string.mobile_number_required)
        return
      }

      viewModel.login(mobileNumber)
    }
  }
}