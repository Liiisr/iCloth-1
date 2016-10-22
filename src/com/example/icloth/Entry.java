package com.example.icloth;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.media.ExifInterface;
import android.net.Uri;

public class Entry extends Activity {
	
	private ImageButton Return;
	private ImageButton Camera;
	private ImageButton Album;
	private ImageView mimageViewPhotoShow;
	private int CAMERA_RESULT = 100;
	private int RESULT_LOAD_IMAGE = 200;
	private File mPhotoFile;
	private String saveDir = Environment.getExternalStorageDirectory()
			.getPath() + "/iCloth";
	public static final String TAG="nate";
	private int picnum=0;
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.entry);
        
        Return = (ImageButton) findViewById(R.id.Return);
        Return.setOnClickListener(new View.OnClickListener() {
			
	    @Override
		public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent i = new Intent();
				i.setClass(Entry.this,Classify.class);
				startActivity(i);
			}
		});
        
        //拍照上传
        
        Camera = (ImageButton) findViewById(R.id.Camera);
        Camera.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String state = Environment.getExternalStorageState();
				//getExternalStorageState()方法用于判断SD卡的状态

				if (state.equals(Environment.MEDIA_MOUNTED)) {
					//MEDIA_MOUNTED表明对象是否存在并具有读/写权限
					//挂载就是加载的意思.具体就是说,把sd卡和系统相连,让系统能认到并读取sd卡的内容
					mPhotoFile = new File(saveDir, "temp.jpg");
					//找到saveDir路径中命名为temp.jpg的文件
					mPhotoFile.delete();
					//由于命名相同，拍摄两张后将会覆盖，即删除旧的那张
					if (!mPhotoFile.exists()) {
						try {
							mPhotoFile.createNewFile();
							//若该文件不存在则新建一张名为temp.jpg的文件
						} catch (IOException e) {
							e.printStackTrace();
							Toast.makeText(getApplication(), "照片创建失败!",
									Toast.LENGTH_LONG).show();
							/*第一个参数：当前的上下文环境。可用getApplicationContext()或者getContext()或this
							第二个参数：要显示的字符串。也可是R.string中字符串ID
							第三个参数：显示的时间长短。Toast默认的有两个LENGTH_LONG(长3.5秒)和LENGTH_SHORT(短2秒)，也可以使用毫秒如1000ms（不建议）*/
							return;
						}
					}
					Intent intent = new Intent(
							"android.media.action.IMAGE_CAPTURE");
					//调用照相机
					intent.putExtra(MediaStore.EXTRA_OUTPUT,
							Uri.fromFile(mPhotoFile));
					//图像输出，保存为mPhotoFile
					startActivityForResult(intent, CAMERA_RESULT);
					//完成拍照动作后传回CAMERA_RESULT=100
				} else {
					Toast.makeText(getApplication(), "sdcard无效或没有插入!",
							Toast.LENGTH_SHORT).show();
				}
			}
		});
        //相册导入
        
        Album = (ImageButton) findViewById(R.id.Album);
        Album.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(
						Intent.ACTION_PICK,
						//ACTION_PICK是Intent的标准动作之一，目的是从数据中选择一项， 
						android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				        //每个Content provider 提供公共的URI来唯一标识其数据集，以上应当是标识了图片集合?
				startActivityForResult(i, RESULT_LOAD_IMAGE);
			}
		});
		
		File savePath = new File("saveDir");
		//saveDir的意思是临时目录
		if (!savePath.exists()) {
			savePath.mkdirs();//如果没有就创建
		}
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		//当调用startActivityForResult()后，先前的Actitity要重写onActivityResult方法
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == CAMERA_RESULT && resultCode == RESULT_OK) {
			//判断条件：若是相机传入
			if (mPhotoFile != null && mPhotoFile.exists()) {
				String path = mPhotoFile.getPath();
				Intent jump = new Intent();
				//jump.putExtra("path",path);
                jump.setClass(this, EntryClassify.class);
                startActivity(jump);
			}
		}
		if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK
				&& null != data) {
			//判断条件：若为相册传入
			Uri selectedImage = data.getData();
			String[] filePathColumn = { MediaStore.Images.Media.DATA };

			Cursor cursor = getContentResolver().query(selectedImage,
					filePathColumn, null, null, null);
			cursor.moveToFirst();

			int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
			String path = cursor.getString(columnIndex);
			cursor.close();
			//Log.i(TAG,path);
            
			Intent jump = new Intent();
			jump.putExtra("path", path);
			jump.setClass(this, EntryClassify.class);
			startActivity(jump);
		}
	}


}
