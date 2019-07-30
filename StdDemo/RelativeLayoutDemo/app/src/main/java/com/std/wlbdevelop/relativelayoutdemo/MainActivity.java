package com.std.wlbdevelop.relativelayoutdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    public Intent in=new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StaticClass.marginActivityIsDo=false;
    }

    //指定onClick属性方式
    //传人的View对象，就是用户按下的那个按钮对象
    public void click(View v) {
        // TODO Auto-generated method stub

        //获取组件的资源id
        int id = v.getId();
        switch (id) {
            case R.id.Btn_Plum:
                Log.i("指定onClick属性方式","Plum点击事件");
                showPlumActivity();
                break;
            case R.id.Btn_margin_padding:
                Log.i("指定onClick属性方式","margin_padding点击事件");
                showMarginPaddingActivity();
                break;
            case R.id.Btn_margin:
                Log.i("指定onClick属性方式","margin击事件");
                showMarginActivity();
                break;

            default:
                break;
        }
    }

    public void showPlumActivity(){
        //Intent in = new Intent();
        in.putExtra("name","LeiPei");
        in.setClass(MainActivity.this, PlumActivity.class);
        startActivity( in );
        
        //finish();
    }

    public void showMarginPaddingActivity(){
        //Intent in = new Intent();
        in.putExtra("name","LeiPei");
        in.setClass(MainActivity.this, MarginPaddingActivity.class);
        startActivity( in );
    }

    public void showMarginActivity(){
        if(StaticClass.marginActivityIsDo){
            return;
        }
        //final Intent in = new Intent(MainActivity.this,MarginActivity.class);
        in.putExtra("name","LeiPei");
        in.setClass(MainActivity.this, MarginActivity.class);

        Thread thread=new Thread(){
            public void run(){
                try {
                    sleep(2000 );
                    startActivity(in);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        thread.start();
        StaticClass.marginActivityIsDo=true;
        //startActivity( in );
    }

}
