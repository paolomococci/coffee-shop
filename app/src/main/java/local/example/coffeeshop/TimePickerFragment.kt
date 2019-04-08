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

import android.app.Dialog
import android.os.Bundle
import android.text.format.DateFormat
import android.app.TimePickerDialog
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment

import java.util.Calendar

class TimePickerFragment : 
    DialogFragment(),
    TimePickerDialog.OnTimeSetListener {

    override fun onCreateDialog(bundle: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        return TimePickerDialog(
            activity,
            this,
            hour,
            minute,
            DateFormat.is24HourFormat(activity)
        )
    }

    override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int) {
        val clickedActivity = activity as ClickedActivity?
        clickedActivity!!.processTimePickerResult(
            hourOfDay,
            minute
        )
    }
}
