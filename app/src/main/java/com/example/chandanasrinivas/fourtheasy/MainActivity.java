package com.example.chandanasrinivas.fourtheasy;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView capt;
    Button open;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        open=(Button) findViewById(R.id.open);
        capt=(ImageView) findViewById(R.id.capt);
        open.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(i.resolveActivity(getPackageManager()) != null)
        {
            startActivityForResult(i,1001);
        }
    }

    protected void onActivityResult(int requestCode,int resultCode,Intent data)
    {
        if(requestCode==1001)
        {
            Bundle extras = data.getExtras();
            Bitmap bitmap= (Bitmap)extras.get("data");
            capt.setImageBitmap(bitmap);
        }
        super.onActivityResult(requestCode,resultCode,data);
    }
}
