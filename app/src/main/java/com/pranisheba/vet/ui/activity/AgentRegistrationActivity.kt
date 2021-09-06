package com.pranisheba.vet.ui.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.pranisheba.vet.R
import com.pranisheba.vet.databinding.ActivityAgentRegistrationBinding
import com.pranisheba.vet.ui.viewmodel.AgentRegistrationViewModel

class AgentRegistrationActivity : AppCompatActivity() {

  private lateinit var binding: ActivityAgentRegistrationBinding
  private lateinit var viewModel: AgentRegistrationViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityAgentRegistrationBinding.inflate(layoutInflater)
    setContentView(binding.root)

    setSupportActionBar(binding.toolbar)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setDisplayShowHomeEnabled(true)

    viewModel = ViewModelProvider(this).get(AgentRegistrationViewModel::class.java)

    binding.submitButton.setOnClickListener { submit() }

    viewModel.message.observe(this, {
      Snackbar.make(binding.parentLayout, getString(it), Snackbar.LENGTH_SHORT).show()
    })


  }

  private fun submit() {
    val name = binding.nameLayout.editText?.text.toString()
    val dob = binding.dobLayout.editText?.text.toString()
    val mobile = binding.mobileLayout.editText?.text.toString()
    val email = binding.emailLayout.editText?.text.toString()
    val businessType = binding.businessTypeLayout.editText?.text.toString()
    val address = binding.addressLayout.editText?.text.toString()
    val businessYears = binding.businessYearsLayout.editText?.text.toString()
    val tradeLicense = binding.tradeLicenseLayout.editText?.text.toString()
    val tin = binding.tinLayout.editText?.text.toString()
    val website = binding.websiteLayout.editText?.text.toString()

    if (name.isEmpty()) {
      binding.nameLayout.error = getString(R.string.name_required)
      return
    }
    if (dob.isEmpty()) {
      binding.dobLayout.error = getString(R.string.date_of_birth_required)
      return
    }
    if (mobile.isEmpty()) {
      binding.mobileLayout.error = getString(R.string.mobile_number_required)
      return
    }
    if (businessType.isEmpty()) {
      binding.businessTypeLayout.error = getString(R.string.type_of_business_service_required)
      return
    }
    if (address.isEmpty()) {
      binding.addressLayout.error = getString(R.string.address_required)
      return
    }
    if (businessYears.isEmpty()) {
      binding.businessYearsLayout.error = getString(R.string.years_in_business_service_required)
      return
    }


  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    // handle arrow click here
    if (item.itemId == android.R.id.home) {
      onBackPressed()
    }
    return super.onOptionsItemSelected(item)
  }
}