package com.artushock.stopwatch.ui

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.artushock.stopwatch.viewmodel.MainViewModel
import com.artushock.stopwatch.R
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel: MainViewModel = getViewModel()

        val textView = findViewById<TextView>(R.id.text_time)
        viewModel.liveData.observe(this, {
            textView.text = it
        })

        findViewById<Button>(R.id.button_start).setOnClickListener {
            viewModel.start()
        }

        findViewById<Button>(R.id.button_pause).setOnClickListener {
            viewModel.pause()
        }

        findViewById<Button>(R.id.button_stop).setOnClickListener {
            viewModel.stop()
        }
    }
}