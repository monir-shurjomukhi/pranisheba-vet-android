package com.pranisheba.vet.preference

import android.content.Context
import android.content.SharedPreferences
import com.pranisheba.vet.util.Constants


const val PREFERENCE_TITLE = "VetPreference"

class VetPreference(context: Context) {
  private val preferences: SharedPreferences =
    context.getSharedPreferences(PREFERENCE_TITLE, Context.MODE_PRIVATE)
  private val editor: SharedPreferences.Editor = preferences.edit()

  fun setFirstTimeLaunch(isFirstTime: Boolean) {
    editor.putBoolean(Constants.FIRST_TIME, isFirstTime)
    editor.apply()
  }

  fun isFirstTimeLaunch(): Boolean {
    return preferences.getBoolean(Constants.FIRST_TIME, true)
  }

  fun getSelectedLanguage(): String? {
    return preferences.getString(Constants.LANGUAGE, "")
  }

  fun putSelectedLanguage(language: String) {
    editor.putString(Constants.LANGUAGE, language)
    editor.apply()
  }
}
