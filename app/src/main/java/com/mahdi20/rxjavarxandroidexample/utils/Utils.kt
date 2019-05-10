package com.mahdi20.rxjavarxandroidexample.utils

import android.content.Context
import android.nfc.Tag
import android.util.Log
import android.widget.Toast

class Utils {

    private val TAG = "RxJavaRxAndroidExample"

    fun log(msg: String) {
        Log.i(TAG, "log: " + msg)
    }


    fun toast(ctx: Context, msg: String) {
        Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show()
    }


}
