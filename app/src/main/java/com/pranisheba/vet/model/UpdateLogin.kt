package com.pranisheba.vet.model

import com.google.gson.annotations.SerializedName

data class UpdateLogin(
  @SerializedName("id") val id: Int?,
  @SerializedName("mobile_number") val mobileNumber: String?,
  @SerializedName("otp") val otp: String?,
  @SerializedName("success") val success: Boolean?,
  @SerializedName("return_code") val returnCode: String?
) {
  constructor(id: Int, mobileNumber: String, otp: String): this(id, mobileNumber, otp, null, null)
}
