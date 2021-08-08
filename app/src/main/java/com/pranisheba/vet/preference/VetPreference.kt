package com.pranisheba.vet.preference

import android.content.Context
import android.content.SharedPreferences
import com.pranisheba.vet.util.AUTH_TOKEN
import com.pranisheba.vet.util.FIRST_TIME
import com.pranisheba.vet.util.LANGUAGE


class VetPreference(context: Context) {
  private val preferences: SharedPreferences =
    context.getSharedPreferences(PREFERENCE_TITLE, Context.MODE_PRIVATE)
  private val editor: SharedPreferences.Editor = preferences.edit()

  fun putAuthToken(token: String?) {
    editor.putString(AUTH_TOKEN, token)
    editor.apply()
  }

  fun getAuthToken(): String? {
    return preferences.getString(AUTH_TOKEN, "")
  }

  fun putFirstTimeLaunch(isFirstTime: Boolean) {
    editor.putBoolean(FIRST_TIME, isFirstTime)
    editor.apply()
  }

  fun isFirstTimeLaunch(): Boolean {
    return preferences.getBoolean(FIRST_TIME, true)
  }

  fun getSelectedLanguage(): String? {
    return preferences.getString(LANGUAGE, "")
  }

  fun putSelectedLanguage(language: String) {
    editor.putString(LANGUAGE, language)
    editor.apply()
  }

  companion object {
    private const val PREFERENCE_TITLE = "VetPreference"
  }
}
