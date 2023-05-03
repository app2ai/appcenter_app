package com.example.appforappcenter

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.hilt.work.HiltWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import javax.sql.ConnectionEventListener
import kotlin.random.Random

fun showNotification(appContext: Context) {
    val notificationManager = appContext.getSystemService(NotificationManager::class.java)

    val notifyIntent = Intent(appContext, MainActivity::class.java)

    val notifyPendingIntent = PendingIntent.getActivity(
        appContext, 0, notifyIntent, PendingIntent.FLAG_IMMUTABLE
    )

    val notification =
        NotificationCompat.Builder(appContext, Constants.NEW_ORDER_NOTIFICATION_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("New order received!")
            .setVibrate(longArrayOf(500, 500, 500))
            .setContentIntent(notifyPendingIntent)
            .setAutoCancel(true)
            .build()

    val notificationId = Random.nextInt()

    notificationManager.notify(
        notificationId,
        notification
    )
}

// @HiltWorker
// class NotifWorker @AssistedInject constructor(
//     @Assisted private val appContext: Context,
//     @Assisted private val workerParameters: WorkerParameters,
// ) : Worker(
//     appContext,
//     workerParameters
// ) {
//     override fun doWork(): Result {
//         val options = PusherOptions()
//         options.setCluster("us2")
//
//         val pusher = Pusher(Constants.PUSHER_API_KEY, options)
//
//         pusher.connect(object : ConnectionEventListener {
//             override fun onConnectionStateChange(change: ConnectionStateChange) {
//                 Log.i(
//                     "Pusher",
//                     "State changed from ${change.previousState} to ${change.currentState}"
//                 )
//             }
//
//             override fun onError(
//                 message: String,
//                 code: String,
//                 e: Exception
//             ) {
//                 Log.w(
//                     "Pusher",
//                     "There was a problem connecting! code ($code), message ($message), exception($e)"
//                 )
//             }
//         }, ConnectionState.ALL)
//
//         val channel = pusher.subscribe("orders")
//
//         channel.bind("new-order") { event ->
//             showNotification(appContext)
//             Log.i("Pusher", "Received event with data: ${event.data}")
//         }
//
//         return Result.success()
//     }
//
//
// }