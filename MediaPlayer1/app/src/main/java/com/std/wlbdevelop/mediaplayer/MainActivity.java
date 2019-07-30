package com.std.wlbdevelop.mediaplayer;

import android.app.Dialog;
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


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton pushBtn,fetchBtn;
    Button goPush,goFetch;
    Dialog bottomDialog;
    EditText pushUrl,fetchUrl,cacheValue,maxCacheValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        //全屏设置

        /*View decorView = getWindow().getDecorView();
        // Hide both the navigation bar and the status bar.
        // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
        // a general rule, you should design your app to hide the status bar whenever you
        // hide the navigation bar.
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);*/

        pushBtn=(ImageButton)findViewById(R.id.push);
        fetchBtn=(ImageButton)findViewById(R.id.fetch);

        pushBtn.setOnClickListener(this);
        fetchBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.push:
                showPushOptions();
                break;
            case R.id.fetch:
                showFetchOptions();
                break;
        }


    }

    private void showPushOptions() {
        bottomDialog = new Dialog(this, R.style.BottomDialog);
        View contentView = LayoutInflater.from(this).inflate(R.layout.activity_pushoptions, null);


        bottomDialog.setCanceledOnTouchOutside(true);


        bottomDialog.setContentView(contentView);
        ViewGroup.LayoutParams layoutParams = contentView.getLayoutParams();
        layoutParams.width = getResources().getDisplayMetrics().widthPixels;
        contentView.setLayoutParams(layoutParams);
        bottomDialog.getWindow().setGravity(Gravity.BOTTOM);
        bottomDialog.getWindow().setWindowAnimations(R.style.BottomDialog_Animation);


        bottomDialog.show();


        goPush=contentView.findViewById(R.id.goPush);

        pushUrl=contentView.findViewById(R.id.pushURL);

        if(pushUrl.getText().toString() == null || pushUrl.getText().toString().length() <= 0){
            pushUrl.setText("rtmp://192.168.0.110/live/test" + Math.round((Math.random() * 10+ 1)));
        }


        goPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pushUrl.getText().toString().length() <= 0 || pushUrl.getText().toString() == null){
                    Toast.makeText(MainActivity.this,"请输入正确的直播地址！",Toast.LENGTH_SHORT);
                    return;
                }
                Options.setPushUrl(pushUrl.getText().toString());
                MainActivity.this.startActivity(new Intent(MainActivity.this, PublishActivity.class));
                bottomDialog.cancel();
            }
        });
    }

    private void showFetchOptions(){
        bottomDialog = new Dialog(this, R.style.BottomDialog);
        final View contentView = LayoutInflater.from(this).inflate(R.layout.activity_fetchoptions, null);


        bottomDialog.setCanceledOnTouchOutside(true);


        bottomDialog.setContentView(contentView);
        ViewGroup.LayoutParams layoutParams = contentView.getLayoutParams();
        layoutParams.width = getResources().getDisplayMetrics().widthPixels;
        contentView.setLayoutParams(layoutParams);
        bottomDialog.getWindow().setGravity(Gravity.BOTTOM);
        bottomDialog.getWindow().setWindowAnimations(R.style.BottomDialog_Animation);


        bottomDialog.show();


        goFetch=contentView.findViewById(R.id.goFetch);
        fetchUrl=contentView.findViewById(R.id.fetchURL);
        cacheValue=contentView.findViewById(R.id.editText_bufferTime);
        maxCacheValue=contentView.findViewById(R.id.editText_maxBufferTime);

        if(fetchUrl.getText().toString().length() <= 0 || fetchUrl.getText().toString() == null){
            fetchUrl.setText("rtmp://192.168.0.110/live/test" + Math.round((Math.random() * 10+ 1)));
        }


        goFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fetchUrl.getText().toString().length() <= 0 || fetchUrl.getText().toString() == null){
                    Toast.makeText(MainActivity.this,"请输入正确的直播地址！",Toast.LENGTH_SHORT);
                    return;
                }
                if(!Util.isInteger(cacheValue.getText().toString())){
                    Toast.makeText(MainActivity.this,"请输入正确的启动缓冲值！",Toast.LENGTH_SHORT);
                    return;
                }
                if(!Util.isInteger(maxCacheValue.getText().toString())){
                    Toast.makeText(MainActivity.this,"请输入正确的最大缓冲值！",Toast.LENGTH_SHORT);
                    return;
                }

                Options.setFetchUrl(fetchUrl.getText().toString());
                Options.setBufferTime(Integer.parseInt(cacheValue.getText().toString()));
                Options.setMaxBufferTime(Integer.parseInt(maxCacheValue.getText().toString()));

                MainActivity.this.startActivity(new Intent(MainActivity.this, PlayerActivity.class));
                bottomDialog.cancel();
            }
        });
    }

}
