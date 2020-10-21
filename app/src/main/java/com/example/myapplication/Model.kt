package com.example.myapplication

class Model : MainActivityContract.Model {

    override val imageResource : HashMap <Int, Int> = HashMap()

    init {
        imageResource[1] = R.drawable.dice1
        imageResource[2] = R.drawable.dice2
        imageResource[3] = R.drawable.dice3
        imageResource[4] = R.drawable.dice4
        imageResource[5] = R.drawable.dice5
        imageResource[6] = R.drawable.dice6
    }

    override fun getResult() {
        TODO("Not yet implemented")
    }
}