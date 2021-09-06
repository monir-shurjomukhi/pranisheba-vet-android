package com.pranisheba.vet.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.pranisheba.vet.BuildConfig
import com.pranisheba.vet.networking.ApiClient
import com.pranisheba.vet.networking.ApiInterface
import com.pranisheba.vet.preference.VetPreference

open class BaseViewModel(application: Application) : AndroidViewModel(application) {
  val progress = MutableLiveData<Boolean>()
  val message = MutableLiveData<Int>()
  val preference = VetPreference(application)
  val apiClient = ApiClient().getApiClient(BuildConfig.BASE_URL)?.create(ApiInterface::class.java)
  val apiClientAdmin = ApiClient().getApiClient(BuildConfig.BASE_URL_ADMIN)?.create(ApiInterface::class.java)
}
