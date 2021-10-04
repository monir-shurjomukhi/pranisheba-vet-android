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
import com.google.android.material.textfield.TextInputLayout
import com.pranisheba.vet.R
import com.pranisheba.vet.databinding.FragmentAnimalInfoBinding
import com.pranisheba.vet.ui.activity.TreatmentFormActivity

class AnimalInfoFragment : Fragment() {

  private lateinit var binding: FragmentAnimalInfoBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentAnimalInfoBinding.inflate(inflater, container, false)
    return binding.root
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

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.treatedBeforeLayout.setOnKeyListener(null)
    binding.animalGroupLayout.setOnKeyListener(null)
    binding.animalTypeLayout.setOnKeyListener(null)
    binding.breedTypeLayout.setOnKeyListener(null)
    binding.animalBreedLayout.setOnClickListener(null)
    binding.partOfIotLayout.setOnKeyListener(null)
    binding.ageUnitLayout.setOnKeyListener(null)
    binding.animalGenderLayout.setOnKeyListener(null)
    binding.stageOfGenderLayout.setOnKeyListener(null)
    binding.deWormingStatusLayout.setOnKeyListener(null)
    binding.vaccinationStatusLayout.setOnKeyListener(null)
    binding.typeOfVaccinesLayout.setOnKeyListener(null)

    context?.let {
      ArrayAdapter(it, android.R.layout.simple_list_item_1, listOf("Yes", "No"))
        .also { adapter ->
          binding.treatedBeforeTextView.setAdapter(adapter)
          binding.treatedBeforeTextView.inputType = InputType.TYPE_NULL
        }
    }

    binding.treatedBeforeLayout.editText?.addTextChangedListener(object : TextWatcher {
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
        listOf("Ruminants", "Poultry", "Pet Bird", "Pet & Zoo Animals")
      ).also { adapter ->
        binding.animalGroupTextView.setAdapter(adapter)
        binding.animalGroupTextView.inputType = InputType.TYPE_NULL
      }
    }

