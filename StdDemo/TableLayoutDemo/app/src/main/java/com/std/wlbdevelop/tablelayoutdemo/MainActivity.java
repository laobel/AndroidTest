package com.std.wlbdevelop.tablelayoutdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_collapse;
    private Button btn_stretch;
    private Button btn_shrink;
    private Button btn_demo;

    public Intent it=new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
    }

    private void bindViews(){
        btn_collapse=findViewById(R.id.Btn_collapseColumns);
        btn_stretch=findViewById(R.id.Btn_stretchColumns);
        btn_shrink=findViewById(R.id.Btn_shrinkColumns);
        btn_demo=findViewById(R.id.Btn_demo);

        btn_collapse.setOnClickListener(this);
        btn_stretch.setOnClickListener(this);
        btn_shrink.setOnClickListener(this);
        btn_demo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Btn_collapseColumns:
                it.setClass(MainActivity.this,CollapseActivity.class);
                startActivity(it);
                break;
            case R.id.Btn_shrinkColumns:
                it.setClass(MainActivity.this,ShrinkActivity.class);
                startActivity(it);
                break;
            case R.id.Btn_stretchColumns:
                it.setClass(MainActivity.this,StretchActivity.class);
                startActivity(it);
                break;
            default:
                it.setClass(MainActivity.this,DemoActivity.class);
                startActivity(it);
                break;
        }
    }
}
