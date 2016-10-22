package com.example.icloth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

	public class TPs extends Activity{
		
		private ImageButton Return;
		private ImageButton Tops;
		private ImageButton Pants;
		protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.tops_pants);
	        
	        Return = (ImageButton) findViewById(R.id.Return);
	        Return.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 自动生成的方法存根
					Intent i = new Intent();
					i.setClass(TPs.this,Classify.class);
					startActivity(i);
				}
			});
	        
	        Tops = (ImageButton) findViewById(R.id.Tops);
	        Tops.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 自动生成的方法存根
					Intent i = new Intent();
					i.setClass(TPs.this,Tops.class);
					startActivity(i);
				}
			});
	        
	        Pants = (ImageButton) findViewById(R.id.Pants);
	        Pants.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 自动生成的方法存根
					Intent i = new Intent();
					i.setClass(TPs.this,Pants.class);
					startActivity(i);
				}
			});
		}
}
