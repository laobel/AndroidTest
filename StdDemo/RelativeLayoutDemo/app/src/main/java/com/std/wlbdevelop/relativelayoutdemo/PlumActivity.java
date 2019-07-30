package com.std.wlbdevelop.relativelayoutdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class PlumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plum);

        Button btn=(Button)findViewById(R.id.Btn_plumGo);
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
