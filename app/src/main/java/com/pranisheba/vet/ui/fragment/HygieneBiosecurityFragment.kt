package com.pranisheba.vet.ui.fragment

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout
import com.pranisheba.vet.databinding.FragmentHygieneBiosecurityBinding


class HygieneBiosecurityFragment : Fragment() {

  private lateinit var binding: FragmentHygieneBiosecurityBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentHygieneBiosecurityBinding.inflate(inflater, container, false)
    return binding.root
  }

  fun getFarmLocationLayout(): TextInputLayout {
    return binding.farmLocationLayout
  }

  fun getBiosecurityMeasuresLayout(): TextInputLayout {
    return binding.biosecurityMeasuresLayout
  }

  fun getHousingStatusLayout(): TextInputLayout {
    return binding.housingStatusLayout
  }

  fun getFarmSurroundingLayout(): TextInputLayout {
    return binding.farmSurroundingLayout
  }

  fun getFarmTypeLayout(): TextInputLayout {
    return binding.farmTypeLayout
  }

  fun getStaffResidentLayout(): TextInputLayout {
    return binding.staffResidentLayout
  }

  fun getFeedAndWaterLayout(): TextInputLayout {
    return binding.feedAndWaterLayout
  }

  fun getWasteDisposalLayout(): TextInputLayout {
    return binding.wasteDisposalLayout
  }

  fun getTypeOfVehicleLayout(): TextInputLayout {
    return binding.typeOfVehicleLayout
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.farmLocationLayout.setOnKeyListener(null)
    binding.biosecurityMeasuresLayout.setOnKeyListener(null)
    binding.housingStatusLayout.setOnKeyListener(null)
    binding.farmSurroundingLayout.setOnKeyListener(null)
    binding.farmTypeLayout.setOnKeyListener(null)
    binding.staffResidentLayout.setOnKeyListener(null)
    binding.feedAndWaterLayout.setOnKeyListener(null)
    binding.wasteDisposalLayout.setOnKeyListener(null)
    binding.typeOfVehicleLayout.setOnKeyListener(null)

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf(
          "Urban",
          "Semi Urban",
          "Rural"
        )
      ).also { adapter ->
        binding.farmLocationTextView.setAdapter(adapter)
        binding.farmLocationTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("Boundary", "Boundary With Well Gate", "Only Wire Net", "Open")
      ).also { adapter ->
        binding.biosecurityMeasuresTextView.setAdapter(adapter)
        binding.biosecurityMeasuresTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("Scientific", "Semi Scientific", "Normal", "Don't Know")
      ).also { adapter ->
        binding.housingStatusTextView.setAdapter(adapter)
        binding.housingStatusTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf(
          "Water Source Nearby",
          "Public Place Nearby",
          "Highway Nearby",
          "Farm Nearby",
          "Don't Know"
        )
      ).also { adapter ->
        binding.farmSurroundingTextView.setAdapter(adapter)
        binding.farmSurroundingTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf(
          "One Type Animal Farm",
          "Two Type Animal Farm",
          "Integrated Farm",
          "Don't Know"
        )
      ).also { adapter ->
        binding.farmTypeTextView.setAdapter(adapter)
        binding.farmTypeTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf(
          "Only Farm Supervisor",
          "Supervisor & Workers",
          "Only Workers",
          "Easily Move By All",
          "Don't Know"
        )
      ).also { adapter ->
        binding.staffResidentTextView.setAdapter(adapter)
        binding.staffResidentTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf(
          "Own Management",
          "Supplier Feed & Hygienic Water",
          "No Specific Way For Feeding & Watering",
          "Don't Know"
        )
      ).also { adapter ->
        binding.feedAndWaterTextView.setAdapter(adapter)
        binding.feedAndWaterTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf(
          "Good",
          "Medium",
          "Poor",
          "Don't Know"
        )
      ).also { adapter ->
        binding.wasteDisposalTextView.setAdapter(adapter)
        binding.wasteDisposalTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf(
          "Own",
          "Others",
          "Both",
          "Don't Know"
        )
      ).also { adapter ->
        binding.typeOfVehicleTextView.setAdapter(adapter)
        binding.typeOfVehicleTextView.inputType = InputType.TYPE_NULL
      }
    }
  }

  companion object {
    fun newInstance(someInt: Int = 0): HygieneBiosecurityFragment {
      val fragment = HygieneBiosecurityFragment()
      val args = Bundle()
      args.putInt("someInt", someInt)
      fragment.arguments = args
      return fragment
    }
  }
}
