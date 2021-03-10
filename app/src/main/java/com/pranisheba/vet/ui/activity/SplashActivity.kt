package com.pranisheba.vet.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.pranisheba.vet.R

class SplashActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_splash)

    Handler().postDelayed(Runnable {
      startActivity(Intent(this, MainActivity::class.java))
      finish()
    }, 300)
  }
}