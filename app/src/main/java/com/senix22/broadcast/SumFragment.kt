package com.senix22.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment

import kotlinx.android.synthetic.main.fragment.*

class SumFragment : Fragment(R.layout.fragment) {
    private val TAG = "My_LOG"

    private lateinit var receiver: BroadcastReceiver
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        receiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                val data = intent.getIntExtra(EXTRAS_DATA, 5)
                Log.e(TAG, "Broadcast Started $data")
                textFrag.text = data.toString()
            }
        }
        activity?.registerReceiver(
            receiver,
            IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION).apply {
                addAction(BROADCAST_ACTION)
            })

    }
    override fun onPause() {
        super.onPause()
        activity?.unregisterReceiver(receiver)
    }
    companion object {
        fun newInstance() = SumFragment()
        val EXTRAS_DATA = "extras_data"
        val BROADCAST_ACTION = "ru.startandroid.develop.p0961servicebackbroadcast"
    }
}