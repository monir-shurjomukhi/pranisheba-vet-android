package com.pranisheba.vet.ui.fragment

import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.MultiAutoCompleteTextView
import android.widget.ScrollView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputLayout
import com.pranisheba.vet.R
import com.pranisheba.vet.databinding.FragmentAnimalInfoBinding
import com.pranisheba.vet.model.Breed
import com.pranisheba.vet.ui.activity.TreatmentFormActivity
import com.pranisheba.vet.ui.viewmodel.TreatmentFormViewModel

class AnimalInfoFragment : Fragment() {

  private lateinit var binding: FragmentAnimalInfoBinding
  private lateinit var viewModel: TreatmentFormViewModel

  private val animalGroup =
    mapOf("Ruminants" to 1, "Poultry" to 2, "Pet Bird" to 3, "Pet & Zoo Animals" to 4)
  private val animalTypeRuminants =
    mapOf("Cattle" to 1, "Sheep" to 2, "Goat" to 3, "Buffalo" to 4, "Others" to 35)
  private val animalTypePoultry =
    mapOf(
      "Broiler" to 5,
      "Layer" to 6,
      "Quail" to 7,
      "Duck" to 8,
      "Turkey" to 9,
      "Pigeon" to 10,
      "Goose" to 11,
      "Guinea Fowl" to 12,
      "Others" to 36
    )
  private val animalTypePetBird =
    mapOf(
      "Parrot" to 13,
      "Koel" to 14,
      "Mayna" to 15,
      "Dove" to 16,
      "Lovebird" to 17,
      "Others" to 36
    )
  private val animalTypePetAndZoo =
    mapOf(
      "Dog" to 18,
      "Cat" to 19,
      "Deer" to 20,
      "Rabbit" to 21,
      "Snake" to 22,
      "Tiger" to 23,
      "Elephant" to 24,
      "Horse" to 29,
      "Monkey" to 33,
      "Others" to 36
    )
  private val typeOfBreed = mapOf("Local" to 1, "Cross Breed" to 2, "Foreign" to 3)
  private val animalBreed = mutableMapOf<String, Int>()

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentAnimalInfoBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    viewModel = ViewModelProvider(requireActivity()).get(TreatmentFormViewModel::class.java)

    binding.treatedBeforeTextView.inputType = InputType.TYPE_NULL
    binding.animalGroupTextView.inputType = InputType.TYPE_NULL
    binding.animalTypeTextView.inputType = InputType.TYPE_NULL
    binding.breedTypeTextView.inputType = InputType.TYPE_NULL
    binding.animalBreedTextView.inputType = InputType.TYPE_NULL
    binding.partOfIotTextView.inputType = InputType.TYPE_NULL
    binding.ageUnitTextView.inputType = InputType.TYPE_NULL
    binding.animalGenderTextView.inputType = InputType.TYPE_NULL
    binding.stageOfGenderTextView.inputType = InputType.TYPE_NULL
    binding.deWormingStatusTextView.inputType = InputType.TYPE_NULL
    binding.vaccinationStatusTextView.inputType = InputType.TYPE_NULL
    binding.typeOfVaccinesTextView.inputType = InputType.TYPE_NULL

    viewModel.animalBreed.observe(viewLifecycleOwner, { breed ->
      animalBreed.clear()
      for (data in breed.data!!) {
        animalBreed[data.name.toString()] = data.id!!
      }
      context?.let {
        ArrayAdapter(
          it, android.R.layout.simple_list_item_1,
          animalBreed.keys.toList()
        ).also { adapter ->
          binding.animalBreedTextView.setAdapter(adapter)
        }
      }
    })

    context?.let {
      ArrayAdapter(it, android.R.layout.simple_list_item_1, listOf("Yes", "No"))
        .also { adapter ->
          binding.treatedBeforeTextView.setAdapter(adapter)
        }
    }

