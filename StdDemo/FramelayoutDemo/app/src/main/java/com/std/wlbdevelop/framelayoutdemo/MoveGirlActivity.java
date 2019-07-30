package com.std.wlbdevelop.framelayoutdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class MoveGirlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_girl);

        FrameLayout frame = (FrameLayout) findViewById(R.id.moveGirl);
        final MoveView moveGirl = new MoveView(MoveGirlActivity.this);
        //为我们的萌妹子添加触摸事件监听器
        moveGirl.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                //设置妹子显示的位置
                moveGirl.bitmapX = event.getX() - 150;
                moveGirl.bitmapY = event.getY() - 150;
                //调用重绘方法
                moveGirl.invalidate();
                return true;
            }
        });
        frame.addView(moveGirl);
    }
}
