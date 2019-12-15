package com.example.calculationfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edtNumber;
    private TextView tvResult;
    private Double Ans;
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnPlus,btnSub,btnMul,btnDiv,btnResult,btnPoint,btnDel,btnAC,btnPi,btnAns;
    private Button btnSin,btnCos,btnTan,btnAbs,btnCan,btnMu,btnMoNgoac,btnDongNgoac,btnGiaiThua, btnLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWedget();
        setEventClickView();
    }

    public void initWedget() {
        edtNumber=findViewById(R.id.edt_input);
        tvResult=findViewById(R.id.tv_result);
        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        btnPlus=findViewById(R.id.btnPlus);
        btnSub=findViewById(R.id.btnSub);
        btnMul=findViewById(R.id.btnMul);
        btnDiv=findViewById(R.id.btnDiv);
        btnResult=findViewById(R.id.btnResult);
        btnPoint=findViewById(R.id.btnPoint);
        btnDel=findViewById(R.id.btnDel);
        btnAC=findViewById(R.id.btnAC);
        btnSin=findViewById(R.id.btnsin);
        btnPi=findViewById(R.id.btnPi);
        btnAns=findViewById(R.id.btnAns);

        btnCos=findViewById(R.id.btncos);
        btnTan=findViewById(R.id.btntan);
        btnAbs=findViewById(R.id.btnAbs);
        btnCan=findViewById(R.id.btnCan);
        btnMu=findViewById(R.id.btnMu);
        btnMoNgoac=findViewById(R.id.btnMongoac);
        btnDongNgoac=findViewById(R.id.btnDongngoac);
        btnGiaiThua=findViewById(R.id.btnGiaithua);
        btnLog=findViewById(R.id.btnlog);
    }
    public void setEventClickView() {
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnPoint.setOnClickListener(this);
        btnResult.setOnClickListener(this);
        btnAC.setOnClickListener(this);
        btnDel.setOnClickListener(this);

        btnSin.setOnClickListener(this);
        btnCos.setOnClickListener(this);
        btnTan.setOnClickListener(this);
        btnAbs.setOnClickListener(this);
        btnMu.setOnClickListener(this);
        btnCan.setOnClickListener(this);
        btnMoNgoac.setOnClickListener(this);
        btnDongNgoac.setOnClickListener(this);
        btnGiaiThua.setOnClickListener(this);
        btnLog.setOnClickListener(this);
        btnPi.setOnClickListener(this);
        btnAns.setOnClickListener(this);
    }
    public void onClickAdd(View v) {
        Intent intent=new Intent(MainActivity.this,Menu.class);
        startActivity(intent);
    }
    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn0: {
                edtNumber.append("0");
                break;
            }
            case R.id.btn1: {
                edtNumber.append("1");
                break;
            }
            case R.id.btn2: {
                edtNumber.append("2");
                break;
            }
            case R.id.btn3: {
                edtNumber.append("3");
                break;
            }
            case R.id.btn4: {
                edtNumber.append("4");
                break;
            }
            case R.id.btn5: {
                edtNumber.append("5");
                break;
            }
            case R.id.btn6: {
                edtNumber.append("6");
                break;
            }
            case R.id.btn7: {
                edtNumber.append("7");
                break;
            }
            case R.id.btn8: {
                edtNumber.append("8");
                break;
            }
            case R.id.btn9: {
                edtNumber.append("9");
                break;
            }
            case R.id.btnPi: {
                edtNumber.append("-");
                break;
            }
            case R.id.btnAns: {
                tvResult.setText(""+Ans);
                break;
            }
            case R.id.btnPlus: {
                edtNumber.append("+");
                break;
            }
            case R.id.btnSub: {
                edtNumber.append("-");
                break;
            }
            case R.id.btnMul: {
                edtNumber.append("x");
                break;
            }
            case R.id.btnDiv: {
                edtNumber.append("/");
                break;
            }
            case R.id.btnMongoac: {
                edtNumber.append("(");
                break;
            }
            case R.id.btnDongngoac: {
                edtNumber.append(")");
                break;
            }
            case R.id.btnResult: {
                if(edtNumber.getText().toString().length()== 0){
                    Toast.makeText(MainActivity.this,"Bạn chưa nhập biểu thức!",Toast.LENGTH_SHORT).show();
                    return;
                }
                DecimalFormat dcf=new DecimalFormat("###.#####");
                addOperation(edtNumber.getText().toString());
                addNumber(edtNumber.getText().toString());
                double result=0;

                if(arrNumber.size() == 1) {
                    result= arrNumber.get(0);
                }else {
                    result=tinhTatCa();

                }
                tvResult.setText(dcf.format(result)+"");
                Ans= result;
                break;
            }
            case R.id.btnPoint: {
                edtNumber.append(".");
                break;
            }
            case R.id.btnDel: {
                if(edtNumber.getText().toString().length() == 0 ){
                    edtNumber.setText(" ");
                }
                String temp= clearOneNumber(edtNumber.getText().toString());
                edtNumber.setText("");
                edtNumber.append(temp);
                break;
            }
            case R.id.btnAC: {
                edtNumber.setText("");
                tvResult.setText("");
                break;
            }
            case R.id.btnsin: {
                if(edtNumber.getText().toString().length()== 0){
                    Toast.makeText(MainActivity.this,"Bạn chưa nhập biểu thức!",Toast.LENGTH_SHORT).show();
                    return;
                }
                DecimalFormat dcf=new DecimalFormat("###.#####");
                addOperation(edtNumber.getText().toString());
                addNumber(edtNumber.getText().toString());
                double result=0;

                if(arrNumber.size() == 1) {
                    result= arrNumber.get(0);
                }else {
                    result=tinhTatCa();

                }
                Double v= result;
                while(result>360) {
                    result-=360;
                }
                result=Math.PI*result/180;
                Double res=Math.sin(result);
                tvResult.setText("sin("+v+")="+dcf.format(res));
                Ans = res;
                break;
            }
            case R.id.btncos: {
                if(edtNumber.getText().toString().length()== 0){
                    Toast.makeText(MainActivity.this,"Bạn chưa nhập biểu thức!",Toast.LENGTH_SHORT).show();
                    return;
                }
                DecimalFormat dcf=new DecimalFormat("###.#####");
                addOperation(edtNumber.getText().toString());
                addNumber(edtNumber.getText().toString());
                double result=0;

                if(arrNumber.size() == 1) {
                    result= arrNumber.get(0);
                }else {
                    result=tinhTatCa();

                }
                Double v= result;
                while(result>360) {
                    result-=360;
                }
                result=Math.PI*result/180;
                Double res=Math.cos(result);
                tvResult.setText("cos("+v+")="+dcf.format(res));
                Ans = res;
                break;
            }
            case R.id.btntan: {
                if(edtNumber.getText().toString().length()== 0){
                    Toast.makeText(MainActivity.this,"Bạn chưa nhập biểu thức!",Toast.LENGTH_SHORT).show();
                    return;
                }
                DecimalFormat dcf=new DecimalFormat("###.#####");
                addOperation(edtNumber.getText().toString());
                addNumber(edtNumber.getText().toString());
                double result=0;

                if(arrNumber.size() == 1) {
                    result= arrNumber.get(0);
                }else {
                    result=tinhTatCa();

                }
                Double v= result;
                while(result>360) {
                    result-=360;
                }
                result=Math.PI*result/180;
                Double res=Math.tan(result);
                tvResult.setText("tan("+v+")="+dcf.format(res));
                Ans = res;
                break;
            }
            case R.id.btnAbs: {
                if(edtNumber.getText().toString().length()== 0){
                    Toast.makeText(MainActivity.this,"Bạn chưa nhập biểu thức!",Toast.LENGTH_SHORT).show();
                    return;
                }
                DecimalFormat dcf=new DecimalFormat("###.#####");
                addOperation(edtNumber.getText().toString());
                addNumber(edtNumber.getText().toString());
                double result=0;

                if(arrNumber.size() == 1) {
                    result= arrNumber.get(0);
                }else {
                    result=tinhTatCa();

                }
                Double res=Math.abs(result);
                tvResult.setText("|"+result+"|="+res);
                Ans = res;
                break;
            }
            case R.id.btnGiaithua: {
                if(edtNumber.getText().toString().length()== 0){
                    Toast.makeText(MainActivity.this,"Bạn chưa nhập biểu thức!",Toast.LENGTH_SHORT).show();
                    return;
                }
                int temp=Integer.parseInt(edtNumber.getText().toString());
                long res=giaithua(temp);
                tvResult.setText(temp+"!="+res);
                Ans = (double)res;
                break;
            }
            case R.id.btnCan: {
                if(edtNumber.getText().toString().length()== 0){
                    Toast.makeText(MainActivity.this,"Bạn chưa nhập biểu thức!",Toast.LENGTH_SHORT).show();
                    return;
                }
                DecimalFormat dcf=new DecimalFormat("###.#####");
                addOperation(edtNumber.getText().toString());
                addNumber(edtNumber.getText().toString());
                double result=0;

                if(arrNumber.size() == 1) {
                    result= arrNumber.get(0);
                }else {
                    result=tinhTatCa();
                }
                Double res=Math.sqrt(result);
                tvResult.setText("√"+result+"="+dcf.format(res));
                Ans = res;
                break;
            }
            case R.id.btnlog: {
                if(edtNumber.getText().toString().length()== 0){
                    Toast.makeText(MainActivity.this,"Bạn chưa nhập biểu thức!",Toast.LENGTH_SHORT).show();
                    return;
                }
                DecimalFormat dcf=new DecimalFormat("###.#####");
                addOperation(edtNumber.getText().toString());
                addNumber(edtNumber.getText().toString());
                double result=0;

                if(arrNumber.size() == 1) {
                    result= arrNumber.get(0);
                }else {
                    result=tinhTatCa();
                }
                Double res=Math.log10(result);
                tvResult.setText("log"+result+"="+dcf.format(res));
                Ans = res;
                break;
            }
            case R.id.btnMu: {
                if(edtNumber.getText().toString().length()== 0){
                    Toast.makeText(MainActivity.this,"Bạn chưa nhập biểu thức!",Toast.LENGTH_SHORT).show();
                    return;
                }
                DecimalFormat dcf=new DecimalFormat("###.#####");
                addOperation(edtNumber.getText().toString());
                addNumber(edtNumber.getText().toString());
                double result=0;

                if(arrNumber.size() == 1) {
                    result= arrNumber.get(0);
                }else {
                    result=tinhTatCa();
                }
                tvResult.setText(""+result+"^2="+dcf.format(result*result));
                Ans = result*result;
                break;
            }
        }
    }

    public String clearOneNumber(String number) {
        return number.substring(0,number.length()-1);
    }


    private ArrayList<String> arrOperation;
    private ArrayList<Double> arrNumber;


    public void addOperation(String number) {
        arrOperation = new ArrayList<String>();
        char[] letter = number.toCharArray();
        int check=0;
        for (int i = 1; i < letter.length-1; i++) {
            if (letter[i] == '(' || letter[i] == ')') {
                check =1;
                break;
            }
        }
        for (int i = 0; i < letter.length; i++) {
            int kt=0;
            if (letter[i] == '+') {
                if(letter[i+1]=='-') {
                    arrOperation.add('-' + "");
                    i++;
                    kt=1;
                }else
                    arrOperation.add('+' + "");

            }
            if (letter[i] == '-' && letter[i + 1] == '-') {
                arrOperation.add('+' + "");
                i++;
            }
            if (letter[i] == '-' && letter[i - 1] == '+') {
                arrOperation.add('-' + "");
            }
            if (letter[i] == 'x') {
                arrOperation.add('*' + "");
            }
            if (letter[i] == '/') {
                arrOperation.add('/' + "");
            }
            if (letter[i] == '(' && (check == 1 || (check ==0 && i!=0))) {
                arrOperation.add('(' + "");
            }
            if (letter[i] == ')' && (check == 1 || (check ==0 && i!=letter.length-1))) {
                arrOperation.add(')' + "");
            }
            if(kt == 0)
            if (letter[i] == '-') {
                arrOperation.add('-' + "");
            }
        }
    }

    public void addNumber(final String number) {
        arrNumber=new ArrayList<Double>();
        Pattern regex=Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher=regex.matcher(number);
        while(matcher.find()) {
            arrNumber.add(Double.valueOf(matcher.group(1)));
        }
    }

    private ArrayList<String> arrStrSum;

    public void ganMang() {
        arrStrSum = new ArrayList<String>();
        int i = 0, j = 0;
        while (true) {
            if (i < arrNumber.size()) {
                String s = Double.toString(arrNumber.get(i));
                arrStrSum.add(s);
                i++;
            }
            if (j < arrOperation.size()) {
                if (j <= arrOperation.size() - 2 && (arrOperation.get(j + 1).compareTo("(") == 0)) {
                    arrStrSum.add(arrOperation.get(j));
                    arrStrSum.add(arrOperation.get(j + 1));
                    j = j + 2;
                } else {
                    if (j <= arrOperation.size() - 2 && arrOperation.get(j).compareTo(")") == 0) {
                        arrStrSum.add(arrOperation.get(j));
                        arrStrSum.add(arrOperation.get(j + 1));
                        j = j + 2;
                    } else {
                        arrStrSum.add(arrOperation.get(j));
                        j++;
                    }
                }
            }
            if (i == arrNumber.size() && j == arrOperation.size()) {
                break;
            }
        }
    }
    public void mulAndDiv(int b,int k) {

        double temp = 0;
        for (int i = b; i <= k - 1; i++) {
            if (arrStrSum.get(i).compareTo("*") == 0) {
                temp = Double.parseDouble(arrStrSum.get(i - 1)) * Double.parseDouble(arrStrSum.get(i + 1));
            }
            if (arrStrSum.get(i).compareTo("/") == 0) {
                temp = Double.parseDouble(arrStrSum.get(i - 1)) / Double.parseDouble(arrStrSum.get(i + 1));
            }
            if (arrStrSum.get(i).compareTo("*") == 0 || arrStrSum.get(i).compareTo("/") == 0) {
                arrStrSum.remove(i + 1);
                arrStrSum.add(i + 1, String.valueOf(temp));
                arrStrSum.remove(i);
                arrStrSum.remove(i - 1);
                i = i - 2;
                k = k - 2;
            }
        }
    }
    public void tinhTrongNgoac ( int i, int j){
        int index = 0;
        int check = 0;
        double temp;
        mulAndDiv(i + 1, j - 1);

        for (int t = i + 1; t < arrStrSum.size(); t++) {
            if (arrStrSum.get(t).compareTo("+") == 0 || arrStrSum.get(t).compareTo("-") == 0) {
                check = 1;
            }
            if (arrStrSum.get(t).compareTo(")") == 0) {
                index = t;
                break;
            }
        }
        if(i+1 == index-1) {
            temp=Double.parseDouble(arrStrSum.get(i+1));
        }else {
            temp = addAndSub(arrStrSum, i + 1, index);
        }

        if (check == 1) {
            for (int t = i; t <= index; t++) {
                arrStrSum.remove(t);
                index--;
                t--;
            }
            arrStrSum.add(i, String.valueOf(temp).toString());

        } else {
            arrStrSum.remove(index);
            arrStrSum.remove(i);
        }
    }

    public double addAndSub(ArrayList<String> s,int b,int k) {
        double result = 0;
        if(arrStrSum.size()==1) {
            result=Double.parseDouble(arrStrSum.get(0));
        }
        else {
            if (s.get(b + 1).compareTo("+") == 0) {
                result += Double.parseDouble(s.get(b + 0)) + Double.parseDouble(s.get(b + 2));
            }
            if (s.get(b + 1).compareTo("-") == 0) {
                result += (Double.parseDouble(s.get(b + 0)) - Double.parseDouble(s.get(b + 2)));
            }
            for (int i = b + 3; i < k; i = i + 2) {
                if (s.get(i).compareTo("+") == 0) {
                    result += Double.parseDouble(s.get(i + 1));

                } else {
                    result -= Double.parseDouble(s.get(i + 1));
                }
            }
        }

        return result;
    }
    public double tinhTatCa() {
        addNumber(edtNumber.getText().toString());
        addOperation(edtNumber.getText().toString());
        ganMang();
        double result = 0;
        int b = 0, k=0;
        for (int i = 0; i < arrStrSum.size(); i++) {
            if (arrStrSum.get(i).compareTo("(") == 0) {
                b = i;
            }
            if (arrStrSum.get(i).compareTo(")") == 0) {
                k = i;
                tinhTrongNgoac(b, k);
            }
        }
        mulAndDiv(0, arrStrSum.size()-1);
        result=addAndSub(arrStrSum, 0, arrStrSum.size() - 1);
        return result;
    }

    private long giaithua(int n) {
        if(n==0) return 1;
        if(n==1) return n;
        return n*giaithua(n-1);
    }
}
