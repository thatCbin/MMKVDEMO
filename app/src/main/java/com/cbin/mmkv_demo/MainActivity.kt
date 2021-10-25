package com.cbin.mmkv_demo

import android.content.Context
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.cbin.mmkv_demo.databinding.ActivityMainBinding
import com.cbin.mmkv_demo.databinding.ContentMainBinding
import com.tencent.mmkv.MMKV


class MainActivity : AppCompatActivity() {

    private val mmkv: MMKV by lazy { MMKV.defaultMMKV() }
    private var boolean by mmkv.boolean(key = "boolean", defaultValue = false)
    private var int by mmkv.int(key = "int", defaultValue = 0)
    private var long by mmkv.long(key = "long", defaultValue = 0L)
    private var float by mmkv.float(key = "float", defaultValue = .0F)
    private var double by mmkv.double(key = "double", 0.0)
    private var byteArray by mmkv.byteArray(key = "byteArray")
    private var string by mmkv.string(key = "string")
    private var stringSet by mmkv.stringSet(key = "stringSet")
    private var parcelable by mmkv.parcelable<User>("parcelable")

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding


    fun 使用MMKV() {
        boolean = true
        int = 10
        long = 10L
        float = .1F
        double = .5
        byteArray = ByteArray(10).apply {
            for (i in 1..9) {
                set(i, i.toByte())
            }
        }
        string = "String"
        stringSet = HashSet<String>().apply {
            for (i in 1..9) {
                add("第$i 个")
            }
        }
        parcelable = User("name", 10, false)
        val TAG = "MMKV_TEST"

        /**
         * 2
         */
        Log.i(TAG, "boolean:${mmkv.getBoolean("boolean", false)}")
        Log.i(TAG, "int:${mmkv.getInt("int", 0)}")
        Log.i(TAG, "long:$long")
        Log.i(TAG, "float:$float")
        Log.i(TAG, "double:$double")
        Log.i(TAG, "byteArray:$byteArray")
        Log.i(TAG, "string:$string")
        Log.i(TAG, "stringSet:$stringSet")
        Log.i(TAG, "parcelable:$parcelable")
        Log.i(TAG, "----------------")

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        使用MMKV()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}

