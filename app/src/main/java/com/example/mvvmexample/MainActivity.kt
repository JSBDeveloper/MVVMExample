package com.example.mvvmexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.example.mvvmexample.data.MainViewModel
import com.example.mvvmexample.databinding.ActivityMainBinding

class MainActivity : BaseView<ActivityMainBinding, MainViewModel>() {
    override val layoutResourceId: Int
        get() = R.layout.activity_main
    override val viewModel: MainViewModel
        get() = MainViewModel(DataModelImpl())

    override fun initStartView() {

    }

    override fun initDataBinding() {
        TODO("Not yet implemented")
    }

    override fun initAfterBinding() {
        TODO("Not yet implemented")
    }
}