package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainActivityContract.View {
    private val DICE_FACE: String = "DICE_FACE"

    private val presenter: MainActivityContract.Presenter = MainActivityPresenter(this)
    private var diceFace: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState?.getInt(DICE_FACE) != null) {
            diceFace = savedInstanceState.getInt(DICE_FACE, 1)
        }

        dice_button.setImageResource(presenter.getDiceImageResource(diceFace))
        dice_button.setOnClickListener {presenter.loadResult()}
    }

    override fun onSuccess(result: Int) {
        diceFace = result
        dice_button.setImageResource(presenter.getDiceImageResource(diceFace))
    }

    override fun onError(errorMessage: String) {
        toast(errorMessage)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(DICE_FACE, diceFace)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.rxUnsubscribe()
    }

    private fun Context.toast(message: CharSequence) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}