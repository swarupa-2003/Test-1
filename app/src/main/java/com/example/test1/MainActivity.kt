package com.example.test1

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ecowaste.ScheduleCollectionFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate called")

        val scheduleButton: Button = findViewById(R.id.btnSchedule)
        val guidelinesButton: Button = findViewById(R.id.btnGuidelines)
        val previousButton: Button = findViewById(R.id.btnPrevious)

        scheduleButton.setOnClickListener({ v ->
            supportFragmentManager
                .beginTransaction()
                .replace(
                    R.id.fragmentContainer,
                    ScheduleCollectionFragment()
                )
                .addToBackStack(null)
                .commit()
        })

        guidelinesButton.setOnClickListener({ v ->
            Toast.makeText(
                this@MainActivity,
                "Separate organic, recyclable, electronic and general waste.",
                Toast.LENGTH_LONG
            ).show()
        })

        previousButton.setOnClickListener({ v ->
            Toast.makeText(
                this@MainActivity,
                "No previous collection requests found.",
                Toast.LENGTH_SHORT
            ).show()
        })
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy called")
    }

    companion object {
        private val TAG = "EcoWaste"
    }
}