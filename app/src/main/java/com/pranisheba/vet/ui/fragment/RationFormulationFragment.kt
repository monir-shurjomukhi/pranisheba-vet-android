package com.pranisheba.vet.ui.fragment

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.MultiAutoCompleteTextView
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout
import com.pranisheba.vet.databinding.FragmentRationFormulationBinding


class RationFormulationFragment : Fragment() {

  private lateinit var binding: FragmentRationFormulationBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentRationFormulationBinding.inflate(inflater, container, false)
    return binding.root
  }

  fun getTypeOfAnimalLayout(): TextInputLayout {
    return binding.typeOfAnimalLayout
  }

  fun getMilkProductionLayout(): TextInputLayout {
    return binding.milkProductionLayout
  }

  fun getBreedTypeLayout(): TextInputLayout {
    return binding.breedTypeLayout
  }

  fun getAnimalBreedLayout(): TextInputLayout {
    return binding.animalBreedLayout
  }

  fun getNumberOfAnimalsLayout(): TextInputLayout {
    return binding.numberOfAnimalsLayout
  }

  fun getTypeOfFeedLayout(): TextInputLayout {
    return binding.typeOfFeedLayout
  }

  fun getTypeOfGreenGrassLayout(): TextInputLayout {
    return binding.typeOfGreenGrassLayout
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.typeOfAnimalLayout.setOnKeyListener(null)
    binding.breedTypeLayout.setOnKeyListener(null)
    binding.animalBreedLayout.setOnKeyListener(null)
    binding.typeOfFeedLayout.setOnKeyListener(null)
    binding.typeOfGreenGrassLayout.setOnKeyListener(null)

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf(
          "Dairy",
          "Beef",
          "Pregnant",
          "Heifer",
          "Calf",
          "Horse",
          "Horse",
          "Kid",
          "Sheep",
          "Dog",
          "Puppy",
          "Broiler",
          "Chick",
          "Laying",
          "Growing",
          "Turkey",
          "Duck",
          "Duckling",
          "Goose",
          "Guinea Fowl",
          "Pigeon"
        )
      ).also { adapter ->
        binding.typeOfAnimalTextView.setAdapter(adapter)
        binding.typeOfAnimalTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf(
          "Local", "Cross Breed", "Foreign"
        )
      ).also { adapter ->
        binding.breedTypeTextView.setAdapter(adapter)
        binding.breedTypeTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf(
          "No Data Available"
        )
      ).also { adapter ->
        binding.animalBreedTextView.setAdapter(adapter)
        binding.animalBreedTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf(
          "Own Arrangement",
          "Supplier Feed & Hygienic Water",
          "No Specific Way For Feed & Watering",
          "Don’t Know"
        )
      ).also { adapter ->
        binding.typeOfFeedTextView.setAdapter(adapter)
        binding.typeOfFeedTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_multiple_choice,
        listOf(
          "Napier",
          "Maize",
          "Jumbo",
          "German",
          "Kalai",
          "Para",
          "Bangla",
          "Mix Supply",
          "Don't Know"
        )
      ).also { adapter ->
        binding.typeOfGreenGrassTextView.setAdapter(adapter)
        binding.typeOfGreenGrassTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        binding.typeOfGreenGrassTextView.inputType = InputType.TYPE_NULL
      }
    }
  }
}
