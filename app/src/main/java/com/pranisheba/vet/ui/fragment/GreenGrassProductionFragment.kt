package com.pranisheba.vet.ui.fragment

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout
import com.pranisheba.vet.databinding.FragmentGreenGrassProductionBinding


class GreenGrassProductionFragment : Fragment() {

  private lateinit var binding: FragmentGreenGrassProductionBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentGreenGrassProductionBinding.inflate(inflater, container, false)
    return binding.root
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

  fun getLandSizeLayout(): TextInputLayout {
    return binding.landSizeLayout
  }

  fun getTypeOfGreenGrassLayout(): TextInputLayout {
    return binding.typeOfGreenGrassLayout
  }

  fun getSoilQualityLayout(): TextInputLayout {
    return binding.soilQualityLayout
  }

  fun getLandStatusLayout(): TextInputLayout {
    return binding.landStatusLayout
  }

  fun getIrrigationSystemLayout(): TextInputLayout {
    return binding.irrigationSystemLayout
  }

  fun getGrassProductionPurposesLayout(): TextInputLayout {
    return binding.grassProductionPurposesLayout
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.landSizeLayout.setOnKeyListener(null)
    binding.typeOfGreenGrassLayout.setOnKeyListener(null)
    binding.soilQualityLayout.setOnKeyListener(null)
    binding.landStatusLayout.setOnKeyListener(null)
    binding.irrigationSystemLayout.setOnKeyListener(null)
    binding.grassProductionPurposesLayout.setOnKeyListener(null)

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf(
          "10",
          "20",
          "30",
          "50",
          "100",
          "150",
          "200",
          "250",
          "300",
          "400",
          "500",
          "More",
          "Don't Know"
        )
      ).also { adapter ->
        binding.landSizeTextView.setAdapter(adapter)
        binding.landSizeTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
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
        binding.typeOfGreenGrassTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf(
          "Clay", "Sandy", "Bele-Doash", "Etel", "Don't Know"
        )
      ).also { adapter ->
        binding.soilQualityTextView.setAdapter(adapter)
        binding.soilQualityTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf(
          "Low", "High", "Floodplain", "Hill", "Don't Know"
        )
      ).also { adapter ->
        binding.landStatusTextView.setAdapter(adapter)
        binding.landStatusTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf(
          "Only Rain",
          "Rain & Pump",
          "Rain & Shallow Tube Wells",
          "Rain & Deep Tube Wells",
          "Don’t Know"
        )
      ).also { adapter ->
        binding.irrigationSystemTextView.setAdapter(adapter)
        binding.irrigationSystemTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf(
          "Only Feeding",
          "Feeding & Silaging",
          "Feeding & Selling",
          "Don’t Know"
        )
      ).also { adapter ->
        binding.grassProductionPurposesTextView.setAdapter(adapter)
        binding.grassProductionPurposesTextView.inputType = InputType.TYPE_NULL
      }
    }
  }

  companion object {
    fun newInstance(someInt: Int = 0): GreenGrassProductionFragment {
      val fragment = GreenGrassProductionFragment()
      val args = Bundle()
      args.putInt("someInt", someInt)
      fragment.arguments = args
      return fragment
    }
  }
}
