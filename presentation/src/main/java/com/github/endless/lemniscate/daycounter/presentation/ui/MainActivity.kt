package com.github.endless.lemniscate.daycounter.presentation.ui

import android.appwidget.AppWidgetManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.github.endless.lemniscate.daycounter.R
import com.github.endless.lemniscate.daycounter.databinding.ActivityMainBinding
import com.github.endless.lemniscate.daycounter.presentation.ui.list.WidgetsListFragmentDirections

class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        NavigationUI.setupWithNavController(binding.bottomNavigation, navHostFragment.navController)

        // Get widget id
        val widgetId = intent?.extras?.getInt(
            AppWidgetManager.EXTRA_APPWIDGET_ID,
            AppWidgetManager.INVALID_APPWIDGET_ID
        ) ?: AppWidgetManager.INVALID_APPWIDGET_ID

        // If id is present -> open configuration fragment
        if(widgetId != AppWidgetManager.INVALID_APPWIDGET_ID) {
            val destination = WidgetsListFragmentDirections
                .actionWidgetsListFragmentToWidgetConfigureFragment(widgetId)
            navHostFragment.navController.navigate(destination)
            binding.bottomNavigation.visibility = View.GONE
        }
    }

}