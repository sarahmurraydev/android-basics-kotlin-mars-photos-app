package com.example.android.marsphotos.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface MarsApiService {

    @GET("photos")
    // why do I need suspend here?
    suspend fun getPhotos(): List<MarsPhoto>
}

// The call to create() function on a Retrofit object is expensive and the app needs only one
// instance of Retrofit API service. So, you expose the service to the rest of the app using object declaration.
// This is the public singleton object that can be accessed from the rest of the app.
object MarsApi {
    val retrofitService: MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}

// The Retrofit setup is done! Each time your app calls MarsApi.retrofitService, the caller will
// access the same a singleton Retrofit object that implements MarsApiService which is created
// on the first access.