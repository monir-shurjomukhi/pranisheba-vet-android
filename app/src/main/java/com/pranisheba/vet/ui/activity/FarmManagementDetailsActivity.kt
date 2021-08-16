package com.pranisheba.vet.ui.activity

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.pranisheba.vet.databinding.ActivityFarmManagementDetailsBinding
import com.pranisheba.vet.util.FARM_MANAGEMENT_TYPE
import com.pranisheba.vet.util.FARM_MANAGEMENT_TYPE_DETAILS

class FarmManagementDetailsActivity : AppCompatActivity() {

  private lateinit var binding: ActivityFarmManagementDetailsBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityFarmManagementDetailsBinding.inflate(layoutInflater)
    setContentView(binding.root)

    setSupportActionBar(binding.toolbar)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setDisplayShowHomeEnabled(true)

    binding.collapsingToolbarLayout.title = intent.extras?.getString(FARM_MANAGEMENT_TYPE)
    binding.farmManagementDetailsTextView.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
      Html.fromHtml(
        intent.extras?.getString(FARM_MANAGEMENT_TYPE_DETAILS),
        Html.FROM_HTML_MODE_COMPACT
      )
    } else {
      Html.fromHtml(intent.extras?.getString(FARM_MANAGEMENT_TYPE_DETAILS))
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
