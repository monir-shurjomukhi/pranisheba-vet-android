package com.pranisheba.vet.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.aceinteract.android.stepper.StepperNavListener
import com.pranisheba.vet.R
import com.pranisheba.vet.databinding.ActivityConsultancyFormBinding
import com.pranisheba.vet.ui.fragment.DiseaseInfoFragment
import com.pranisheba.vet.ui.fragment.FarmInfoFragment
import com.pranisheba.vet.ui.fragment.OwnerInfoFragment


class ConsultancyFormActivity : AppCompatActivity(), StepperNavListener {

  private lateinit var binding: ActivityConsultancyFormBinding
  private var currentStep = 0

  // Owner Info
  private var name: String = ""
  private var mobile: String = ""
  private var email: String = ""
  private var farmName: String = ""
  private var address: String = ""

  // Disease Info
  private var typeOfConsultancy: String = ""
  private var typeOfFarm: String = ""
  private var numberOfAnimals: String = ""
  private var placeOfFarm: String = ""
  private var ageOfFarm: String = ""
  private var frequencyOfConsultancy: String = ""

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityConsultancyFormBinding.inflate(layoutInflater)
    setContentView(binding.root)

    setSupportActionBar(binding.toolbar)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setDisplayShowHomeEnabled(true)

    binding.stepper.setupWithNavController(findNavController(R.id.frame_stepper))
    //setupActionBarWithNavController(findNavController(R.id.frame_stepper))
    binding.stepper.stepperNavListener = this

    binding.buttonPrevious.setOnClickListener { findNavController(R.id.frame_stepper).navigateUp() }
    binding.buttonNext.setOnClickListener {
      when (currentStep) {
        0 -> {
          val navHostFragment: Fragment? = supportFragmentManager.findFragmentById(R.id.frame_stepper)
          val foregroundFragment =
            if (navHostFragment == null) null else navHostFragment.childFragmentManager
              .fragments[0]
          foregroundFragment as OwnerInfoFragment

          name = foregroundFragment.getNameLayout().editText?.text.toString()
          mobile = foregroundFragment.getMobileLayout().editText?.text.toString()
          email = foregroundFragment.getEmailLayout().editText?.text.toString()
          farmName = foregroundFragment.getFarmNameLayout().editText?.text.toString()
          address = foregroundFragment.getAddressLayout().editText?.text.toString()

          validateOwnerInfo(foregroundFragment)
        }
        1 -> {
          val navHostFragment: Fragment? = supportFragmentManager.findFragmentById(R.id.frame_stepper)
          val foregroundFragment =
            if (navHostFragment == null) null else navHostFragment.childFragmentManager
              .fragments[0]
          foregroundFragment as FarmInfoFragment

          typeOfConsultancy = foregroundFragment.getTypeOfConsultancyLayout().editText?.text.toString()
          typeOfFarm = foregroundFragment.getTypeOfFarmLayout().editText?.text.toString()
          numberOfAnimals = foregroundFragment.getNumberOfAnimalsLayout().editText?.text.toString()
          placeOfFarm = foregroundFragment.getPlaceOfFarmLayout().editText?.text.toString()
          ageOfFarm = foregroundFragment.getAgeOfFirmLayout().editText?.text.toString()
          frequencyOfConsultancy = foregroundFragment.getFrequencyOfConsultancyLayout().editText?.text.toString()

          validateFarmInfo(foregroundFragment)
        }
      }
    }
  }

  private fun validateOwnerInfo(fragment: OwnerInfoFragment) {
    if (name.isEmpty()) {
      fragment.getNameLayout().error = getString(R.string.this_field_is_required)
      return
    } else {
      fragment.getNameLayout().error = null
    }
    if (mobile.isEmpty()) {
      fragment.getMobileLayout().error = getString(R.string.this_field_is_required)
      return
    } else {
      fragment.getMobileLayout().error = null
    }
    if (address.isEmpty()) {
      fragment.getAddressLayout().error = getString(R.string.this_field_is_required)
      return
    } else {
      fragment.getAddressLayout().error = null
    }

    binding.stepper.goToNextStep()
  }

  private fun validateFarmInfo(fragment: FarmInfoFragment) {
    if (typeOfConsultancy.isEmpty()) {
      fragment.getTypeOfConsultancyLayout().error = getString(R.string.this_field_is_required)
      return
    } else {
      fragment.getTypeOfConsultancyLayout().error = null
    }
    if (typeOfFarm.isEmpty()) {
      fragment.getTypeOfFarmLayout().error = getString(R.string.this_field_is_required)
      return
    } else {
      fragment.getTypeOfFarmLayout().error = null
    }
    if (ageOfFarm.isEmpty()) {
      fragment.getAgeOfFirmLayout().error = getString(R.string.this_field_is_required)
      return
    } else {
      fragment.getAgeOfFirmLayout().error = null
    }
    if (frequencyOfConsultancy.isEmpty()) {
      fragment.getFrequencyOfConsultancyLayout().error = getString(R.string.this_field_is_required)
      return
    } else {
      fragment.getFrequencyOfConsultancyLayout().error = null
    }

    binding.stepper.goToNextStep()
  }

  override fun onStepChanged(step: Int) {
    currentStep = step
    binding.buttonPrevious.isVisible = step != 0

    /*if (step == 1) {
      binding.buttonNext.setImageResource(R.drawable.ic_check)
    } else {
      binding.buttonNext.setImageResource(R.drawable.ic_right)
    }*/
  }

  override fun onCompleted() {
    Toast.makeText(this, "Stepper completed", Toast.LENGTH_SHORT).show()
    startActivity(Intent(this, ConsultancyInfoActivity::class.java))
  }

  override fun onBackPressed() {
    if (binding.stepper.currentStep == 0) {
      super.onBackPressed()
    } else {
      findNavController(R.id.frame_stepper).navigateUp()
    }
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    // handle arrow click here
    if (item.itemId == android.R.id.home) {
      finish()
    }
    return super.onOptionsItemSelected(item)
  }

  fun showPreviousInfo() {
    val navHostFragment: Fragment? = supportFragmentManager.findFragmentById(R.id.frame_stepper)
    val foregroundFragment =
      if (navHostFragment == null) null else navHostFragment.childFragmentManager
        .fragments[0]

    when(foregroundFragment) {
      is OwnerInfoFragment -> {
        foregroundFragment.getNameLayout().editText?.setText(name)
        foregroundFragment.getMobileLayout().editText?.setText(mobile)
        foregroundFragment.getEmailLayout().editText?.setText(email)
        foregroundFragment.getFarmNameLayout().editText?.setText(farmName)
        foregroundFragment.getAddressLayout().editText?.setText(address)
      }
      is FarmInfoFragment -> {
        foregroundFragment.getTypeOfConsultancyLayout().editText?.setText(typeOfConsultancy)
        foregroundFragment.getTypeOfFarmLayout().editText?.setText(typeOfFarm)
        foregroundFragment.getNumberOfAnimalsLayout().editText?.setText(numberOfAnimals)
        foregroundFragment.getPlaceOfFarmLayout().editText?.setText(placeOfFarm)
        foregroundFragment.getAgeOfFirmLayout().editText?.setText(ageOfFarm)
        foregroundFragment.getFrequencyOfConsultancyLayout().editText?.setText(frequencyOfConsultancy)
      }
    }
  }
}
