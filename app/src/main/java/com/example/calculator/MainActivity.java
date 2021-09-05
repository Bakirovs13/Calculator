package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;  //  // поле для ввода числа
    private Integer firstValue, secondValue;
    private String operation;
    private String result;
    private boolean isOperationFinished = false;
    private Button btnShare;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tv_result);
        btnShare = findViewById(R.id.btn_share);

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                String text = tvResult.getText().toString();
                intent.putExtra("Key", text);
                startActivity(intent);
            }
        });

    }


    public void onNumberClick(View view) {
        btnShare.setVisibility(View.GONE);
        if (isOperationFinished) {
            tvResult.setText("");
        } else isOperationFinished = false;

        switch (view.getId()) {
            case R.id.btn_clear:
                tvResult.setText("");
                break;
            case R.id.btn_zero:
                tvResult.append("0");
                break;
            case R.id.btn_one:
                if (tvResult.getText().toString().equals("0")) {
                    tvResult.setText("1");
                } else {
                    tvResult.append("1");
                }
                break;

            case R.id.btn_two:
                if (tvResult.getText().toString().equals("0")) {
                    tvResult.setText("2");
                } else {
                    tvResult.append("2");
                }
                break;
            case R.id.btn_three:
                if (tvResult.getText().toString().equals("0")) {
                    tvResult.setText("3");
                } else {
                    tvResult.append("3");
                }
                break;
            case R.id.btn_four:
                if (tvResult.getText().toString().equals("0")) {
                    tvResult.setText("4");
                } else {
                    tvResult.append("4");
                }
                break;
            case R.id.btn_five:
                if (tvResult.getText().toString().equals("0")) {
                    tvResult.setText("5");
                } else {
                    tvResult.append("5");
                }
                break;
            case R.id.btn_six:
                if (tvResult.getText().toString().equals("0")) {
                    tvResult.setText("6");
                } else {
                    tvResult.append("6");
                }
                break;
            case R.id.btn_seven:
                if (tvResult.getText().toString().equals("0")) {
                    tvResult.setText("7");
                } else {
                    tvResult.append("7");
                }
                break;
            case R.id.btn_eight:
                if (tvResult.getText().toString().equals("0")) {
                    tvResult.setText("8");
                } else {
                    tvResult.append("8");
                }
                break;
            case R.id.btn_nine:
                if (tvResult.getText().toString().equals("0")) {
                    tvResult.setText("9");
                } else {
                    tvResult.append("9");
                }
                break;

        }
    }


    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.btn_multiply:
                firstValue = Integer.parseInt(tvResult.getText().toString());
                operation = "*";
                tvResult.setText(firstValue + operation);
                break;

            case R.id.btn_divide:
                firstValue = Integer.parseInt(tvResult.getText().toString());
                operation = "/";
                tvResult.setText(firstValue + operation);
                break;


            case R.id.btn_minus:
                firstValue = Integer.parseInt(tvResult.getText().toString());
                operation = "-";
                tvResult.setText(firstValue + operation);
                break;

            case R.id.btn_plus:
                firstValue = Integer.parseInt(tvResult.getText().toString());
                operation = "+";
                tvResult.setText(firstValue + operation);
                break;

            case R.id.btn_equal:
                String two = tvResult.getText().toString()
                        .replace(firstValue + operation, "");
                secondValue = Integer.parseInt(two);
                btnShare.setVisibility(View.VISIBLE);
                switch (operation) {

                    case "+":
                        result = String.valueOf(firstValue + secondValue);
                        tvResult.setText(firstValue + operation + secondValue + "=" + result);
                        break;
                    case "-":
                        result = String.valueOf(firstValue - secondValue);
                        tvResult.setText(firstValue + operation + secondValue + "=" + result);
                        break;
                    case "*":
                        result = String.valueOf(firstValue * secondValue);
                        tvResult.setText(firstValue + operation + secondValue + "=" + result);
                        break;

                    case "/":
                        result = String.valueOf(firstValue / secondValue);
                        tvResult.setText(firstValue + operation + secondValue + "=" + result);
                        break;
                }
                isOperationFinished = true;

                // operation = "=";
                break;
        }

    }
}