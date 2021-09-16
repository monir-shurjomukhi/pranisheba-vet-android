package com.pranisheba.vet.ui.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.aceinteract.android.stepper.StepperNavListener
import com.pranisheba.vet.R
import com.pranisheba.vet.databinding.ActivityTreatmentFormBinding
import com.pranisheba.vet.ui.fragment.AnimalInfoFragment
import com.pranisheba.vet.ui.fragment.DiseaseInfoFragment
import com.pranisheba.vet.ui.fragment.OwnerInfoFragment


class TreatmentFormActivity : AppCompatActivity(), StepperNavListener {

  private lateinit var binding: ActivityTreatmentFormBinding

  // Owner Info
  private var name: String = ""
  private var mobile: String = ""
  private var email: String = ""
  private var farmName: String = ""
  private var address: String = ""

  // Animal Info
  private var treatedBefore: String = ""
  private var previousPrescription: String = ""
  private var animalNameOrId: String = ""
  private var animalGroup: String = ""
  private var animalType: String = ""
  private var breedType: String = ""
  private var animalBreed: String = ""
  private var partOfIot: String = ""
  private var bolusId: String = ""
  private var animalAge: String = ""
  private var ageUnit: String = ""
  private var animalWeight: String = ""
  private var animalGender: String = ""
  private var stageOfGender: String = ""
  private var deWormingStatus: String = ""
  private var vaccinationStatus: String = ""
  private var typeOfVaccines: String = ""

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityTreatmentFormBinding.inflate(layoutInflater)
    setContentView(binding.root)

    setSupportActionBar(binding.toolbar)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setDisplayShowHomeEnabled(true)

    binding.stepper.setupWithNavController(findNavController(R.id.frame_stepper))
    //setupActionBarWithNavController(findNavController(R.id.frame_stepper))
    binding.stepper.stepperNavListener = this

    binding.buttonPrevious.setOnClickListener { findNavController(R.id.frame_stepper).navigateUp() }
    binding.buttonNext.setOnClickListener {

      val navHostFragment: Fragment? = supportFragmentManager.findFragmentById(R.id.frame_stepper)
      val foregroundFragment = if (navHostFragment == null) null else navHostFragment.childFragmentManager
        .fragments[0]

      when (foregroundFragment) {
        is OwnerInfoFragment -> {
          name = foregroundFragment.getNameLayout().editText?.text.toString()
          mobile = foregroundFragment.getMobileLayout().editText?.text.toString()
          email = foregroundFragment.getEmailLayout().editText?.text.toString()
          farmName = foregroundFragment.getFarmNameLayout().editText?.text.toString()
          address = foregroundFragment.getAddressLayout().editText?.text.toString()

          validateOwnerInfo(foregroundFragment)
        }

        is AnimalInfoFragment -> {
          treatedBefore = foregroundFragment.getTreatedBeforeLayout().editText?.text.toString()
          previousPrescription = foregroundFragment.getPreviousPrescriptionLayout().editText?.text.toString()
          animalNameOrId = foregroundFragment.getAnimalNameOrIdLayout().editText?.text.toString()
          animalGroup = foregroundFragment.getAnimalGroupLayout().editText?.text.toString()
          animalType = foregroundFragment.getAnimalTypeLayout().editText?.text.toString()
          breedType = foregroundFragment.getBreedTypeLayout().editText?.text.toString()
          animalBreed = foregroundFragment.getAnimalBreedLayout().editText?.text.toString()
          partOfIot = foregroundFragment.getPartOfIotLayout().editText?.text.toString()
          bolusId = foregroundFragment.getBolusIdLayout().editText?.text.toString()
          animalAge = foregroundFragment.getAnimalAgeLayout().editText?.text.toString()
          ageUnit = foregroundFragment.getAgeUnitLayout().editText?.text.toString()
          animalWeight = foregroundFragment.getAnimalWeightLayout().editText?.text.toString()
          animalGender = foregroundFragment.getAnimalGenderLayout().editText?.text.toString()
          stageOfGender = foregroundFragment.getStageOfGenderLayout().editText?.text.toString()
          deWormingStatus = foregroundFragment.getDeWormingStatusLayout().editText?.text.toString()
          vaccinationStatus = foregroundFragment.getVaccinationStatusLayout().editText?.text.toString()
          typeOfVaccines = foregroundFragment.getTypeOfVaccinesLayout().editText?.text.toString()

          validateAnimalInfo(foregroundFragment)
        }

        is DiseaseInfoFragment -> {

        }
      }
    }
  }

  private fun validateOwnerInfo(fragment: OwnerInfoFragment) {
    when {
      name.isEmpty() -> {
        fragment.getNameLayout().editText?.error = getString(R.string.name_required)
        return
      }
      mobile.isEmpty() -> {
        fragment.getMobileLayout().editText?.error = getString(R.string.mobile_number_required)
        return
      }
      address.isEmpty() -> {
        fragment.getAddressLayout().editText?.error = getString(R.string.address_required)
        return
      }
      else -> {
        binding.stepper.goToNextStep()
      }
    }
  }

  private fun validateAnimalInfo(fragment: AnimalInfoFragment) {
    when {
      treatedBefore.isEmpty() -> {
        fragment.getTreatedBeforeLayout().editText?.error = getString(R.string.treated_before_status_required)
        return
      }
      animalGroup.isEmpty() -> {
        fragment.getAnimalGroupLayout().editText?.error = getString(R.string.animal_group_required)
        return
      }
      animalType.isEmpty() -> {
        fragment.getAnimalTypeLayout().editText?.error = getString(R.string.animal_type_required)
        return
      }
      partOfIot.isEmpty() -> {
        fragment.getPartOfIotLayout().editText?.error = getString(R.string.part_of_iot_status_required)
        return
      }
      animalAge.isEmpty() -> {
        fragment.getAnimalAgeLayout().editText?.error = getString(R.string.age_retuired)
        return
      }
      ageUnit.isEmpty() -> {
        fragment.getAgeUnitLayout().editText?.error = getString(R.string.unit_required)
        return
      }
      animalWeight.isEmpty() -> {
        fragment.getAnimalWeightLayout().editText?.error = getString(R.string.weight_of_the_animal_in_kg)
        return
      }
      animalGender.isEmpty() -> {
        fragment.getAnimalGenderLayout().editText?.error = getString(R.string.gender_required)
        return
      }
      deWormingStatus.isEmpty() -> {
        fragment.getDeWormingStatusLayout().editText?.error = getString(R.string.deworming_status_required)
        return
      }
      vaccinationStatus.isEmpty() -> {
        fragment.getVaccinationStatusLayout().editText?.error = getString(R.string.vaccination_status_required)
        return
      }
      else -> {
        binding.stepper.goToNextStep()
      }
    }
  }

  override fun onStepChanged(step: Int) {
    //Toast.makeText(this, "Step changed to: $step", Toast.LENGTH_SHORT).show()

    binding.buttonPrevious.isVisible = step != 0

    if (step == 2) {
      binding.buttonNext.setImageResource(R.drawable.ic_check)
    } else {
      binding.buttonNext.setImageResource(R.drawable.ic_right)
    }
  }

  override fun onCompleted() {
    //Toast.makeText(this, "Stepper completed", Toast.LENGTH_SHORT).show()
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

  private fun getForegroundFragment(): Fragment? {
    val navHostFragment: Fragment? = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
    return if (navHostFragment == null) null else navHostFragment.childFragmentManager
      .fragments[0]
  }
}
