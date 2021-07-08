package com.pranisheba.vet.ui.activity

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.pranisheba.vet.R
import com.pranisheba.vet.util.Constants
import kotlinx.android.synthetic.main.activity_service_details.*

class ServiceDetailsActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_service_details)

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
