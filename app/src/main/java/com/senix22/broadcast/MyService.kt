package com.senix22.broadcast

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class SumService : Service() {
    private val TAG = "My_LOG"
    private fun sum(): Int {
        return 5 + 3
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.e(TAG, "Service Started ${sum()}")
        val intent = Intent(SumFragment.BROADCAST_ACTION)
        intent.putExtra(SumFragment.EXTRAS_DATA, sum());
        sendBroadcast(intent);
        return START_STICKY;
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}