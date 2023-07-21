package com.example.deliveryapp.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dishes")
data class DishEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = 0,

    @ColumnInfo(name = "name")
    val name: String? = "",

    @ColumnInfo(name = "url")
    val url: String? = ""
)