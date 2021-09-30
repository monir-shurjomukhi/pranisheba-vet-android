package com.pranisheba.vet.ui.fragment

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout
import com.pranisheba.vet.databinding.FragmentFarmManagementBinding


class FarmManagementFragment : Fragment() {

  private lateinit var binding: FragmentFarmManagementBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentFarmManagementBinding.inflate(inflater, container, false)
    return binding.root
  }

  fun getBreedTypeLayout(): TextInputLayout {
    return binding.breedTypeLayout
  }

  fun getAnimalBreedLayout(): TextInputLayout {
    return binding.animalBreedLayout
  }

  fun getForeignBloodLevelLayout(): TextInputLayout {
    return binding.foreignBloodLevelLayout
  }

  fun getNormalBreedingPlanLayout(): TextInputLayout {
    return binding.normalBreedingPlanLayout
  }

  fun getFarmManagementPracticeLayout(): TextInputLayout {
    return binding.farmManagementPracticeLayout
  }

  fun getHousingStyleLayout(): TextInputLayout {
    return binding.housingStyleLayout
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.breedTypeLayout.setOnKeyListener(null)
    binding.animalBreedLayout.setOnKeyListener(null)
    binding.foreignBloodLevelLayout.setOnKeyListener(null)
    binding.normalBreedingPlanLayout.setOnKeyListener(null)
    binding.farmManagementPracticeLayout.setOnKeyListener(null)
    binding.housingStyleLayout.setOnKeyListener(null)

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
        it,
        android.R.layout.simple_list_item_1,
        listOf("Don't Know")
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
          "Pure Local",
          "25",
          "37.5",
          "50",
          "62.5",
          "68.75",
          "75",
          "84.37",
          "87.5",
          "100",
          "Don't Know"
        )
      ).also { adapter ->
        binding.foreignBloodLevelTextView.setAdapter(adapter)
        binding.foreignBloodLevelTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("Cross", "Scientific", "Own Bull", "AISP Dependent", "Don't Know")
      ).also { adapter ->
        binding.normalBreedingPlanTextView.setAdapter(adapter)
        binding.normalBreedingPlanTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf(
          "Scientific",
          "Semi Scientific",
          "Normal",
          "Don't Know"
        )
      ).also { adapter ->
        binding.farmManagementPracticeTextView.setAdapter(adapter)
        binding.farmManagementPracticeTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("Don't Know")
      ).also { adapter ->
        binding.housingStyleTextView.setAdapter(adapter)
        binding.housingStyleTextView.inputType = InputType.TYPE_NULL
      }
    }
  }
}
