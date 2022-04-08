package com.dicoding.picodiploma.submission1_apkgithubuser

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    var username: String,
    var name: String,
    var avatar: Int,
    var company: String,
    var location: String,
    var repository: String,
    var follower: String,
    var following: String
) : Parcelable
