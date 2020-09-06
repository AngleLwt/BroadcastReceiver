package com.angle.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.angle.broadcastreceiver.databinding.ActivityOtherBinding;

public class OtherActivity extends AppCompatActivity {

    private ActivityOtherBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOtherBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();


    }

    private void initView() {
//         接受值
        String recriveMessage = getIntent().getStringExtra(MyReceiver.BRAODCAST_MEESAGE);
        if (recriveMessage != null) {
            binding.tv.setText(recriveMessage);
        }
    }
}
