package com.example.ecowaste

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.test1.MainActivity
import com.example.test1.R

class CollectionConfirmationActivity : AppCompatActivity() {

    companion object {
        private const val CHANNEL_ID = "EcoWasteChannel"
        private const val NOTIFICATION_PERMISSION_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_collection_confirmation
        )

        val txtName = findViewById<TextView>(R.id.txtName)
        val txtAddress = findViewById<TextView>(R.id.txtAddress)
        val txtWaste = findViewById<TextView>(R.id.txtWaste)
        val txtPriority = findViewById<TextView>(R.id.txtPriority)
        val txtDoorstep = findViewById<TextView>(R.id.txtDoorstep)
        val btnDashboard = findViewById<Button>(R.id.btnDashboard)

        val name = intent.getStringExtra("name")
        val address = intent.getStringExtra("address")
        val wasteType = intent.getStringExtra("wasteType")
        val priority = intent.getStringExtra("priority")

        val doorstep =
            intent.getBooleanExtra("doorstep", false)

        txtName.text = "Resident Name: $name"
        txtAddress.text = "Address: $address"
        txtWaste.text = "Waste Type: $wasteType"
        txtPriority.text = "Priority: $priority"

        txtDoorstep.text =
            if (doorstep) {
                "Doorstep Pickup: ON"
            } else {
                "Doorstep Pickup: OFF"
            }

        createNotificationChannel()
        showNotification()

        btnDashboard.setOnClickListener {

            val dashboardIntent = Intent(
                this@CollectionConfirmationActivity,
                MainActivity::class.java
            )

            dashboardIntent.flags =
                Intent.FLAG_ACTIVITY_CLEAR_TOP

            startActivity(dashboardIntent)
            finish()
        }
    }

    private fun createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val channel = NotificationChannel(
                CHANNEL_ID,
                "EcoWaste Notifications",
                NotificationManager.IMPORTANCE_DEFAULT
            )

            channel.description =
                "Notifications for waste collection"

            val manager =
                getSystemService(NotificationManager::class.java)

            manager.createNotificationChannel(channel)
        }
    }

    private fun showNotification() {

        val builder = NotificationCompat.Builder(
            this,
            CHANNEL_ID
        )
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle("EcoWaste")
            .setContentText(
                "Waste collection scheduled successfully."
            )
            .setPriority(
                NotificationCompat.PRIORITY_DEFAULT
            )
            .setAutoCancel(true)

        if (
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
            ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {

            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.POST_NOTIFICATIONS
                ),
                NOTIFICATION_PERMISSION_CODE
            )

            return
        }

        NotificationManagerCompat
            .from(this)
            .notify(1, builder.build())
    }
}