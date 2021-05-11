package com.pranisheba.vet.ui.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.pranisheba.vet.R
import com.pranisheba.vet.ui.fragment.GalleryFragment
import com.pranisheba.vet.ui.fragment.HomeFragment

class ServiceReceivingFormPagerAdapter(val context: Context, fragmentManager: FragmentManager?) :
  FragmentStatePagerAdapter(
    fragmentManager!!, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
  ) {

  override fun getItem(position: Int): Fragment {
    return if (position == 0) {
      GalleryFragment()
    } else {
      HomeFragment()
    }
  }

  override fun getCount(): Int {
    return 2
  }

  override fun getPageTitle(position: Int): CharSequence? {
    return if (position == 0) {
      context.getString(R.string.treatment)
    } else context.getString(R.string.consultancy)
  }
}
