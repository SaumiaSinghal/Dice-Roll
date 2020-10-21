package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainActivityContract.View {

    private val presenter: MainActivityContract.Presenter = MainActivityPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dice_button.setOnClickListener {presenter.loadResult()}
    }

    override fun onSuccess(result: Int) {
        dice_button.setImageResource(presenter.getDiceImageResource(result))
    }

    override fun onError(errorMessage: String) {
        toast(errorMessage)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.rxUnsubscribe()
    }

    fun Context.toast(message: CharSequence) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}