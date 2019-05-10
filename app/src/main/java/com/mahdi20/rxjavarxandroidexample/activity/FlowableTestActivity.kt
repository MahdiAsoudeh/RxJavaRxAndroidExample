package com.mahdi20.rxjavarxandroidexample.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mahdi20.rxjavarxandroidexample.R
import com.mahdi20.rxjavarxandroidexample.utils.Utils
import kotlinx.android.synthetic.main.activity_test_flowable.*
import io.reactivex.BackpressureStrategy
import io.reactivex.FlowableOnSubscribe
import io.reactivex.Flowable
import org.reactivestreams.Subscription
import org.reactivestreams.Subscriber


class FlowableTestActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_flowable)


        btnTest.setOnClickListener {

            val myFlowable = Flowable.create(FlowableOnSubscribe<String> { emitter ->
                try {
                    emitter.onNext("flowable_test_data")
                    emitter.onComplete()

                } catch (e: Exception) {
                    emitter.onError(e)
                }
            }, BackpressureStrategy.BUFFER)


            val subscriber = object : Subscriber<String> {
                override fun onSubscribe(s: Subscription) {

                    //Without this, there is no subscription!
                    s.request(java.lang.Long.MAX_VALUE)

                }

                override fun onNext(s: String) {
                    Utils().log("onNext: $s")
                    txtTest.text = "onNext: $s"
                }

                override fun onError(t: Throwable) {
                    Utils().log("onError: $t")
                    txtTest.text = "onError: $t"
                }

                override fun onComplete() {
                    Utils().log("onComplete")
                    txtTest.text = "onComplete"
                }
            }


            myFlowable.subscribeWith(subscriber);


        }

    }
}
