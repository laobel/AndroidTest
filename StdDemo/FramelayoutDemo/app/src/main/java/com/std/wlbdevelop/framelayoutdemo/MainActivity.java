package com.std.wlbdevelop.framelayoutdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button simplyBtn,moveGirlBtn,runGirlBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simplyBtn=(Button)findViewById(R.id.simplyDemo);
        moveGirlBtn=(Button)findViewById(R.id.moveGirl);
        runGirlBtn=(Button)findViewById(R.id.runGirl);


        simplyBtn.setOnClickListener(this);
        moveGirlBtn.setOnClickListener(this);
        runGirlBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.simplyDemo:
                MainActivity.this.startActivity(new Intent(MainActivity.this,SimplyActivity.class));
                break;
            case R.id.moveGirl:
                MainActivity.this.startActivity(new Intent(MainActivity.this,MoveGirlActivity.class));
                break;
            case R.id.runGirl:
                MainActivity.this.startActivity(new Intent(MainActivity.this,RunGirlActivity.class));
                break;
        }
    }
}
