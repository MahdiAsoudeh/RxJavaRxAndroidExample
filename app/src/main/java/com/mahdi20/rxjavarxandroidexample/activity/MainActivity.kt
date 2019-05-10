package com.mahdi20.rxjavarxandroidexample.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mahdi20.rxjavarxandroidexample.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnObservableActivity.setOnClickListener {

            var intent = Intent(this, ObservableTestActivity::class.java)
            startActivity(intent)

        }


        btnFlowableActivity.setOnClickListener {

            var intent = Intent(this, FlowableTestActivity::class.java)
            startActivity(intent)

        }


        btnSingleActivity.setOnClickListener {

            var intent = Intent(this, SingelTestActivity::class.java)
            startActivity(intent)

        }


        btnMaybeActivity.setOnClickListener {

            var intent = Intent(this, MaybeTestActivity::class.java)
            startActivity(intent)

        }


        btnCompletableActivity.setOnClickListener {

            var intent = Intent(this, CompletableTestActivity::class.java)
            startActivity(intent)

        }


    }
}
