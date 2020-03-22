package com.example.internetcheck

/*
*Created by utkuglsvn
*/
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager

class InternetConnectivityReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        if (internetConnectivityReceiverListener != null) {
            internetConnectivityReceiverListener!!.onNetworkConnectionChanged(isConnectedOrConnecting(context!!))
        }

    }

    private fun isConnectedOrConnecting(context: Context): Boolean {
        val connMgr = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connMgr.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnectedOrConnecting
    }

    interface ConnectivityReceiverListener {
        fun onNetworkConnectionChanged(isConnected: Boolean)
    }

    companion object {
        var internetConnectivityReceiverListener: ConnectivityReceiverListener? = null
    }
}