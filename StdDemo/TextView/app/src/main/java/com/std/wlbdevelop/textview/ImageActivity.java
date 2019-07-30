package com.std.wlbdevelop.textview;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ImageActivity extends AppCompatActivity {

    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        txt=findViewById(R.id.txt);

        Drawable[] drawable=txt.getCompoundDrawables();
        // 数组下表0~3,依次是:左上右下
        drawable[1].setBounds(100, 0, 200, 200);
        txt.setCompoundDrawables(drawable[0], drawable[1], drawable[2],
                drawable[3]);
    }
}
