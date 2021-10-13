package com.pranisheba.vet.model

import com.google.gson.annotations.SerializedName

data class CustomerData(
  @SerializedName("id") val id: Int?,
  @SerializedName("name") val name: String?,
  @SerializedName("mobile_number") val mobileNumber: String?,
  @SerializedName("email") val email: String?,
  @SerializedName("farm_name") val farmName: String?,
  @SerializedName("address") val address: String?
)
