package com.pranisheba.vet.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pranisheba.vet.R
import com.pranisheba.vet.databinding.FragmentConsultancyFormBinding


class ConsultancyFormFragment : Fragment() {

  private lateinit var binding: FragmentConsultancyFormBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentConsultancyFormBinding.inflate(inflater, container, false)
    return binding.root
  }
}
