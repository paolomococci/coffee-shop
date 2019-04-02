/**
 *
 * Copyright 2019 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package local.example.coffeeshop

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import local.example.coffeeshop.R.id.action_settings
import local.example.coffeeshop.R.layout.activity_main

class MainActivity : AppCompatActivity() {

    private var messageText: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val floatingActionButton = findViewById<FloatingActionButton>(R.id.fab)
        floatingActionButton.setOnClickListener {
            val intent = Intent(
                this@MainActivity,
                ClickedActivity::class.java
            )
            intent.putExtra(MainActivity.EXTRA_MESSAGE, messageText)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(
            R.menu.menu_main,
            menu
        )
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun showDonutOnClick(view: View) {
        messageText = getString(R.string.donut_on_click_message)
        displayToast(messageText.toString())
    }

    fun showIceCreamOnClick(view: View) {
        messageText = getString(R.string.icecream_on_click_message)
        displayToast(messageText.toString())
    }

    fun showFroYoOnClick(view: View) {
        messageText = getString(R.string.froyo_on_click_message)
        displayToast(messageText.toString())
    }

    private fun displayToast(message: String) {
        Toast.makeText(
            applicationContext,
            message,
            Toast.LENGTH_SHORT
        ).show()
    }

    companion object {
        const val EXTRA_MESSAGE = "local.example.coffeeshop.extra.MESSAGE"
    }
}
