package com.pranisheba.vet.networking

import com.pranisheba.vet.model.LoginResponse
import com.pranisheba.vet.model.SignUp
import com.pranisheba.vet.model.SignUpData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {

  ///////////////////// GET ///////////////////

  @GET("insertcheck/mobile_number")
  fun login(
    @Query("mobile_number") mobileNumber: String
  ): Call<LoginResponse>

  @POST("customers/")
  fun signUp(
    @Body signUp: SignUpData
  ): Call<SignUp>
}