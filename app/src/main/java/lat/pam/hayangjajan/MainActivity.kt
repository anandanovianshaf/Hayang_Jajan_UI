package lat.pam.hayangjajan

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var bottomNavView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // 1. Temukan komponen
        bottomNavView = findViewById(R.id.bottom_nav_view)

        // 2. Temukan NavController
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // 3. Hubungkan BottomNavigationView dengan NavController
        NavigationUI.setupWithNavController(bottomNavView, navController)

        // 4. Logika untuk Sembunyikan/Tampilkan Menu
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                // Tampilkan menu di 3 layar ini
                R.id.homeFragment,
                R.id.cartFragment,
                R.id.profileFragment -> {
                    bottomNavView.visibility = View.VISIBLE
                }

                // Sembunyikan di layar lainnya
                else -> {
                    bottomNavView.visibility = View.GONE
                }
            }
        }

        // 5. Setup Edge-to-Edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_container)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}