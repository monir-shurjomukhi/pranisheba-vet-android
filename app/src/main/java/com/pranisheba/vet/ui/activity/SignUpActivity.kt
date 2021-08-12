package com.pranisheba.vet.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.pranisheba.vet.R
import com.pranisheba.vet.databinding.ActivitySignUpBinding
import com.pranisheba.vet.model.SignUpData
import com.pranisheba.vet.ui.viewmodel.SignUpViewModel

class SignUpActivity : AppCompatActivity() {

  private lateinit var binding: ActivitySignUpBinding
  private lateinit var viewModel: SignUpViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivitySignUpBinding.inflate(layoutInflater)
    setContentView(binding.root)

    viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)

    binding.submitButton.setOnClickListener {
      signUp()
    }

    binding.loginTextView.setOnClickListener {
      onBackPressed()
    }

    viewModel.progress.observe(this, {

    })

    viewModel.message.observe(this, {

    })

    viewModel.signUp.observe(this, {
      if (it != null) {
        Toast.makeText(this, "Signup successful! Please Login!", Toast.LENGTH_SHORT).show()
      }
    })

    viewModel.progress.observe(this, {

    })
  }

  private fun signUp() {
    val name = binding.nameLayout.editText?.text.toString()
    val mobileNumber = binding.mobileLayout.editText?.text.toString()
    val email = binding.emailLayout.editText?.text.toString()
    val farmName = binding.farmNameLayout.editText?.text.toString()
    val address = binding.addressLayout.editText?.text.toString()

    if (name.isEmpty()) {
      binding.nameLayout.error = getString(R.string.name_required)
      return
    }
    if (mobileNumber.isEmpty()) {
      binding.mobileLayout.error = getString(R.string.mobile_number_required)
      return
    }
    if (address.isEmpty()) {
      binding.addressLayout.error = getString(R.string.address_required)
      return
    }

    val signUpData = SignUpData(name, mobileNumber, email, farmName, address)
    viewModel.signUp(signUpData)
  }
}
