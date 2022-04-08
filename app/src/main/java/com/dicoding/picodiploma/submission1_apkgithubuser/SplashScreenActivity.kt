package com.dicoding.picodiploma.submission1_apkgithubuser

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler

class SplashScreenActivity : Activity() {

    private val SplashScreenActivity : Long = 1500
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()

        }, SplashScreenActivity)
    }
}