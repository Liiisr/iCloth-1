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
				// TODO �Զ����ɵķ������
				Intent i = new Intent();
				i.setClass(Entry.this,Classify.class);
				startActivity(i);
			}
		});
        
        //�����ϴ�
        
        Camera = (ImageButton) findViewById(R.id.Camera);
        Camera.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String state = Environment.getExternalStorageState();
				//getExternalStorageState()���������ж�SD����״̬

				if (state.equals(Environment.MEDIA_MOUNTED)) {
					//MEDIA_MOUNTED���������Ƿ���ڲ����ж�/дȨ��
					//���ؾ��Ǽ��ص���˼.�������˵,��sd����ϵͳ����,��ϵͳ���ϵ�����ȡsd��������
					mPhotoFile = new File(saveDir, "temp.jpg");
					//�ҵ�saveDir·��������Ϊtemp.jpg���ļ�
					mPhotoFile.delete();
					//����������ͬ���������ź󽫻Ḳ�ǣ���ɾ���ɵ�����
					if (!mPhotoFile.exists()) {
						try {
							mPhotoFile.createNewFile();
							//�����ļ����������½�һ����Ϊtemp.jpg���ļ�
						} catch (IOException e) {
							e.printStackTrace();
							Toast.makeText(getApplication(), "��Ƭ����ʧ��!",
									Toast.LENGTH_LONG).show();
							/*��һ����������ǰ�������Ļ���������getApplicationContext()����getContext()��this
							�ڶ���������Ҫ��ʾ���ַ�����Ҳ����R.string���ַ���ID
							��������������ʾ��ʱ�䳤�̡�ToastĬ�ϵ�������LENGTH_LONG(��3.5��)��LENGTH_SHORT(��2��)��Ҳ����ʹ�ú�����1000ms�������飩*/
							return;
						}
					}
					Intent intent = new Intent(
							"android.media.action.IMAGE_CAPTURE");
					//���������
					intent.putExtra(MediaStore.EXTRA_OUTPUT,
							Uri.fromFile(mPhotoFile));
					//ͼ�����������ΪmPhotoFile
					startActivityForResult(intent, CAMERA_RESULT);
					//������ն����󴫻�CAMERA_RESULT=100
				} else {
					Toast.makeText(getApplication(), "sdcard��Ч��û�в���!",
							Toast.LENGTH_SHORT).show();
				}
			}
		});
        //��ᵼ��
        
        Album = (ImageButton) findViewById(R.id.Album);
        Album.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(
						Intent.ACTION_PICK,
						//ACTION_PICK��Intent�ı�׼����֮һ��Ŀ���Ǵ�������ѡ��һ� 
						android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				        //ÿ��Content provider �ṩ������URI��Ψһ��ʶ�����ݼ�������Ӧ���Ǳ�ʶ��ͼƬ����?
				startActivityForResult(i, RESULT_LOAD_IMAGE);
			}
		});
		
		File savePath = new File("saveDir");
		//saveDir����˼����ʱĿ¼
		if (!savePath.exists()) {
			savePath.mkdirs();//���û�оʹ���
		}
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		//������startActivityForResult()����ǰ��ActitityҪ��дonActivityResult����
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == CAMERA_RESULT && resultCode == RESULT_OK) {
			//�ж������������������
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
			//�ж���������Ϊ��ᴫ��
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
