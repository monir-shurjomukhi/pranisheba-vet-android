package com.pranisheba.vet.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pranisheba.vet.R
import com.pranisheba.vet.ui.activity.FarmManagementInfoActivity
import com.pranisheba.vet.ui.activity.ServiceReceivingFormActivity
import com.pranisheba.vet.ui.activity.ServiceRelatedInfoActivity
import com.pranisheba.vet.ui.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

  private lateinit var homeViewModel: HomeViewModel

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    homeViewModel =
      ViewModelProvider(this).get(HomeViewModel::class.java)
    val root = inflater.inflate(R.layout.fragment_home, container, false)
    //val textView: TextView = root.findViewById(R.id.text_home)
    homeViewModel.text.observe(viewLifecycleOwner, Observer {
      //textView.text = it
    })

    return root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    serviceRelatedInfoCardView.setOnClickListener {
      startActivity(Intent(context, ServiceRelatedInfoActivity::class.java))
    }

    farmManagementInfoCardView.setOnClickListener {
      startActivity(Intent(context, FarmManagementInfoActivity::class.java))
    }

    weightMeasurementCardView.setOnClickListener {
      //startActivity(Intent(context, ServiceRelatedInfoActivity::class.java))
    }

    oneTimeServiceCardView.setOnClickListener {
      startActivity(Intent(context, ServiceReceivingFormActivity::class.java))
    }

    monthlyServiceRegistrationCardView.setOnClickListener {
      //startActivity(Intent(context, ServiceReceivingFormActivity::class.java))
    }

    monthlyServiceRelatedInfoCardView.setOnClickListener {
      //startActivity(Intent(context, ServiceReceivingFormActivity::class.java))
    }

    agentRegistrationCardView.setOnClickListener {
      //startActivity(Intent(context, ServiceReceivingFormActivity::class.java))
    }

    paymentFormCardView.setOnClickListener {
      //startActivity(Intent(context, ServiceReceivingFormActivity::class.java))
    }
  }
}
