package com.example.internetcheck

/*
*Created by utkuglsvn
*/
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT:Long=2000 // 1000 = 1 sec
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        if (internetCheck())
        {
            Handler().postDelayed({
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            }, SPLASH_TIME_OUT)
        }
        else
        {
            alertDialog()
        }

    }

    fun internetCheck():Boolean
    {
        val cm = getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
        return  isConnected
    }
    fun alertDialog()
    {
        val alert = AlertDialog.Builder(this)
        alert.setTitle("Warning")
        alert.setMessage("Check Internet Control?")
        alert.setCancelable(true);
        alert.setPositiveButton("Try Again") { dialogInterface: DialogInterface, i: Int ->
            this.recreate()
        }

        alert.setNegativeButton("Close App") {dialogInterface: DialogInterface, i: Int ->
            this.finish()
        }
        alert.show()
    }
}
