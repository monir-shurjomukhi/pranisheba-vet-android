package com.pranisheba.vet.util

import android.content.Context
import java.util.*

fun setLocale(context: Context, language: String) {
  val locale = Locale(language)
  Locale.setDefault(locale)
  val config = context.resources.configuration
  config.setLocale(locale)
  context.createConfigurationContext(config)
  context.resources.updateConfiguration(config, context.resources.displayMetrics)
}
