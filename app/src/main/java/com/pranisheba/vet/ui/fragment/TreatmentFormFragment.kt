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
      ArrayAdapter(it, android.R.layout.simple_expandable_list_item_1, listOf("Yes", "No"))
        .also { adapter ->
          treatedBeforeTextView.setAdapter(adapter)
          treatedBeforeTextView.inputType = InputType.TYPE_NULL
        }
    }
  }
}
