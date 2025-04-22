package com.example.projectserwin

import android.content.ClipData.Item
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectserwin.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var binding: ActivityRecyclerViewBinding

    private var gridLayoutManager : GridLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imgList = listOf<ImgData>(

            ImgData(
                R.drawable.udang_selingkuh,getString(R.string.udang_selingkuh), getString(R.string.udang_selingkuh_desc)
            ),
            ImgData(
                R.drawable.ulat_sagu,getString(R.string.ulat_sagu), getString(R.string.ulat_sagu_desc)
            ),
            ImgData(
                R.drawable.sarang_semut,getString(R.string.sarang_semut), getString(R.string.sarang_semut_desc)
            ),
            ImgData(
                R.drawable.sagu_lempeng,getString(R.string.sagu_lempeng), getString(R.string.sagu_lempeng_desc)
            ),
            ImgData(
                R.drawable.keripik_keladi,getString(R.string.keripik_keladi), getString(R.string.keripik_keladi_desc)
            ),
            ImgData(
                R.drawable.sabeta,getString(R.string.sabeta), getString(R.string.sabeta_desc)
            ),
            ImgData(
                R.drawable.aunu_senebre,getString(R.string.aunu_senebre), getString(R.string.aunu_senebre_desc)
            ),
            ImgData(
                R.drawable.eurimo,getString(R.string.eurimoo), getString(R.string.eurimoo_desc)
            ),
        )

        val myRecyclerView = findViewById<RecyclerView>(R.id.myRV)

        gridLayoutManager = GridLayoutManager(applicationContext, 3, LinearLayoutManager.VERTICAL, false)

        myRecyclerView?.layoutManager = gridLayoutManager
        myRecyclerView?.setHasFixedSize(true)
        myRecyclerView.adapter = ImgAdapter(this, imgList) { selectedItem ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, selectedItem)  // kirim data ImgData
            startActivity(intent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_profile -> {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.action_settings -> {
                Toast.makeText(this, "Settings diklik", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}