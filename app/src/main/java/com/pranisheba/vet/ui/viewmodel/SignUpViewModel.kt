package com.pranisheba.vet.ui.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pranisheba.vet.model.SignUp
import com.pranisheba.vet.model.SignUpData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpViewModel(application: Application) : BaseViewModel(application) {
  private val _signUp = MutableLiveData<SignUp>()
  val signUp: LiveData<SignUp>
    get() = _signUp

  fun signUp(signUpData: SignUpData) {
    progress.value = true
    apiClient?.signUp(signUpData)?.enqueue(object : Callback<SignUp> {
      override fun onResponse(call: Call<SignUp>, response: Response<SignUp>) {
        if (response.isSuccessful) {
          _signUp.value = response.body()
        }

        progress.value = false
      }

      override fun onFailure(call: Call<SignUp>, t: Throwable) {
        Log.e(TAG, "onFailure: ${t.message}", t)
        progress.value = false
      }
    })
  }

  companion object {
    private const val TAG = "SignUpViewModel"
  }
}
