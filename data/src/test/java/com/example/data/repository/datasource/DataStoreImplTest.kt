package com.example.data.repository.datasource

import com.example.data.UnitTest
import com.example.data.net.ApiService
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class DataStoreImplTest : UnitTest() {

    private lateinit var dataStore: DataStoreImpl
    @Mock
    private lateinit var apiService: ApiService

    @Before
    fun setup() {
        dataStore = DataStoreImpl(apiService)
    }

    @Test
    fun getPopularMoviesTest() {
        dataStore.getGameList(756)

        verify(apiService).getGameList(any())
    }
}