    binding.animalGroupLayout.editText?.addTextChangedListener(object : TextWatcher {
      override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

      override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        binding.animalTypeLayout.editText?.text = null
        binding.breedTypeLayout.editText?.text = null
        binding.animalBreedLayout.editText?.text = null
        if (s?.isNotEmpty() == true) {
          when (s.toString()) {
            "Ruminants" -> {
              binding.breedTypeLayout.visibility = View.VISIBLE
              binding.animalBreedLayout.visibility = View.VISIBLE

              context?.let {
                ArrayAdapter(
                  it, android.R.layout.simple_list_item_1,
                  listOf("Cattle", "Sheep", "Goat", "Buffalo")
                ).also { adapter ->
                  binding.animalTypeTextView.setAdapter(adapter)
                  binding.animalTypeTextView.inputType = InputType.TYPE_NULL
                }
              }

              context?.let {
                ArrayAdapter(
                  it, android.R.layout.simple_list_item_1,
                  listOf("Local", "Cross breed", "Foreign")
                ).also { adapter ->
                  binding.breedTypeTextView.setAdapter(adapter)
                  binding.breedTypeTextView.inputType = InputType.TYPE_NULL
                }
              }

              binding.breedTypeLayout.editText?.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                  s: CharSequence?,
                  start: Int,
                  count: Int,
                  after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                  binding.animalBreedLayout.editText?.text = null
                  if (s?.isNotEmpty() == true) {
                    when (s.toString()) {
                      "Local" -> {
                        when (binding.animalTypeTextView.text.toString()) {
                          "Cattle" -> {
                            context?.let {
                              ArrayAdapter(
                                it, android.R.layout.simple_list_item_1,
                                listOf("Deshi", "RCC", "Pabna", "North Bengal Grey")
                              ).also { adapter ->
                                binding.animalBreedTextView.setAdapter(adapter)
                                binding.animalBreedTextView.inputType = InputType.TYPE_NULL
                              }
                            }
                          }
                          else -> {
                            context?.let {
                              ArrayAdapter(
                                it, android.R.layout.simple_list_item_1,
                                listOf("Deshi")
                              ).also { adapter ->
                                binding.animalBreedTextView.setAdapter(adapter)
                                binding.animalBreedTextView.inputType = InputType.TYPE_NULL
                              }
                            }
                          }
                        }
                      }
                      else -> {
                        when (binding.animalTypeTextView.text.toString()) {
                          "Cattle" -> {
                            context?.let {
                              ArrayAdapter(
                                it, android.R.layout.simple_list_item_1,
                                listOf(
                                  "Holstein-Friesian",
                                  "Jersey",
                                  "Guernsey",
                                  "Ayrshire",
                                  "Brown Swiss",
                                  "Sindhi",
                                  "Sahiwal",
                                  "Gir",
                                  "Hariyana",
                                  "Tharparkar",
                                  "Brahman",
                                  "Angus",
                                  "Charolais",
                                  "Hereford",
                                  "Devon"
                                )
                              ).also { adapter ->
                                binding.animalBreedTextView.setAdapter(adapter)
                                binding.animalBreedTextView.inputType = InputType.TYPE_NULL
                              }
                            }
                          }
                          "Sheep" -> {
                            context?.let {
                              ArrayAdapter(
                                it, android.R.layout.simple_list_item_1,
                                listOf(
                                  "Local",
                                  "Debouillet",
                                  "Merino",
                                  "Rambouillet",
                                  "Cheviot",
                                  "Dorset",
                                  "Suffolk",
                                  "Lincoln",
                                  "Romney"
                                )
                              ).also { adapter ->
                                binding.animalBreedTextView.setAdapter(adapter)
                                binding.animalBreedTextView.inputType = InputType.TYPE_NULL
                              }
                            }
                          }
                          "Goat" -> {
                            context?.let {
                              ArrayAdapter(
                                it, android.R.layout.simple_list_item_1,
                                listOf(
                                  "Local",
                                  "Saanen",
                                  "Toggenburg",
                                  "Anglo Nubian",
                                  "Beetal",
                                  "Jamnapari",
                                  "Marwari",
                                  "Barbari",
                                  "Black Bengal",
                                  "Angora"
                                )
                              ).also { adapter ->
                                binding.animalBreedTextView.setAdapter(adapter)
                                binding.animalBreedTextView.inputType = InputType.TYPE_NULL
                              }
                            }
                          }
                          "Buffalo" -> {
                            context?.let {
                              ArrayAdapter(
                                it, android.R.layout.simple_list_item_1,
                                listOf(
                                  "Local",
                                  "Murrah",
                                  "Nili-Ravi",
                                  "Jaffarabadi",
                                  "Nagpuri",
                                  "Kundi",
                                  "Pandharpuri"
                                )
                              ).also { adapter ->
                                binding.animalBreedTextView.setAdapter(adapter)
                                binding.animalBreedTextView.inputType = InputType.TYPE_NULL
                              }
                            }
                          }
                          "Horse" -> {
                            context?.let {
                              ArrayAdapter(
                                it, android.R.layout.simple_list_item_1,
                                listOf(
                                  "Local",
                                  "Anglo-Arabia",
                                  "Arabian",
                                  "Canadian",
                                  "Friesian",
                                  "Marwari",
                                  "Russian Don",
                                  "Russian Trotter"
                                )
                              ).also { adapter ->
                                binding.animalBreedTextView.setAdapter(adapter)
                                binding.animalBreedTextView.inputType = InputType.TYPE_NULL
                              }
                            }
                          }
                          "Dog" -> {
                            context?.let {
                              ArrayAdapter(
                                it, android.R.layout.simple_list_item_1,
                                listOf(
                                  "Local",
                                  "Alsatian",
                                  "German Shepherd",
                                  "Labrador",
                                  "Retriever",
                                  "Chihuahua",
                                  "Bulldog",
                                  "Black Dog",
                                  "Dalmatian",
                                  "Guard Dog",
                                  "Hunting Dog",
                                  "Herding Dog",
                                  "Boxer"
                                )
                              ).also { adapter ->
                                binding.animalBreedTextView.setAdapter(adapter)
                                binding.animalBreedTextView.inputType = InputType.TYPE_NULL
                              }
                            }
                          }
                          "Cat" -> {
                            context?.let {
                              ArrayAdapter(
                                it, android.R.layout.simple_list_item_1,
                                listOf(
                                  "Local",
                                  "American Bobtail",
                                  "Angora",
                                  "Himalayan",
                                  "Siamese",
                                  "Persian",
                                  "Siberian",
                                  "Burmese"
                                )
                              ).also { adapter ->
                                binding.animalBreedTextView.setAdapter(adapter)
                                binding.animalBreedTextView.inputType = InputType.TYPE_NULL
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }

                override fun afterTextChanged(s: Editable?) {}
              })
            }
            "Poultry" -> {
              binding.breedTypeLayout.visibility = View.GONE
              binding.animalBreedLayout.visibility = View.GONE

              binding.animalTypeLayout.setOnKeyListener(null)
              context?.let {
                ArrayAdapter(
                  it, android.R.layout.simple_list_item_1,
                  listOf(
                    "Broiler",
                    "Layer",
                    "Quail",
                    "Duck",
                    "Turkey",
                    "Pigeon",
                    "Goose",
                    "Guinea Fowl",
                    "Others"
                  )
                ).also { adapter ->
                  binding.animalTypeTextView.setAdapter(adapter)
                  binding.animalTypeTextView.inputType = InputType.TYPE_NULL
                }
              }
            }
            "Pet Bird" -> {
              binding.breedTypeLayout.visibility = View.GONE
              binding.animalBreedLayout.visibility = View.GONE

              binding.animalTypeLayout.setOnKeyListener(null)
              context?.let {
                ArrayAdapter(
                  it, android.R.layout.simple_list_item_1,
                  listOf("Parrot", "Koel", "Mayna", "Dove", "Lovebird", "Others")
                ).also { adapter ->
                  binding.animalTypeTextView.setAdapter(adapter)
                  binding.animalTypeTextView.inputType = InputType.TYPE_NULL
                }
              }
            }
            "Pet & Zoo Animals" -> {
              binding.breedTypeLayout.visibility = View.VISIBLE
              binding.animalBreedLayout.visibility = View.VISIBLE

              context?.let {
                ArrayAdapter(
                  it, android.R.layout.simple_list_item_1,
                  listOf(
                    "Dog",
                    "Cat",
                    "Deer",
                    "Rabbit",
                    "Snake",
                    "Tiger",
                    "Elephant",
                    "Monkey",
                    "Horse",
                    "Others"
                  )
                ).also { adapter ->
                  binding.animalTypeTextView.setAdapter(adapter)
                  binding.animalTypeTextView.inputType = InputType.TYPE_NULL
                }
              }

              context?.let {
                ArrayAdapter(
                  it, android.R.layout.simple_list_item_1,
                  listOf("Local", "Cross breed", "Foreign")
                ).also { adapter ->
                  binding.breedTypeTextView.setAdapter(adapter)
                  binding.breedTypeTextView.inputType = InputType.TYPE_NULL
                }
              }

              context?.let {
                ArrayAdapter(
                  it, android.R.layout.simple_list_item_1,
                  listOf("Local", "Cross breed", "Foreign")
                ).also { adapter ->
                  binding.breedTypeTextView.setAdapter(adapter)
                  binding.breedTypeTextView.inputType = InputType.TYPE_NULL
                }
              }

              binding.breedTypeLayout.editText?.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                  s: CharSequence?,
                  start: Int,
                  count: Int,
                  after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                  binding.animalBreedLayout.editText?.text = null
                  if (s?.isNotEmpty() == true) {
                    when (binding.animalTypeTextView.text.toString()) {
                      "Horse" -> {
                        context?.let {
                          ArrayAdapter(
                            it, android.R.layout.simple_list_item_1,
                            listOf(
                              "Local",
                              "Anglo-Arabia",
                              "Arabian",
                              "Canadian",
                              "Friesian",
                              "Marwari",
                              "Russian Don",
                              "Russian Trotter"
                            )
                          ).also { adapter ->
                            binding.animalBreedTextView.setAdapter(adapter)
                            binding.animalBreedTextView.inputType = InputType.TYPE_NULL
                          }
                        }
                      }
                      "Dog" -> {
                        context?.let {
                          ArrayAdapter(
                            it, android.R.layout.simple_list_item_1,
                            listOf(
                              "Local",
                              "Alsatian",
                              "German Shepherd",
                              "Labrador",
                              "Retriever",
                              "Chihuahua",
                              "Bulldog",
                              "Black Dog",
                              "Dalmatian",
                              "Guard Dog",
                              "Hunting Dog",
                              "Herding Dog",
                              "Boxer"
                            )
                          ).also { adapter ->
                            binding.animalBreedTextView.setAdapter(adapter)
                            binding.animalBreedTextView.inputType = InputType.TYPE_NULL
                          }
                        }
                      }
                      "Cat" -> {
                        context?.let {
                          ArrayAdapter(
                            it, android.R.layout.simple_list_item_1,
                            listOf(
                              "Local",
                              "American Bobtail",
                              "Angora",
                              "Himalayan",
                              "Siamese",
                              "Persian",
                              "Siberian",
                              "Burmese"
                            )
                          ).also { adapter ->
                            binding.animalBreedTextView.setAdapter(adapter)
                            binding.animalBreedTextView.inputType = InputType.TYPE_NULL
                          }
                        }
                      }
                    }
                  }
                }

                override fun afterTextChanged(s: Editable?) {}
              })
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
          binding.partOfIotTextView.inputType = InputType.TYPE_NULL
        }
    }

    binding.animalTypeLayout.editText?.addTextChangedListener(object : TextWatcher {
      override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

      override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        binding.breedTypeLayout.editText?.text = null
        binding.animalBreedLayout.editText?.text = null
      }

      override fun afterTextChanged(s: Editable?) {}
    })

    binding.partOfIotLayout.editText?.addTextChangedListener(object : TextWatcher {
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
        binding.ageUnitTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(it, android.R.layout.simple_list_item_1, listOf("Male", "Female"))
        .also { adapter ->
          binding.animalGenderTextView.setAdapter(adapter)
          binding.animalGenderTextView.inputType = InputType.TYPE_NULL
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
                    binding.stageOfGenderTextView.inputType = InputType.TYPE_NULL
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
                    binding.stageOfGenderTextView.inputType = InputType.TYPE_NULL
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
        binding.deWormingStatusTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("3 months", "2 months", "1 month", "No")
      ).also { adapter ->
        binding.vaccinationStatusTextView.setAdapter(adapter)
        binding.vaccinationStatusTextView.inputType = InputType.TYPE_NULL
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
                  binding.typeOfVaccinesTextView.inputType = InputType.TYPE_NULL
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
}


