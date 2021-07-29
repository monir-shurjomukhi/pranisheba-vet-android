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
import com.pranisheba.vet.util.Constants

class ServiceDetailsActivity : AppCompatActivity() {

  private lateinit var toolbar: Toolbar
  private lateinit var collapsingToolbarLayout: CollapsingToolbarLayout
  private lateinit var serviceDetailsTextView: TextView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_service_details)

    toolbar = findViewById(R.id.toolbar)
    collapsingToolbarLayout = findViewById(R.id.collapsingToolbarLayout)
    serviceDetailsTextView = findViewById(R.id.farmManagementDetailsTextView)

    setSupportActionBar(toolbar)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setDisplayShowHomeEnabled(true)

    collapsingToolbarLayout.title = intent.extras?.getString(Constants.SERVICE_TYPE)
    serviceDetailsTextView.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
      Html.fromHtml(
        intent.extras?.getString(Constants.SERVICE_TYPE_DETAILS),
        Html.FROM_HTML_MODE_COMPACT
      )
    } else {
      Html.fromHtml(intent.extras?.getString(Constants.SERVICE_TYPE_DETAILS))
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
