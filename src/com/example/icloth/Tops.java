package com.example.icloth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
	
	public class Tops extends Activity{
		
		private ImageButton Return;
		
		protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.tops);
	        
	        Return = (ImageButton) findViewById(R.id.Tops);
	        Return.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO 自动生成的方法存根
					Intent i = new Intent();
					i.setClass(Tops.this,TPs.class);
					startActivity(i);
				}
			});
		}
}
