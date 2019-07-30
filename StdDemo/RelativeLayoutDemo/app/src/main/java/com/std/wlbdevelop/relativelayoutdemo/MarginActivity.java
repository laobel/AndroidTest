package com.std.wlbdevelop.relativelayoutdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MarginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_margin);

        Button btn=(Button)findViewById(R.id.Btn_marginGo);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=getIntent();
                String name=intent.getStringExtra("name");
                Log.i("activity01传过来的值为:",name);

                finish();
            }
        });


        ImageView imv=(ImageView)findViewById(R.id.Btn_imgCancle);
        imv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    protected void onDestroy (){
        super.onDestroy();
        StaticClass.marginActivityIsDo=false;
        Log.i("AAAA:","AAAAAAAAAAAAAAAAAAAA");
    }

}


