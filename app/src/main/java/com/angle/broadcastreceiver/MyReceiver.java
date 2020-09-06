package com.angle.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    public static final String BRAODCAST_MEESAGE = MyReceiver.class.getName();

    @Override
    public void onReceive(Context context, Intent intent) {
//        接受从MainActivity得到的消息
        String receiveMessage = intent.getStringExtra(MainActivity.ACTIVITY_MAIN_SENDBORADCASE_MESSAGE);
        Toast.makeText(context, receiveMessage, Toast.LENGTH_SHORT).show();

//        发送的其他的activity
        Intent intent1 = new Intent(context, OtherActivity.class);
//        传值必须设置该变量
        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent1.putExtra(BRAODCAST_MEESAGE, "message for broadcast");
        context.startActivity(intent1);


    }
}
