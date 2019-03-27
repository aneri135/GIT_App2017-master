package com.git.gitapp

import android.app.Activity
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.git.gitapp.databinding.ActivityChatBinding

class ChatActivity : Activity() {

    lateinit var mBinding: ActivityChatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this@ChatActivity, R.layout.activity_chat)
        mBinding.exit.setOnClickListener { finish() }

    }
}
