package com.pranisheba.vet.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
  @SerializedName("success") val success: Boolean?,
  @SerializedName("key") val key: String?,
  @SerializedName("id") val id: Int?,
  @SerializedName("mobile_number") val mobileNumber: String?
)
