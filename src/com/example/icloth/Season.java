package com.example.icloth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

public class Season extends Activity{
	
	private ImageButton Return;
	private ImageButton Spring;
	private ImageButton Summer;
	private ImageButton Fall;
	private ImageButton Winter;
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.season);
        
        Return = (ImageButton) findViewById(R.id.Return);
        Return.setOnClickListener(new View.OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			// TODO 自动生成的方法存根
    			Intent i = new Intent();
    			i.setClass(Season.this,Classify.class);
    			startActivity(i);
    		}
    	});
        
        Spring = (ImageButton) findViewById(R.id.Spring);
        Spring.setOnClickListener(new View.OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			// TODO 自动生成的方法存根
    			Intent i = new Intent();
    			i.setClass(Season.this,Spring.class);
    			startActivity(i);
    		}
    	});
        
        Summer = (ImageButton) findViewById(R.id.Summer);
        Summer.setOnClickListener(new View.OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			// TODO 自动生成的方法存根
    			Intent i = new Intent();
    			i.setClass(Season.this,Summer.class);
    			startActivity(i);
    		}
    	});
        
        Fall = (ImageButton) findViewById(R.id.Fall);
        Fall.setOnClickListener(new View.OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			// TODO 自动生成的方法存根
    			Intent i = new Intent();
    			i.setClass(Season.this,Fall.class);
    			startActivity(i);
    		}
    	});
        
        Winter = (ImageButton) findViewById(R.id.Winter);
        Winter.setOnClickListener(new View.OnClickListener() {
    		
    		@Override
    		public void onClick(View v) {
    			// TODO 自动生成的方法存根
    			Intent i = new Intent();
    			i.setClass(Season.this,Winter.class);
    			startActivity(i);
    		}
    	});
	}
	

}
