package com.example.makoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;

public class Internal2 extends AppCompatActivity {

    TextView getname, getpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal2);

        getname = (TextView)findViewById(R.id.getname);
        getpass = (TextView)findViewById(R.id.getpass);
    }

    public void  load(View view)
    {
        try {
            FileInputStream fileInputStream =  openFileInput("Code.txt");
            int read = -1;
            StringBuffer buffer = new StringBuffer();
            while((read =fileInputStream.read())!= -1){
                buffer.append((char)read);
            }
            Log.d("Code", buffer.toString());
            String name = buffer.substring(0,buffer.indexOf(" "));
            String pass = buffer.substring(buffer.indexOf(" ")+1);
            getname.setText(name);
            getpass.setText(pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Toast.makeText(this,"Loaded", Toast.LENGTH_SHORT).show();
    }

    public void  back( View view)
    {
        Toast.makeText(this,"Back", Toast.LENGTH_SHORT).show();
        Intent intent= new Intent(this, internalstorage.class);
        startActivity(intent);
    }
}
