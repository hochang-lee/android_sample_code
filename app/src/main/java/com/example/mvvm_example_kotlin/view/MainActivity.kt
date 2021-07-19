package com.example.mvvm_example_kotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_example_kotlin.R
import com.example.mvvm_example_kotlin.databinding.ActivityMainBinding
import com.example.mvvm_example_kotlin.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainViewModel : MainViewModel by viewModel()
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.mainSearchRcy.layoutManager = LinearLayoutManager(this)
        binding.mainSavedRcy.layoutManager = LinearLayoutManager(this)

        var page = 1
        binding.mainAddBtn.setOnClickListener {
            mainViewModel.getKakaoSearch("카페","accuracy",page,10)
            page++
        }

        mainViewModel.getSavedData()
        mainViewModel.searchList.observe(this, Observer { result ->
            val adapter = KaKaoRcyAdapter(result.documents)
            adapter.setItemOnClickListener(object  : KaKaoRcyAdapter.ItemOnClickListener{
                override fun itemOnClick(v: View, pos: Int) {
                    val itemData = adapter.getList()[pos]
                    mainViewModel.saveData(itemData.title,itemData.contents,itemData.url)
                }
            })
            binding.mainSearchRcy.adapter = adapter
        })

        binding.mainSavedListBtn.setOnClickListener {
            mainViewModel.getSavedData()
        }

        mainViewModel.savedList.observe(this, Observer {
            binding.mainSavedRcy.adapter = SaveRcyAdapter(it)
            Log.e("savedData",it.toString())
        })

    }
}