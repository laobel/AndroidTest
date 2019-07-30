package com.std.wlbdevelop.textview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent intent;
    private Button simplyBtn,shadowBtn,borderBtn,imageBtn,linkBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simplyBtn=findViewById(R.id.simplyDemo);
        shadowBtn=findViewById(R.id.shadowDemo);
        borderBtn=findViewById(R.id.borderDemo);
        imageBtn=findViewById(R.id.imageDemo);
        linkBtn=findViewById(R.id.linkDemo);

        simplyBtn.setOnClickListener(this);
        shadowBtn.setOnClickListener(this);
        borderBtn.setOnClickListener(this);
        imageBtn.setOnClickListener(this);
        linkBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.simplyDemo:
                intent=new Intent(this,SimplyDemoActivity.class);
                break;
            case R.id.shadowDemo:
                intent=new Intent(this,ShadowActivity.class);
                break;
            case R.id.borderDemo:
                intent=new Intent(this,BorderActivity.class);
                break;
            case R.id.imageDemo:
                intent=new Intent(this,ImageActivity.class);
                break;
            case R.id.linkDemo:
                intent=new Intent(this,AutoLinkActivity.class);
                break;
        }

        this.startActivity(intent);
    }
}
