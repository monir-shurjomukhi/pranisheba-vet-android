package com.pranisheba.vet.ui.fragment

import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.pranisheba.vet.databinding.FragmentTreatmentFormBinding


class TreatmentFormFragment : Fragment() {

  private lateinit var binding: FragmentTreatmentFormBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentTreatmentFormBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.treatedBeforeLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(it, android.R.layout.simple_list_item_1, listOf("Yes", "No"))
        .also { adapter ->
          binding.treatedBeforeTextView.setAdapter(adapter)
          binding.treatedBeforeTextView.inputType = InputType.TYPE_NULL
        }
    }

    binding.animalGroupLayout.setOnKeyListener(null)
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
      override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

      }

      override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        if (s?.isNotEmpty() == true) {
          when (s) {
            "Ruminants" -> {
              binding.animalTypeLayout.setOnKeyListener(null)
              context?.let {
                ArrayAdapter(
                  it, android.R.layout.simple_list_item_1,
                  listOf("Cattle", "Sheep", "Goat", "Buffalo")
                ).also { adapter ->
                  binding.animalTypeTextView.setAdapter(adapter)
                  binding.animalTypeTextView.inputType = InputType.TYPE_NULL
                }
              }

              binding.animalBreedLayout.visibility = View.VISIBLE
              binding.animalBreedLayout.setOnKeyListener(null)
              context?.let {
                ArrayAdapter(
                  it, android.R.layout.simple_list_item_1,
                  listOf("Local", "Cross breed", "Foreign")
                ).also { adapter ->
                  binding.animalTypeTextView.setAdapter(adapter)
                  binding.animalTypeTextView.inputType = InputType.TYPE_NULL
                }
              }
            }
            "Poultry" -> {
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

              binding.animalBreedLayout.visibility = View.GONE
            }
            "Pet Bird" -> {
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

              binding.animalBreedLayout.visibility = View.GONE
            }
            "Pet & Zoo Animals" -> {
              binding.animalTypeLayout.setOnKeyListener(null)
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

              binding.animalBreedLayout.visibility = View.VISIBLE
              binding.animalBreedLayout.setOnKeyListener(null)
              context?.let {
                ArrayAdapter(
                  it, android.R.layout.simple_list_item_1,
                  listOf("Local", "Cross breed", "Foreign")
                ).also { adapter ->
                  binding.animalTypeTextView.setAdapter(adapter)
                  binding.animalTypeTextView.inputType = InputType.TYPE_NULL
                }
              }
            }
          }
        }
      }

      override fun afterTextChanged(s: Editable?) {

      }
    })

    binding.partOfIotLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(it, android.R.layout.simple_list_item_1, listOf("Yes", "No"))
        .also { adapter ->
          binding.partOfIotTextView.setAdapter(adapter)
          binding.partOfIotTextView.inputType = InputType.TYPE_NULL
        }
    }

    binding.partOfIotLayout.editText?.addTextChangedListener(object: TextWatcher {
      override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

      }

      override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        if (s?.isNotEmpty() == true) {
          when(s.toString()) {
            "Yes" -> {
              binding.bolusIdLayout.visibility = View.VISIBLE
            }
            "No" -> {
              binding.bolusIdLayout.visibility = View.GONE
            }
          }
        }
      }

      override fun afterTextChanged(s: Editable?) {

      }

    })

    binding.ageUnitLayout.setOnKeyListener(null)
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

    binding.animalGenderLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(it, android.R.layout.simple_list_item_1, listOf("Male", "Female"))
        .also { adapter ->
          binding.animalGenderTextView.setAdapter(adapter)
          binding.animalGenderTextView.inputType = InputType.TYPE_NULL
        }
    }

    binding.dewormingStatusLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("3 months", "2 months", "1 month", "No")
      ).also { adapter ->
        binding.dewormingStatusTextView.setAdapter(adapter)
        binding.dewormingStatusTextView.inputType = InputType.TYPE_NULL
      }
    }

    binding.vaccinationStatusLayout.setOnKeyListener(null)
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

    binding.temperatureLevelLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("High", "Low", "Normal")
      ).also { adapter ->
        binding.temperatureLevelTextView.setAdapter(adapter)
        binding.temperatureLevelTextView.inputType = InputType.TYPE_NULL
      }
    }

    binding.feedIntakeLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("Normal", "Low", "No")
      ).also { adapter ->
        binding.feedIntakeTextView.setAdapter(adapter)
        binding.feedIntakeTextView.inputType = InputType.TYPE_NULL
      }
    }

    binding.defecationStatusLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf(
          "No",
          "Normal",
          "Loose motion",
          "Bloody with mucus",
          "Constipation",
          "Whitish",
          "Yellowish",
          "Greenish"
        )
      ).also { adapter ->
        binding.defecationStatusTextView.setAdapter(adapter)
        binding.defecationStatusTextView.inputType = InputType.TYPE_NULL
      }
    }

    binding.urinationStatusLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("No", "Normal color", "Red color")
      ).also { adapter ->
        binding.urinationStatusTextView.setAdapter(adapter)
        binding.urinationStatusTextView.inputType = InputType.TYPE_NULL
      }
    }

    binding.hairStatusLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("Normal", "Erected")
      ).also { adapter ->
        binding.hairStatusTextView.setAdapter(adapter)
        binding.hairStatusTextView.inputType = InputType.TYPE_NULL
      }
    }

    binding.salivationStatusLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("No", "Only salivation", "Salivation with foam")
      ).also { adapter ->
        binding.salivationStatusTextView.setAdapter(adapter)
        binding.salivationStatusTextView.inputType = InputType.TYPE_NULL
      }
    }

    binding.postureStatusLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("Standing", "Sitting", "Lying on head up", "Lying on the ground")
      ).also { adapter ->
        binding.postureStatusTextView.setAdapter(adapter)
        binding.postureStatusTextView.inputType = InputType.TYPE_NULL
      }
    }

    binding.muzzleStatusLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("Wet", "Dry")
      ).also { adapter ->
        binding.muzzleStatusTextView.setAdapter(adapter)
        binding.muzzleStatusTextView.inputType = InputType.TYPE_NULL
      }
    }

    binding.sneezingStatusLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("Yes", "No", "With mucus")
      ).also { adapter ->
        binding.sneezingStatusTextView.setAdapter(adapter)
        binding.sneezingStatusTextView.inputType = InputType.TYPE_NULL
      }
    }

    binding.gestureStatusLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("Normal", "Abnormal")
      ).also { adapter ->
        binding.gestureStatusTextView.setAdapter(adapter)
        binding.gestureStatusTextView.inputType = InputType.TYPE_NULL
      }
    }

    binding.firstTimeLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("Yes", "No")
      ).also { adapter ->
        binding.firstTimeTextView.setAdapter(adapter)
        binding.firstTimeTextView.inputType = InputType.TYPE_NULL
      }
    }

    binding.soughtElsewhereLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("Yes", "No")
      ).also { adapter ->
        binding.soughtElsewhereTextView.setAdapter(adapter)
        binding.soughtElsewhereTextView.inputType = InputType.TYPE_NULL
      }
    }

    binding.otherAnimalsLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("Yes", "No")
      ).also { adapter ->
        binding.otherAnimalsTextView.setAdapter(adapter)
        binding.otherAnimalsTextView.inputType = InputType.TYPE_NULL
      }
    }

    binding.emergencyTypeLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("Normal", "Emergency")
      ).also { adapter ->
        binding.emergencyTypeTextView.setAdapter(adapter)
        binding.emergencyTypeTextView.inputType = InputType.TYPE_NULL
      }
    }
  }
}
