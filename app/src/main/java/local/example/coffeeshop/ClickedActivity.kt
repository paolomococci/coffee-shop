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

import android.R.layout.simple_spinner_item
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.ArrayAdapter.createFromResource
import androidx.appcompat.app.AppCompatActivity
import local.example.coffeeshop.R.array.phone_labels_array
import local.example.coffeeshop.R.id.*
import local.example.coffeeshop.R.layout.activity_clicked

class ClickedActivity :
    AppCompatActivity(),
    AdapterView.OnItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_clicked)
        val intent = this.intent
        val message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)
        val textView = findViewById<TextView>(activity_clicked_text_view)
        textView.text = message
        val spinner = findViewById<Spinner>(label_spinner)
        if (spinner != null) {
            spinner.onItemSelectedListener = this
        }
        val adapter = createFromResource(
            this,
            phone_labels_array,
            simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        if (spinner != null) {
            spinner.adapter = adapter
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        // TODO
    }

    override fun onItemSelected(
        parent: AdapterView<*>?,
        view: View?,
        position: Int,
        id: Long
    ) {
        val spinnerLabel = parent?.getItemAtPosition(position).toString()
        displayToast(spinnerLabel)
    }

    fun onRadioButtonClicked(view: View) {
        val checked = (view as RadioButton).isChecked
        when (view.getId()) {
            same_day -> if (checked)
                displayToast(
                    getString(
                        R.string.same_day_messenger_service
                    )
                )
            next_day -> if (checked)
                displayToast(
                    getString(
                        R.string.next_day_messenger_service
                    )
                )
            pick_up -> if (checked)
                displayToast(
                    getString(
                        R.string.pick_up_messenger_service
                    )
                )
            else -> {
            }
        }
    }

    private fun displayToast(spinnerLabel: String) {
        Toast.makeText(
            applicationContext,
            spinnerLabel,
            Toast.LENGTH_SHORT
        ).show()
    }
}
