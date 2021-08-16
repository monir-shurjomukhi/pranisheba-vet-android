package com.pranisheba.vet.ui.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.pranisheba.vet.databinding.ActivityServiceReceivingFormBinding
import com.pranisheba.vet.ui.adapter.ServiceReceivingFormPagerAdapter

class ServiceReceivingFormActivity : AppCompatActivity() {

  private lateinit var binding: ActivityServiceReceivingFormBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityServiceReceivingFormBinding.inflate(layoutInflater)
    setContentView(binding.root)

    setSupportActionBar(binding.toolbar)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setDisplayShowHomeEnabled(true)

    binding.viewPager.adapter = ServiceReceivingFormPagerAdapter(this, supportFragmentManager)
    binding.tabLayout.setupWithViewPager(binding.viewPager)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    // handle arrow click here
    if (item.itemId == android.R.id.home) {
      onBackPressed()
    }
    return super.onOptionsItemSelected(item)
  }
}
