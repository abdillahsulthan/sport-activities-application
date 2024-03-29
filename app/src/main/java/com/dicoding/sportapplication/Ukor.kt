package com.dicoding.sportapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ukor (
    var name: String,
    var description: String,
    var supervisor: String,
    var location: String,
    var photo: String
): Parcelable