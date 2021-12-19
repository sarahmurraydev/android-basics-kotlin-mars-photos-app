package com.example.android.marsphotos

import com.example.android.marsphotos.network.MarsApi
import com.example.android.marsphotos.network.MarsApiService
import org.junit.Before
import org.junit.Test

class MarsApiServiceTests: BaseTest() {
    private lateinit var service: MarsApiService

    @Before
    fun setup() {



        // this is what I want to do based on what I've done before:
        // service = MarsApi.retrofitService
        // every { service.getPhotos() } returns parsedDataFromJsonFile
        // "every" is a method from mockk which we aren't using here
        // TODO: what's the different between mockk and using something like mockwebserver
        // is one better than the other?
    }

    @Test
    fun `Test MarsApiService`() {

    }

}