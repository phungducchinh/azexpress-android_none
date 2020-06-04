package com.azer.azexpressandroid.view

import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.MergeAdapter
import com.azer.azexpressandroid.R
import com.azer.azexpressandroid.adapter.MessagePagedAdapter
import com.azer.azexpressandroid.base.BaseActivity
import com.azer.azexpressandroid.base.LoadStateAdapter
import com.azer.azexpressandroid.databinding.ActivityMainBinding
import com.azer.azexpressandroid.viewmodel.AuthViewModel
import com.azer.core.CoreApplication
import com.azer.core.param.LoginParam
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.azer.core.model.Result

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val authViewModel: AuthViewModel by viewModel()

    private var adapter: MessagePagedAdapter? = null
    private var loadStateAdapter: LoadStateAdapter? = null
    private var mergeAdapter: MergeAdapter? = null


    override val layoutId: Int
        get() = R.layout.activity_main

    override fun bindView() {
        adapter = MessagePagedAdapter()
        loadStateAdapter = LoadStateAdapter()
        mergeAdapter = MergeAdapter(adapter, loadStateAdapter)

//        viewBinding.rvMessage.layoutManager =
//            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val gridLayoutManager = GridLayoutManager(this, 2)
        viewBinding.rvMessage.layoutManager = gridLayoutManager
        viewBinding.rvMessage.adapter = mergeAdapter
        gridLayoutManager.spanSizeLookup = object :
            GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when {
                    loadStateAdapter?.loadState is Result.Error -> return gridLayoutManager.spanCount

                    ((gridLayoutManager.itemCount - 1 == position) && loadStateAdapter?.loadState is Result.LoadingMore) -> {
                        return gridLayoutManager.spanCount
                    }
                    else -> 1
                }
            }
        }

        authViewModel.login(
            LoginParam(
                "jason@vinova.sg",
                "123123",
                "dGKlJJU1lCc:APA91bGZTz25rKtcb5WobysyPQSUp0Bfp4w1hblFjgWQeGdCEZwgFmRTCTQX9vhDk2WazWcvwpOHn8MV4NyTjrgE5vFEraxP5GbAMOnqYmo6FyVGy924yS98pEYSJXBJZ_5g_56nIFuC"
            )
        )
    }

    override fun bindViewModel() {
        authViewModel.loginLiveData.observe(this, Observer {
            CoreApplication.instance.saveUser(it)
            viewBinding.data = it
            Toast.makeText(this, it.email, Toast.LENGTH_SHORT).show()
            authViewModel.messagePaging()
        })

        authViewModel.loadStateLiveData.observe(this, Observer {
            loadStateAdapter?.loadState = it
        })

        authViewModel.messagesLiveData.observe(this, Observer {
            adapter?.submitList(it)
        })
    }
}
