package com.pranisheba.vet.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.pranisheba.vet.R
import com.pranisheba.vet.databinding.ActivityLoginBinding
import com.pranisheba.vet.model.OtpData
import com.pranisheba.vet.preference.VetPreference
import com.pranisheba.vet.ui.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

  private lateinit var binding: ActivityLoginBinding
  private lateinit var viewModel: LoginViewModel

  private lateinit var preference: VetPreference

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityLoginBinding.inflate(layoutInflater)
    setContentView(binding.root)

    viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
    preference = VetPreference(this)

    binding.sendButton.setOnClickListener {
      insertCheck()
    }

    binding.loginButton.setOnClickListener {
      login()
    }

    binding.signUpTextView.setOnClickListener {
      startActivity(Intent(this, SignUpActivity::class.java))
    }

    viewModel.insertCheck.observe(this, {
      if (it.success == true) {
        binding.sendButton.text = getString(R.string.resend)
        binding.otpLayout.visibility = View.VISIBLE
        binding.loginButton.visibility = View.VISIBLE
      }
    })

    viewModel.login.observe(this, {
      if (it.token.toString().isNotEmpty()) {
        preference.putAuthToken(it.token.toString())
        startActivity(Intent(this, MainActivity2::class.java))
        finishAffinity()
      }
    })

    viewModel.progress.observe(this, {
      if (it) {
        binding.animationView.visibility = View.VISIBLE
      } else {
        binding.animationView.visibility = View.GONE
      }
    })

    viewModel.message.observe(this, {
      Snackbar.make(binding.parentLayout, getString(it), Snackbar.LENGTH_SHORT).show()
    })
  }

  private fun insertCheck() {
      val mobileNumber = binding.mobileLayout.editText?.text.toString()
      if (mobileNumber.isEmpty()) {
        binding.mobileLayout.error = getString(R.string.mobile_number_required)
        return
      }

      viewModel.insertCheck(mobileNumber)
  }

  private fun login() {
    val otp = binding.otpLayout.editText?.text.toString()
    if (otp.isEmpty()) {
      binding.otpLayout.error = getString(R.string.otp_required)
      return
    }

    val otpData = OtpData(otp, viewModel.insertCheck.value?.key.toString())
    viewModel.verifyOtp(otpData)
  }
}
