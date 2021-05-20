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
  }
}
