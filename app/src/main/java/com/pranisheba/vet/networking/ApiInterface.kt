package com.pranisheba.vet.networking

import com.pranisheba.vet.model.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {

  ///////////////////// GET ///////////////////

  @GET("insertcheck/{mobile_number}")
  fun insertCheck(
    @Path("mobile_number") mobileNumber: String
  ): Call<InsertCheck>

  //////////////////// POST ///////////////////

  @POST("customers")
  fun signUp(
    @Body signUp: SignUpData
  ): Call<SignUp>

  @POST("verify_input_code")
  fun verifyOtp(
    @Body otpData: OtpData
  ): Call<String>

  @POST("update_customer_logins")
  fun updateLogin(
    @Body updateLogin: UpdateLogin
  ): Call<UpdateLogin>

  @POST("auth/login")
  fun login(
    @Body login: Login
  ): Call<String>
}
