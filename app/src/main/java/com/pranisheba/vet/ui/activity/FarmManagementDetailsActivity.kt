package com.pranisheba.vet.ui.activity

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.pranisheba.vet.R
import com.pranisheba.vet.util.FARM_MANAGEMENT_TYPE
import com.pranisheba.vet.util.FARM_MANAGEMENT_TYPE_DETAILS

class FarmManagementDetailsActivity : AppCompatActivity() {

  private lateinit var toolbar: Toolbar
  private lateinit var collapsingToolbarLayout: CollapsingToolbarLayout
  private lateinit var farmManagementDetailsTextView: TextView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_farm_management_details)

    toolbar = findViewById(R.id.toolbar)
    collapsingToolbarLayout = findViewById(R.id.collapsingToolbarLayout)
    farmManagementDetailsTextView = findViewById(R.id.farmManagementDetailsTextView)

    setSupportActionBar(toolbar)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setDisplayShowHomeEnabled(true)

    collapsingToolbarLayout.title = intent.extras?.getString(FARM_MANAGEMENT_TYPE)
    farmManagementDetailsTextView.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
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
