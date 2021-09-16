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

  // Disease Info
  private var temperatureLevel: String = ""
  private var temperature: String = ""
  private var feedIntake: String = ""
  private var defecation: String = ""
  private var urination: String = ""
  private var hair: String = ""
  private var salivation: String = ""
  private var staticPosture: String = ""
  private var muzzle: String = ""
  private var sneezing: String = ""
  private var sweating: String = ""
  private var postureAndGesture: String = ""
  private var firstTime: String = ""
  private var soughtElsewhere: String = ""
  private var description: String = ""
  private var otherAnimals: String = ""
  private var emergency: String = ""

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
      val foregroundFragment =
        if (navHostFragment == null) null else navHostFragment.childFragmentManager
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
          previousPrescription =
            foregroundFragment.getPreviousPrescriptionLayout().editText?.text.toString()
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
          vaccinationStatus =
            foregroundFragment.getVaccinationStatusLayout().editText?.text.toString()
          typeOfVaccines = foregroundFragment.getTypeOfVaccinesLayout().editText?.text.toString()

          validateAnimalInfo(foregroundFragment)
        }

        is DiseaseInfoFragment -> {
          temperatureLevel =
            foregroundFragment.getTemperatureLevelLayout().editText?.text.toString()
          temperature = foregroundFragment.getTemperatureLayout().editText?.text.toString()
          feedIntake = foregroundFragment.getFeedIntakeLayout().editText?.text.toString()
          defecation = foregroundFragment.getDefecationStatusLayout().editText?.text.toString()
          urination = foregroundFragment.getUrinationStatusLayout().editText?.text.toString()
          hair = foregroundFragment.getHairStatusLayout().editText?.text.toString()
          salivation = foregroundFragment.getSalivationStatusLayout().editText?.text.toString()
          staticPosture = foregroundFragment.getPostureStatusLayout().editText?.text.toString()
          muzzle = foregroundFragment.getMuzzleStatusLayout().editText?.text.toString()
          sneezing = foregroundFragment.getSneezingStatusLayout().editText?.text.toString()
          sweating = foregroundFragment.getSweatingStatusLayout().editText?.text.toString()
          postureAndGesture = foregroundFragment.getGestureStatusLayout().editText?.text.toString()
          firstTime = foregroundFragment.getFirstTimeLayout().editText?.text.toString()
          soughtElsewhere = foregroundFragment.getSoughtElsewhereLayout().editText?.text.toString()
          description = foregroundFragment.getProblemDescriptionLayout().editText?.text.toString()
          otherAnimals = foregroundFragment.getOtherAnimalsLayout().editText?.text.toString()
          emergency = foregroundFragment.getEmergencyTypeLayout().editText?.text.toString()

          validateDiseaseInfo(foregroundFragment)
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

  private fun validateAnimalInfo(fragment: AnimalInfoFragment) {
    if (treatedBefore.isEmpty()) {
      fragment.getTreatedBeforeLayout().error = getString(R.string.this_field_is_required)
      return
    } else {
      fragment.getTreatedBeforeLayout().error = null
    }
    if (animalGroup.isEmpty()) {
      fragment.getAnimalGroupLayout().error = getString(R.string.this_field_is_required)
      return
    } else {
      fragment.getAnimalGroupLayout().error = null
    }
    if (animalType.isEmpty()) {
      fragment.getAnimalTypeLayout().error = getString(R.string.this_field_is_required)
      return
    } else {
      fragment.getAnimalTypeLayout().error = null
    }
    if (partOfIot.isEmpty()) {
      fragment.getPartOfIotLayout().error = getString(R.string.this_field_is_required)
      return
    } else {
      fragment.getPartOfIotLayout().error = null
    }
    if (animalAge.isEmpty()) {
      fragment.getAnimalAgeLayout().error = getString(R.string.this_field_is_required)
      return
    } else {
      fragment.getAnimalAgeLayout().error = null
    }
    if (ageUnit.isEmpty()) {
      fragment.getAgeUnitLayout().error = getString(R.string.this_field_is_required)
      return
    } else {
      fragment.getAgeUnitLayout().error = null
    }
    if (animalWeight.isEmpty()) {
      fragment.getAnimalWeightLayout().error = getString(R.string.this_field_is_required)
      return
    } else {
      fragment.getAnimalWeightLayout().error = null
    }
    if (animalGender.isEmpty()) {
      fragment.getAnimalGenderLayout().error = getString(R.string.this_field_is_required)
      return
    } else {
      fragment.getAnimalGenderLayout().error = null
    }
    if (deWormingStatus.isEmpty()) {
      fragment.getDeWormingStatusLayout().error = getString(R.string.this_field_is_required)
      return
    } else {
      fragment.getDeWormingStatusLayout().error = null
    }
    if (vaccinationStatus.isEmpty()) {
      fragment.getVaccinationStatusLayout().error = getString(R.string.this_field_is_required)
      return
    } else {
      fragment.getVaccinationStatusLayout().error = null
    }

    binding.stepper.goToNextStep()
  }

  private fun validateDiseaseInfo(fragment: DiseaseInfoFragment) {
    if (temperatureLevel.isEmpty()) {
      fragment.getTemperatureLevelLayout().error = getString(R.string.this_field_is_required)
      return
    } else {
      fragment.getTemperatureLevelLayout().error = null
    }
    if (temperature.isEmpty()) {
      fragment.getTemperatureLayout().error = getString(R.string.this_field_is_required)
      return
    } else {
      fragment.getTemperatureLayout().error = null
    }
    if (feedIntake.isEmpty()) {
      fragment.getFeedIntakeLayout().error = getString(R.string.this_field_is_required)
      return
    } else {
      fragment.getFeedIntakeLayout().error = null
    }
    if (defecation.isEmpty()) {
      fragment.getDefecationStatusLayout().error = getString(R.string.this_field_is_required)
      return
    } else {
      fragment.getDefecationStatusLayout().error = null
    }
    if (staticPosture.isEmpty()) {
      fragment.getPostureStatusLayout().error = getString(R.string.this_field_is_required)
      return
    } else {
      fragment.getPostureStatusLayout().error = null
    }
    if (postureAndGesture.isEmpty()) {
      fragment.getGestureStatusLayout().error = getString(R.string.this_field_is_required)
      return
    } else {
      fragment.getGestureStatusLayout().error = null
    }
    if (firstTime.isEmpty()) {
      fragment.getFirstTimeLayout().error = getString(R.string.this_field_is_required)
      return
    } else {
      fragment.getFirstTimeLayout().error = null
    }
    if (description.isEmpty()) {
      fragment.getProblemDescriptionLayout().error = getString(R.string.this_field_is_required)
      return
    } else {
      fragment.getProblemDescriptionLayout().error = null
    }
    if (otherAnimals.isEmpty()) {
      fragment.getOtherAnimalsLayout().error = getString(R.string.this_field_is_required)
      return
    } else {
      fragment.getOtherAnimalsLayout().error = null
    }
    if (emergency.isEmpty()) {
      fragment.getEmergencyTypeLayout().error = getString(R.string.this_field_is_required)
      return
    } else {
      fragment.getEmergencyTypeLayout().error = null
    }
  }

  override fun onStepChanged(step: Int) {
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
}
