package com.example.calculationfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void exit_cn(View v) {
        Intent intent=new Intent(Menu.this,MainActivity.class);
        startActivity(intent);
    }
    public void ptb_test(View v) {
        Intent i =new Intent(Menu.this,ptb2.class);
        startActivity(i);
    }
    public void pt2a(View v) {
        Intent i =new Intent(Menu.this,pt2a.class);
        startActivity(i);
    }
    public void giaiBptb2(View v) {
        Intent i = new Intent(Menu.this, bptb2.class);
        startActivity(i);
    }
    public void pt3a(View v) {
        Intent i = new Intent(Menu.this, pt3a.class);
        startActivity(i);
    }
    public void doicoso(View v) {
        Intent i = new Intent(Menu.this, DoiCoSo.class);
        startActivity(i);
    }
    public void backUclnBcnn(View v) {
        Intent i = new Intent(Menu.this, UclnBcnn.class);
        startActivity(i);
    }
}
