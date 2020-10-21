package com.example.myapplication

import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class MainActivityPresenter(val view: MainActivityContract.View): MainActivityContract.Presenter {

    private val model: MainActivityContract.Model = Model()
    private var disposable: Disposable? = null

    override fun loadResult() {
        model.getResult()
            .subscribe(object: Observer<Int> {
                override fun onSubscribe(d: Disposable?) {
                    disposable = d
                }

                override fun onNext(result: Int?) {
                    if (result != null) {
                        view.onSuccess(result)
                    }
                }

                override fun onError(error: Throwable?) {
                    view.onError(error.toString())
                }

                override fun onComplete() {
                }

            })
    }

    override fun rxUnsubscribe() {
        disposable?.dispose()
    }

    override fun getDiceImageResource(result: Int): Int {
        return model.imageResource[result]!!
    }
}