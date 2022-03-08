package com.example.popupmanager

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.PopupWindow
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.popupmanager.databinding.PopupOneButtonBinding
import com.example.popupmanager.databinding.PopupThreeButtonBinding
import com.example.popupmanager.databinding.PopupTwoButtonBinding


class PopupManager : ConstraintLayout {
    private lateinit var popupOneButtonBinding: PopupOneButtonBinding
    private lateinit var popupTwoButtonBinding: PopupTwoButtonBinding
    private lateinit var popupThreeButtonBinding: PopupThreeButtonBinding

    private val enumHashMap: HashMap<Int, String> = HashMap()

    constructor(context: Context) : super(context) {
        initLayout()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initLayout()
    }

    constructor(context: Context, attrs: AttributeSet, defStylrAttr: Int) : super(
        context,
        attrs,
        defStylrAttr
    ) {
        initLayout()
    }

    fun initLayout() {
        popupOneButtonBinding =
            PopupOneButtonBinding.inflate(LayoutInflater.from(context), this, true)
        popupTwoButtonBinding =
            PopupTwoButtonBinding.inflate(LayoutInflater.from(context), this, true)
        popupThreeButtonBinding =
            PopupThreeButtonBinding.inflate(LayoutInflater.from(context), this, true)
    }

    fun setPopup(response: Response, context: Context) {
        enumHashMap[1] = "ONE"
        enumHashMap[2] = "TWO"
        enumHashMap[3] = "THREE"


        val size = response.buttonList.size
        if (size == 1) {
            popupOneButtonBinding.textView.text = response.title
            popupTwoButtonBinding.content.text = response.content
            popupOneButtonBinding.firstButton.setOnClickListener {
                popupOneButtonBinding.firstButton.text = response.buttonList[0].name
                PopupEnumManager.valueOf(enumHashMap[response.buttonList[0].action]!!)
            }
            showPopupOneButton()

        } else if (size == 2) {
            popupTwoButtonBinding.title.text = response.title
            popupTwoButtonBinding.content.text = response.content
            popupTwoButtonBinding.firstButton.setOnClickListener {
                popupTwoButtonBinding.firstButton.text = response.buttonList[0].name
                PopupEnumManager.valueOf(enumHashMap[response.buttonList[0].action]!!)
            }
            popupTwoButtonBinding.secondButton.setOnClickListener {
                popupTwoButtonBinding.secondButton.text = response.buttonList[1].name
                PopupEnumManager.valueOf(enumHashMap[response.buttonList[1].action]!!)
            }
            showPopupTwoButton()

        } else if (size == 3) {
            popupThreeButtonBinding.textView.text = response.title
            popupThreeButtonBinding.firstButton.setOnClickListener {
                popupThreeButtonBinding.firstButton.text = response.buttonList[0].name
                PopupEnumManager.valueOf(enumHashMap[response.buttonList[0].action]!!)
            }
            popupThreeButtonBinding.secondButton.setOnClickListener {
                popupThreeButtonBinding.secondButton.text = response.buttonList[1].name
                PopupEnumManager.valueOf(enumHashMap[response.buttonList[1].action]!!)
            }
            popupThreeButtonBinding.thirdButton.setOnClickListener {
                popupThreeButtonBinding.thirdButton.text = response.buttonList[2].name
                PopupEnumManager.valueOf(enumHashMap[response.buttonList[2].action]!!)
            }
            showPopupThreeButton()
        }
    }

    fun showPopupOneButton() {
        removeAllViews()
        val popupWindow = PopupWindow(
            popupOneButtonBinding.root,
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )

        popupOneButtonBinding.popupOneButton.post {
            popupWindow.showAtLocation(
                popupOneButtonBinding.popupOneButton, Gravity.CENTER, 0, 0
            )
        }
    }

    fun showPopupTwoButton() {
        removeAllViews()
        val popupWindow = PopupWindow(
            popupTwoButtonBinding.root,
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        popupWindow.showAtLocation(popupTwoButtonBinding.popupTwoButton, Gravity.CENTER, 0, 0)
    }

    fun showPopupThreeButton() {
        removeAllViews()
        val popupWindow = PopupWindow(
            popupThreeButtonBinding.root,
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        popupWindow.showAtLocation(popupThreeButtonBinding.popupThreeButton, Gravity.CENTER, 0, 0)
    }
}