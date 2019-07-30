package com.jay.example.framelayoutdemo2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class MeziView extends View {
	//������ر���,������������ʾλ�õ�X,Y����
	public float bitmapX;
	public float bitmapY;
	

	public MeziView(Context context) {
		super(context);
		//�������ӵ���ʼ����
		bitmapX = 0;
		bitmapY = 200;
	}


	//��дView���onDraw()����
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		//����,����ʵ����Paint�Ķ���
		Paint paint = new Paint();
		//����ͼƬ����λͼ����
		Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.s_jump);
		//����������
		canvas.drawBitmap(bitmap, bitmapX, bitmapY,paint);
		//�ж�ͼƬ�Ƿ����,ľ�л��յĻ�ǿ���ջ�ͼƬ
		if(bitmap.isRecycled())
		{
			bitmap.recycle();
		}
		
	}
		
}
