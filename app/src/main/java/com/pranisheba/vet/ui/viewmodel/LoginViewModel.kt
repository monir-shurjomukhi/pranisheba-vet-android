package com.pranisheba.vet.ui.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pranisheba.vet.model.InsertCheck
import com.pranisheba.vet.model.Login
import com.pranisheba.vet.model.Otp
import com.pranisheba.vet.model.UpdateLogin
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel(application: Application) : BaseViewModel(application) {
  private val _insertCheck = MutableLiveData<InsertCheck>()
  val insertCheck: LiveData<InsertCheck>
    get() = _insertCheck

  private val _login = MutableLiveData<Login>()
  val login: LiveData<Login>
    get() = _login

  fun insertCheck(mobileNumber: String) {
    progress.value = true
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
    apiClient?.updateLogin(updateLogin)?.enqueue(object: Callback<UpdateLogin> {
      override fun onResponse(call: Call<UpdateLogin>, response: Response<UpdateLogin>) {
        if (response.isSuccessful) {
          val login = Login(updateLogin.mobileNumber.toString(), updateLogin.otp.toString())
          login(login)
        }

        progress.value = false
      }

      override fun onFailure(call: Call<UpdateLogin>, t: Throwable) {
        Log.e(TAG, "onFailure: ${t.message}", t)
        progress.value = false
      }
    })
  }

  fun login(login: Login) {
    progress.value = true
    apiClient?.login(login)?.enqueue(object : Callback<String> {
      override fun onResponse(call: Call<String>, response: Response<String>) {
        if (response.isSuccessful) {
          login.token = response.body()
          _login.value = login
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
