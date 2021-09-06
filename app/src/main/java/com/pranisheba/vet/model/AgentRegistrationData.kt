package com.pranisheba.vet.model

import com.google.gson.annotations.SerializedName

data class AgentRegistrationData(
  @SerializedName("id") val id: Int?,
  @SerializedName("applicant_name") val applicantName: String?,
  @SerializedName("dob") val dob: String?,
  @SerializedName("mobile_number") val mobileNumber: String?,
  @SerializedName("email") val email: String?,
  @SerializedName("type_of_business") val typeOfBusiness: String?,
  @SerializedName("address") val address: String?,
  @SerializedName("years_in_business") val yearsInBusiness: String?,
  @SerializedName("trade_license") val tradeLicense: String?,
  @SerializedName("tin") val tin: String?,
  @SerializedName("website") val website: String?
) {
  constructor(
    applicantName: String?,
    dob: String?,
    mobileNumber: String?,
    email: String?,
    typeOfBusiness: String?,
    address: String?,
    yearsInBusiness: String?,
    tradeLicense: String?,
    tin: String?,
    website: String?
  ) : this(
    null,
    applicantName,
    dob,
    mobileNumber,
    email,
    typeOfBusiness,
    address,
    yearsInBusiness,
    tradeLicense,
    tin,
    website
  )
}
