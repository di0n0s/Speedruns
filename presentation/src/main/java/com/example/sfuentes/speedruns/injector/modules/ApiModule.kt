package com.example.sfuentes.speedruns.injector.modules

import com.example.data.net.ApiConstants
import com.example.data.net.ApiService
import com.example.data.repository.datasource.DataStore
import com.example.data.repository.datasource.DataStoreImpl
import com.example.data.repository.RepositoryImpl
import com.example.domain.executor.PostExecutionThread
import com.example.domain.repository.Repository
import com.example.sfuentes.speedruns.UIThread
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        val httpClient = OkHttpClient.Builder()
                .connectTimeout(ApiConstants.TIMEOUT_CONNECTION_VALUE, TimeUnit.SECONDS)
                .readTimeout(ApiConstants.TIMEOUT_READ_VALUE, TimeUnit.SECONDS)
                .writeTimeout(ApiConstants.TIMEOUT_WRITE_VALUE, TimeUnit.SECONDS)
        val builder = Retrofit.Builder()
                .baseUrl(ApiConstants.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        return builder.client(httpClient.build()).build().create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(repositoryImpl: RepositoryImpl): Repository = repositoryImpl


    @Provides
    @Singleton
    fun provideHeroDataStore(moviesDataStoreImpl: DataStoreImpl): DataStore = moviesDataStoreImpl


    @Provides
    @Singleton
    fun providePostExecutionThread(uiThread: UIThread): PostExecutionThread = uiThread
}