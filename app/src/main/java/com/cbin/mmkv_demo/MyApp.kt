package com.cbin.mmkv_demo

import android.app.Application
import android.content.Context
import android.util.Log
import com.tencent.mmkv.MMKV

/**
 * @author Cbin
 * @CreateDate 2021/10/25
 * @describe
 */
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initMMKV(this)
    }


}

fun initMMKV(context: Context) {
    val rootDir = MMKV.initialize(context)
    Log.e("MMKV_INIT", rootDir)
}