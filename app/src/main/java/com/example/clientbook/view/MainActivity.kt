package com.example.clientbook.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
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
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    private lateinit var binding : ActivityMainBinding
    var repository = RetrofitRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setTitle("")

        setupDrawer()
        openFragment(HomeFragment())
        bottomNavigation()
        repository.getClient().value
    }

    private fun setupDrawer(){
        val draweLayout : DrawerLayout = binding.drawerLayout
        val navView : NavigationView = binding.navView

        toggle = ActionBarDrawerToggle(this,draweLayout, R.string.open, R.string.close)
        draweLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            when(it.itemId){
                R.id.nav_client -> startClientActivity()
                R.id.nav_auto_training -> Toast.makeText(this, "teste", Toast.LENGTH_SHORT).show()
            }
            true
        }
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
        binding.appHomeMain.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeId -> {
                    openFragment(HomeFragment())
                    true
                }
                R.id.purchasesId -> {
                    openFragment(PurchaseFragment())
                    true
                }
                R.id.favoritId -> {
                    openFragment(FavoriteFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun openFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(binding.appHomeMain.container.id, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}