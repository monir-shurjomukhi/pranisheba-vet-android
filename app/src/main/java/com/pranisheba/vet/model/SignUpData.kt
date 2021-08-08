package com.pranisheba.vet.model

import com.google.gson.annotations.SerializedName

data class SignUpData(
  @SerializedName("id") val id: Int?,
  @SerializedName("name") val name: String?,
  @SerializedName("mobile_number") val mobileNumber: String?,
  @SerializedName("email") val email: String?,
  @SerializedName("farm_name") val farmName: String?,
  @SerializedName("address") val address: String?,
  @SerializedName("user_id") val userId: String?
) {
  constructor(name: String, mobileNumber: String, email: String, farmName: String, address: String)
      : this(null, name, mobileNumber, email, farmName, address, null)
}
