package com.pranisheba.vet.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.pranisheba.vet.R
import com.pranisheba.vet.databinding.ActivityServiceReceivingFormBinding
import com.pranisheba.vet.util.SERVICE_TYPE
import com.pranisheba.vet.util.SERVICE_TYPE_DETAILS

class ServiceReceivingFormActivity : AppCompatActivity() {

  private lateinit var binding: ActivityServiceReceivingFormBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityServiceReceivingFormBinding.inflate(layoutInflater)
    setContentView(binding.root)

    setSupportActionBar(binding.toolbar)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setDisplayShowHomeEnabled(true)

    /*binding.viewPager.adapter = ServiceReceivingFormPagerAdapter(this, supportFragmentManager)
    binding.tabLayout.setupWithViewPager(binding.viewPager)*/

    binding.treatmentServiceCard.setOnClickListener {
      val intent = Intent(this, TreatmentFormActivity::class.java)
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
      val intent = Intent(this, ConsultancyFormActivity::class.java)
      val bundle = Bundle()
      bundle.putString(SERVICE_TYPE, getString(R.string.consultancy_service))
      bundle.putString(
        SERVICE_TYPE_DETAILS,
        getString(R.string.consultancy_service_details)
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
