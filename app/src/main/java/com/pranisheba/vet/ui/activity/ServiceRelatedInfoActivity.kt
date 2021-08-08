package com.pranisheba.vet.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import com.pranisheba.vet.R
import com.pranisheba.vet.util.SERVICE_TYPE
import com.pranisheba.vet.util.SERVICE_TYPE_DETAILS

class ServiceRelatedInfoActivity : AppCompatActivity() {

  private lateinit var toolbar: Toolbar
  private lateinit var treatmentServiceCard: CardView
  private lateinit var consultancyServiceCard: CardView
  private lateinit var registeredFarmServiceCard: CardView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_service_related_info)

    toolbar = findViewById(R.id.toolbar)
    treatmentServiceCard = findViewById(R.id.treatmentServiceCard)
    consultancyServiceCard = findViewById(R.id.consultancyServiceCard)
    registeredFarmServiceCard = findViewById(R.id.registeredFarmServiceCard)

    setSupportActionBar(toolbar)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setDisplayShowHomeEnabled(true)

    treatmentServiceCard.setOnClickListener {
      val intent = Intent(this, ServiceDetailsActivity::class.java)
      val bundle = Bundle()
      bundle.putString(SERVICE_TYPE, getString(R.string.treatment_service))
      bundle.putString(
        SERVICE_TYPE_DETAILS,
        getString(R.string.treatment_service_details)
      )
      intent.putExtras(bundle)
      startActivity(intent)
    }

    consultancyServiceCard.setOnClickListener {
      val intent = Intent(this, ServiceDetailsActivity::class.java)
      val bundle = Bundle()
      bundle.putString(SERVICE_TYPE, getString(R.string.consultancy_service))
      bundle.putString(
        SERVICE_TYPE_DETAILS,
        getString(R.string.consultancy_service_details)
      )
      intent.putExtras(bundle)
      startActivity(intent)
    }

    registeredFarmServiceCard.setOnClickListener {
      val intent = Intent(this, ServiceDetailsActivity::class.java)
      val bundle = Bundle()
      bundle.putString(SERVICE_TYPE, getString(R.string.registered_farm_service))
      bundle.putString(
        SERVICE_TYPE_DETAILS,
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
