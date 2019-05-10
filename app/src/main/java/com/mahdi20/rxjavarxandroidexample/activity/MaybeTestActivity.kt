package com.mahdi20.rxjavarxandroidexample.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mahdi20.rxjavarxandroidexample.R
import com.mahdi20.rxjavarxandroidexample.utils.Utils
import kotlinx.android.synthetic.main.activity_test_observable.*
import io.reactivex.disposables.Disposable
import io.reactivex.MaybeOnSubscribe
import io.reactivex.Maybe
import io.reactivex.MaybeObserver


class MaybeTestActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_maybe)


        btnTest.setOnClickListener {

            var boolean: Boolean? = true

            /// shayad bashad shayad nabashad bara hamin maybe nam ghozari shode - boolean dast bose shooma ;)
            /// dar sorati ke true bashad data send mishe vali age false bashad data send nemishe va fagat be onComplete mire

            val myMaybe = Maybe.create(MaybeOnSubscribe<String> { emitter ->
                try {
                    if (boolean!!) {
                        emitter.onSuccess("maybe_test_data")
                    } else {
                        emitter.onComplete()

                    }

                } catch (e: Exception) {
                    emitter.onError(e)
                }
            })


            val myMaybeObserver = object : MaybeObserver<String> {
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

                override fun onComplete() {
                    Utils().log("onComplete")
                    txtTest.text = "onComplete"

                }
            }


            myMaybe.subscribeWith(myMaybeObserver)

        }


    }
}
