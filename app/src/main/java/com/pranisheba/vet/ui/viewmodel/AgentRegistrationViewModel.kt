package com.pranisheba.vet.ui.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pranisheba.vet.R
import com.pranisheba.vet.model.AgentRegistration
import com.pranisheba.vet.model.AgentRegistrationData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AgentRegistrationViewModel(application: Application) : BaseViewModel(application) {

  private val _agentRegistration = MutableLiveData<AgentRegistration>()
  val agentRegistration: LiveData<AgentRegistration>
    get() = _agentRegistration

  fun registerAgent(agentRegistrationData: AgentRegistrationData) {
    progress.value = true
    apiClient?.registerAgent(agentRegistrationData)?.enqueue(object : Callback<AgentRegistration> {
      override fun onResponse(
        call: Call<AgentRegistration>,
        response: Response<AgentRegistration>
      ) {
        if (response.isSuccessful) _agentRegistration.value = response.body()
        else message.value = R.string.could_not_register_agent

        progress.value = false
      }

      override fun onFailure(call: Call<AgentRegistration>, t: Throwable) {
        Log.e(TAG, "onFailure: ${t.message}", t)
        message.value = R.string.could_not_register_agent
        progress.value = false
      }
    })
  }

  companion object {
    private const val TAG = "AgentRegViewModel"
  }
}
