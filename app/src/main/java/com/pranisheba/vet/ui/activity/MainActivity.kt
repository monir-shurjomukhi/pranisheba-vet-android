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
import androidx.webkit.WebSettingsCompat
import androidx.webkit.WebViewFeature
import com.pranisheba.vet.R


class MainActivity : AppCompatActivity() {

  private lateinit var progress: ProgressDialog
  private lateinit var webView: WebView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContentView(R.layout.activity_main)

    progress = ProgressDialog(this)
    progress.setMessage("Please Wait...")
    progress.setCancelable(false)

    webView = findViewById(R.id.webView)

    webView.settings.javaScriptEnabled = true
    webView.settings.loadWithOverviewMode = true
    webView.settings.useWideViewPort = true
    webView.settings.domStorageEnabled = true
    webView.settings.setAppCacheEnabled(true)
    webView.settings.loadsImagesAutomatically = true
    webView.settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
    webView.webViewClient = object : WebViewClient() {
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

    webView.loadUrl("https://pranishebavet.com.bd/")

    if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
      WebSettingsCompat.setForceDark(webView.settings, WebSettingsCompat.FORCE_DARK_OFF)
    }
  }

  override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
    if (event?.action != ACTION_UP || event.keyCode != KEYCODE_BACK) {
      return super.onKeyUp(keyCode, event)
    }

    if (webView.canGoBack()) {
      webView.goBack()
    } else {
      finish()
    }

    return true
  }

  companion object {
    private const val TAG = "MainActivity"
  }
}
