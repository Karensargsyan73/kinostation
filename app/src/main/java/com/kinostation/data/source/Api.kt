package com.kinostation.data.source

import com.kinostation.data.entity.AccountDetailEntity
import retrofit2.http.Query
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface Api {

    @GET("account")
    fun getAccountDetails(
        @Query("session_id") sessionId: String
    ):Flow<AccountDetailEntity>
}