    binding.treatedBeforeTextView.addTextChangedListener(object : TextWatcher {
      override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

      override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        if (s?.isNotEmpty() == true) {
          when (s.toString()) {
            "Yes" -> {
              binding.previousPrescriptionLayout.visibility = View.VISIBLE
            }
            "No" -> {
              binding.previousPrescriptionLayout.visibility = View.GONE
            }
          }
        }
      }

      override fun afterTextChanged(s: Editable?) {}
    })

    context?.let {
      ArrayAdapter(
        it, android.R.layout.simple_list_item_1,
        animalGroup.keys.toList()
      ).also { adapter ->
        binding.animalGroupTextView.setAdapter(adapter)
      }
    }

    binding.animalGroupTextView.addTextChangedListener(object : TextWatcher {
      override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

      override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        if (s?.isNotEmpty() == true) {
          when (s.toString()) {
            "Ruminants" -> {
              binding.animalTypeTextView.text = null
              binding.breedTypeLayout.visibility = View.VISIBLE
              binding.animalBreedLayout.visibility = View.VISIBLE

              context?.let {
                ArrayAdapter(
                  it, android.R.layout.simple_list_item_1,
                  animalTypeRuminants.keys.toList()
                ).also { adapter ->
                  binding.animalTypeTextView.setAdapter(adapter)
                }
              }
            }
            "Poultry" -> {
              binding.animalTypeTextView.text = null
              binding.breedTypeLayout.visibility = View.GONE
              binding.animalBreedLayout.visibility = View.GONE

              context?.let {
                ArrayAdapter(
                  it, android.R.layout.simple_list_item_1,
                  animalTypePoultry.keys.toList()
                ).also { adapter ->
                  binding.animalTypeTextView.setAdapter(adapter)
                }
              }
            }
            "Pet Bird" -> {
              binding.animalTypeTextView.text = null
              binding.breedTypeLayout.visibility = View.GONE
              binding.animalBreedLayout.visibility = View.GONE

              context?.let {
                ArrayAdapter(
                  it, android.R.layout.simple_list_item_1,
                  animalTypePetBird.keys.toList()
                ).also { adapter ->
                  binding.animalTypeTextView.setAdapter(adapter)
                }
              }
            }
            "Pet & Zoo Animals" -> {
              binding.animalTypeTextView.text = null
              binding.breedTypeLayout.visibility = View.GONE
              binding.animalBreedLayout.visibility = View.GONE

              context?.let {
                ArrayAdapter(
                  it, android.R.layout.simple_list_item_1,
                  animalTypePetAndZoo.keys.toList()
                ).also { adapter ->
                  binding.animalTypeTextView.setAdapter(adapter)
                }
              }
            }
          }
        }
      }

      override fun afterTextChanged(s: Editable?) {}
    })

    binding.animalTypeTextView.addTextChangedListener(object : TextWatcher {
      override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

      override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        binding.breedTypeLayout.editText?.text = null
        binding.animalBreedLayout.editText?.text = null

        if (binding.animalGroupTextView.text.toString() == "Pet & Zoo Animals") {
          when(binding.animalTypeTextView.text.toString()) {
            "Horse", "Dog", "Cat" -> {
              binding.breedTypeLayout.visibility = View.VISIBLE
              binding.animalBreedLayout.visibility = View.VISIBLE
            }
            else -> {
              binding.breedTypeLayout.visibility = View.GONE
              binding.animalBreedLayout.visibility = View.GONE
            }
          }
        }
      }

      override fun afterTextChanged(s: Editable?) {}
    })

    context?.let {
      ArrayAdapter(
        it, android.R.layout.simple_list_item_1,
        typeOfBreed.keys.toList()
      ).also { adapter ->
        binding.breedTypeTextView.setAdapter(adapter)
      }
    }

    binding.breedTypeTextView.addTextChangedListener(object : TextWatcher {
      override fun beforeTextChanged(
        s: CharSequence?,
        start: Int,
        count: Int,
        after: Int
      ) {
      }

      override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        binding.animalBreedTextView.text = null
        if (s?.isNotEmpty() == true) {
          when (binding.animalGroupTextView.text.toString()) {
            "Ruminants" -> {
              val breed = Breed(
                animalTypeRuminants[binding.animalTypeTextView.text.toString()],
                typeOfBreed[binding.breedTypeTextView.text.toString()]
              )
              viewModel.getAnimalBreed(breed)
            }
            "Poultry" -> {
              val breed = Breed(
                animalTypePoultry[binding.animalTypeTextView.text.toString()],
                typeOfBreed[binding.breedTypeTextView.text.toString()]
              )
              viewModel.getAnimalBreed(breed)
            }
            "Pet Bird" -> {
              val breed = Breed(
                animalTypePetBird[binding.animalTypeTextView.text.toString()],
                typeOfBreed[binding.breedTypeTextView.text.toString()]
              )
              viewModel.getAnimalBreed(breed)
            }
            "Pet & Zoo Animals" -> {
              val breed = Breed(
                animalTypePetAndZoo[binding.animalTypeTextView.text.toString()],
                typeOfBreed[binding.breedTypeTextView.text.toString()]
              )
              viewModel.getAnimalBreed(breed)
            }
          }
        }
      }

      override fun afterTextChanged(s: Editable?) {}
    })

    context?.let {
      ArrayAdapter(it, android.R.layout.simple_list_item_1, listOf("Yes", "No"))
        .also { adapter ->
          binding.partOfIotTextView.setAdapter(adapter)
        }
    }

    binding.partOfIotTextView.addTextChangedListener(object : TextWatcher {
      override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

      override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        if (s?.isNotEmpty() == true) {
          when (s.toString()) {
            "Yes" -> {
              binding.bolusIdLayout.visibility = View.VISIBLE
            }
            "No" -> {
              binding.bolusIdLayout.visibility = View.GONE
            }
          }
        }
      }

      override fun afterTextChanged(s: Editable?) {}
    })

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("Years", "Months", "Weeks", "Days")
      ).also { adapter ->
        binding.ageUnitTextView.setAdapter(adapter)
      }
    }

    context?.let {
      ArrayAdapter(it, android.R.layout.simple_list_item_1, listOf("Male", "Female"))
        .also { adapter ->
          binding.animalGenderTextView.setAdapter(adapter)
        }
    }

    binding.animalGenderTextView.addTextChangedListener(object : TextWatcher {
      override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

      override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        if (s?.isNotEmpty() == true) {
          binding.stageOfGenderLayout.visibility = View.VISIBLE
          when (s.toString()) {
            "Male" -> {
              binding.stageOfGenderLayout.hint = getString(R.string.stage_of_male)
              binding.stageOfGenderTextView.text = null
              context?.let {
                ArrayAdapter(
                  it,
                  android.R.layout.simple_list_item_1,
                  listOf(
                    "Calf",
                    "Kid",
                    "Puppy",
                    "Kitten",
                    "Ox",
                    "Bullock",
                    "Bull",
                    "Buck",
                    "Ram",
                    "Stallion"
                  )
                )
                  .also { adapter ->
                    binding.stageOfGenderTextView.setAdapter(adapter)
                  }
              }
            }
            "Female" -> {
              binding.stageOfGenderLayout.hint = getString(R.string.stage_of_female)
              binding.stageOfGenderTextView.text = null
              context?.let {
                ArrayAdapter(
                  it, android.R.layout.simple_list_item_1,
                  listOf(
                    "Calf",
                    "Kid",
                    "Puppy",
                    "Kitten",
                    "Ox",
                    "Mare",
                    "Heifer",
                    "Lactating",
                    "Dry",
                    "Pregnant"
                  )
                )
                  .also { adapter ->
                    binding.stageOfGenderTextView.setAdapter(adapter)
                  }
              }
            }
          }
        } else {
          binding.stageOfGenderLayout.visibility = View.GONE
        }
      }

      override fun afterTextChanged(s: Editable?) {}
    })

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("3 months", "2 months", "1 month", "No")
      ).also { adapter ->
        binding.deWormingStatusTextView.setAdapter(adapter)
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("3 months", "2 months", "1 month", "No")
      ).also { adapter ->
        binding.vaccinationStatusTextView.setAdapter(adapter)
      }
    }

    binding.vaccinationStatusTextView.addTextChangedListener(object : TextWatcher {
      override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

      override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        if (s?.isNotEmpty() == true) {
          if (s.toString() != "No") {
            binding.typeOfVaccinesLayout.visibility = View.VISIBLE
            binding.typeOfVaccinesTextView.text = null
            context?.let {
              ArrayAdapter(
                it,
                android.R.layout.simple_list_item_multiple_choice,
                listOf(
                  "Calf",
                  "Kid",
                  "Puppy",
                  "Kitten",
                  "Ox",
                  "Bullock",
                  "Bull",
                  "Buck",
                  "Ram",
                  "Stallion"
                )
              )
                .also { adapter ->
                  binding.typeOfVaccinesTextView.setAdapter(adapter)
                  binding.typeOfVaccinesTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
                }
            }
          } else {
            binding.typeOfVaccinesLayout.visibility = View.GONE
          }
        } else {
          binding.typeOfVaccinesLayout.visibility = View.GONE
        }
      }

      override fun afterTextChanged(s: Editable?) {}
    })

    (activity as TreatmentFormActivity).showPreviousInfo()
  }

  fun getScrollView(): ScrollView {
    return binding.scrollView
  }

  fun getTreatedBeforeLayout(): TextInputLayout {
    return binding.treatedBeforeLayout
  }

  fun getPreviousPrescriptionLayout(): TextInputLayout {
    return binding.previousPrescriptionLayout
  }

  fun getAnimalNameOrIdLayout(): TextInputLayout {
    return binding.animalNameOrIdLayout
  }

  fun getAnimalGroupLayout(): TextInputLayout {
    return binding.animalGroupLayout
  }

  fun getAnimalTypeLayout(): TextInputLayout {
    return binding.animalTypeLayout
  }

  fun getBreedTypeLayout(): TextInputLayout {
    return binding.breedTypeLayout
  }

  fun getAnimalBreedLayout(): TextInputLayout {
    return binding.animalBreedLayout
  }

  fun getPartOfIotLayout(): TextInputLayout {
    return binding.partOfIotLayout
  }

  fun getBolusIdLayout(): TextInputLayout {
    return binding.bolusIdLayout
  }

  fun getAnimalAgeLayout(): TextInputLayout {
    return binding.animalAgeLayout
  }

  fun getAgeUnitLayout(): TextInputLayout {
    return binding.ageUnitLayout
  }

  fun getAnimalWeightLayout(): TextInputLayout {
    return binding.animalWeightLayout
  }

  fun getAnimalGenderLayout(): TextInputLayout {
    return binding.animalGenderLayout
  }

  fun getStageOfGenderLayout(): TextInputLayout {
    return binding.stageOfGenderLayout
  }

  fun getDeWormingStatusLayout(): TextInputLayout {
    return binding.deWormingStatusLayout
  }

  fun getVaccinationStatusLayout(): TextInputLayout {
    return binding.vaccinationStatusLayout
  }

  fun getTypeOfVaccinesLayout(): TextInputLayout {
    return binding.typeOfVaccinesLayout
  }
}
