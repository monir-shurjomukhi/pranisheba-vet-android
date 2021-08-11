package com.pranisheba.vet.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.pranisheba.vet.R
import com.pranisheba.vet.databinding.ActivityLoginBinding
import com.pranisheba.vet.model.LoginResponse
import com.pranisheba.vet.model.Otp
import com.pranisheba.vet.ui.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

  private lateinit var binding: ActivityLoginBinding
  private lateinit var viewModel: LoginViewModel

  private var loginResponse: LoginResponse? = null

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
      loginResponse = it
      if (loginResponse?.success == true) {
        binding.otpLayout.visibility = VISIBLE
      }
    })

    viewModel.verifyOtp.observe(this, {
      if (it.equals("1")) {
        startActivity(Intent(this, MainActivity2::class.java))
        finishAffinity()
      } else {
        Toast.makeText(this, "Otp Did Not Match!", Toast.LENGTH_SHORT).show()
        //TODO: remove these after testing
        startActivity(Intent(this, MainActivity2::class.java))
        finishAffinity()
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

      val otpData = Otp(otp, loginResponse?.key.toString())
      viewModel.verifyOtp(otpData)
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
