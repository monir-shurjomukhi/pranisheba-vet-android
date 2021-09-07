package com.pranisheba.vet.ui.activity

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.pranisheba.vet.R
import com.pranisheba.vet.databinding.ActivityAgentRegistrationBinding
import com.pranisheba.vet.model.AgentRegistrationData
import com.pranisheba.vet.ui.viewmodel.AgentRegistrationViewModel
import java.text.SimpleDateFormat
import java.util.*


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

    val calendar = Calendar.getInstance()
    val date = OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
      calendar.set(Calendar.YEAR, year)
      calendar.set(Calendar.MONTH, monthOfYear)
      calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

      val myFormat = "yyyy/MM/dd"

      val sdf = SimpleDateFormat(myFormat, Locale.US)

      binding.dobLayout.editText?.setText(sdf.format(calendar.time))
    }

    binding.dobLayout.editText?.setOnClickListener {
      DatePickerDialog(
        this,
        date,
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
      ).show()
    }

    binding.submitButton.setOnClickListener { submit() }

    viewModel.agentRegistration.observe(this, {
      Snackbar.make(binding.parentLayout, it.message, Snackbar.LENGTH_SHORT).show()
    })

    viewModel.message.observe(this, {
      Snackbar.make(binding.parentLayout, getString(it), Snackbar.LENGTH_SHORT).show()
    })

    viewModel.progress.observe(this, {
      if (it) {
        binding.animationView.visibility = View.VISIBLE
      } else {
        binding.animationView.visibility = View.GONE
      }
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

    val agentRegistrationData = AgentRegistrationData(
      name, dob, mobile, email, businessType, address, businessYears, tradeLicense, tin, website
    )
    viewModel.registerAgent(agentRegistrationData)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    // handle arrow click here
    if (item.itemId == android.R.id.home) {
      onBackPressed()
    }
    return super.onOptionsItemSelected(item)
  }
}