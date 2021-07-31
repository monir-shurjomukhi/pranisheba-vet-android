package com.pranisheba.vet.ui.activity

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.pranisheba.vet.R
import com.pranisheba.vet.databinding.ActivityWeightMeasurementBinding


class WeightMeasurementActivity : AppCompatActivity() {

  private lateinit var binding: ActivityWeightMeasurementBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityWeightMeasurementBinding.inflate(layoutInflater)
    setContentView(binding.root)

    setSupportActionBar(binding.toolbar)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setDisplayShowHomeEnabled(true)

    binding.submitButton.setOnClickListener {
      val length = binding.lengthLayout.editText?.text.toString()
      val circumference = binding.circumferenceLayout.editText?.text.toString()
      if (TextUtils.isEmpty(length)) {
        binding.lengthLayout.error = getString(R.string.body_length_a_to_b_inch_is_required)
        return@setOnClickListener
      }
      if (TextUtils.isEmpty(circumference)) {
        binding.circumferenceLayout.error = getString(R.string.body_circumference_c_inch_is_required)
        return@setOnClickListener
      }

      val weight1 =
        (circumference.toDouble() * circumference.toDouble() * length.toDouble()) / 660.0
      val percent5 = (weight1 * 5) / 100.0
      val netWeight = weight1 - percent5

      val builder = AlertDialog.Builder(this)
      builder.setTitle("Total Weight")
      builder.setMessage(String.format("%.2f KG", netWeight))
      builder.setPositiveButton(android.R.string.yes) { dialog, _ ->
        dialog.dismiss()
      }
      builder.setNegativeButton(android.R.string.no) { dialog, _ ->
        dialog.dismiss()
      }
      builder.show()
    }

    binding.instructionTextView.setOnClickListener {
      val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:lvjrH6ng2Lk"))
      val webIntent = Intent(
        Intent.ACTION_VIEW,
        Uri.parse("http://www.youtube.com/watch?v=lvjrH6ng2Lk")
      )
      try {
        startActivity(appIntent)
      } catch (ex: ActivityNotFoundException) {
        startActivity(webIntent)
      }
    }
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    // handle arrow click here
    if (item.itemId == android.R.id.home) {
      onBackPressed()
    }
    return super.onOptionsItemSelected(item)
  }
}