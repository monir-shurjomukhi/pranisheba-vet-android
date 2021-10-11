package com.pranisheba.vet.ui.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pranisheba.vet.model.CounterNumber
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TreatmentFormViewModel(application: Application) : BaseViewModel(application) {
  private val _counterNumber = MutableLiveData<CounterNumber>()
  val counterNumber: LiveData<CounterNumber>
    get() = _counterNumber

  fun getCounterNumber() {
    apiClient?.createCounterNumber("Bearer ${preference.getAuthToken()}")?.enqueue(object : Callback<CounterNumber> {
      override fun onResponse(call: Call<CounterNumber>, response: Response<CounterNumber>) {
        Log.d(TAG, "onResponse: $response")
        if (response.isSuccessful) {
          _counterNumber.value = response.body()
        }
      }

      override fun onFailure(call: Call<CounterNumber>, t: Throwable) {
        Log.e(TAG, "onFailure: ${t.message}", t)
      }
    })
  }

  companion object {
    private const val TAG = "TreatmentFormViewModel"
  }
}
