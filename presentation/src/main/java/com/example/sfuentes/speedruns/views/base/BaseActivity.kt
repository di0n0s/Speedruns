package com.example.sfuentes.speedruns.views.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.sfuentes.speedruns.R
import com.example.sfuentes.speedruns.SpeedrunApplication
import com.example.sfuentes.speedruns.extensions.inTransaction
import com.example.sfuentes.speedruns.navigation.Navigator
import kotlinx.android.synthetic.main.activity_base.*
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {

    @Inject
    protected lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        setupActivityComponent()
        addFragment(savedInstanceState)
    }

    private fun addFragment(savedInstanceState: Bundle?) =
            savedInstanceState
                    ?: supportFragmentManager.inTransaction { add(fragmentContainer.id, fragment()) }

    override fun onBackPressed() {
        (supportFragmentManager.findFragmentById(
                fragmentContainer.id) as BaseFragment).onBackPressed()
        super.onBackPressed()
    }

    private fun setupActivityComponent() {
        SpeedrunApplication
                .applicationComponent
                .inject(this)
    }

    abstract fun fragment(): BaseFragment

    abstract fun setToolbarTitle()

}
