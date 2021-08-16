package com.pranisheba.vet.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.pranisheba.vet.R
import com.pranisheba.vet.databinding.ActivityFarmManagementInfoBinding
import com.pranisheba.vet.util.FARM_MANAGEMENT_TYPE
import com.pranisheba.vet.util.FARM_MANAGEMENT_TYPE_DETAILS

class FarmManagementInfoActivity : AppCompatActivity() {

  private lateinit var binding: ActivityFarmManagementInfoBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityFarmManagementInfoBinding.inflate(layoutInflater)
    setContentView(binding.root)

    setSupportActionBar(binding.toolbar)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setDisplayShowHomeEnabled(true)

    binding.pregnantCowCareCard.setOnClickListener {
      val intent = Intent(this, FarmManagementDetailsActivity::class.java)
      val bundle = Bundle()
      bundle.putString(FARM_MANAGEMENT_TYPE, getString(R.string.pregnant_cow_care_and_management))
      bundle.putString(
        FARM_MANAGEMENT_TYPE_DETAILS,
        getString(R.string.pregnant_cow_care_and_management_details)
      )
      intent.putExtras(bundle)
      startActivity(intent)
    }

    binding.calfCareCard.setOnClickListener {
      val intent = Intent(this, FarmManagementDetailsActivity::class.java)
      val bundle = Bundle()
      bundle.putString(FARM_MANAGEMENT_TYPE, getString(R.string.calf_care_and_management))
      bundle.putString(
        FARM_MANAGEMENT_TYPE_DETAILS,
        getString(R.string.calf_care_and_management_details)
      )
      intent.putExtras(bundle)
      startActivity(intent)
    }

    binding.dailyActivitiesCard.setOnClickListener {
      val intent = Intent(this, FarmManagementDetailsActivity::class.java)
      val bundle = Bundle()
      bundle.putString(FARM_MANAGEMENT_TYPE, getString(R.string.daily_activities_of_farm))
      bundle.putString(
        FARM_MANAGEMENT_TYPE_DETAILS,
        getString(R.string.daily_activities_of_farm_details)
      )
      intent.putExtras(bundle)
      startActivity(intent)
    }

    binding.publicHealthCard.setOnClickListener {
      val intent = Intent(this, FarmManagementDetailsActivity::class.java)
      val bundle = Bundle()
      bundle.putString(FARM_MANAGEMENT_TYPE, getString(R.string.importance_of_public_health))
      bundle.putString(
        FARM_MANAGEMENT_TYPE_DETAILS,
        getString(R.string.importance_of_public_health_details)
      )
      intent.putExtras(bundle)
      startActivity(intent)
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
