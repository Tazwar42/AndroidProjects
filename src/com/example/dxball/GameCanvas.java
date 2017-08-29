package com.example.dxball;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class GameCanvas extends View {

	Paint paint,paint2,paint3;
	float x=0,y=0,z=0,barBottom=0,barTop=0,barLeft=0,barRight=0,brickLeft=0,brickRight=0,brickTop=0,brickDown=100;
	float downX,downY,upX,upY;
	boolean upflag=true;
	boolean over=true;
	boolean eventtt=false;

    Brick brick1,brick2,brick3,brick4,brick5,brick6,brick7,brick8,brick9,brick10;
	public static int checkWidth=0;
	Bar myBar;
	
	Brick a1,a2;
	ArrayList<Brick> bricks=new ArrayList<Brick>();
	boolean firstTime=true;
	boolean leftbar=true;
	boolean rightbar=true;
	float deltaX,deltaY;
	float newbarLeft,newbarRight;
	boolean height=true;
	boolean Time=true;
	float brickX = 0,
            brickY=0;
	boolean leftPos,rightPos;
	int min_distance = 50;
	protected  void calculateNextPos(){
			if(over==false){
			
			y=y+4;
			
		}
		
			else{
		if(height==false){
	//		firstTime=false;
			y=y-4;
			
			for(int i=0;i<bricks.size();i++) {
				if(((y-30)<=bricks.get(i).getBottom())&&((y+30)>=bricks.get(i).getBottom())){
					
					
					bricks.remove(i);
					height=true;
				}
			
			}
		
			
			
//		Log.d("z", "uppppppppppmsg");		
		}
		
		
		
		else if(height==true & (y+30)<barTop){
			
		//	if(x>=barLeft && x<=barRight){
			y=y+4;
			//}
		//	if(y+30==barTop){
		//		y=y-4;
			//	height=false;
		//		y=y-4;
		//	}
			
			
			
			
			if(y+30>=barTop){
				
				
				height=false;
				}
			
			

			if( x+30>barRight || x+30<barLeft){
				
				
				over=false;
				}
			
	//		else {
				
		//		y=y+4;
	//			over=false;
	//		}
			
			
			
//			else {
//				y=y+4;
//			}
			
	//		if(y>=z){
	//		height=false;
	//		}
			Log.d("tag", "lowwwwwwwwwwwwwwwmsg");
		}
		
			}
	//	y=y+4;
	//	if(y==(y*2)){
	//		firstTime=false;
	//	}
	//	Log.d("tag", "yyyyymsg");
	//	return y;
	}
	
		/*
	public void brickCollison(){
		
		for(int i=0;i<bricks.size();i++) {
			if(((y-30)<=bricks.get(i).getBottom())&&((y+30)>=bricks.get(i).getBottom())){
				
				
				bricks.remove(i);
				y=y+4;
			}
			
			
		}
			
			
			
			
		}
		
		
*/		
		
		
		
		
	
	
	
	
	
	
	  public void moveBar(){
		  
		  
//		  if(eventtt==true){
	        if(leftPos==true){
	        	
	        //////////right e jabeeeeeeeeeeeeeeeeeeeeeeeeeeeee	
	            if(GameCanvas.checkWidth>=barRight) {
	                barLeft = barLeft + 4;
	                newbarLeft=barLeft;
	                barRight = barRight +4;
	                newbarRight=barRight;
	                
	               eventtt=false;
	               // 	upflag=false;
	               Log.d("tag", "right e jabeeeeeeeeeeeeeeeeeeeeeeeeee");
	                
	                
	              //  if(barLeft==newbarLeft && barRight==newbarRight){
	               // leftbar=false;
	               // }
	            }


	        }
	        else if(rightPos==true){
	            if(0<=barLeft) {
	                //if()
	            	  Log.d("tag", "left e jabeeeeeeeeeeeeeeeee");
	            ///left e jabeeeeeeeeeeeeeeeeeeeee	
	                barLeft = barLeft - 4;
	                barRight = barRight - 4;
	                rightbar=false;
	                eventtt=false;
	            }

	        }
//		  }
//		  else {
			  
			  /////
			  
			  Log.d("tag", "sssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
//		  }

	   }
	
	protected void onDraw(Canvas canvas)
	{
		if(firstTime==true)
		{
			firstTime=false;
			x=canvas.getWidth() / 2;
			y=canvas.getHeight() / 2;
			z=canvas.getHeight();
			barTop=canvas.getHeight()-20;
			barBottom=canvas.getHeight();
			barLeft=(canvas.getWidth()/2)-100;
			barRight=(canvas.getWidth()/2)+100;
			
			checkWidth = canvas.getWidth();
			Log.d("tag", "firsttttttttttttttttttttttttttttttttttttt");
			
			
			
			
		    for(int i=0; i<10; i++){
                int color;

                //CREATE BRICK POSITION
                if(brickX>=canvas.getWidth()) {
                    brickX = 0;
                    brickY +=100;
                }

                //CHECK COLOR
                if(i%2==0)
                    color = Color.BLACK;
                else
                    color = Color.RED;

                //ADD NEW BRICK
                bricks.add(new Brick(brickX,brickY,brickX+canvas.getWidth()/5,brickY+100,color));

                brickX += canvas.getWidth() / 5;
            }
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
		}
		
		calculateNextPos();
		 moveBar();
//		 brickCollison();
//		 brick();
		 
		Log.d("tag", "drawwwwwwwwwwmsg");
		canvas.drawRGB(255, 255, 255);
		paint.setColor(Color.RED);
		paint.setStyle(Style.FILL);
		paint2.setColor(Color.BLACK);
		paint2.setStyle(Style.FILL);
		paint3.setColor(Color.GREEN);
		paint3.setStyle(Style.FILL);
		
		   for(int i=0;i<bricks.size();i++){
	            canvas.drawRect(bricks.get(i).getLeft(),bricks.get(i).getTop(),bricks.get(i).getRight(),bricks.get(i).getBottom(),bricks.get(i).getPaint());
	        }
		
		canvas.drawCircle(x,y, 30, paint2);
		
	//	canvas.drawRect(50, 50,50 100, 100, paint);
		
	/*	canvas.drawRect(0, 0, 110, brickDown, paint);
	    canvas.drawRect(110, 0, 220, brickDown, paint2);
	    canvas.drawRect(220, 0, 330,brickDown, paint);
	    canvas.drawRect(330, 0, 440, brickDown, paint2);
        canvas.drawRect(440, 0, 550, brickDown, paint);
        canvas.drawRect(0, brickTop+100, 110, brickDown+100, paint2);
        canvas.drawRect(110, brickTop+100, 220, brickDown+100, paint);
        canvas.drawRect(220, brickTop+100, 330, brickDown+100, paint2);
        canvas.drawRect(330, brickTop+100, 440, brickDown+100, paint);
        canvas.drawRect(440, brickTop+100, 550, brickDown+100, paint2);
        */
        canvas.drawRect(barLeft, barTop,barRight ,barBottom , paint3);
     //   performClick();
        
        
    //  this.run();  
		invalidate();
	}
	
	
	//Moving Bar
//    @SuppressLint("ClickableViewAccessibility")
	@Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:{
            	//start
            	
        //   barLeft=event.getX();
      //     barTop=event.getY();
            	 performClick();
                 downX=event.getX();
                downY=event.getY();
               
                float d=Math.abs(downX);
                float e=Math.abs(downY);
                Log.d("Value: " ,Float.toString(d));
                Log.d("Value: " ,Float.toString(e));
                
                
            	Log.d("touch", "only downnnnnnnnnnnnnnnnnnnnnnnnt");		
            //    int s=(int) downX;
         //   Toast.makeText(this, "ACTION_DOWN AT COORDS "+"X: "+p+" Y: "+q, Toast.LENGTH_SHORT).show();
   //          Toast.makeText(this, "netwrk not", Toast.LENGTH_LONG).show();
            //    Toast.makeText(this, "dsfsdfsdg" , Toast.LENGTH_SHORT).show();
             //   Toast.makeText(CONTEXT, s, Toast.LENGTH_SHORT).show();
            	
            	eventtt=true;
            	
                return true;

            }
            
            case MotionEvent.ACTION_MOVE:{
            	
            
            	
           // 	barRight=event.getX();
     //       	barBottom=event.getY();
            	
           	
                upX=event.getX();
                upY=event.getY();
                eventtt=true;
            	Log.d("touchtoototot", "rightttttttttttffffffffffffffffffffffffffffffffffffffffffffffffffffffft");		

                 deltaX=downX-upX;
                deltaY=downY-upY;
                float a=Math.abs(deltaX);
                float b=Math.abs(deltaY);
               
                Log.d("Value: " ,Float.toString(a));
                Log.d("Value: " , Float.toString(b));
                if(Math.abs(deltaX) > Math.abs(deltaY)){
                    if(Math.abs(deltaX) > min_distance) {
                        if (deltaX < 0) {
                            //left=left+100;
                            //right=right+100;
                 /////right e jabeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee       	
                        	
                       //left to right
                    //    	Log.d("tag", "trueeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee  right");		
                            leftPos=true;
                            rightPos=false;
                      //      myBar.moveBar(leftPos, rightPos);
                            return true;
                        }

                        if (deltaX > 0) {
                        	
                     /////////////left e  jabeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee   	
                            leftPos=false;
                            rightPos=true;
                        	Log.d("tag", "leftttttttttttttttt");		
                      //      myBar.moveBar(leftPos,rightPos);
                            //Right to left
                            return true;

                        }
                    }
                    else{
                        return  false;
                    }
                }
                else{
                    if(Math.abs(deltaY) > min_distance) {
                        if (deltaY < 0) {
                            //top to bottom
                            return true;
                        }
                        if (deltaY > 0) {
                            //bottom to top
                            return true;

                        }
                    }
                    else{
                        return  false;
                    }
                }
            	
            	
            	
            	
            	
            	
            	
             	Log.d("touch", "moveeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
             	
             	eventtt=true;
             	
             	return true;  
            }
            /*
            case MotionEvent.ACTION_UP:{
            
            	upflag=true;
            	
            	
            	return true;
            	
         
            	//finish
           	 performClick();
                upX=event.getX();
                upY=event.getY();
                
  //          	Log.d("touchtoototot", "rightttttttttttffffffffffffffffffffffffffffffffffffffffffffffffffffffft");		

                 deltaX=downX-upX;
                deltaY=downY-upY;
                float a=Math.abs(deltaX);
                float b=Math.abs(deltaY);
               
                Log.d("Value: " ,Float.toString(a));
                Log.d("Value: " , Float.toString(b));
                if(Math.abs(deltaX) > Math.abs(deltaY)){
                    if(Math.abs(deltaX) > min_distance) {
                        if (deltaX < 0) {
                            //left=left+100;
                            //right=right+100;
                 /////right e jabeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee       	
                        	
                       //left to right
   //                     	Log.d("tag", "rightttttttttttt");		
                            leftPos=true;
                            rightPos=false;
                      //      myBar.moveBar(leftPos, rightPos);
                            return true;
                        }

                        if (deltaX > 0) {
                        	
                     /////////////left e  jabeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee   	
                            leftPos=false;
                            rightPos=true;
                        	Log.d("tag", "leftttttttttttttttt");		
                      //      myBar.moveBar(leftPos,rightPos);
                            //Right to left
                            return true;

                        }
                    }
                    else{
                        return  false;
                    }
                }
                else{
                    if(Math.abs(deltaY) > min_distance) {
                        if (deltaY < 0) {
                            //top to bottom
                            return true;
                        }
                        if (deltaY > 0) {
                            //bottom to top
                            return true;

                        }
                    }
                    else{
                        return  false;
                    }
                }
             //   invalidate();
                
                

            }*/ 

        }
   //     invalidate();
     //  return false; 
        return super.onTouchEvent(event);
    }
	
	@Override
	 public boolean performClick() {
	  // Calls the super implementation, which generates an AccessibilityEvent
	        // and calls the onClick() listener on the view, if any
	        super.performClick();

	        // Handle the action for the custom click here

	        return true;
	 }

	
	
	
	
	public GameCanvas(Context context) {
		super(context);
		paint = new Paint();
		paint2= new Paint();
		paint3= new Paint();
		myBar=new Bar();
	}
	/*
	@Override
    public boolean onTouchEvent(final MotionEvent event) {
		
		case MotionEvent.
		
	}
	*/
	

	
	
	
	
	
	
}
