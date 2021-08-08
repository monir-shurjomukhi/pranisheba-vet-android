package com.pranisheba.vet.networking

import com.pranisheba.vet.model.SignUp
import com.pranisheba.vet.model.SignUpData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {

  @POST("auth/customers/")
  fun signUp(
    @Body signUp: SignUpData
  ): Call<SignUp>
}