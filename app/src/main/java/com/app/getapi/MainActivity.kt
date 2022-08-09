package com.app.getapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.getapi.data.UserItem
import com.app.getapi.databinding.ActivityMainBinding
import com.app.getapi.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding
    private val adapterUser = AdapterUser()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //getApi
        getDataApi()
    }

    fun setData(data: ArrayList<UserItem>) {
        binding.rvList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adapterUser
            adapterUser.setUser(data)
        }
    }

    fun getDataApi() {
        ApiConfig.getApiService().getListUser().enqueue(object : Callback<ArrayList<UserItem>> {
            override fun onResponse(
                call: Call<ArrayList<UserItem>>,
                response: Response<ArrayList<UserItem>>
            ) {
                response.body()?.let {
//                    adapterUser.setUser(it)
                    setData(it)
                }
            }

            override fun onFailure(call: Call<ArrayList<UserItem>>, t: Throwable) {
                Log.e("TAG", "onFailure: $t")
            }
        })
    }
}