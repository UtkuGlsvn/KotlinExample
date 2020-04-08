package com.example.fragmentexample

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fragmentexample.fragment.FragmentOne
import com.example.fragmentexample.fragment.FragmentTwo

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View) {
        when (view.getId())
        {
            R.id.btnfragment1 -> changeFragment(FragmentOne())
            R.id.btnfragment2 ->changeFragment(FragmentTwo())
        }
    }

    fun changeFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentGroup, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

//    override fun onBackPressed() {
//        finish()
//        super.onBackPressed()
//    }
}
