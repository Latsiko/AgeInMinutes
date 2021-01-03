package com.example.ageinminutes

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*
import android.app.DatePickerDialog.OnDateSetListener as OnDateSetListener1

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnDatePicker.setOnClickListener{view->
            clickDatePicker(view)
        }

    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun clickDatePicker(view: View) {

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
                OnDateSetListener1 {
           view, selectedYear, selectedMonth, selectedDayOfMonth ->
    
           val theSelectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"
    
                    selectedDate.text = theSelectedDate
                    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                    val theDate = sdf.parse(theSelectedDate)

                    val selectedDateInMinutes = theDate!!.time / 60000
                    val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                    val currentDateToMinutes = currentDate!!.time / 60000
                    val differenceInMinutes = currentDateToMinutes - selectedDateInMinutes
                    THEselectedDateInMinutes.setText(differenceInMinutes.toString())
       }
            ,year
            ,month
            ,day).show()

    }
}


