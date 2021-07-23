package com.example.ourstoreapp.datamodel.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user")
class User(
    @PrimaryKey @ColumnInfo(name = "userName") var userName: String = "",
    @ColumnInfo(name = "fullName") var fullName: String,
    @ColumnInfo(name = "password") var password: String = "123456"
)