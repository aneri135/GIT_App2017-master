package com.git.gitapp

import android.app.Activity
import android.content.Intent
import android.databinding.DataBindingUtil
import android.databinding.ObservableArrayList
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import android.view.WindowManager
import com.github.nitrico.lastadapter.LastAdapter

class VideoListActivity : Activity() {

/*    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_list)
    }*/


    lateinit var mBinding: com.git.gitapp.databinding.ActivityVideoListBinding
    private var materialList: ObservableArrayList<MaterialData> = ObservableArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this@VideoListActivity, R.layout.activity_video_list)
        mBinding.recyclerViewMater.layoutManager = LinearLayoutManager(this@VideoListActivity)

        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayShowHomeEnabled(true)
        setAdapter()
    }


    /* private fun getMaterialBySubjectId(subjectId: String?) {

         // todo get subject id
         val reqMap = HashMap<String, RequestBody>()
         reqMap["subject_id"] = Utility.getRequestBody(subjectId.toString())
         reqMap["id"] = Utility.getRequestBody(AppPreference.loginUserData.id.toString())
         reqMap["device_id"] = Utility.getRequestBody(AppBasePref.DEVICE_ID)


         ApiClient.service.getMaterailBySubjectId(ApiMethods.getmaterialbysubjectId, reqMap).enqueue(RetrofitCallback {

             onCompleted { call, response, throwable ->
                 ProgressDialogUtility.dismiss()
             }
             on2xxSuccess { call, response ->
                 materialList.clear()
                 response?.body()?.data?.let { materialList.addAll(it) }
                 materialList.map { it.id }.sorted()
                 setAdapter()
             }
             onFailureCallback { call, throwable ->
                 Log.d("tag", "error............" + throwable.toString())
                 toast("Something went wrong")
             }
             on5xxServerError { call, response ->
                 Log.d("tag", "error1.." + response?.code())
             }
         })
     }*/

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setAdapter() {

        materialList.add(MaterialData(1, "DBMS","https://firebasestorage.googleapis.com/v0/b/gitapp-151d2.appspot.com/o/dbms_tutorial.pdf?alt=media&token=e094822a-2857-4965-81e2-7f5276d6bb51"))

        if (materialList.isNotEmpty()) {

            LastAdapter(materialList, com.git.gitapp.BR.item).map<MaterialData, com.git.gitapp.databinding.ItemMaterialBinding>(R.layout.item_material) {
                onBind {
                    val pos = it.adapterPosition

                    it.binding.layoutMaterial.setOnClickListener {
                        val inetnt = Intent(this@VideoListActivity, PDFViewerActivity::class.java)
                        inetnt.putExtra(PDFViewerActivity.EXTRA_PDF_URL, materialList[pos].material_url)
                        startActivity(inetnt)
                    }
                }
            }.into(mBinding.recyclerViewMater)
        } else {
        }
    }

    override fun onPause() {
        window?.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)
        super.onPause()
    }

    companion object {
        const val SUBJECT_ID = "suject_id"
        const val SUBJECT_NAME = "subject_name"
    }

}

data class MaterialResponse(
        val data: List<MaterialData>,
        val error: Boolean,
        val message: String
)

data class MaterialData(
        val id: Int,
        val material_name: String,
        val material_url: String
)