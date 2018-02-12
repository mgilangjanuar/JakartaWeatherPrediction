package com.mgilangjanuar.dev.weatherprediction.base

import android.graphics.Color
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import android.widget.Toast

/**
 * Created by mgilangjanuar (mgilangjanuar@gmail.com)
 * @since 2018
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(findLayout())
    }

    abstract fun findLayout() : Int

    fun setupRecyclerView(recyclerView: RecyclerView, divider: Boolean) {
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.itemAnimator = DefaultItemAnimator()
        if (divider) {
            recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        }
    }

    fun showSnackbar(@StringRes text: Int) {
        showSnackbar(getString(text))
    }

    fun showSnackbar(message: String) {
        val view = findViewById<View>(android.R.id.content)
        val snack = Snackbar.make(view, message, Snackbar.LENGTH_LONG)
        val textView = snack.view.findViewById<TextView>(android.support.design.R.id.snackbar_text)
        textView.setTextColor(Color.WHITE)
        snack.show()
    }

    fun showToast(@StringRes text: Int) {
        showToast(getString(text))
    }

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}