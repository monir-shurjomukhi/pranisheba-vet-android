package com.pranisheba.vet.ui.fragment

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.pranisheba.vet.databinding.FragmentDiseaseInfoBinding


class DiseaseInfoFragment : Fragment() {

  private lateinit var binding: FragmentDiseaseInfoBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentDiseaseInfoBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.temperatureLevelLayout.setOnKeyListener(null)
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

    binding.feedIntakeLayout.setOnKeyListener(null)
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

    binding.defecationStatusLayout.setOnKeyListener(null)
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

    binding.urinationStatusLayout.setOnKeyListener(null)
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

    binding.hairStatusLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("Normal", "Erected")
      ).also { adapter ->
        binding.hairStatusTextView.setAdapter(adapter)
        binding.hairStatusTextView.inputType = InputType.TYPE_NULL
      }
    }

    binding.salivationStatusLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("No", "Only salivation", "Salivation with foam")
      ).also { adapter ->
        binding.salivationStatusTextView.setAdapter(adapter)
        binding.salivationStatusTextView.inputType = InputType.TYPE_NULL
      }
    }

    binding.postureStatusLayout.setOnKeyListener(null)
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

    binding.muzzleStatusLayout.setOnKeyListener(null)
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

    binding.sneezingStatusLayout.setOnKeyListener(null)
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

    binding.gestureStatusLayout.setOnKeyListener(null)
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

    binding.firstTimeLayout.setOnKeyListener(null)
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

    binding.soughtElsewhereLayout.setOnKeyListener(null)
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

    binding.otherAnimalsLayout.setOnKeyListener(null)
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

    binding.emergencyTypeLayout.setOnKeyListener(null)
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
  }
}