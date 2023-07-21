package com.example.deliveryapp.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    @ColumnInfo(name = "login")
    val login: String? = "",

    @ColumnInfo(name = "password")
    val password: String? = ""
)

