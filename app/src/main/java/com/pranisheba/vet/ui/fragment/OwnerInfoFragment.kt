package com.pranisheba.vet.ui.fragment

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputLayout
import com.pranisheba.vet.databinding.FragmentOwnerInfoBinding
import com.pranisheba.vet.ui.activity.ConsultancyFormActivity
import com.pranisheba.vet.ui.activity.TreatmentFormActivity
import com.pranisheba.vet.ui.viewmodel.TreatmentFormViewModel


class OwnerInfoFragment : Fragment() {

  private lateinit var binding: FragmentOwnerInfoBinding
  private lateinit var viewModel: TreatmentFormViewModel

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentOwnerInfoBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    viewModel = ViewModelProvider(requireActivity()).get(TreatmentFormViewModel::class.java)

    viewModel.customer.observe(viewLifecycleOwner, {

      binding.nameLayout.editText?.setText(it.data.name)
      if (!TextUtils.isEmpty(binding.nameLayout.editText?.text)) {
        binding.nameLayout.editText?.keyListener = null
      }

      binding.mobileLayout.editText?.setText(it.data.mobileNumber)
      if (!TextUtils.isEmpty(binding.mobileLayout.editText?.text)) {
        binding.mobileLayout.editText?.keyListener = null
      }

      binding.emailLayout.editText?.setText(it.data.email)
      if (!TextUtils.isEmpty(binding.emailLayout.editText?.text)) {
        binding.emailLayout.editText?.keyListener = null
      }

      binding.farmNameLayout.editText?.setText(it.data.farmName)
      if (!TextUtils.isEmpty(binding.farmNameLayout.editText?.text)) {
        binding.farmNameLayout.editText?.keyListener = null
      }

      binding.addressLayout.editText?.setText(it.data.address)
      if (!TextUtils.isEmpty(binding.addressLayout.editText?.text)) {
        binding.addressLayout.editText?.keyListener = null
      }
    })

    viewModel.getCustomer()

    when (activity) {
      is TreatmentFormActivity -> (activity as TreatmentFormActivity).showPreviousInfo()
      is ConsultancyFormActivity -> (activity as ConsultancyFormActivity).showPreviousInfo()
    }
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
}
