package com.pranisheba.vet.model

import com.google.gson.annotations.SerializedName

data class CounterNumberData(
  @SerializedName("id") val id: Int?,
  @SerializedName("counter_number") val counterNumber: String?
)
