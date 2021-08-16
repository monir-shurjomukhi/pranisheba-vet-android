package com.pranisheba.vet.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.pranisheba.vet.R
import com.pranisheba.vet.databinding.ActivityServiceRelatedInfoBinding
import com.pranisheba.vet.util.SERVICE_TYPE
import com.pranisheba.vet.util.SERVICE_TYPE_DETAILS

class ServiceRelatedInfoActivity : AppCompatActivity() {

  private lateinit var binding: ActivityServiceRelatedInfoBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityServiceRelatedInfoBinding.inflate(layoutInflater)
    setContentView(binding.root)

    setSupportActionBar(binding.toolbar)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setDisplayShowHomeEnabled(true)

    binding.treatmentServiceCard.setOnClickListener {
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

    binding.consultancyServiceCard.setOnClickListener {
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

    binding.registeredFarmServiceCard.setOnClickListener {
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
