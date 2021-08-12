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
import com.pranisheba.vet.model.Otp
import com.pranisheba.vet.model.UpdateLogin
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
      insertCheck()
    }

    binding.signUpTextView.setOnClickListener {
      startActivity(Intent(this, SignUpActivity::class.java))
    }

    viewModel.insertCheck.observe(this, {
      if (it.success == true) {
        binding.otpLayout.visibility = VISIBLE
      }
    })

    viewModel.verifyOtp.observe(this, {
      if (it.equals("1")) {
        startActivity(Intent(this, MainActivity2::class.java))
        finishAffinity()
      } else {
        Toast.makeText(this, "Otp Did Not Match!", Toast.LENGTH_SHORT).show()
      }
    })

    viewModel.verifyOtp.observe(this, {
      updateLogin()
    })
  }

  private fun insertCheck() {
    if (binding.otpLayout.isVisible) {
      val otp = binding.otpLayout.editText?.text.toString()
      if (otp.isEmpty()) {
        binding.mobileLayout.error = getString(R.string.otp_required)
        return
      }

      val otpData = Otp(otp, viewModel.insertCheck.value?.key.toString())
      viewModel.verifyOtp(otpData)
    } else {
      val mobileNumber = binding.mobileLayout.editText?.text.toString()
      if (mobileNumber.isEmpty()) {
        binding.mobileLayout.error = getString(R.string.mobile_number_required)
        return
      }

      viewModel.insertCheck(mobileNumber)
    }
  }

  private fun updateLogin() {
    val updateLogin = UpdateLogin(viewModel.insertCheck.value?.id!!,
      viewModel.insertCheck.value?.mobileNumber!!, binding.otpLayout.editText?.text.toString())


  }
}
