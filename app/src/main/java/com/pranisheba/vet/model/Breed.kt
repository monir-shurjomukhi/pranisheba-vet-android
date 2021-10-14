package com.pranisheba.vet.model

import com.google.gson.annotations.SerializedName

data class Breed(
  @SerializedName("animal_id") var animalId: Int?,
  @SerializedName("breed_of_animal_id") var typeOfBreed: Int?,
  @SerializedName("data") var data: List<BreedData>?
) {
  constructor(animalId: Int?, typeOfBreed: Int?) : this(animalId, typeOfBreed, null)
}
