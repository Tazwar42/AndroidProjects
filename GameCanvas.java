package com.example.dxball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.Log;
import android.view.View;

public class GameCanvas extends View {

	Paint paint,paint2;
	float x=0,y=0,z=0;;
	
	boolean firstTime=true;
	boolean height=true;
	boolean Time=true;
	
	protected  void calculateNextPos(){
		if(height==false || y>=z){
	//		firstTime=false;
			y=y-4;
			Log.d("z", "uppppppppppmsg");
		}
		else if(height==true & y<z){
			y=y+4;
			if(y>=z){
			height=false;
			}
			Log.d("tag", "lowwwwwwwwwwwwwwwmsg");
		}
	//	y=y+4;
	//	if(y==(y*2)){
	//		firstTime=false;
	//	}
	//	Log.d("tag", "yyyyymsg");
	//	return y;
	}
	
	protected void onDraw(Canvas canvas)
	{
		if(firstTime==true)
		{
			firstTime=false;
			x=canvas.getWidth() / 2;
			y=canvas.getHeight() / 2;
			z=canvas.getHeight();
			Log.d("tag", "firsttimemsg");
		
		}
		
		calculateNextPos();
		Log.d("tag", "drawwwwwwwwwwmsg");
		canvas.drawRGB(255, 255, 255);
		paint.setColor(Color.RED);
		paint.setStyle(Style.FILL);
		paint2.setColor(Color.BLACK);
		paint2.setStyle(Style.FILL);
		
		canvas.drawCircle(x,y, 40, paint2);
		
		canvas.drawRect(50, 50, 100, 100, paint);
		
		invalidate();
	}
	
	public GameCanvas(Context context) {
		super(context);
		paint = new Paint();
		paint2= new Paint();
	}
}
