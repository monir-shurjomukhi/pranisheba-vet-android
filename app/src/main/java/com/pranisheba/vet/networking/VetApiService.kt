package com.pranisheba.vet.networking

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.pranisheba.vet.BuildConfig
import com.pranisheba.vet.networking.Client.okHttpClient
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

//enum class VetApiStatus { LOADING, ERROR, DONE }

private val moshi = Moshi.Builder()
  .add(KotlinJsonAdapterFactory())
  .build()

object Client {
  val okHttpClient: OkHttpClient = OkHttpClient.Builder()
    .connectTimeout(5, TimeUnit.MINUTES)
    .readTimeout(5, TimeUnit.MINUTES)
    .writeTimeout(5, TimeUnit.MINUTES)
    .retryOnConnectionFailure(true)
    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
    .build()
}

private val retrofit = Retrofit.Builder()
  .addConverterFactory(MoshiConverterFactory.create(moshi))
  .addCallAdapterFactory(CoroutineCallAdapterFactory())
  .baseUrl(BuildConfig.BASE_URL)
  .client(okHttpClient)
  .build()

object VetApi {
  val retrofitService: VetApiService by lazy {
    retrofit.create(VetApiService::class.java)
  }
}

interface VetApiService {

  /*@POST("geoLocationEntry.jsp")
  fun sendGeoLocationAsync(
    @Query("key") key: String,
    @Query("userId") userId: String,
    @Query("lat") lat: String,
    @Query("lng") lng: String
  ): Deferred<LocationResponse>

  @POST("getBillType.jsp")
  fun getBillTypeAsync(
    @Query("key") key: String,
    @Query("userId") userId: String,
    @Query("lat") lat: String,
    @Query("lng") lng: String
  ): Deferred<BillTypeResponse>

  @POST("getUserAdvanceIdTaskWise.jsp")
  fun getTaskWiseAdvanceIdAsync(
    @Query("key") key: String,
    @Query("userId") userId: String,
    @Query("lat") lat: String,
    @Query("lng") lng: String,
    @Query("lng") taskId: String
  ): Deferred<AdvanceIdResponse>

  @FormUrlEncoded
  @POST("billEntry.jsp")
  fun addBillAsync(
    @Query("key") key: String,
    @Query("userId") userId: String,
    @Query("lat") lat: String,
    @Query("lng") lng: String,
    @Query("billData") billData: String,
    @Query("taskIdData") taskIdData: String,
    @Field("imageString") imageString: String,
    @Query("advanceId") advanceId: String,
    @Query("priority") priority: String
  ): Deferred<AddBillResponse>

  @FormUrlEncoded
  @POST("advanceBillEntry.jsp")
  fun addAdvanceBillAsync(
    @Query("key") key: String,
    @Query("userId") userId: String,
    @Query("lat") lat: String,
    @Query("lng") lng: String,
    @Query("billData") billData: String,
    @Field("imageString") imageString: String,
    @Query("taskIdData") taskIdData: String,
    @Query("priority") priority: String
  ): Deferred<AddBillResponse>

  @POST("getUserBillList.jsp")
  fun getExpenseBillListAsync(
    @Query("key") key: String,
    @Query("userId") userId: String,
    @Query("lat") lat: String,
    @Query("lng") lng: String
  ): Deferred<BillDashboardResponse>

  @POST("getUserAdvanceBillList.jsp")
  fun getAdvanceBillListAsync(
    @Query("key") key: String,
    @Query("userId") userId: String,
    @Query("lat") lat: String,
    @Query("lng") lng: String
  ): Deferred<BillDashboardResponse>

  @POST("getUserBillDetails.jsp")
  fun getBillDetailsAsync(
    @Query("key") key: String,
    @Query("userId") userId: String,
    @Query("lat") lat: String,
    @Query("lng") lng: String,
    @Query("billId") billId: String
  ): Deferred<BillDetailsResponse>

  @POST("getUserAdvanceBillDetails.jsp")
  fun getAdvanceBillDetailsAsync(
    @Query("key") key: String,
    @Query("userId") userId: String,
    @Query("lat") lat: String,
    @Query("lng") lng: String,
    @Query("advanceBillId") advanceBillId: String
  ): Deferred<BillDetailsResponse>

  @POST("technicianSummaryInfo.jsp")
  fun getTaskDashboardAsync(
    @Query("regTechId") regTechId: String
  ): Deferred<List<TaskDashboardResponse>>

  @POST("assignTicketList.jsp")
  fun getAssignedTaskListAsync(
    @Query("regTechId") regTechId: String
  ): Deferred<List<TaskListResponse>>

  @POST("acceptedTicketList.jsp")
  fun getAcceptedTaskListAsync(
    @Query("regTechId") regTechId: String
  ): Deferred<List<TaskListResponse>>

  @POST("completedTicketList.jsp")
  fun getCompletedTaskListAsync(
    @Query("regTechId") regTechId: String
  ): Deferred<List<TaskListResponse>>

  @POST("inprogressTicketList.jsp")
  fun getInProgressTaskListAsync(
    @Query("regTechId") regTechId: String
  ): Deferred<List<TaskListResponse>>

  @POST("tickeDetailsInfo.jsp")
  fun getTaskDetailsAsync(
    @Query("regTechId") regTechId: String,
    @Query("ticketId") ticketId: String
  ): Deferred<List<TaskDetailsResponse>>

  @POST("getItemList.jsp")
  fun getInventoryItemListAsync(
    @Query("key") key: String,
    @Query("userId") userId: String,
    @Query("lat") lat: String,
    @Query("lng") lng: String
  ): Deferred<InventoryItemResponse>

  @POST("getUserItemRequisitionList.jsp")
  fun getRequisitionListAsync(
    @Query("key") key: String,
    @Query("userId") userId: String,
    @Query("lat") lat: String,
    @Query("lng") lng: String
  ): Deferred<RequisitionResponse>

  @POST("getUserItemRequisitionDetails.jsp")
  fun getRequisitionDetailsAsync(
    @Query("key") key: String,
    @Query("userId") userId: String,
    @Query("lat") lat: String,
    @Query("lng") lng: String,
    @Query("itemRequisitionId") itemRequisitionId: String
  ): Deferred<BillDetailsResponse>

  @POST("itemRequisition.jsp")
  fun createRequisitionAsync(
    @Query("key") key: String,
    @Query("userId") userId: String,
    @Query("lat") lat: String,
    @Query("lng") lng: String,
    @Query("taskIdData") taskIdData: String,
    @Query("itemRequisitionData") itemRequisitionData: String,
    @Query("priority") priority: String
  ): Deferred<CreateRequisitionResponse>

  @POST("getTaskListForItemRequisition.jsp")
  fun getTaskListForRequisitionAsync(
    @Query("key") key: String,
    @Query("userId") userId: String,
    @Query("lat") lat: String,
    @Query("lng") lng: String
  ): Deferred<SearchTaskResponse>

  @POST("getTaskListForBill.jsp")
  fun getTaskListForBillAsync(
    @Query("key") key: String,
    @Query("userId") userId: String,
    @Query("lat") lat: String,
    @Query("lng") lng: String
  ): Deferred<SearchTaskResponse>*/
}
