package com.example.mvvmexample

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.mvvmexample.viewmodel.BaseViewModel

abstract class BaseActivity<T: ViewDataBinding, R : BaseViewModel>: AppCompatActivity() {
    private val TAG = "BaseActivity"

    lateinit var viewDataBinding: T

    abstract val layoutResourceId : Int

    abstract val viewModel: R

    abstract fun initStartView()

    abstract fun initDataBinding()

    abstract fun initAfterBinding()

    private var isSetBackButtonValid = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewDataBinding = DataBindingUtil.setContentView(this, layoutResourceId)

        initStartView()
        initDataBinding()
        initAfterBinding()

    }
}