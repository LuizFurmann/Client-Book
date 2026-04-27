package com.example.clientbook.view

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.MutableLiveData
import com.example.clientbook.R
import com.example.clientbook.databinding.ActivityMainBinding
import com.example.clientbook.network.RetrofitRepository
import com.example.clientbook.view.favorite.FavoriteFragment
import com.example.clientbook.view.home.HomeFragment
import com.example.clientbook.view.purchase.PurchaseActivity
import com.example.clientbook.view.purchase.PurchaseFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    private lateinit var binding : ActivityMainBinding
    var repository = RetrofitRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            view.setPadding(
                0,
                bars.top,     // status bar
                0,
                bars.bottom   // navigation bar
            )
            insets
        }

        // Topo - status bar
        window.statusBarColor = Color.parseColor("#FFFFFF")

        // Bottom - navigation bar
        window.navigationBarColor = ContextCompat.getColor(this, R.color.theme)

        // Ícones escuros no topo (hora/bateria)
        WindowCompat.getInsetsController(window, window.decorView)
            .isAppearanceLightStatusBars = true

        setTitle("")

        openFragment(HomeFragment())
        bottomNavigation()
        repository.getClient().value
    }


    private fun startClientActivity(){
        Intent(this@MainActivity, PurchaseActivity::class.java).also{
            startActivity(it)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item))
            return true

        return super.onOptionsItemSelected(item)
    }

    private fun bottomNavigation(){
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeId -> {
                    openFragment(HomeFragment())
                    setTitle("")
                    true
                }
                R.id.purchasesId -> {
                    openFragment(PurchaseFragment())
                    setTitle("Minhas compras")
                    true
                }
                R.id.favoritId -> {
                    openFragment(FavoriteFragment())
                    setTitle("Favoritos")
                    true
                }
                else -> false
            }
        }
    }

    private fun openFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(binding.container.id, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}