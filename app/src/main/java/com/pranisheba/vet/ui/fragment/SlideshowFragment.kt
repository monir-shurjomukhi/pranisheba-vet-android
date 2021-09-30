package com.pranisheba.vet.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pranisheba.vet.databinding.FragmentSlideshowBinding
import com.pranisheba.vet.ui.viewmodel.SlideshowViewModel

class SlideshowFragment : Fragment() {

  private var _binding: FragmentSlideshowBinding? = null

  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!
  private lateinit var slideshowViewModel: SlideshowViewModel

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
    slideshowViewModel =
      ViewModelProvider(this).get(SlideshowViewModel::class.java)

    slideshowViewModel.text.observe(viewLifecycleOwner, Observer {
      binding.textSlideshow.text = it
    })

    return binding.root
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}