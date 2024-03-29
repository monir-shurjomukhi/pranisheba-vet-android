package com.pranisheba.vet.ui.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pranisheba.vet.R
import com.pranisheba.vet.model.InsertCheck
import com.pranisheba.vet.model.Login
import com.pranisheba.vet.model.OtpData
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
          message.value = R.string.otp_sent_to_your_mobile_number
        } else {
          message.value = R.string.could_not_send_otp
        }

        progress.value = false
      }

      override fun onFailure(call: Call<InsertCheck>, t: Throwable) {
        Log.e(TAG, "onFailure: ${t.message}", t)
        message.value = R.string.could_not_send_otp
        progress.value = false
      }
    })
  }

  fun verifyOtp(otpData: OtpData) {
    progress.value = true
    apiClient?.verifyOtp(otpData)?.enqueue(object : Callback<String> {
      override fun onResponse(call: Call<String>, response: Response<String>) {
        if (response.isSuccessful) {
          if (response.body().equals(" 1")) {
            val updateLogin = UpdateLogin(
              insertCheck.value?.id!!,
              insertCheck.value?.mobileNumber!!, otpData.otp.toString()
            )
            updateLogin(updateLogin)
          } else {
            message.value = R.string.could_not_verify_otp
            progress.value = false
          }
        } else {
          message.value = R.string.could_not_verify_otp
          progress.value = false
        }
      }

      override fun onFailure(call: Call<String>, t: Throwable) {
        Log.e(TAG, "onFailure: ${t.message}", t)
        message.value = R.string.could_not_verify_otp
        progress.value = false
      }
    })
  }

  private fun updateLogin(updateLogin: UpdateLogin) {
    apiClient?.updateLogin(updateLogin)?.enqueue(object : Callback<UpdateLogin> {
      override fun onResponse(call: Call<UpdateLogin>, response: Response<UpdateLogin>) {
        if (response.isSuccessful) {
          val login = Login(updateLogin.mobileNumber.toString(), updateLogin.otp.toString())
          login(login)
        } else {
          message.value = R.string.could_not_login
        }
      }

      override fun onFailure(call: Call<UpdateLogin>, t: Throwable) {
        Log.e(TAG, "onFailure: ${t.message}", t)
        message.value = R.string.could_not_login
        progress.value = false
      }
    })
  }

  private fun login(login: Login) {
    apiClient?.login(login)?.enqueue(object : Callback<String> {
      override fun onResponse(call: Call<String>, response: Response<String>) {
        if (response.isSuccessful) {
          login.token = response.body()
          _login.value = login
        } else {
          message.value = R.string.could_not_login
        }

        progress.value = false
      }

      override fun onFailure(call: Call<String>, t: Throwable) {
        Log.e(TAG, "onFailure: ${t.message}", t)
        message.value = R.string.could_not_login
        progress.value = false
      }
    })
  }

  companion object {
    private const val TAG = "LoginViewModel"
  }
}
