package com.pranisheba.vet.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pranisheba.vet.R
import com.pranisheba.vet.ui.adapter.ServiceReceivingFormPagerAdapter
import kotlinx.android.synthetic.main.activity_service_receiving_form.*

class ServiceReceivingFormActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_service_receiving_form)

    viewPager.adapter = ServiceReceivingFormPagerAdapter(this, supportFragmentManager)
    tabLayout.setupWithViewPager(viewPager)
  }
}