package com.example.reddit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reddit.adapter.AdapterList
import com.example.reddit.data.model.ListModel
import com.example.reddit.data.LitService
import com.example.reddit.data.RetrofitReddit
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar_list.title = "r/androiddev"
        setSupportActionBar(toolbar_list)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setup()
    }

    private fun setup() {
        val remote = RetrofitReddit.createService(LitService::class.java)
        val call: Call<ListModel> = remote.list()

        val response = call.enqueue(object : Callback<ListModel>{
            override fun onFailure(call: Call<ListModel>, t: Throwable) {
                val s = t.message
            }
            override fun onResponse(call: Call<ListModel>, res: Response<ListModel>) {
                val s = res.body()
                getAdapter(s!!.data.children)
            }
        } )
    }

    private fun getAdapter(childrens:List<ListModel.Data.Children>) {
        reddit_list.layoutManager = LinearLayoutManager(this)
        reddit_list.adapter = AdapterList(childrens)
    }

}