package com.example.calculationfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class pt3a extends AppCompatActivity {

    private EditText edit_a,edit_b,edit_c,edit_d,edit_a1,edit_b1,edit_c1,edit_d1,edit_a2,edit_b2,edit_c2,edit_d2;
    Double a,b,c,d,a1,b1,c1,d1,a2,b2,c2,d2,D,Dx,Dy,Dz,x,y,z;
    private TextView tv_res ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pt3a);

        edit_a = findViewById(R.id.edt_a);
        edit_b = findViewById(R.id.edt_b);
        edit_c = findViewById(R.id.edt_c);
        edit_d = findViewById(R.id.edt_d);
        edit_a1 = findViewById(R.id.edt_a1);
        edit_b1 = findViewById(R.id.edt_b1);
        edit_c1 = findViewById(R.id.edt_c1);
        edit_d1 = findViewById(R.id.edt_d1);
        edit_a2 = findViewById(R.id.edt_a2);
        edit_b2 = findViewById(R.id.edt_b2);
        edit_c2 = findViewById(R.id.edt_c2);
        edit_d2 = findViewById(R.id.edt_d2);
        tv_res=findViewById(R.id.tv_result);

    }
    public void onClickResult(View v) {
        //kiem tra nhap
        if(!checkInput(edit_a.getText().toString(),edit_a1.getText().toString(),edit_a2.getText().toString(),edit_b.getText().toString(),edit_b1.getText().toString(),edit_b2.getText().toString(),
                edit_c.getText().toString(),edit_c1.getText().toString(),edit_c2.getText().toString(),edit_d.getText().toString(),edit_d1.getText().toString(),edit_d2.getText().toString())) {
            Toast.makeText(pt3a.this, "Bạn chưa nhập đủ", Toast.LENGTH_SHORT).show();
            return;
        }
        if((!checkIsNumber(edit_a.getText().toString())||(!checkIsNumber(edit_b.getText().toString()))||(!checkIsNumber(edit_c.getText().toString()))||(!checkIsNumber(edit_d.getText().toString()))||
                (!checkIsNumber(edit_a1.getText().toString()))||(!checkIsNumber(edit_b1.getText().toString()))||(!checkIsNumber(edit_c1.getText().toString()))||(!checkIsNumber(edit_d2.getText().toString()))||
                (!checkIsNumber(edit_a2.getText().toString()))||(!checkIsNumber(edit_b2.getText().toString()))||(!checkIsNumber(edit_c2.getText().toString())))||(!checkIsNumber(edit_d2.getText().toString()))) {
            Toast.makeText(pt3a.this,"Nhập sai, hãy nhập lại",Toast.LENGTH_SHORT).show();
            return;
        }
        a=Double.parseDouble(edit_a.getText().toString());
        b=Double.parseDouble(edit_b.getText().toString());
        c=Double.parseDouble(edit_c.getText().toString());
        d=Double.parseDouble(edit_d.getText().toString());
        a1=Double.parseDouble(edit_a1.getText().toString());
        b1=Double.parseDouble(edit_b1.getText().toString());
        c1=Double.parseDouble(edit_c1.getText().toString());
        d1=Double.parseDouble(edit_d1.getText().toString());
        a2=Double.parseDouble(edit_a2.getText().toString());
        b2=Double.parseDouble(edit_b2.getText().toString());
        c2=Double.parseDouble(edit_c2.getText().toString());
        d2=Double.parseDouble(edit_d2.getText().toString());
        D =(a*b1*c2 + a2*b*c1 + a1*b2*c) -(a2*b1*c + a1*b*c2 + a*b2*c1);
        Dx=(d*b1*c2 + d2*b*c1 + d1*b2*c) -(d2*b1*c + d1*b*c2 + d*b2*c1);
        Dy=(a*d1*c2 + a2*d*c1 + a1*d2*c) -(a2*d1*c + a1*d*c2 + a*d2*c1);
        Dz=(a*b1*d2 + a2*b*d1 + a1*b2*d) -(a2*b1*d + a1*b*d2 + a*b2*d1);
        if (D == 0) {
            if (Dx ==0 && Dy == 0 && Dz == 0)
                tv_res.setText("He phuong trinh co vo so nghiem");
            else
                tv_res.setText("He phuong trinh vo nghiem");
        }
        else {
            x = Dx / D;
            y = Dy / D;
            z=  Dz / D;
            tv_res.setText("x ="+ x +"\ny ="+y +"\nz ="+z);
        }
    }
    public void onClickDelete(View v) {
        edit_a.setText("");
        edit_b.setText("");
        edit_c.setText("");
        edit_d.setText("");
        edit_a1.setText("");
        edit_b1.setText("");
        edit_c1.setText("");
        edit_d1.setText("");
        edit_a2.setText("");
        edit_b2.setText("");
        edit_c2.setText("");
        edit_d2.setText("");
        tv_res.setText("");
    }
    boolean checkIsNumber(String string) {
        char[] arr=string.toCharArray();
        if(string.length()==1) {
            if( (arr[0]>='0' && arr[0]<='9')) {
                return true;
            }
            return false;
        }
        for(int i=1;i<arr.length;i++) {
            if(arr[0]=='-'|| (arr[0]>='0' && arr[0]<='9')) {
                if(arr[i]<'0' || arr[i]>'9') {
                    return false;
                }
            }else {
                return false;
            }

        }
        return true;
    }
    boolean checkInput(String a,String b,String c ,String d,String a1,String b1,String c1 ,String d1,String a2,String b2,String c2 ,String d2) {
        if(a.length()==0||b.length()==0||c.length()==0 || d.length()==0||a1.length()==0||b1.length()==0||c1.length()==0 || d1.length()==0||a2.length()==0||b2.length()==0||c2.length()==0 || d2.length()==0) {
            return false;
    }
        return true;
    }
    public void  backMenu (View v) {
        Intent i = new Intent(pt3a.this, Menu.class);
        startActivity(i);
    }
}
