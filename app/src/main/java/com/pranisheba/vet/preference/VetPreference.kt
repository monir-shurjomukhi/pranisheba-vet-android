package com.pranisheba.vet.preference

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.pranisheba.vet.util.AUTH_TOKEN
import com.pranisheba.vet.util.FIRST_TIME
import com.pranisheba.vet.util.LANGUAGE
import com.pranisheba.vet.util.MOBILE_NUMBER


class VetPreference(context: Context) {
  private val preferences: SharedPreferences =
    context.getSharedPreferences(PREFERENCE_TITLE, Context.MODE_PRIVATE)
  private val editor: SharedPreferences.Editor = preferences.edit()

  fun putAuthToken(token: String?) {
    Log.d(PREFERENCE_TITLE, "putAuthToken: $token")
    var newToken = token?.drop(2)
    newToken = newToken?.dropLast(1)
    editor.putString(AUTH_TOKEN, newToken)
    Log.d(PREFERENCE_TITLE, "putAuthToken: $newToken")
    editor.apply()
  }

  fun getAuthToken(): String? {
    Log.d(PREFERENCE_TITLE, "getAuthToken: ${preferences.getString(AUTH_TOKEN, "")}")
    return preferences.getString(AUTH_TOKEN, "")
  }

  fun putMobileNumber(token: String?) {
    editor.putString(MOBILE_NUMBER, token)
    editor.apply()
  }

  fun getMobileNumber(): String? {
    return preferences.getString(MOBILE_NUMBER, "")
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
