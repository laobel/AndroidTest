package com.std.wlbdevelop.mediaplayer;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.anthonycr.grant.PermissionsManager;
import com.anthonycr.grant.PermissionsResultAction;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton pushBtn,fetchBtn,optionBtn;
    Button setOptionsBtn;
    Dialog bottomDialog;
    EditText pushUrl,fetchUrl,bufferTime,maxBufferTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //全屏设置
        View decorView = getWindow().getDecorView();
        // Hide both the navigation bar and the status bar.
        // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
        // a general rule, you should design your app to hide the status bar whenever you
        // hide the navigation bar.
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        //设置状态栏为透明模式
        Util.translucentStatusBar(MainActivity.this,true);


        //Android 6.0及以上并且targetSdkVersion 23及以上,摄像头和麦克风权限需要用代码请求
        //这里使用第三方的权限管理库来请求
        PermissionsManager.getInstance().requestAllManifestPermissionsIfNecessary(this,
                new PermissionsResultAction() {
                    @Override
                    public void onGranted() {

                    }

                    @Override
                    public void onDenied(String permission) {

                    }
                });

        final BubbleLayout bubbleLayout = (BubbleLayout) findViewById(R.id.bubble_layout);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Thread.sleep(15);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    bubbleLayout.postInvalidate();
                }
            }
        }).start();



        pushBtn=(ImageButton)findViewById(R.id.push);
        fetchBtn=(ImageButton)findViewById(R.id.fetch);
        optionBtn=(ImageButton)findViewById(R.id.option);

        pushBtn.setOnClickListener(this);
        fetchBtn.setOnClickListener(this);
        optionBtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.fetch:
                // 记住上次播放配置的信息，只在demo中使用，非SDK方法
                MainActivity.this.startActivity(new Intent(MainActivity.this, LivePlayerDemoActivity.class));
                break;
            case R.id.push:
                // 记住上次输入的发布地址，只在demo中使用，非SDK方法
                MainActivity.this.startActivity(new Intent(MainActivity.this, LivePublisherDemoActivity.class));
                break;
            case R.id.option:
               showOptions();
                break;
        }
    }

    private void showOptions(){
        bottomDialog = new Dialog(this, R.style.BottomDialog);
        final View contentView = LayoutInflater.from(this).inflate(R.layout.activity_live_options, null);

        bottomDialog.setCanceledOnTouchOutside(true);


        bottomDialog.setContentView(contentView);
        ViewGroup.LayoutParams layoutParams = contentView.getLayoutParams();
        layoutParams.width = getResources().getDisplayMetrics().widthPixels;
        contentView.setLayoutParams(layoutParams);
        bottomDialog.getWindow().setGravity(Gravity.BOTTOM);
        bottomDialog.getWindow().setWindowAnimations(R.style.BottomDialog_Animation);

        bottomDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {

            @Override
            public void onDismiss(DialogInterface dialog) {
                //处理监听事件
                Options.setPushUrl(pushUrl.getText().toString());
                Options.setFetchUrl(fetchUrl.getText().toString());
                Options.setBufferTime(Integer.parseInt(bufferTime.getText().toString()));
                Options.setMaxBufferTime(Integer.parseInt(maxBufferTime.getText().toString()));
            }
        });

        bottomDialog.show();


        setOptionsBtn=contentView.findViewById(R.id.setoptions);

        pushUrl=contentView.findViewById(R.id.pushURL);
        fetchUrl=contentView.findViewById(R.id.fetchURL);

        bufferTime=contentView.findViewById(R.id.editText_bufferTime);
        maxBufferTime=contentView.findViewById(R.id.editText_maxBufferTime);

        pushUrl.setText(Options.pushUrl);
        fetchUrl.setText(Options.fetchUrl);
        bufferTime.setText(Integer.toString(Options.bufferTime));
        maxBufferTime.setText(Integer.toString(Options.maxBufferTime));


        setOptionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pushUrl.getText().toString().length() <= 0 || pushUrl.getText().toString() == null){
                    Toast.makeText(MainActivity.this,"请输入正确的直播地址！",Toast.LENGTH_SHORT);
                    return;
                }
                if(fetchUrl.getText().toString().length() <= 0 || fetchUrl.getText().toString() == null){
                    Toast.makeText(MainActivity.this,"请输入正确的直播地址！",Toast.LENGTH_SHORT);
                    return;
                }
                if(!Util.isInteger(bufferTime.getText().toString())){
                    Toast.makeText(MainActivity.this,"请输入正确的启动缓冲值！",Toast.LENGTH_SHORT);
                    return;
                }
                if(!Util.isInteger(maxBufferTime.getText().toString())){
                    Toast.makeText(MainActivity.this,"请输入正确的最大缓冲值！",Toast.LENGTH_SHORT);
                    return;
                }

                Options.setPushUrl(pushUrl.getText().toString());
                Options.setFetchUrl(fetchUrl.getText().toString());
                Options.setBufferTime(Integer.parseInt(bufferTime.getText().toString()));
                Options.setMaxBufferTime(Integer.parseInt(maxBufferTime.getText().toString()));

                //MainActivity.this.startActivity(new Intent(MainActivity.this, PlayerActivity.class));
                bottomDialog.cancel();
            }
        });
    }
}
