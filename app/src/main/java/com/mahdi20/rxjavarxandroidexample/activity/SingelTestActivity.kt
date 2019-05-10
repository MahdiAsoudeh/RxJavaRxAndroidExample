package com.mahdi20.rxjavarxandroidexample.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mahdi20.rxjavarxandroidexample.R
import com.mahdi20.rxjavarxandroidexample.utils.Utils
import kotlinx.android.synthetic.main.activity_test_observable.*
import io.reactivex.*
import io.reactivex.disposables.Disposable
import io.reactivex.SingleObserver


class SingelTestActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_single)


        btnTest.setOnClickListener {


            val mySingle = Single.create(SingleOnSubscribe<String> { emitter ->
                try {
                    emitter.onSuccess("single_test_data")

                } catch (e: Exception) {
                    emitter.onError(e)
                }
            })

            val singleObserver = object : SingleObserver<String> {
                override fun onSubscribe(d: Disposable) {

                }

                override fun onSuccess(s: String) {
                    Utils().log("onSuccess: $s")
                    txtTest.text = "onSuccess: $s"
                }

                override fun onError(e: Throwable) {
                    Utils().log("onError: $e")
                    txtTest.text = "onError: $e"
                }
            }


            mySingle.subscribeWith(singleObserver)

        }


    }
}
