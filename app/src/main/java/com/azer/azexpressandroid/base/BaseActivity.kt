package com.azer.azexpressandroid.base

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.Toolbar
import androidx.core.content.res.ResourcesCompat.getColor
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import com.azer.azexpressandroid.R
import com.azer.azexpressandroid.ext.addToolbar
import com.azer.azexpressandroid.ext.hideSoftKeyboard
import com.azer.azexpressandroid.ext.removeToolbar
import com.azer.azexpressandroid.ext.setAutoHideKeyboard
import com.azer.azexpressandroid.utils.AppEvent
import com.azer.azexpressandroid.utils.PopupDialog
import com.azer.azexpressandroid.utils.PopupEventListener
import com.azer.core.model.PopUp
import com.jaeger.library.StatusBarUtil
import java.util.concurrent.CopyOnWriteArraySet

abstract class BaseActivity<ViewBinding : ViewDataBinding> : AppCompatActivity(),
    PopupEventListener {
    lateinit var viewBinding: ViewBinding

    @get:LayoutRes
    abstract val layoutId: Int

//    @get:LayoutRes
//    open val toolbarLayoutId: Int = -1

    private var listOfPopupDialogFragment: Set<DialogFragment> =
        CopyOnWriteArraySet<DialogFragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppEvent.addPopupEventListener(this)
        StatusBarUtil.setColor(this, Color.parseColor("#F47320"))
        viewBinding = DataBindingUtil.setContentView(this, layoutId)
        viewBinding.lifecycleOwner = this
        viewBinding.root.setAutoHideKeyboard(this)
        bindView()
        bindViewModel()
    }

    //    private fun setupToolbar() {
//        if (toolbarLayoutId == -1) return
//        addToolbar(
//            toolbarLayoutId = toolbarLayoutId,
//            viewGroup = viewBinding.root as? ViewGroup,
//            toolbarCallBack = { curActivity, toolbar ->
//                toolbarFunc(curActivity, toolbar)
//            })
//    }
//
//    fun removeToolbar() {
//        removeToolbar(viewBinding.root as? ViewGroup)
//    }
//
//    open fun toolbarFunc(curActivity: Activity?, toolbar: Toolbar?) {}
    open fun bindView() {}
    open fun bindViewModel() {}

    override fun onShowPopup(popup: PopUp?) {
        hideSoftKeyboard()
        onClosePopup()
        val popupDialogFragment = PopupDialog.newInstance(popup ?: PopUp())

//        if (popup?.isBottomSheet == true)
//                BottomPopupDialog.newInstance(popup)
//            else
//                PopupDialog.newInstance(popup ?: PopUp())

        popupDialogFragment.show(supportFragmentManager, PopupDialog().tag)
        listOfPopupDialogFragment = listOfPopupDialogFragment.plus(popupDialogFragment)
    }

    override fun onClosePopup() {
        for (item in listOfPopupDialogFragment) {
            item.dismissAllowingStateLoss()
            listOfPopupDialogFragment = listOfPopupDialogFragment.minus(item)
        }
    }

    override fun onDestroy() {
        AppEvent.unRegisterPopupEventListener(this)
        super.onDestroy()
    }
}