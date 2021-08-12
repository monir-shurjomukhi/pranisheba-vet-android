package com.pranisheba.vet.model

import com.google.gson.annotations.SerializedName

data class Login(
  @SerializedName("mobile_number") var mobileNumber: String?,
  @SerializedName("password") var password: String?,
  @SerializedName("token") var token: String?
) {
  constructor(mobileNumber: String, password: String): this(mobileNumber, password, null)
}
