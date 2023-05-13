package com.example.yuhdolan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.yuhdolan.Fragment.DestinationFragment
import com.example.yuhdolan.Fragment.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val destinationFragment = DestinationFragment()

        val navbar = findViewById<BottomNavigationView>(R.id.navbar)

        makeCurrentFragment(homeFragment)

        navbar.setOnNavigationItemReselectedListener {
            when(it.itemId) {
                R.id.nav_home -> makeCurrentFragment(homeFragment)
                R.id.nav_destination -> makeCurrentFragment(destinationFragment)
            }
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.navbar_frame, fragment)
            commit()
        }
    }
}