package com.pranisheba.vet.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import com.pranisheba.vet.R
import com.pranisheba.vet.util.Constants

class FarmManagementInfoActivity : AppCompatActivity() {

  private lateinit var toolbar: Toolbar
  private lateinit var pregnantCowCareCard: CardView
  private lateinit var calfCareCard: CardView
  private lateinit var dailyActivitiesCard: CardView
  private lateinit var publicHealthCard: CardView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_farm_management_info)

    toolbar = findViewById(R.id.toolbar)
    pregnantCowCareCard = findViewById(R.id.pregnantCowCareCard)
    calfCareCard = findViewById(R.id.calfCareCard)
    dailyActivitiesCard = findViewById(R.id.dailyActivitiesCard)
    publicHealthCard = findViewById(R.id.publicHealthCard)

    setSupportActionBar(toolbar)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setDisplayShowHomeEnabled(true)

    pregnantCowCareCard.setOnClickListener {
      val intent = Intent(this, FarmManagementDetailsActivity::class.java)
      val bundle = Bundle()
      bundle.putString(Constants.FARM_MANAGEMENT_TYPE, getString(R.string.pregnant_cow_care_and_management))
      bundle.putString(
        Constants.FARM_MANAGEMENT_TYPE_DETAILS,
        getString(R.string.pregnant_cow_care_and_management_details)
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
        getString(R.string.calf_care_and_management_details)
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
        getString(R.string.daily_activities_of_farm_details)
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
