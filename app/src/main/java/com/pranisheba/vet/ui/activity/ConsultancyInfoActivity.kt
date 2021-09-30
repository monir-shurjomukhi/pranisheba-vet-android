package com.pranisheba.vet.ui.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.pranisheba.vet.R
import com.pranisheba.vet.databinding.ActivityConsultancyInfoBinding
import com.pranisheba.vet.ui.fragment.FarmPlanningFragment


class ConsultancyInfoActivity : AppCompatActivity() {

  private lateinit var binding: ActivityConsultancyInfoBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityConsultancyInfoBinding.inflate(layoutInflater)
    setContentView(binding.root)

    setSupportActionBar(binding.toolbar)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setDisplayShowHomeEnabled(true)

    showFragment()
  }

  private fun showFragment() {
    val fragment = FarmPlanningFragment.newInstance()

    val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
    transaction.replace(R.id.container, fragment)
    //transaction.addToBackStack(null)
    transaction.commit()
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    // handle arrow click here
    if (item.itemId == android.R.id.home) {
      onBackPressed()
    }
    return super.onOptionsItemSelected(item)
  }
}