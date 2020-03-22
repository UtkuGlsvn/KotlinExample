package com.example.intentsexample

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



    override fun onClick(view: View) {
        when (view?.id) {
            R.id.btnCall -> {
                checkPermission()
            }
            R.id.btnSms ->
            {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + "1122334455"))
                startActivity(intent)

            }
            R.id.btnEmail ->
            {
                val intent = Intent(Intent.ACTION_SEND)
                intent.putExtra(Intent.EXTRA_EMAIL,"e-mail")
                intent.putExtra(Intent.EXTRA_SUBJECT,"subject")
                intent.putExtra(Intent.EXTRA_TEXT,"text")
                startActivity(Intent.createChooser(intent,"E-mail"))
            }
            R.id.btnUrl ->
            {
                val openURL = Intent(Intent.ACTION_VIEW)
                openURL.data = Uri.parse("https://www.google.com/")
                startActivity(openURL)
            }
            R.id.btnNewActivity ->
            {
                startActivity(Intent(this,AnotherActivity::class.java))
            }
            R.id.btnPassActivity ->
            {
                val editText= findViewById<EditText>(R.id.editText)
                val intent = Intent(this,AnotherActivity::class.java)
                intent.putExtra("text",editText.text.toString())
                startActivity(intent)
            }
        }
    }

    fun checkPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)
            != PackageManager.PERMISSION_GRANTED) {


            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CALL_PHONE)) {

            } else {
                ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.CALL_PHONE),
                    42)
            }
        } else {
            callPhone()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        if (requestCode == 42) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                callPhone()
            } else {
                Toast.makeText(this,"Please allow permission!",Toast.LENGTH_SHORT).show();
            }
            return
        }
    }

    fun callPhone(){
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "1122334455"))
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.CALL_PHONE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        startActivity(intent)
    }
}
