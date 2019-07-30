package com.jay.example.framelayoutdemo2;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.app.Activity;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		FrameLayout frame = (FrameLayout) findViewById(R.id.mylayout);
		final MeziView mezi = new MeziView(MainActivity.this);
		
		//Ϊ���ǵ���������Ӵ����¼�������
		mezi.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View view, MotionEvent event) {
				//����������ʾ��λ��
				mezi.bitmapX = event.getX();
				mezi.bitmapY = event.getY();
				//�����ػ淽��
				mezi.invalidate();
				return true;
			}
		});
		
		frame.addView(mezi);
		
	}
}
