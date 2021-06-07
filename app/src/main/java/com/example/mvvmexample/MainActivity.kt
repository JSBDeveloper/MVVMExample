package com.example.mvvmexample

import com.example.mvvmexample.databinding.ActivityMainBinding
import com.example.mvvmexample.model.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseView<ActivityMainBinding, MainViewModel>() {
    override val layoutResourceId: Int
        get() = R.layout.activity_main
    override val viewModel: MainViewModel by viewModel()

    override fun initStartView() {

    }

    override fun initDataBinding() {
        TODO("Not yet implemented")
    }

    override fun initAfterBinding() {
        TODO("Not yet implemented")
    }
}