package com.git.gitapp

import android.annotation.SuppressLint
import android.app.Activity
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.WindowManager
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.git.gitapp.databinding.ActivityPdfviewerBinding

class PDFViewerActivity : Activity() {

    lateinit var mBinding: ActivityPdfviewerBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)
        mBinding = DataBindingUtil.setContentView(this@PDFViewerActivity, R.layout.activity_pdfviewer)

        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayShowHomeEnabled(true)
        actionBar?.title = "Target with Bhavik Maru"

        mBinding.webviewMaterial.settings.javaScriptEnabled = true
        mBinding.webviewMaterial.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
                view.loadUrl(request.url.toString())
                return false
            }
        }

        Log.d("tag", "pdf url....." + intent.getStringExtra(EXTRA_PDF_URL))
        if (!intent.getStringExtra(EXTRA_PDF_URL).isNullOrEmpty()) {
            mBinding.webviewMaterial.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url=" + intent.getStringExtra(EXTRA_PDF_URL));
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val EXTRA_PDF_URL = "pdf_url"
    }
}
