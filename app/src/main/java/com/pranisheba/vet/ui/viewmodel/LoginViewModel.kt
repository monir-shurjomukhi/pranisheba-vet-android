package com.pranisheba.vet.ui.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pranisheba.vet.model.InsertCheck
import com.pranisheba.vet.model.Otp
import com.pranisheba.vet.model.UpdateLogin
import com.pranisheba.vet.networking.ApiClient
import com.pranisheba.vet.networking.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel(application: Application) : BaseViewModel(application) {
  private val _insertCheck = MutableLiveData<InsertCheck>()
  val insertCheck: LiveData<InsertCheck>
    get() = _insertCheck

  private val _verifyOtp = MutableLiveData<String>()
  val verifyOtp: LiveData<String>
    get() = _verifyOtp

  fun insertCheck(mobileNumber: String) {
    progress.value = true
    val apiClient = ApiClient().getApiClient()?.create(ApiInterface::class.java)
    apiClient?.insertCheck(mobileNumber)?.enqueue(object : Callback<InsertCheck> {
      override fun onResponse(call: Call<InsertCheck>, response: Response<InsertCheck>) {
        if (response.isSuccessful) {
          _insertCheck.value = response.body()
        }

        progress.value = false
      }

      override fun onFailure(call: Call<InsertCheck>, t: Throwable) {
        Log.e(TAG, "onFailure: ${t.message}", t)
        progress.value = false
      }
    })
  }

  fun verifyOtp(otpData: Otp) {
    progress.value = true
    val apiClient = ApiClient().getApiClient()?.create(ApiInterface::class.java)
    apiClient?.verifyOtp(otpData)?.enqueue(object : Callback<String> {
      override fun onResponse(call: Call<String>, response: Response<String>) {
        if (response.isSuccessful) {
          if (response.body().equals("1")) {
            val updateLogin = UpdateLogin(insertCheck.value?.id!!,
              insertCheck.value?.mobileNumber!!, otpData.otp.toString())
            updateLogin(updateLogin)
          }
        }

        progress.value = false
      }

      override fun onFailure(call: Call<String>, t: Throwable) {
        Log.e(TAG, "onFailure: ${t.message}", t)
        progress.value = false
      }
    })
  }

  fun updateLogin(updateLogin: UpdateLogin) {
    progress.value = true

    val apiClient = ApiClient().getApiClient()?.create(ApiInterface::class.java)
    apiClient?.updateLogin(updateLogin)?.enqueue(object: Callback<UpdateLogin> {
      override fun onResponse(call: Call<UpdateLogin>, response: Response<UpdateLogin>) {
        if (response.isSuccessful) {

        }
      }

      override fun onFailure(call: Call<UpdateLogin>, t: Throwable) {
        Log.e(TAG, "onFailure: ${t.message}", t)
        progress.value = false
      }
    })
  }

  companion object {
    private const val TAG = "LoginViewModel"
  }
}
