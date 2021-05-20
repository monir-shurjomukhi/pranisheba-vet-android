package com.pranisheba.vet.ui.fragment

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.pranisheba.vet.R
import kotlinx.android.synthetic.main.fragment_treatment_form.*


class TreatmentFormFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_treatment_form, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    treatedBeforeLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(it, android.R.layout.simple_list_item_1, listOf("Yes", "No"))
        .also { adapter ->
          treatedBeforeTextView.setAdapter(adapter)
          treatedBeforeTextView.inputType = InputType.TYPE_NULL
        }
    }

    animalGroupLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(
        it, android.R.layout.simple_list_item_1,
        listOf("Ruminants", "Poultry", "Bird", "Pet", "Elephant", "Horse", "Monkey")
      ).also { adapter ->
        animalGroupTextView.setAdapter(adapter)
        animalGroupTextView.inputType = InputType.TYPE_NULL
      }
    }

    animalTypeLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(
        it, android.R.layout.simple_list_item_1,
        listOf("Cattle", "Sheep", "Goat", "Buffalo")
      ).also { adapter ->
        animalTypeTextView.setAdapter(adapter)
        animalTypeTextView.inputType = InputType.TYPE_NULL
      }
    }

    partOfIotLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(it, android.R.layout.simple_list_item_1, listOf("Yes", "No"))
        .also { adapter ->
          partOfIotTextView.setAdapter(adapter)
          partOfIotTextView.inputType = InputType.TYPE_NULL
        }
    }

    ageUnitLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("Years", "Months", "Weeks", "Days")
      ).also { adapter ->
        ageUnitTextView.setAdapter(adapter)
        ageUnitTextView.inputType = InputType.TYPE_NULL
      }
    }

    animalGenderLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(it, android.R.layout.simple_list_item_1, listOf("Male", "Female"))
        .also { adapter ->
          animalGenderTextView.setAdapter(adapter)
          animalGenderTextView.inputType = InputType.TYPE_NULL
        }
    }

    dewormingStatusLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("3 months", "2 months", "1 month", "No")
      ).also { adapter ->
        dewormingStatusTextView.setAdapter(adapter)
        dewormingStatusTextView.inputType = InputType.TYPE_NULL
      }
    }

    vaccinationStatusLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("3 months", "2 months", "1 month", "No")
      ).also { adapter ->
        vaccinationStatusTextView.setAdapter(adapter)
        vaccinationStatusTextView.inputType = InputType.TYPE_NULL
      }
    }

    temperatureLevelLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("High", "Low", "Normal")
      ).also { adapter ->
        temperatureLevelTextView.setAdapter(adapter)
        temperatureLevelTextView.inputType = InputType.TYPE_NULL
      }
    }

    feedIntakeLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("Normal", "Low", "No")
      ).also { adapter ->
        feedIntakeTextView.setAdapter(adapter)
        feedIntakeTextView.inputType = InputType.TYPE_NULL
      }
    }

    defecationStatusLayout.setOnKeyListener(null)
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
        defecationStatusTextView.setAdapter(adapter)
        defecationStatusTextView.inputType = InputType.TYPE_NULL
      }
    }

    urinationStatusLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("No", "Normal color", "Red color")
      ).also { adapter ->
        urinationStatusTextView.setAdapter(adapter)
        urinationStatusTextView.inputType = InputType.TYPE_NULL
      }
    }

    hairStatusLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("Normal", "Erected")
      ).also { adapter ->
        hairStatusTextView.setAdapter(adapter)
        hairStatusTextView.inputType = InputType.TYPE_NULL
      }
    }

    salivationStatusLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("No", "Only salivation", "Salivation with foam")
      ).also { adapter ->
        salivationStatusTextView.setAdapter(adapter)
        salivationStatusTextView.inputType = InputType.TYPE_NULL
      }
    }

    postureStatusLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("Standing", "Sitting", "Lying on head up", "Lying on the ground")
      ).also { adapter ->
        postureStatusTextView.setAdapter(adapter)
        postureStatusTextView.inputType = InputType.TYPE_NULL
      }
    }

    muzzleStatusLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("Wet", "Dry")
      ).also { adapter ->
        muzzleStatusTextView.setAdapter(adapter)
        muzzleStatusTextView.inputType = InputType.TYPE_NULL
      }
    }

    sneezingStatusLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("Yes", "No", "With mucus")
      ).also { adapter ->
        sneezingStatusTextView.setAdapter(adapter)
        sneezingStatusTextView.inputType = InputType.TYPE_NULL
      }
    }

    gestureStatusLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("Normal", "Abnormal")
      ).also { adapter ->
        gestureStatusTextView.setAdapter(adapter)
        gestureStatusTextView.inputType = InputType.TYPE_NULL
      }
    }

    firstTimeLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("Yes", "No")
      ).also { adapter ->
        firstTimeTextView.setAdapter(adapter)
        firstTimeTextView.inputType = InputType.TYPE_NULL
      }
    }

    soughtElsewhereLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("Yes", "No")
      ).also { adapter ->
        soughtElsewhereTextView.setAdapter(adapter)
        soughtElsewhereTextView.inputType = InputType.TYPE_NULL
      }
    }

    otherAnimalsLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("Yes", "No")
      ).also { adapter ->
        otherAnimalsTextView.setAdapter(adapter)
        otherAnimalsTextView.inputType = InputType.TYPE_NULL
      }
    }

    emergencyTypeLayout.setOnKeyListener(null)
    context?.let {
      ArrayAdapter(
        it,
        android.R.layout.simple_list_item_1,
        listOf("Normal", "Emergency")
      ).also { adapter ->
        emergencyTypeTextView.setAdapter(adapter)
        emergencyTypeTextView.inputType = InputType.TYPE_NULL
      }
    }
  }
}
