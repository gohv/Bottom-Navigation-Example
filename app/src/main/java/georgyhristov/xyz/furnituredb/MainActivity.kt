package georgyhristov.xyz.furnituredb


import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.design.widget.BottomNavigationView

import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.view.MenuItem

import georgyhristov.xyz.furnituredb.fragment.AddFurnitureFragment
import georgyhristov.xyz.furnituredb.fragment.FurnitureFragment

class MainActivity : FragmentActivity() {


    private lateinit var fragment: Fragment
    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.content, FurnitureFragment()).commit()
        val navigation = findViewById<BottomNavigationView>(R.id.navigation)
        fragmentManager = supportFragmentManager

        navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home ->

                    fragment = FurnitureFragment()

                R.id.navigation_notifications -> fragment = AddFurnitureFragment()
            }
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.content, fragment).commit()
            false
        }


    }


}
