package friendlychat.udacity.firebase.google.com.fromtheday

import android.app.DatePickerDialog
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit
import android.icu.util.TimeZone
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        ds.setOnClickListener {
//            var picker: DatePickerDialog? = null
//            ds!!.inputType = InputType.TYPE_NULL
//            val cldr = Calendar.getInstance()
//            TimeZone.getTimeZone("Asia/Calcutta")
//            cldr.timeZone = TimeZone.getTimeZone("Asia/Calcutta")
//            val day = cldr.get(Calendar.DAY_OF_MONTH)
//            val month = cldr.get(Calendar.MONTH)
//            val year = cldr.get(Calendar.YEAR)
//            picker = DatePickerDialog(
//                this@MainActivity,
//                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
//                    ds!!.text = dayOfMonth.toString() + "/" + (monthOfYear + 1) + "/" + year
//                },
//                year,
//                month,
//                day
//            )
//            var pick = picker!!.show().toString()
//            ds.text = pick


        //}
//        calc.setOnClickListener {
            val givenDateString = "19/11/2000"


            val sdf = SimpleDateFormat("dd/MM/yyyy")
            val mDate = sdf.parse(givenDateString)
            var timeInMilliseconds = mDate.time
            var a = timeInMilliseconds

            val formatter = SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS")

            val now = System.currentTimeMillis()


            var b = now

            val calendar = Calendar.getInstance()
            calendar.timeInMillis = now
            var millis = b - a

            var r = (now.toString() + " = " + formatter.format(calendar.time))


            var res = ("Date in milli  $timeInMilliseconds")
            val t = object : Thread() {
                override fun run() {

                    while (!isInterrupted) {
                        Thread.sleep(1000)
                        runOnUiThread {
                            val date = System.currentTimeMillis() - timeInMilliseconds
                            Log.v("roki", date.toString())
                            val sdf = SimpleDateFormat("HH:mm:ss")
                            val dateString = sdf.format(System.currentTimeMillis() - timeInMilliseconds-19800000)
                            tv.text = " ${TimeUnit.DAYS.convert((b - a), TimeUnit.MILLISECONDS)} DAYS\n $dateString HOURS"

                        }

                    }
                }
            }
            t.start()

//                val formatter = SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS")
//
//                val now = System.currentTimeMillis()
//
//
//                var b = now
//
//                val calendar = Calendar.getInstance()
//                calendar.timeInMillis = now
//                var millis = b - a
//
//                var r = (now.toString() + " = " + formatter.format(calendar.time))

//                tv.text = " ${TimeUnit.DAYS.convert((b - a), TimeUnit.MILLISECONDS)} DAYS $dateString)"
//            System.out.println ("Days: " + TimeUnit.DAYS.convert((b-a), TimeUnit.MILLISECONDS));

        }
    }



//
//        time.setOnClickListener {
//            val t = object : Thread() {
//                override fun run() {
//                    try {
//                        while (!isInterrupted) {
//                            Thread.sleep(1000)
//                            runOnUiThread {
//                                val date = System.currentTimeMillis()
//                                val sdf = SimpleDateFormat("hh-mm-ss a")
//                                val dateString = sdf.format(date)
//                                tv.text = dateString
//                            }
//                        }
//                    } catch (e: InterruptedException) {
//                    }
//
//                }
//            }
//            t.start()
//        }
//    }


//object : CountDownTimer(millis, 1000) { // adjust the milli seconds here
//
//                override fun onTick(millisUntilFinished: Long) {
//
//                    tv.text = ("" + String.format(
//                        "%02d:%02d:%02d",
//                        TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
//                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) + TimeUnit.HOURS.toMinutes(
//                            TimeUnit.MILLISECONDS.toHours(millisUntilFinished)
//                        ),
//                        (TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) + TimeUnit.MINUTES.toSeconds(
//                            TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)
//                        ))
//                    ))
//                }
//
//                override fun onFinish() {
//                    tv.text = "done!"
//                }
//            }.start()
/*    time.setOnClickListener {
        val cldr = Calendar.getInstance()
        val timePicker = TimePickerDialog(
            this, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                tv.text = "$hourOfDay : $minute "
            },


            cldr.get(Calendar.HOUR_OF_DAY), cldr.get(Calendar.MINUTE), false
        )
        timePicker.show()
    }*/
//        time.setOnClickListener {
//            val textView = TextView(this)
//            val timePicker = TimePicker(this)
//            textView.text = "Hour: "+timePicker.hour+ " Minute: "+ timePicker.minute
//            timePicker.setOnTimeChangedListener { timePicker, hour, minute ->
//                textView.text = "Hour: $hour Minute : $minute"
//            }
//        }

/*    val hms = String.format(
        "%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
        TimeUnit.MILLISECONDS.toMinutes(millis) % TimeUnit.HOURS.toMinutes(1),
        TimeUnit.MILLISECONDS.toSeconds(millis) % TimeUnit.MINUTES.toSeconds(1)
    )
    println(hms)
    */

