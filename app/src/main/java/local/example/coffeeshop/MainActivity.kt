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
import local.example.coffeeshop.R.id
import local.example.coffeeshop.R.layout.activity_main
import local.example.coffeeshop.R.string
import local.example.coffeeshop.R.string.action_contact

class MainActivity : AppCompatActivity() {

    private var messageText: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        val toolbar = findViewById<Toolbar>(id.toolbar)
        setSupportActionBar(toolbar)
        val floatingActionButton = findViewById<FloatingActionButton>(id.fab)
        floatingActionButton.setOnClickListener {
            val intent = Intent(
                this@MainActivity,
                ClickedActivity::class.java
            )
            intent.putExtra(
                EXTRA_MESSAGE,
                messageText
            )
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
        return optionsItemSelected(item)
    }

    fun showDonutOnClick(view: View) {
        messageText = getString(string.donut_on_click_message)
        displayToast(messageText.toString())
    }

    fun showIceCreamOnClick(view: View) {
        messageText = getString(string.icecream_on_click_message)
        displayToast(messageText.toString())
    }

    fun showFroYoOnClick(view: View) {
        messageText = getString(string.froyo_on_click_message)
        displayToast(messageText.toString())
    }

    private fun displayToast(message: String) {
        Toast.makeText(
            applicationContext,
            message,
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun sampleItemSelected(menuItem: MenuItem): Boolean {
        val id = menuItem.itemId
        return if (id == action_contact) {
            true
        } else super.onOptionsItemSelected(menuItem)
    }

    private fun optionsItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.action_clicked -> {
                val intent = Intent(
                    this@MainActivity,
                    ClickedActivity::class.java
                )
                intent.putExtra(EXTRA_MESSAGE, messageText)
                startActivity(intent)
                return true
            }
            R.id.action_status -> {
                displayToast(getString(R.string.status_message))
                return true
            }
            R.id.action_favorites -> {
                displayToast(getString(R.string.favorites_message))
                return true
            }
            R.id.action_contact -> {
                displayToast(getString(R.string.contact_message))
                return true
            }
        }
        return super.onOptionsItemSelected(menuItem)
    }

    companion object {
        const val EXTRA_MESSAGE = "local.example.coffeeshop.extra.MESSAGE"
    }
}
