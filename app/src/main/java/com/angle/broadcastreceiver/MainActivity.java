package com.angle.broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.angle.broadcastreceiver.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    public static final String ACTIVITY_MAIN_SENDBORADCASE_MESSAGE = "com.angle.broadcastreceiver.MainActivity";

    private ActivityMainBinding binding;
    private Intent intent;

    private Button button;
    private MyReceiver myReceiver;
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();

    }

    private void initView() {

        binding.activityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageBroadcast();
            }
        });
    }

    private void sendMessageBroadcast() {
//        创建连接
        intent = new Intent(this, MyReceiver.class).setAction(MyReceiver.class.getName());
//        发送消息也可以利用bundle传值
        intent.putExtra(ACTIVITY_MAIN_SENDBORADCASE_MESSAGE, "messge for activity");
//        普通广播
        sendBroadcast(intent);
//        本地广播
//        localBroadcastManager.sendBroadcast(intent);

    }

    @Override
    protected void onResume() {
        super.onResume();
        //   创建本地广播管理器（需要手动导入 LocalBroadcastManager包）
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
//       得到广播的对象
        myReceiver = new MyReceiver();
//        得到广播处理器的对象
        IntentFilter intentFilter = new IntentFilter(MyReceiver.class.getName());
//        注册广播
        registerReceiver(myReceiver, intentFilter);
        //      本地  注册广播
//        localBroadcastManager.registerReceiver(myReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        解注册广播
        unregisterReceiver(myReceiver);
//        本地解注册广播
//        localBroadcastManager.unregisterReceiver(myReceiver);
    }

}
