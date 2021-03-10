package com.pranisheba.vet.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.pranisheba.vet.preference.VetPreference
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

open class BaseViewModel(application: Application) : AndroidViewModel(application) {
  val progress = MutableLiveData<Boolean>()
  val message = MutableLiveData<String>()
  val preference = VetPreference(application)

  private val viewModelJob = Job()
  protected val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

  override fun onCleared() {
    super.onCleared()
    viewModelJob.cancel()
  }
}
