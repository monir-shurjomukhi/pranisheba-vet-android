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
      val intent = Intent(this, ServiceDetailsActivity::class.java)
      val bundle = Bundle()
      bundle.putString(Constants.SERVICE_TYPE, getString(R.string.treatment_service))
      bundle.putString(
        Constants.SERVICE_TYPE_DETAILS,
        getString(R.string.treatment_service_details)
      )
      intent.putExtras(bundle)
      startActivity(intent)
    }

    calfCareCard.setOnClickListener {
      val intent = Intent(this, ServiceDetailsActivity::class.java)
      val bundle = Bundle()
      bundle.putString(Constants.SERVICE_TYPE, getString(R.string.consultancy_service))
      bundle.putString(
        Constants.SERVICE_TYPE_DETAILS,
        getString(R.string.consultancy_service_details)
      )
      intent.putExtras(bundle)
      startActivity(intent)
    }

    dailyActivitiesCard.setOnClickListener {
      val intent = Intent(this, ServiceDetailsActivity::class.java)
      val bundle = Bundle()
      bundle.putString(Constants.SERVICE_TYPE, getString(R.string.registered_farm_service))
      bundle.putString(
        Constants.SERVICE_TYPE_DETAILS,
        getString(R.string.registered_farm_service_details)
      )
      intent.putExtras(bundle)
      startActivity(intent)
    }

    publicHealthCard.setOnClickListener {
      val intent = Intent(this, ServiceDetailsActivity::class.java)
      val bundle = Bundle()
      bundle.putString(Constants.SERVICE_TYPE, getString(R.string.registered_farm_service))
      bundle.putString(
        Constants.SERVICE_TYPE_DETAILS,
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
