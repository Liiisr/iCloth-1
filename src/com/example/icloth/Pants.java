package com.example.icloth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
	
	public class Pants extends Activity{
		
		private ImageButton Return;
		
		protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.pants);
	        
	        Return = (ImageButton) findViewById(R.id.Tops);
	        Return.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO �Զ����ɵķ������
					Intent i = new Intent();
					i.setClass(Pants.this,TPs.class);
					startActivity(i);
				}
			});
		}
}
