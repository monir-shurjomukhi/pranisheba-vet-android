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
import com.pranisheba.vet.databinding.*


class ReproductionManagementFragment : Fragment() {

  private lateinit var binding: FragmentReproductionManagementBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentReproductionManagementBinding.inflate(inflater, container, false)
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

  fun getFarmersEconomicStatusLayout(): TextInputLayout {
    return binding.farmersEconomicStatusLayout
  }

  fun getAverageMilkProductionLayout(): TextInputLayout {
    return binding.averageMilkProductionLayout
  }

  fun getHighestLowestMilkProductionLayout(): TextInputLayout {
    return binding.highestLowestMilkProductionLayout
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.breedTypeLayout.setOnKeyListener(null)
    binding.animalBreedLayout.setOnKeyListener(null)
    binding.foreignBloodLevelLayout.setOnKeyListener(null)
    binding.normalBreedingPlanLayout.setOnKeyListener(null)
    binding.farmManagementPracticeLayout.setOnKeyListener(null)
    binding.farmersEconomicStatusLayout.setOnKeyListener(null)
    binding.averageMilkProductionLayout.setOnKeyListener(null)
    binding.highestLowestMilkProductionLayout.setOnKeyListener(null)

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
        listOf("No Data Available")
      ).also { adapter ->
        binding.animalBreedTextView.setAdapter(adapter)
        binding.animalBreedTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("Pure Local", "25", "37.5", "50", "62.5", "68.75", "75", "84.37", "87.5", "100", "Don't Know")
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
        listOf(
          "Poor & Low Attitude",
          "Medium Income & Conscious",
          "Medium Income & Good Attitude",
          "Solvent & Good Attitude",
          "Don't Know"
        )
      ).also { adapter ->
        binding.farmersEconomicStatusTextView.setAdapter(adapter)
        binding.farmersEconomicStatusTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf(
          "≤3",
          "≤5",
          "≤8",
          "≤10",
          "≤12",
          "≤15",
          "≤20",
          "≤25",
          "≤30",
          "More",
          "Don't Know"
        )
      ).also { adapter ->
        binding.averageMilkProductionTextView.setAdapter(adapter)
        binding.averageMilkProductionTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf(
          "4 & 2",
          "7 & 3",
          "10 & 5",
          "12 & 7",
          "15 & 10",
          "20 & 12",
          "20 & 15",
          "25 & 20",
          "30 & 25",
          "More",
          "Don't Know"
        )
      ).also { adapter ->
        binding.highestLowestMilkProductionTextView.setAdapter(adapter)
        binding.highestLowestMilkProductionTextView.inputType = InputType.TYPE_NULL
      }
    }
  }
}
