package com.pranisheba.vet.model

import com.google.gson.annotations.SerializedName

data class BreedData(
  @SerializedName("id") val id: Int?,
  @SerializedName("name") val name: String?,
  @SerializedName("animal_id") val animalId: Int?,
  @SerializedName("animal_name") val animalName: String?,
  @SerializedName("breed_of_animal_id") val breedType: Int?,
  @SerializedName("breed_of_animal") val animalBreed: String?
)
