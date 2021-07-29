package com.pranisheba.vet.ui.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.pranisheba.vet.R
import com.pranisheba.vet.ui.adapter.ServiceReceivingFormPagerAdapter

class ServiceReceivingFormActivity : AppCompatActivity() {

  private lateinit var toolbar: Toolbar
  private lateinit var viewPager: ViewPager
  private lateinit var tabLayout: TabLayout

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_service_receiving_form)

    toolbar = findViewById(R.id.toolbar)
    viewPager = findViewById(R.id.viewPager)
    tabLayout = findViewById(R.id.tabLayout)

    setSupportActionBar(toolbar)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setDisplayShowHomeEnabled(true)

    viewPager.adapter = ServiceReceivingFormPagerAdapter(this, supportFragmentManager)
    tabLayout.setupWithViewPager(viewPager)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    // handle arrow click here
    if (item.itemId == android.R.id.home) {
      onBackPressed()
    }
    return super.onOptionsItemSelected(item)
  }
}
