package com.pranisheba.vet.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pranisheba.vet.databinding.FragmentOwnerInfoBinding


class OwnerInfoFragment : Fragment() {

  private lateinit var binding: FragmentOwnerInfoBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentOwnerInfoBinding.inflate(inflater, container, false)
    return binding.root
  }
}