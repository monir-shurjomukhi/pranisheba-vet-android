package com.pranisheba.vet.ui.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.pranisheba.vet.R
import com.pranisheba.vet.preference.VetPreference
import com.pranisheba.vet.util.setLocale


class LanguageActivity : AppCompatActivity() {

  private lateinit var preference: VetPreference

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_language)

    preference = VetPreference(this)
  }

  fun setBangla(view: View) {
    preference.putSelectedLanguage("bn")
    setLocale(this, "bn")
    startActivity(Intent(this, MainActivity2::class.java))
  }

  fun setEnglish(view: View) {
    preference.putSelectedLanguage("en")
    setLocale(this, "en")
    startActivity(Intent(this, MainActivity2::class.java))
  }

  fun launchWebsite(view: View) {
    val webpage: Uri = Uri.parse("https://www.pranishebavet.com.bd/")
    val intent = Intent(Intent.ACTION_VIEW, webpage)
    if (intent.resolveActivity(packageManager) != null) {
      startActivity(intent)
    }
  }
}