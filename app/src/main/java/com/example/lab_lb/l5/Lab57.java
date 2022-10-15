package com.example.lab_lb.l5;

        import android.app.Activity;
        import android.app.NotificationChannel;
        import android.app.NotificationManager;
        import android.app.PendingIntent;
        import android.content.BroadcastReceiver;
        import android.content.Context;
        import android.content.Intent;
        import android.content.IntentFilter;
        import android.os.Bundle;
        import android.util.Log;

        import androidx.annotation.Nullable;
        import androidx.core.app.NotificationCompat;
        import androidx.core.app.NotificationManagerCompat;

        import com.example.lab_lb.R;

public class Lab57 extends Activity {
    public static final String INCREASE_ACTION = "com.example.lab_lb.inc";
    public static final String DECREASE_ACTION = "com.example.lab_lb.dec";

    private NotificationCompat.Builder builder;
    private Integer counter = 0;
    private BroadcastReceiver receiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab57);


        NotificationChannel channel = new NotificationChannel(
                "CHID",
                "name",
                NotificationManager.IMPORTANCE_DEFAULT);
        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(
                Context.NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(channel);


        Intent incIntent = new Intent(this, BCReceiver.class);
        incIntent.setAction(INCREASE_ACTION);
        PendingIntent pIncIntent = PendingIntent.getBroadcast(this, 0, incIntent, 0);


        Intent decIntent = new Intent(this, BCReceiver.class);
        decIntent.setAction(DECREASE_ACTION);
        PendingIntent pDecIntent = PendingIntent.getBroadcast(this, 0, decIntent, 0);

        builder = new NotificationCompat.Builder(this, "CHID")
                .setContentTitle("Счетчик")
                .setContentText("0")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setOnlyAlertOnce(true)
                .addAction(android.R.drawable.ic_input_add, "Увеличить", pIncIntent)
                .addAction(android.R.drawable.ic_delete, "Уменьшить", pDecIntent);
        builder.setChannelId("CHID");



        NotificationManagerCompat nMC = NotificationManagerCompat.from(Lab57.this);
        nMC.notify(13, builder.build());

        receiver = new BCReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals(Lab57.INCREASE_ACTION)) {
                    counter++;
                } else {
                    counter--;
                }
                builder.setContentText(Integer.toString(counter));
                NotificationManager notificationManager = (NotificationManager) context.getSystemService(
                        Context.NOTIFICATION_SERVICE);
                notificationManager.notify(13, builder.build());
            }
        };
        IntentFilter ifilt = new IntentFilter();
        ifilt.addAction(INCREASE_ACTION);
        ifilt.addAction(DECREASE_ACTION);
        registerReceiver(receiver, ifilt);

    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(receiver);
        super.onDestroy();
    }
}
