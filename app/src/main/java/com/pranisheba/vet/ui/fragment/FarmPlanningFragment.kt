package com.pranisheba.vet.ui.fragment

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout
import com.pranisheba.vet.databinding.FragmentFarmPlanningBinding


class FarmPlanningFragment : Fragment() {

  private lateinit var binding: FragmentFarmPlanningBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentFarmPlanningBinding.inflate(inflater, container, false)
    return binding.root
  }

  fun getFarmLandSizeLayout(): TextInputLayout {
    return binding.farmLandSizeLayout
  }

  fun getHousingStyleLayout(): TextInputLayout {
    return binding.housingStyleLayout
  }

  fun getTypeOfShadesLayout(): TextInputLayout {
    return binding.typeOfShadesLayout
  }

  fun getTypeOfHousesLayout(): TextInputLayout {
    return binding.typeOfHousesLayout
  }

  fun getInvestmentLayout(): TextInputLayout {
    return binding.investmentLayout
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.farmLandSizeLayout.setOnKeyListener(null)
    binding.housingStyleLayout.setOnKeyListener(null)
    binding.typeOfShadesLayout.setOnKeyListener(null)
    binding.typeOfHousesLayout.setOnKeyListener(null)
    binding.investmentLayout.setOnKeyListener(null)

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("≤2", "≤3", "≤4", "≤5", "≤10", "≤15", "≤20")
      ).also { adapter ->
        binding.farmLandSizeTextView.setAdapter(adapter)
        binding.farmLandSizeTextView.inputType = InputType.TYPE_NULL
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
        binding.housingStyleTextView.setAdapter(adapter)
        binding.housingStyleTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf(
          "Cow, Calf, heifer, & Pregnant Cowshed",
          "Cow, Calf, & Pregnant Cowshed",
          "Cow & Calf Shed",
          "Common Shed",
          "Don’t Know"
        )
      ).also { adapter ->
        binding.typeOfShadesTextView.setAdapter(adapter)
        binding.typeOfShadesTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("Cow", "Milk & Storehouse", "Cow & Storehouse", "Only Common House", "Don’t Know")
      ).also { adapter ->
        binding.typeOfHousesTextView.setAdapter(adapter)
        binding.typeOfHousesTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("≤2", "≤3", "≤4", "≤5", "≤10", "≤15", "≤20", "More")
      ).also { adapter ->
        binding.investmentTextView.setAdapter(adapter)
        binding.investmentTextView.inputType = InputType.TYPE_NULL
      }
    }
  }
}
