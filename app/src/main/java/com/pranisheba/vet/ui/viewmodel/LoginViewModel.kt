package com.pranisheba.vet.ui.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pranisheba.vet.model.LoginResponse
import com.pranisheba.vet.model.Otp
import com.pranisheba.vet.networking.ApiClient
import com.pranisheba.vet.networking.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel(application: Application) : BaseViewModel(application) {
  private val _loginResponse = MutableLiveData<LoginResponse>()
  val loginResponse: LiveData<LoginResponse>
    get() = _loginResponse

  private val _verifyOtp = MutableLiveData<String>()
  val verifyOtp: LiveData<String>
    get() = _verifyOtp

  fun login(mobileNumber: String) {
    progress.value = true
    val apiClient = ApiClient().getApiClient()?.create(ApiInterface::class.java)
    apiClient?.login(mobileNumber)?.enqueue(object : Callback<LoginResponse> {
      override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
        if (response.isSuccessful) {
          _loginResponse.value = response.body()
        }

        progress.value = false
      }

      override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
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
          _verifyOtp.value = response.body()
        }

        progress.value = false
      }

      override fun onFailure(call: Call<String>, t: Throwable) {
        Log.e(TAG, "onFailure: ${t.message}", t)
        progress.value = false
      }
    })
  }

  companion object {
    private const val TAG = "LoginViewModel"
  }
}
