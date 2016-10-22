package com.example.icloth;

import android.app.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

public class Classify extends Activity{
	
	private ImageButton Return;
	private ImageButton TPs;
	private ImageButton Season;
	private ImageButton Color;
	private ImageButton Entry;
   
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.classify_entry);
	    
        Return = (ImageButton) findViewById(R.id.Return);
        Return.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent i = new Intent();
				i.setClass(Classify.this,MainActivity.class);
				startActivity(i);
			}
		});
        
        TPs = (ImageButton) findViewById(R.id.TopsPants);
        TPs.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View x) {
				// TODO 自动生成的方法存根
				Intent i = new Intent();
				i.setClass(Classify.this,TPs.class);
				startActivity(i);
			}
		});
        
        Season = (ImageButton) findViewById(R.id.Season);
        Season.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent n = new Intent();
				n.setClass(Classify.this,Season.class);
				startActivity(n);
			}
		});
        
        Color = (ImageButton) findViewById(R.id.Color);
        Color.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent n = new Intent();
				n.setClass(Classify.this,Color.class);
				startActivity(n);
			}
		});
        
        Entry = (ImageButton) findViewById(R.id.Entry);
        Entry.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO 自动生成的方法存根
				Intent n = new Intent();
				n.setClass(Classify.this,Entry.class);
				startActivity(n);
			}
		});

    }
}
