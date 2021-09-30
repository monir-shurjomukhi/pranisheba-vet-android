package com.pranisheba.vet.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pranisheba.vet.databinding.FragmentGalleryBinding
import com.pranisheba.vet.ui.viewmodel.GalleryViewModel

class GalleryFragment : Fragment() {

  private var _binding: FragmentGalleryBinding? = null

  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!
  private lateinit var galleryViewModel: GalleryViewModel

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentGalleryBinding.inflate(inflater, container, false)
    galleryViewModel =
      ViewModelProvider(this).get(GalleryViewModel::class.java)

    galleryViewModel.text.observe(viewLifecycleOwner, Observer {
      binding.textGallery.text = it
    })
    return binding.root
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}