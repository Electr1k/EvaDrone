package ru.trifonov.evadrone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.trifonov.evadrone.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mNavController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mNavController = findNavController(R.id.nav_host_fragment_activity_bottom_navigation)
        val navView: BottomNavigationView = mBinding.bottomNavigationView

        navView.setupWithNavController(mNavController)
        mNavController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.splash_screen){
                findViewById<CardView>(R.id.cardNav).visibility = View.INVISIBLE
            }
            else{
                findViewById<CardView>(R.id.cardNav).visibility = View.VISIBLE
                findViewById<CardView>(R.id.cardNav).translationY = 0f
            }
        }

    }
}