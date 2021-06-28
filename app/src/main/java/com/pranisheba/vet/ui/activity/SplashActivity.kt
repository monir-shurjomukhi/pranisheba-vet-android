package com.pranisheba.vet.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.pranisheba.vet.R
import com.pranisheba.vet.preference.VetPreference

class SplashActivity : AppCompatActivity() {

  private lateinit var preference : VetPreference
  private lateinit var launchIntent: Intent

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_splash)

    preference = VetPreference(this)

    launchIntent = if (preference.getSelectedLanguage().isNullOrBlank()) {
      Intent(this, LanguageActivity::class.java)
    } else {
      Intent(this, MainActivity2::class.java)
    }

    Handler().postDelayed(Runnable {
      startActivity(launchIntent)
      finish()
    }, 300)
  }

  companion object {
    private const val TAG = "SplashActivity"
  }
}
