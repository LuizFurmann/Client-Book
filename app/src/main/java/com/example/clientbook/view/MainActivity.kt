package com.example.clientbook.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.clientbook.R
import com.example.clientbook.databinding.ActivityMainBinding
import com.example.clientbook.network.RetrofitRepository
import com.example.clientbook.view.favorite.FavoriteFragment
import com.example.clientbook.view.home.HomeFragment
import com.example.clientbook.view.purchase.PurchaseFragment

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
                bars.top,
                0,
                bars.bottom
            )
            insets
        }

        window.statusBarColor = Color.parseColor("#FFFFFF")
        window.navigationBarColor = ContextCompat.getColor(this, R.color.theme)
        WindowCompat.getInsetsController(window, window.decorView)
            .isAppearanceLightStatusBars = true
        setTitle("")

        openFragment(HomeFragment())
        bottomNavigation()
        repository.getClient().value
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