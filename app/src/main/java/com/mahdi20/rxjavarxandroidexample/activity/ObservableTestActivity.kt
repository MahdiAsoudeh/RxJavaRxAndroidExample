package com.mahdi20.rxjavarxandroidexample.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mahdi20.rxjavarxandroidexample.R
import com.mahdi20.rxjavarxandroidexample.utils.Utils
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_test_observable.*

class ObservableTestActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_observable)


        btnTest.setOnClickListener {


            val myObservable = Observable.create(
                ObservableOnSubscribe<String> { emitter ->
                    try {
                        emitter.onNext("observable_test_data")
                        emitter.onComplete()
                    } catch (e: Exception) {
                        emitter.onError(e)
                    }
                })


            val observer = object : Observer<String> {
                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(s: String) {
                    Utils().log("onNext: $s")
                    txtTest.text = "onNext: $s"
                }

                override fun onError(e: Throwable) {
                    Utils().log("onError: $e")
                    txtTest.text = "onError: $e"
                }

                override fun onComplete() {
                    Utils().log("onComplete")
                    txtTest.text = "onComplete"
                }
            }

            myObservable.subscribeWith(observer)

        }


    }
}
