package com.example.icloth;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;

public class EntryClassify extends Activity{
	private ImageView Result;
	public static final String TAG="nate";
    private	String path;
	
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.enrtyclassify);
        
        Intent i = getIntent();
        path = i.getExtras().getString("path");
        
        //Bitmap bitmap = BitmapFactory.decodeFile(path);
        Log.i(TAG,path);
        
        
	}

}
