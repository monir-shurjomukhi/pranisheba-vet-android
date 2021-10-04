package com.pranisheba.vet.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout
import com.pranisheba.vet.databinding.FragmentOwnerInfoBinding
import com.pranisheba.vet.ui.activity.ConsultancyFormActivity
import com.pranisheba.vet.ui.activity.TreatmentFormActivity


class OwnerInfoFragment : Fragment() {

  private lateinit var binding: FragmentOwnerInfoBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentOwnerInfoBinding.inflate(inflater, container, false)
    return binding.root
  }

  fun getScrollView(): ScrollView {
    return binding.scrollView
  }

  fun getNameLayout(): TextInputLayout {
    return binding.nameLayout
  }

  fun getMobileLayout(): TextInputLayout {
    return binding.mobileLayout
  }

  fun getEmailLayout(): TextInputLayout {
    return binding.emailLayout
  }

  fun getFarmNameLayout(): TextInputLayout {
    return binding.farmNameLayout
  }

  fun getAddressLayout(): TextInputLayout {
    return binding.addressLayout
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    when (activity) {
      is TreatmentFormActivity -> (activity as TreatmentFormActivity).showPreviousInfo()
      is ConsultancyFormActivity -> (activity as ConsultancyFormActivity).showPreviousInfo()
    }
  }
}
