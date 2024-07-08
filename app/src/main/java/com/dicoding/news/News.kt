package com.dicoding.news

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class News(
    val title: String,
    val description: String,
    val category: String,
    val time: String,
    val writer: String,
    val link: String,
    val photo: String
) : Parcelable
