package com.pranisheba.vet.ui.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pranisheba.vet.model.Breed
import com.pranisheba.vet.model.CounterNumber
import com.pranisheba.vet.model.Customer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TreatmentFormViewModel(application: Application) : BaseViewModel(application) {
  private val _counterNumber = MutableLiveData<CounterNumber>()
  val counterNumber: LiveData<CounterNumber>
    get() = _counterNumber

  private val _customer = MutableLiveData<Customer>()
  val customer: LiveData<Customer>
    get() = _customer

  private val _animalBreed = MutableLiveData<Breed>()
  val animalBreed: LiveData<Breed>
    get() = _animalBreed

  fun getCounterNumber() {
    progress.value = true
    apiClient?.createCounterNumber("Bearer ${preference.getAuthToken()}")
      ?.enqueue(object : Callback<CounterNumber> {
        override fun onResponse(call: Call<CounterNumber>, response: Response<CounterNumber>) {
          Log.d(TAG, "onResponse: ${response.body()}")
          progress.value = false
          if (response.isSuccessful) {
            _counterNumber.value = response.body()
          }
        }

        override fun onFailure(call: Call<CounterNumber>, t: Throwable) {
          Log.e(TAG, "onFailure: ${t.message}", t)
          progress.value = false
        }
      })
  }

  fun getCustomer() {
    apiClient?.getCustomer(
      "Bearer ${preference.getAuthToken()}",
      preference.getMobileNumber().toString()
    )?.enqueue(object : Callback<Customer> {
      override fun onResponse(call: Call<Customer>, response: Response<Customer>) {
        Log.d(TAG, "onResponse: ${response.body()}")
        if (response.isSuccessful) {
          _customer.value = response.body()
        }
      }

      override fun onFailure(call: Call<Customer>, t: Throwable) {
        Log.e(TAG, "onFailure: ${t.message}", t)
      }
    })
  }

  fun getAnimalBreed(breed: Breed) {
    apiClient?.getAnimalBreed(breed)?.enqueue(object : Callback<Breed> {
      override fun onResponse(call: Call<Breed>, response: Response<Breed>) {
        Log.d(TAG, "onResponse: ${response.body()}")
        if (response.isSuccessful) {
          _animalBreed.value = response.body()
        }
      }

      override fun onFailure(call: Call<Breed>, t: Throwable) {
        Log.e(TAG, "onFailure: ${t.message}", t)
      }
    })
  }

  companion object {
    private const val TAG = "TreatmentFormViewModel"
  }
}
