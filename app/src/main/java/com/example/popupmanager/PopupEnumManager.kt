package com.example.popupmanager

import android.util.Log

enum class PopupEnumManager {
    ONE {
        override fun buttonAct() {
            Log.e("ONE Button", "11111111111111")
        }

    },
    TWO {
        override fun buttonAct() {
            Log.e("TWO Button", "2222222222222222")
        }

    },
    THREE {
        override fun buttonAct() {
            Log.e("THREE Button", "333333333333333")
        }
    };

    abstract fun buttonAct()

}

enum class ButtonNumEnum(val num: Int) {
    ONE(1),
    TWO(2),
    THREE(3)
}