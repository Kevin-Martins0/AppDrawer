package com.example.appdrawer

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toolbar: MaterialToolbar
    private lateinit var titleText: TextView
    private lateinit var descriptionText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigationView)
        toolbar = findViewById(R.id.toolbar)
        titleText = findViewById(R.id.textTitulo)
        descriptionText = findViewById(R.id.textDescricao)

        applySystemBarInsets()
        configureNavigation()
        showSection(R.id.menu_inicio)
    }

    private fun applySystemBarInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(drawerLayout) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }
    }

    private fun configureNavigation() {
        toolbar.setNavigationOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        navigationView.setNavigationItemSelectedListener { item ->
            val recognizedItem = when (item.itemId) {
                R.id.menu_inicio, R.id.perfil, R.id.config -> true
                else -> false
            }

            if (recognizedItem) {
                showSection(item.itemId)
                drawerLayout.closeDrawer(GravityCompat.START)
            }

            recognizedItem
        }
    }

    private fun showSection(itemId: Int) {
        val section = when (itemId) {
            R.id.perfil -> Section(
                toolbarTitle = getString(R.string.perfil),
                heading = getString(R.string.perfil_titulo),
                description = getString(R.string.perfil_descricao)
            )

            R.id.config -> Section(
                toolbarTitle = getString(R.string.config),
                heading = getString(R.string.config_titulo),
                description = getString(R.string.config_descricao)
            )

            else -> Section(
                toolbarTitle = getString(R.string.inicio),
                heading = getString(R.string.inicio_titulo),
                description = getString(R.string.inicio_descricao)
            )
        }

        toolbar.title = section.toolbarTitle
        titleText.text = section.heading
        descriptionText.text = section.description
        navigationView.setCheckedItem(itemId)
    }

    private data class Section(
        val toolbarTitle: String,
        val heading: String,
        val description: String
    )
}
