package com.pranisheba.vet.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.pranisheba.vet.R
import com.pranisheba.vet.databinding.ActivityFarmAndFarmerInfoBinding

class FarmAndFarmerInfoActivity : AppCompatActivity() {

  private lateinit var binding: ActivityFarmAndFarmerInfoBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityFarmAndFarmerInfoBinding.inflate(layoutInflater)
    setContentView(binding.root)

    setSupportActionBar(binding.toolbar)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setDisplayShowHomeEnabled(true)
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.farm_and_farmer, menu)
    return super.onCreateOptionsMenu(menu)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    // handle arrow click here
    if (item.itemId == android.R.id.home) {
      onBackPressed()
    } else if (item.itemId == R.id.action_edit) {
      startActivity(Intent(this, EditFarmAndFarmerInfoActivity::class.java))
    }
    return super.onOptionsItemSelected(item)
  }
}
