package com.pranisheba.vet.ui.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.pranisheba.vet.R


class LanguageActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_language)
  }

  fun setBangla(view: View) {
    
  }

  fun setEnglish(view: View) {

  }

  fun launchWebsite(view: View) {
    val webpage: Uri = Uri.parse("https://www.pranishebavet.com.bd/")
    val intent = Intent(Intent.ACTION_VIEW, webpage)
    if (intent.resolveActivity(packageManager) != null) {
      startActivity(intent)
    }
  }
}