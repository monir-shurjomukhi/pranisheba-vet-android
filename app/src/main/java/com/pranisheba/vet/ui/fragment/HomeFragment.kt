package com.pranisheba.vet.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pranisheba.vet.databinding.FragmentHomeBinding
import com.pranisheba.vet.preference.VetPreference
import com.pranisheba.vet.ui.activity.*
import com.pranisheba.vet.ui.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

  private var _binding: FragmentHomeBinding? = null

  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!
  private lateinit var homeViewModel: HomeViewModel
  private lateinit var preference: VetPreference

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentHomeBinding.inflate(inflater, container, false)
    homeViewModel =
      ViewModelProvider(this).get(HomeViewModel::class.java)

    preference = VetPreference(requireContext())

    homeViewModel.text.observe(viewLifecycleOwner, Observer {

    })

    return binding.root
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.serviceRelatedInfoCardView.setOnClickListener {
      startActivity(Intent(context, ServiceRelatedInfoActivity::class.java))
    }

    binding.farmManagementInfoCardView.setOnClickListener {
      startActivity(Intent(context, FarmManagementInfoActivity::class.java))
    }

    binding.weightMeasurementCardView.setOnClickListener {
      startActivity(Intent(context, WeightMeasurementActivity::class.java))
    }

    binding.serviceReceivingFormCardView.setOnClickListener {
      if (preference.getAuthToken()?.isEmpty() == true) {
        startActivity(Intent(context, LoginActivity::class.java))
      } else {
        startActivity(Intent(context, ServiceReceivingFormActivity::class.java))
      }
    }

    binding.monthlyServiceRegistrationCardView.setOnClickListener {
      //startActivity(Intent(context, ServiceReceivingFormActivity::class.java))
    }

    binding.monthlyServiceRelatedInfoCardView.setOnClickListener {
      //startActivity(Intent(context, ServiceReceivingFormActivity::class.java))
    }

    binding.agentRegistrationCardView.setOnClickListener {
      startActivity(Intent(context, AgentRegistrationActivity::class.java))
    }

    binding.paymentFormCardView.setOnClickListener {
      //startActivity(Intent(context, ServiceReceivingFormActivity::class.java))
    }
  }
}
