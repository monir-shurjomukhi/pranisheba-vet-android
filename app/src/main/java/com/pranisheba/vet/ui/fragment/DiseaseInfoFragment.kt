package com.pranisheba.vet.ui.fragment

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout
import com.pranisheba.vet.databinding.FragmentDiseaseInfoBinding
import com.pranisheba.vet.ui.activity.TreatmentFormActivity


class DiseaseInfoFragment : Fragment() {

  private lateinit var binding: FragmentDiseaseInfoBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentDiseaseInfoBinding.inflate(inflater, container, false)
    return binding.root
  }

  fun getTemperatureLevelLayout(): TextInputLayout {
    return binding.temperatureLevelLayout
  }

  fun getTemperatureLayout(): TextInputLayout {
    return binding.temperatureLayout
  }

  fun getFeedIntakeLayout(): TextInputLayout {
    return binding.feedIntakeLayout
  }

  fun getDefecationStatusLayout(): TextInputLayout {
    return binding.defecationStatusLayout
  }

  fun getUrinationStatusLayout(): TextInputLayout {
    return binding.urinationStatusLayout
  }

  fun getHairStatusLayout(): TextInputLayout {
    return binding.hairStatusLayout
  }

  fun getSalivationStatusLayout(): TextInputLayout {
    return binding.salivationStatusLayout
  }

  fun getPostureStatusLayout(): TextInputLayout {
    return binding.postureStatusLayout
  }

  fun getMuzzleStatusLayout(): TextInputLayout {
    return binding.muzzleStatusLayout
  }

  fun getSneezingStatusLayout(): TextInputLayout {
    return binding.sneezingStatusLayout
  }

  fun getSweatingStatusLayout(): TextInputLayout {
    return binding.sweatingStatusLayout
  }

  fun getGestureStatusLayout(): TextInputLayout {
    return binding.gestureStatusLayout
  }

  fun getFirstTimeLayout(): TextInputLayout {
    return binding.firstTimeLayout
  }

  fun getSoughtElsewhereLayout(): TextInputLayout {
    return binding.soughtElsewhereLayout
  }

  fun getProblemDescriptionLayout(): TextInputLayout {
    return binding.problemDescriptionLayout
  }

  fun getOtherAnimalsLayout(): TextInputLayout {
    return binding.otherAnimalsLayout
  }

  fun getEmergencyTypeLayout(): TextInputLayout {
    return binding.emergencyTypeLayout
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.temperatureLevelLayout.setOnKeyListener(null)
    binding.feedIntakeLayout.setOnKeyListener(null)
    binding.defecationStatusLayout.setOnKeyListener(null)
    binding.urinationStatusLayout.setOnKeyListener(null)
    binding.hairStatusLayout.setOnKeyListener(null)
    binding.salivationStatusLayout.setOnKeyListener(null)
    binding.postureStatusLayout.setOnKeyListener(null)
    binding.muzzleStatusLayout.setOnKeyListener(null)
    binding.sneezingStatusLayout.setOnKeyListener(null)
    binding.sweatingStatusLayout.setOnKeyListener(null)
    binding.gestureStatusLayout.setOnKeyListener(null)
    binding.firstTimeLayout.setOnKeyListener(null)
    binding.soughtElsewhereLayout.setOnKeyListener(null)
    binding.otherAnimalsLayout.setOnKeyListener(null)
    binding.emergencyTypeLayout.setOnKeyListener(null)

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

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("Normal", "Erected", "Ruffled")
      ).also { adapter ->
        binding.hairStatusTextView.setAdapter(adapter)
        binding.hairStatusTextView.inputType = InputType.TYPE_NULL
      }
    }

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("No", "Only salivation", "Salivation with foam", "Panting")
      ).also { adapter ->
        binding.salivationStatusTextView.setAdapter(adapter)
        binding.salivationStatusTextView.inputType = InputType.TYPE_NULL
      }
    }

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

    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("No", "Low", "High")
      ).also { adapter ->
        binding.sweatingStatusTextView.setAdapter(adapter)
        binding.sweatingStatusTextView.inputType = InputType.TYPE_NULL
      }
    }

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

    (activity as TreatmentFormActivity).showPreviousInfo()
  }
}
