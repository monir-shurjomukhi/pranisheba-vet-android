package com.pranisheba.vet.ui.fragment

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout
import com.pranisheba.vet.databinding.FragmentFarmInfoBinding
import com.pranisheba.vet.databinding.FragmentFarmPlanningBinding
import com.pranisheba.vet.ui.activity.ConsultancyFormActivity
import com.pranisheba.vet.ui.activity.TreatmentFormActivity


class FarmPlanningFragment : Fragment() {

  private lateinit var binding: FragmentFarmPlanningBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentFarmPlanningBinding.inflate(inflater, container, false)
    return binding.root
  }

  fun getTypeOfConsultancyLayout(): TextInputLayout {
    return binding.typeOfConsultancyLayout
  }

  fun getTypeOfFarmLayout(): TextInputLayout {
    return binding.typeOfFarmLayout
  }

  fun getNumberOfAnimalsLayout(): TextInputLayout {
    return binding.numberOfAnimalsLayout
  }

  fun getPlaceOfFarmLayout(): TextInputLayout {
    return binding.placeOfFarmLayout
  }

  fun getAgeOfFirmLayout(): TextInputLayout {
    return binding.ageOfFirmLayout
  }

  fun getFrequencyOfConsultancyLayout(): TextInputLayout {
    return binding.frequencyOfConsultancyLayout
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.typeOfConsultancyLayout.setOnKeyListener(null)
    binding.typeOfFarmLayout.setOnKeyListener(null)
    binding.placeOfFarmLayout.setOnKeyListener(null)
    binding.ageOfFirmLayout.setOnKeyListener(null)
    binding.frequencyOfConsultancyLayout.setOnKeyListener(null)

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf(
          "Farm Planning(Number of animals ≤ 20)",
          "Farm Planning(Number of animals > 20)",
          "Ration Formulation",
          "Green Grass Production and Management",
          "Silage production and management",
          "Farm Hygiene & Biosecurity Management",
          "Deworming & Vaccination Scheduling",
          "Reproduction and Its management",
          "Farm Management"
        )
      ).also { adapter ->
        binding.typeOfConsultancyTextView.setAdapter(adapter)
        binding.typeOfConsultancyTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf(
          "Dairy",
          "Beef",
          "Buffalo Dairy",
          "Sheep",
          "Goat",
          "Goat Dairy",
          "Horse",
          "Dog",
          "Cat",
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
        binding.typeOfFarmTextView.setAdapter(adapter)
        binding.typeOfFarmTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("Urban", "Semi Urban", "Agricultural Land", "Leased Land")
      ).also { adapter ->
        binding.placeOfFarmTextView.setAdapter(adapter)
        binding.placeOfFarmTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("New", "Less Than 1 Year", "1 to 2 Years", "2 to 5 Years", "More Than 5 Years")
      ).also { adapter ->
        binding.ageOfFirmTextView.setAdapter(adapter)
        binding.ageOfFirmTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("One Time", "Yearly")
      ).also { adapter ->
        binding.frequencyOfConsultancyTextView.setAdapter(adapter)
        binding.frequencyOfConsultancyTextView.inputType = InputType.TYPE_NULL
      }
    }

    (activity as ConsultancyFormActivity).showPreviousInfo()
  }
}
