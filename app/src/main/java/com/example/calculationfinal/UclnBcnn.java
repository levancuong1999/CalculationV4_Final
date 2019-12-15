package com.example.calculationfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UclnBcnn extends AppCompatActivity {
    EditText edt_A,edt_B,edt_Res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ucln_bcnn);
        edt_A=findViewById(R.id.edt_a);
        edt_B=findViewById(R.id.edt_b);
        edt_Res=findViewById(R.id.edt_res);
    }

    public void clickUCLN(View v) {

        //kiem tra la so
        if((!checkIsNumber(edt_A.getText().toString())||(!checkIsNumber(edt_B.getText().toString())))){
            Toast.makeText(UclnBcnn.this,"Bạn nhập sai, hãy nhập lại!",Toast.LENGTH_SHORT).show();
            return;
        }
        //kiem tra nhap
        if(!checkInput(edt_A.getText().toString(),edt_B.getText().toString())) {
            Toast.makeText(UclnBcnn.this,"Chưa nhập số",Toast.LENGTH_SHORT).show();
            return;
        }
        if(Integer.parseInt(edt_A.getText().toString() )< 0 || Integer.parseInt(edt_B.getText().toString() )< 0  ){
            Toast.makeText(UclnBcnn.this,"Bạn số âm không thực hiện được , hãy nhập lại!",Toast.LENGTH_SHORT).show();
            return;
        }
            int a=Integer.parseInt(edt_A.getText().toString());
            int b=Integer.parseInt(edt_B.getText().toString());
            int ucln=UCLN(a,b);
            edt_Res.setText("UCLN:"+ucln);
    }

    public void clickBCNN(View v) {
        if((!checkIsNumber(edt_A.getText().toString())||(!checkIsNumber(edt_B.getText().toString())))){
            Toast.makeText(UclnBcnn.this,"Bạn nhập sai, hãy nhập lại!",Toast.LENGTH_SHORT).show();
            return;
        }
        //kiem tra nhap
        if(!checkInput(edt_A.getText().toString(),edt_B.getText().toString())) {
            Toast.makeText(UclnBcnn.this,"Chưa nhập số",Toast.LENGTH_SHORT).show();
            return;
        }
        if(Integer.parseInt(edt_A.getText().toString() )< 0 || Integer.parseInt(edt_B.getText().toString() )< 0  ){
            Toast.makeText(UclnBcnn.this,"Bạn số âm không thực hiện được , hãy nhập lại!",Toast.LENGTH_SHORT).show();
            return;
        }
            int a = Integer.parseInt(edt_A.getText().toString());
            int b = Integer.parseInt(edt_B.getText().toString());
            int bcnn = BCNN(a, b);
            edt_Res.setText("BCNN:" + bcnn);
    }

    public void clickXoa(View v) {
        edt_A.setText("");
        edt_B.setText("");
        edt_Res.setText("");
    }
    public int UCLN(int a,int b) {
        if(a==b) return a;
        if(a>b) return UCLN(a-b,b);
        return UCLN(a,b-a);
    }

    public int BCNN(int a,int b) {
        return (a*b)/UCLN(a,b);
    }

    //dk
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
    boolean checkInput(String a,String b) {
        if(a.length()==0||b.length()==0) {
            return false;
        }
        return true;
    }
    public void backMenu(View v) {
        Intent i = new Intent(UclnBcnn.this, Menu.class);
        startActivity(i);
    }
}
