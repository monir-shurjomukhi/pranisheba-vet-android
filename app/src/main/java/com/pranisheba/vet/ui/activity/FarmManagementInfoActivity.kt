package com.pranisheba.vet.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.pranisheba.vet.R
import com.pranisheba.vet.util.Constants
import kotlinx.android.synthetic.main.activity_farm_and_farmer_info.toolbar
import kotlinx.android.synthetic.main.activity_farm_management_info.*

class FarmManagementInfoActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_farm_management_info)

    setSupportActionBar(toolbar)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setDisplayShowHomeEnabled(true)

    pregnantCowCareCard.setOnClickListener {
      val intent = Intent(this, FarmManagementDetailsActivity::class.java)
      val bundle = Bundle()
      bundle.putString(Constants.FARM_MANAGEMENT_TYPE, getString(R.string.pregnant_cow_care_and_management))
      bundle.putString(
        Constants.FARM_MANAGEMENT_TYPE_DETAILS,
        getString(R.string.treatment_service_details)
      )
      intent.putExtras(bundle)
      startActivity(intent)
    }

    calfCareCard.setOnClickListener {
      val intent = Intent(this, FarmManagementDetailsActivity::class.java)
      val bundle = Bundle()
      bundle.putString(Constants.FARM_MANAGEMENT_TYPE, getString(R.string.calf_care_and_management))
      bundle.putString(
        Constants.FARM_MANAGEMENT_TYPE_DETAILS,
        getString(R.string.consultancy_service_details)
      )
      intent.putExtras(bundle)
      startActivity(intent)
    }

    dailyActivitiesCard.setOnClickListener {
      val intent = Intent(this, FarmManagementDetailsActivity::class.java)
      val bundle = Bundle()
      bundle.putString(Constants.FARM_MANAGEMENT_TYPE, getString(R.string.daily_activities_of_farm))
      bundle.putString(
        Constants.FARM_MANAGEMENT_TYPE_DETAILS,
        getString(R.string.registered_farm_service_details)
      )
      intent.putExtras(bundle)
      startActivity(intent)
    }

    publicHealthCard.setOnClickListener {
      val intent = Intent(this, FarmManagementDetailsActivity::class.java)
      val bundle = Bundle()
      bundle.putString(Constants.FARM_MANAGEMENT_TYPE, getString(R.string.importance_of_public_health))
      bundle.putString(
        Constants.FARM_MANAGEMENT_TYPE_DETAILS,
        getString(R.string.registered_farm_service_details)
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
