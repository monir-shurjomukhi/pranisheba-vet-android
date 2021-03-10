package com.pranisheba.vet.ui.activity

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.KeyEvent.ACTION_UP
import android.view.KeyEvent.KEYCODE_BACK
import android.webkit.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.webkit.WebSettingsCompat
import androidx.webkit.WebViewFeature
import com.pranisheba.vet.R
import com.pranisheba.vet.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  private lateinit var progress: ProgressDialog

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

    progress = ProgressDialog(this)
    progress.setMessage("Please Wait...")
    progress.setCancelable(false)

    binding.webView.settings.javaScriptEnabled = true
    binding.webView.settings.loadWithOverviewMode = true
    binding.webView.settings.useWideViewPort = true
    binding.webView.settings.domStorageEnabled = true
    binding.webView.settings.setAppCacheEnabled(true)
    binding.webView.settings.loadsImagesAutomatically = true
    binding.webView.settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
    binding.webView.webViewClient = object : WebViewClient() {
      override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
        if (Uri.parse(url).host == "pranishebavet.com.bd" ||
          Uri.parse(url).host == "https://pranishebavet.com.bd" ||
          Uri.parse(url).host == "admin.pranishebavet.com.bd" ||
          Uri.parse(url).host == "https://admin.pranishebavet.com.bd") {
          // This is my web site, so do not override; let my WebView load the page
          return false
        }
        // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
        Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
          startActivity(this)
        }
        return true
      }

      override fun onPageFinished(view: WebView, url: String) {
        //progress.dismiss()
      }

      override fun onReceivedError(
        view: WebView?,
        request: WebResourceRequest?,
        error: WebResourceError?
      ) {
        super.onReceivedError(view, request, error)
        Log.e(TAG, "onReceivedError:")
        //progress.dismiss()
      }
    }

    binding.webView.loadUrl("https://pranishebavet.com.bd/")

    if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
      WebSettingsCompat.setForceDark(binding.webView.settings, WebSettingsCompat.FORCE_DARK_OFF)
    }
  }

  override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
    if (event?.action != ACTION_UP || event.keyCode != KEYCODE_BACK) {
      return super.onKeyUp(keyCode, event)
    }

    if (binding.webView.canGoBack()) {
      binding.webView.goBack()
    } else {
      finish()
    }

    return true
  }

  companion object {
    private const val TAG = "MainActivity"
  }
}
