package com.pranisheba.vet.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.KeyEvent.ACTION_UP
import android.view.KeyEvent.KEYCODE_BACK
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.webkit.WebSettingsCompat
import androidx.webkit.WebViewFeature
import com.pranisheba.vet.R
import com.pranisheba.vet.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

    binding.webView.settings.javaScriptEnabled = true
    binding.webView.settings.loadWithOverviewMode = true
    binding.webView.settings.useWideViewPort = true
    binding.webView.settings.domStorageEnabled = true
    binding.webView.settings.builtInZoomControls = false
    binding.webView.webViewClient = object : WebViewClient() {
      override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
        view.loadUrl(url)
        return true
      }

      override fun onPageFinished(view: WebView, url: String) {
      }

      override fun onReceivedError(
        view: WebView?,
        request: WebResourceRequest?,
        error: WebResourceError?
      ) {
        super.onReceivedError(view, request, error)
        Log.e(TAG, "onReceivedError:")
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
