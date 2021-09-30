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
import com.pranisheba.vet.databinding.FragmentDewormingVaccinationBinding


class DewormingVaccinationFragment : Fragment() {

  private lateinit var binding: FragmentDewormingVaccinationBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentDewormingVaccinationBinding.inflate(inflater, container, false)
    return binding.root
  }

  fun getTypeOfAnimalLayout(): TextInputLayout {
    return binding.typeOfAnimalLayout
  }

  fun getMilkingLayout(): TextInputLayout {
    return binding.milkingLayout
  }

  fun getPregnantLayout(): TextInputLayout {
    return binding.pregnantLayout
  }

  fun getHeiferLayout(): TextInputLayout {
    return binding.heiferLayout
  }

  fun getCalvesLayout(): TextInputLayout {
    return binding.calvesLayout
  }

  fun getMaleLayout(): TextInputLayout {
    return binding.maleLayout
  }

  fun getNumberOfCalvesLayout(): TextInputLayout {
    return binding.numberOfCalvesLayout
  }

  fun getNumberOfPregnantLayout(): TextInputLayout {
    return binding.numberOfPregnantLayout
  }

  fun getLastDewormingTimeLayout(): TextInputLayout {
    return binding.lastDewormingTimeLayout
  }

  fun getFeedingSystemLayout(): TextInputLayout {
    return binding.feedingSystemLayout
  }

  fun getLastVaccinationTimeLayout(): TextInputLayout {
    return binding.lastVaccinationTimeLayout
  }

  fun getVaccinationsLayout(): TextInputLayout {
    return binding.vaccinationsLayout
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.typeOfAnimalLayout.setOnKeyListener(null)
    binding.lastDewormingTimeLayout.setOnKeyListener(null)
    binding.feedingSystemLayout.setOnKeyListener(null)
    binding.lastVaccinationTimeLayout.setOnKeyListener(null)
    binding.vaccinationsLayout.setOnKeyListener(null)

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf(
          "Cattle",
          "Sheep",
          "Goat",
          "Buffalo",
          "Horse",
          "Dog",
          "Cat",
          "Broiler",
          "Quail",
          "Duck",
          "Turkey",
          "Pigeon",
          "Goose",
          "Guinea Fowl",
          "Bird"
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
        listOf("3 Months", "2 Months", "1 Month", "No")
      ).also { adapter ->
        binding.lastDewormingTimeTextView.setAdapter(adapter)
        binding.lastDewormingTimeTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf(
          "Stall", "Grazing", "Both", "Don't Know"
        )
      ).also { adapter ->
        binding.feedingSystemTextView.setAdapter(adapter)
        binding.feedingSystemTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("3 Months", "2 Months", "1 Month", "No")
      ).also { adapter ->
        binding.lastVaccinationTimeTextView.setAdapter(adapter)
        binding.lastVaccinationTimeTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_multiple_choice,
        listOf(
          "FMD",
          "Anthrax",
          "Black Quarter",
          "HS",
          "Brucella",
          "LSD",
          "TB",
          "BEF",
          "Goat Pox",
          "Enterotoxemia",
          "Contagious Ecthyma",
          "PPR"
        )
      ).also { adapter ->
        binding.vaccinationsTextView.setAdapter(adapter)
        binding.vaccinationsTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        binding.vaccinationsTextView.inputType = InputType.TYPE_NULL
      }
    }
  }
}
