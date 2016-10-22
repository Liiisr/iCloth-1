package com.example.icloth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

	public class Color extends Activity{
		
		private ImageButton Return;
		private ImageButton Red;
		private ImageButton Yellow;
		private ImageButton Blue;
		private ImageButton Green;
		private ImageButton Gray;
		private ImageButton Black;
		private ImageButton White;
		private ImageButton Purple;
		
		protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.color);
	        
	        Return = (ImageButton) findViewById(R.id.Return);
	        Return.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent i = new Intent();
					i.setClass(Color.this,Classify.class);
					startActivity(i);
				}
			});
	        
	        Red = (ImageButton) findViewById(R.id.Red);
	        Red.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent i = new Intent();
					i.setClass(Color.this,Red.class);
					startActivity(i);
				}
			});
	        
	        Yellow = (ImageButton) findViewById(R.id.Yellow);
	        Yellow.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent i = new Intent();
					i.setClass(Color.this,Yellow.class);
					startActivity(i);
				}
			});
	        
	        Green = (ImageButton) findViewById(R.id.Green);
	        Green.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent i = new Intent();
					i.setClass(Color.this,Green.class);
					startActivity(i);
				}
			});
	        
	        Blue = (ImageButton) findViewById(R.id.Blue);
	        Blue.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent i = new Intent();
					i.setClass(Color.this,Blue.class);
					startActivity(i);
				}
			});
	        
	        Purple = (ImageButton) findViewById(R.id.Purple);
	        Purple.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent i = new Intent();
					i.setClass(Color.this,Purple.class);
					startActivity(i);
				}
			});
	        
	        White = (ImageButton) findViewById(R.id.White);
	        White.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent i = new Intent();
					i.setClass(Color.this,White.class);
					startActivity(i);
				}
			});
	        
	        Black = (ImageButton) findViewById(R.id.Black);
	        Black.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent i = new Intent();
					i.setClass(Color.this,Black.class);
					startActivity(i);
				}
			});
	        
	        Gray = (ImageButton) findViewById(R.id.Gray);
	        Gray.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent i = new Intent();
					i.setClass(Color.this,Gray.class);
					startActivity(i);
				}
			});
		}
}
