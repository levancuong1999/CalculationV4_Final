package com.example.calculationfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DoiCoSo extends AppCompatActivity {
    EditText edtResult,edtInput,edtValue,edtOutput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doi_co_so);
        edtResult=findViewById(R.id.edt_res);
        edtInput=findViewById(R.id.edt_input);
        edtValue=findViewById(R.id.edt_value);
        edtOutput=findViewById(R.id.edt_output);

    }
    public void clickGiai(View v) {
        if((!checkIsNumber(edtOutput.getText().toString()))||(!checkIsNumber( edtInput.getText().toString())) ||(!checkIsNumber( edtValue.getText().toString()))){
            Toast.makeText(DoiCoSo.this,"Nhập sai kiểu dữ liệu,xin nhập lại!",Toast.LENGTH_SHORT).show();
            return;
        }
        if(!checkInput(edtOutput.getText().toString(),edtInput.getText().toString(),edtValue.getText().toString())) {
            Toast.makeText(DoiCoSo.this,"Chưa nhập đủ dữ liệu!",Toast.LENGTH_SHORT).show();
            return;
        }
        if(Integer.parseInt(edtValue.getText().toString())<0) {
            Toast.makeText(DoiCoSo.this,"Bạn cần nhập vào số nguyên dương.",Toast.LENGTH_SHORT).show();
            return;
        }
            int firstBase=Integer.parseInt(edtInput.getText().toString());
            String number= (edtValue.getText().toString());
            int secondBase=Integer.parseInt(edtOutput.getText().toString());

            if (firstBase != 10 && secondBase == 10) {
                edtResult.setText("" + convertDecimal(number, firstBase));
            } else {

                if (firstBase == 10 && secondBase != 10) {
                    edtResult.setText("" + convert(number, secondBase));
                } else {
                    String temp = convertDecimal(number, firstBase);
                    edtResult.setText("" + convert(temp, secondBase));
                }
            }
    }

    public void clickXoa(View v) {
        edtInput.setText("");
        edtOutput.setText("");
        edtValue.setText("");
        edtResult.setText("");
    }

    private static boolean isDecimal(String s) {
        if (s.contains(".")) {
            return true;
        }
        return false;
    }

    private static String partDecimal(String s) {
        char[] letters = s.toCharArray();
        int index = 0;
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == '.') {
                index = i;
                break;
            }
        }
        return s.substring(index + 1);
    }

    private static int findIndex(String s) {
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                index = i;
                break;
            }
        }
        return index;
    }

    private static String partUnBroken(String s) {
        return s.substring(0, findIndex(s));

    }

    private static String divRemainder(String number, int secondBase) {
        int temp = Integer.parseInt(number);
        String s = "";
        while (temp != 0) {
            s += convertString(temp % secondBase);
            temp /= secondBase;
        }
        char[] character = s.toCharArray();
        s = "";
        for (int i = character.length - 1; i >= 0; i--) {
            s += character[i];
        }
        return s;
    }

    private static String mulPartDecimal(String partDecimal, int secondBase) {
        String var = "0." + partDecimal;
        String s = "";
        String temp;
        int count = 0;
        while (var.compareTo("0.0") != 0) {
            temp = String.valueOf(Double.parseDouble(var) * secondBase);
            count++;
            int n = Integer.parseInt(partUnBroken(temp));
            String t = convertString(n);
            temp = temp.replace(String.valueOf(n), t);
            s += t;
            var = (temp).replace(t, "0");

            if (count > 15)
                break;
        }
        return s;

    }

    private static int convertNumber(char c) {
        char[] letter = { 'A', 'B', 'C', 'D', 'E', 'F' };
        for (int i = 0; i < letter.length; i++) {
            if (c == letter[i]) {
                return 10 + i;
            }
        }
        return Integer.parseInt(c + "");
    }

    private static String convertString(int number) {
        char[] charracter = { 'A', 'B', 'C', 'D', 'E', 'F' };
        if (number > 9) {
            return charracter[number - 10] + "";
        } else {
            return String.valueOf(number);
        }
    }

    private static String convertDecimal(String s, int firstBase) {
        double result = 0;
        int length = s.length() - 1;
        int index = 0;

        if (isDecimal(s)) {
            String partUnBroken = partUnBroken(s);
            String partDecimal = partDecimal(s);
            int temp = partUnBroken.length() - 1;
            while (temp >= 0) {
                result += convertNumber(partUnBroken.charAt(index)) * Math.pow(firstBase, temp);
                index++;
                temp--;
            }
            int var = partDecimal.length();
            while (var != 0) {
                result += convertNumber(partDecimal.charAt(var - 1)) * Math.pow(firstBase, -var);
                var--;
            }
            return String.valueOf(result);
        } else {
            while (length >= 0) {
                result += (convertNumber(s.charAt(index))) * Math.pow(firstBase, length);
                index++;
                length--;
            }
            return String.valueOf((int) result);
        }
    }

    private static String convert(String s, int secondBase) {
        double temp = Double.parseDouble(s);
        int number = (int) temp;
        if (isDecimal(s)) {

            return divRemainder(String.valueOf(number), secondBase) + "." + mulPartDecimal(partDecimal(s), secondBase);
        } else {
            return divRemainder(String.valueOf(number), secondBase);
        }
    }
    //bat dieu kien

    public boolean checkIsNumber(String string) {
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
    public boolean checkInput(String a,String b,String c) {
        if(a.length()==0||b.length()==0||c.length()==0) {
            return false;
        }
        return true;
    }
    public void backMenu(View v){
            Intent i = new Intent(DoiCoSo.this, Menu.class);
            startActivity(i);
    }





}
