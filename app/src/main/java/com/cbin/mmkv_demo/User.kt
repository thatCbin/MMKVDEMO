package com.cbin.mmkv_demo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


/**
 * @author Cbin
 * @CreateDate 2021/10/25
 * @describe
 */

@Parcelize
data class User(
    var name: String,
    var age: Int,
    var sex: Boolean
) : Parcelable