package com.example.androidchoi.mycalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TableLayout mTableLayout;
    EditText mEditFirst;
    EditText mEditSecond;
    EditText mEditResult;
    Boolean isClickOper = false;
    int oper_type = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTableLayout = (TableLayout)findViewById(R.id.table_layout);
        mEditFirst = (EditText)findViewById(R.id.editText);
        mEditSecond = (EditText)findViewById(R.id.editText2);
        mEditResult = (EditText)findViewById(R.id.editText3);
//
        int number = 0;
        //숫자 TableRow
        for(int i=0; i < mTableLayout.getChildCount()-3; i++ ){
            TableRow tableRow = (TableRow)mTableLayout.getChildAt(i);
            for(int j=0; j< tableRow.getChildCount(); j++){
                Button button =(Button)tableRow.getChildAt(j);
                button.setText(number + "");
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TextView textView = (TextView) v;
                        if (!isClickOper) {
                            mEditFirst.setText(mEditFirst.getText().toString() + textView.getText().toString());
                        } else {
                            mEditSecond.setText(mEditSecond.getText().toString() + textView.getText().toString());
                        }
                    }
                });
                number++;
            }
        }
        Button button;
        //계산 TableRow
        button= (Button)findViewById(R.id.button_add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isClickOper = true;
                oper_type = 1;
            }
        });
        button = (Button)findViewById(R.id.button_sub);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isClickOper = true;
                oper_type = 2;
            }
        });
        button = (Button)findViewById(R.id.button_mul);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isClickOper = true;
                oper_type = 3;
            }
        });
        button = (Button)findViewById(R.id.button_div);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isClickOper = true;
                oper_type = 4;
            }
        });

        button = (Button)findViewById(R.id.button_reset);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isClickOper = false;
                oper_type = 0;
                mEditFirst.setText("");
                mEditSecond.setText("");
                mEditResult.setText("");
            }
        });

        button = (Button)findViewById(R.id.button_result);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (oper_type){
                    case 1:
                        long a = Long.valueOf(mEditFirst.getText().toString());
                        long b = Long.valueOf(mEditSecond.getText().toString());
                        mEditResult.setText((a+b)+"");
                        break;

                    case 2:
                        a = Long.valueOf(mEditFirst.getText().toString());
                        b = Long.valueOf(mEditSecond.getText().toString());
                        mEditResult.setText((a - b) + "");
                        break;
                    case 3:
                        a = Long.valueOf(mEditFirst.getText().toString());
                        b = Long.valueOf(mEditSecond.getText().toString());
                        mEditResult.setText((a * b)+"");
                        break;
                    case 4:
                        a = Long.valueOf(mEditFirst.getText().toString());
                        b = Long.valueOf(mEditSecond.getText().toString());
                        mEditResult.setText((a / b)+"");
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "계산이 이루어지지 않았습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });








    }
}
