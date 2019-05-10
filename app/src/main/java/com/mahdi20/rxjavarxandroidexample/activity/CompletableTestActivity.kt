package com.mahdi20.rxjavarxandroidexample.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mahdi20.rxjavarxandroidexample.R
import com.mahdi20.rxjavarxandroidexample.utils.Utils
import kotlinx.android.synthetic.main.activity_test_observable.*
import io.reactivex.disposables.Disposable
import io.reactivex.Completable
import io.reactivex.CompletableObserver


class CompletableTestActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_completable)


        btnTest.setOnClickListener {

            //// faghat ettela mide movaffagh boode ya na hamin :)

            val completable = Completable.create { emitter ->
                try {
                    emitter.onComplete()
                } catch (e: Exception) {
                    emitter.onError(e)
                }
            }

            val myCompletableObserver = object : CompletableObserver {
                override fun onSubscribe(d: Disposable) {

                }

                override fun onComplete() {
                    Utils().log("onComplete")
                    txtTest.text = "onComplete"


                }

                override fun onError(e: Throwable) {
                    Utils().log("onError")
                    txtTest.text = "onError"


                }
            }

            completable.subscribeWith(myCompletableObserver)

        }


    }
}
