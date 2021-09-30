package com.pranisheba.vet.ui.fragment

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout
import com.pranisheba.vet.databinding.FragmentSilageProductionBinding


class SilageProductionFragment : Fragment() {

  private lateinit var binding: FragmentSilageProductionBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentSilageProductionBinding.inflate(inflater, container, false)
    return binding.root
  }

  fun getTargetAmountLayout(): TextInputLayout {
    return binding.targetAmountLayout
  }

  fun getTypeOfSilageLayout(): TextInputLayout {
    return binding.typeOfSilageLayout
  }

  fun getGreenGrassLayout(): TextInputLayout {
    return binding.greenGrassLayout
  }

  fun getAgeOfGreenGrassLayout(): TextInputLayout {
    return binding.ageOfGreenGrassLayout
  }

  fun getPlaceForSilageLayout(): TextInputLayout {
    return binding.placeForSilageLayout
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.targetAmountLayout.setOnKeyListener(null)
    binding.typeOfSilageLayout.setOnKeyListener(null)
    binding.greenGrassLayout.setOnKeyListener(null)
    binding.ageOfGreenGrassLayout.setOnKeyListener(null)
    binding.placeForSilageLayout.setOnKeyListener(null)

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf(
          "10",
          "20",
          "30",
          "40",
          "50",
          "60",
          "80",
          "100",
          "120"
        )
      ).also { adapter ->
        binding.targetAmountTextView.setAdapter(adapter)
        binding.targetAmountTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("Pit", "Drum", "Packet", "Stalk")
      ).also { adapter ->
        binding.typeOfSilageTextView.setAdapter(adapter)
        binding.typeOfSilageTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("Maize", "Sorghum", "Oats", "Bajra", "Hybrid Napier", "Mixture")
      ).also { adapter ->
        binding.greenGrassTextView.setAdapter(adapter)
        binding.greenGrassTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("30-40 Days", "40-50 Days", "50-60 Days", "60-70 Days", "More")
      ).also { adapter ->
        binding.ageOfGreenGrassTextView.setAdapter(adapter)
        binding.ageOfGreenGrassTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf(
          "Low",
          "High",
          "High & Sandy",
          "Medium"
        )
      ).also { adapter ->
        binding.placeForSilageTextView.setAdapter(adapter)
        binding.placeForSilageTextView.inputType = InputType.TYPE_NULL
      }
    }
  }
}
