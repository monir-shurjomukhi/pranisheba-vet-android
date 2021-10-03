package com.pranisheba.vet.ui.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.pranisheba.vet.R
import com.pranisheba.vet.databinding.ActivityConsultancyInfoBinding
import com.pranisheba.vet.ui.fragment.*
import com.pranisheba.vet.util.TYPE_OF_CONSULTANCY


class ConsultancyInfoActivity : AppCompatActivity() {

  private lateinit var binding: ActivityConsultancyInfoBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityConsultancyInfoBinding.inflate(layoutInflater)
    setContentView(binding.root)

    setSupportActionBar(binding.toolbar)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setDisplayShowHomeEnabled(true)

    showFragment()
  }

  private fun showFragment() {
    val typeOfConsultancy = intent.getStringExtra(TYPE_OF_CONSULTANCY)
    val fragment: Fragment

    when(typeOfConsultancy) {
      "Farm Planning(Number of animals ≤ 20)" -> {
        fragment = FarmPlanningFragment.newInstance()
        supportActionBar?.title = "Farm Planning"
      }
      "Farm Planning(Number of animals > 20)" -> {
        fragment = FarmPlanningFragment.newInstance()
        supportActionBar?.title = "Farm Planning"
      }
      "Ration Formulation" -> {
        fragment = RationFormulationFragment.newInstance()
        supportActionBar?.title = "Ration Formulation"
      }
      "Green Grass Production and Management" -> {
        fragment = GreenGrassProductionFragment.newInstance()
        supportActionBar?.title = "Green Grass Production and Management"
      }
      "Silage production and management" -> {
        fragment = SilageProductionFragment.newInstance()
        supportActionBar?.title = "Silage production and management"
      }
      "Farm Hygiene & Biosecurity Management" -> {
        fragment = HygieneBiosecurityFragment.newInstance()
        supportActionBar?.title = "Farm Hygiene & Biosecurity Management"
      }
      "Deworming & Vaccination Scheduling" -> {
        fragment = DewormingVaccinationFragment.newInstance()
        supportActionBar?.title = "Deworming & Vaccination Scheduling"
      }
      "Reproduction and Its management" -> {
        fragment = ReproductionManagementFragment.newInstance()
        supportActionBar?.title = "Reproduction and Its management"
      }
      "Farm Management" -> {
        fragment = FarmManagementFragment.newInstance()
        supportActionBar?.title = "Farm Management"
      }
      else -> {
        fragment = FarmPlanningFragment.newInstance()
        supportActionBar?.title = "Farm Planning"
      }
    }

    val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
    transaction.replace(R.id.container, fragment)
    transaction.commit()
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    // handle arrow click here
    if (item.itemId == android.R.id.home) {
      onBackPressed()
    }
    return super.onOptionsItemSelected(item)
  }
}