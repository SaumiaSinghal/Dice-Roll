package com.example.myapplication

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import kotlin.random.Random

class Model : MainActivityContract.Model {

    override val imageResource: HashMap <Int, Int> = HashMap()

    init {
        imageResource[1] = R.drawable.dice1
        imageResource[2] = R.drawable.dice2
        imageResource[3] = R.drawable.dice3
        imageResource[4] = R.drawable.dice4
        imageResource[5] = R.drawable.dice5
        imageResource[6] = R.drawable.dice6
    }

    override fun getResult(): Observable<Int> {
        return Observable.timer(2, TimeUnit.SECONDS)
            .map { Random.nextInt(6) + 1 }
            .subscribeOn(Schedulers.io())
    }
}