package com.example.sanitiz10

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.view.Menu
import android.view.MenuItem
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.response
import java.io.IOException
import java.util.HashMap

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    internal var LoginURL = ""
    private var username: EditText? = null
    private var password: EditText? = null
    private var loginbtn: Button? = null
    private var textregister: TextView? = null
    private val LoginTask = 1
    private var preferenceHelper: PreferenceHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setSupportActionBar(toolbar)

        preferenceHelper = PreferenceHelper(this)

        username = findViewById<View>(R.id.username) as EditText
        password = findViewById<View>(R.id.password) as EditText

        loginbtn = findViewById(R.id.loginbtn) as Button
        textregister = findViewById(R.id.textregister) as TextView

        textregister!!.setOnClickListener {
            print("register!")
        }

        loginbtn!!.setOnClickListener {
            try {
                login()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }


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

    @Throws(IOException::class)
    private fun login() {
        try {
            Fuel.post(LoginURL, listOf(
                "username" to username!!.text.toString(),
                "password" to password!!.text.toString()
            )).response { req, res, result ->
                Log.d("login", result.get().toString())
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {

        }
    }
}
