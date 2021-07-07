package com.pranisheba.vet.ui.activity

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.pranisheba.vet.R
import com.pranisheba.vet.util.Constants
import kotlinx.android.synthetic.main.activity_farm_and_farmer_info.toolbar
import kotlinx.android.synthetic.main.activity_farm_management_details.*

class FarmManagementDetailsActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_farm_management_details)

    setSupportActionBar(toolbar)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setDisplayShowHomeEnabled(true)

    collapsingToolbarLayout.title = intent.extras?.getString(Constants.FARM_MANAGEMENT_TYPE)
    farmManagementDetailsTextView.text =
      intent.extras?.getString(Constants.FARM_MANAGEMENT_TYPE_DETAILS)

    farmManagementDetailsTextView.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
      Html.fromHtml(
        intent.extras?.getString(Constants.FARM_MANAGEMENT_TYPE_DETAILS),
        Html.FROM_HTML_MODE_COMPACT
      )
    } else {
      Html.fromHtml(intent.extras?.getString(Constants.FARM_MANAGEMENT_TYPE_DETAILS))
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
