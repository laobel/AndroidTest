package com.std.wlbdevelop.relativelayoutdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MarginPaddingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marginpadding);

        Button btn=(Button)findViewById(R.id.Btn_marginpaddingGo);
        btn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                Intent intent = getIntent();
                String name=intent.getStringExtra("name");
                Log.i("activity01传过来的值为:",name);

                /*Intent in = new Intent();
                in.setClass(PlumActivity.this, MainActivity.class);
                startActivity( in );*/

                finish();
            }
        });
    }
}
