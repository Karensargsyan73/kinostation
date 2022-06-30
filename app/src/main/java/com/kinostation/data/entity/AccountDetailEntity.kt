package com.kinostation.data.entity

data class AccountDetailEntity(
    val avatar: GravatarEntity,
    val id: Int,
    val username: String
)

data class GravatarEntity(
    val hash: String
)