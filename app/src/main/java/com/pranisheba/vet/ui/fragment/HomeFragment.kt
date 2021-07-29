package com.pranisheba.vet.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pranisheba.vet.R
import com.pranisheba.vet.ui.activity.FarmManagementInfoActivity
import com.pranisheba.vet.ui.activity.ServiceReceivingFormActivity
import com.pranisheba.vet.ui.activity.ServiceRelatedInfoActivity
import com.pranisheba.vet.ui.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

  private lateinit var homeViewModel: HomeViewModel

  private lateinit var serviceRelatedInfoCardView: CardView
  private lateinit var farmManagementInfoCardView: CardView
  private lateinit var weightMeasurementCardView: CardView
  private lateinit var oneTimeServiceCardView: CardView
  private lateinit var monthlyServiceRegistrationCardView: CardView
  private lateinit var monthlyServiceRelatedInfoCardView: CardView
  private lateinit var agentRegistrationCardView: CardView
  private lateinit var paymentFormCardView: CardView

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    homeViewModel =
      ViewModelProvider(this).get(HomeViewModel::class.java)
    val root = inflater.inflate(R.layout.fragment_home, container, false)

    serviceRelatedInfoCardView = root.findViewById(R.id.serviceRelatedInfoCardView)
    farmManagementInfoCardView = root.findViewById(R.id.farmManagementInfoCardView)
    weightMeasurementCardView = root.findViewById(R.id.weightMeasurementCardView)
    oneTimeServiceCardView = root.findViewById(R.id.oneTimeServiceCardView)
    monthlyServiceRegistrationCardView = root.findViewById(R.id.monthlyServiceRegistrationCardView)
    monthlyServiceRelatedInfoCardView = root.findViewById(R.id.monthlyServiceRelatedInfoCardView)
    agentRegistrationCardView = root.findViewById(R.id.agentRegistrationCardView)
    paymentFormCardView = root.findViewById(R.id.paymentFormCardView)

    homeViewModel.text.observe(viewLifecycleOwner, Observer {

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
