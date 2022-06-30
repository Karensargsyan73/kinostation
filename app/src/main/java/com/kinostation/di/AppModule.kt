package com.kinostation.di

import android.content.Context
import android.content.SharedPreferences
import com.kinostation.BuildConfig
import com.kinostation.R
import com.kinostation.data.source.Api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun buildApi(okHttpClient: OkHttpClient): Api =
        Retrofit
            .Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(Api::class.java)

    @Singleton
    @Provides
    fun okHTTPClient(): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor {
                val requestBuilder = it.request().newBuilder()
                requestBuilder.header("Authorization", "Bearer " + BuildConfig.HEADER_ID)
                it.proceed(requestBuilder.build())
            }
            .build()

    @Singleton
    @Provides
    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences(
            context.resources.getString(R.string.preference_key), Context.MODE_PRIVATE
        )

}