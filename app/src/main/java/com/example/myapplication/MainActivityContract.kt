package com.example.myapplication

import io.reactivex.rxjava3.core.Observable

interface MainActivityContract {

    interface View {
        fun onSuccess(result: Int)
        fun onError(errorMessage: String)
    }

    interface Presenter {
        fun loadResult()
        fun rxUnsubscribe()
        fun getDiceImageResource(result: Int) : Int
    }

    interface Model {
        val imageResource: HashMap <Int, Int>

        fun getResult() : Observable<Int>
    }
}