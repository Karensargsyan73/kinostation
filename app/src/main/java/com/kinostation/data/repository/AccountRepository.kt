package com.kinostation.data.repository

import android.content.SharedPreferences
import com.kinostation.BuildConfig
import com.kinostation.data.entity.AccountDetailEntity
import com.kinostation.data.source.Api
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AccountRepository @Inject constructor(
    private val preferences: SharedPreferences,
    private val api: Api
) {


    fun accountDetailRepository(): Flow<AccountDetailEntity> =
        api.getAccountDetails(BuildConfig.HEADER_ID)
}