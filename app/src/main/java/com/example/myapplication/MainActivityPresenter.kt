package com.example.myapplication

class MainActivityPresenter: MainActivityContract.Presenter {

    private val model: MainActivityContract.Model = Model()

    override fun loadResult() {
        TODO("Not yet implemented")
    }

    override fun rxUnsubscribe() {
        TODO("Not yet implemented")
    }

    override fun getDiceImageResource(result: Int): Int {
        return model.imageResource[result]!!
    }
}