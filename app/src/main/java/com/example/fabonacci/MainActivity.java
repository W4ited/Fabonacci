package com.example.fabonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button,button1,button2,button3,button4,button5,button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();     //初始化主页面的控件
    }

    private void init() {
        button = (Button) findViewById(R.id.button);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);      //各个按钮找到实例

        button.setOnClickListener(this);
        button1.setOnClickListener(this);               //因为设置了接口，设置点击事件
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
    }

    //按钮的点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                Intent intent = new Intent(MainActivity.this,Introduce.class);
                startActivity(intent);
                break;
            case R.id.button1:
                Intent intent_button1 = new Intent(MainActivity.this,ButtonOne.class);
                startActivity(intent_button1);
                break;
            case R.id.button2:
                Intent intent_button2 = new Intent(MainActivity.this,ButtonTwo.class);
                startActivity(intent_button2);
                break;
            case R.id.button3:
                Intent intent_button3 = new Intent(MainActivity.this,ButtonThree.class);
                startActivity(intent_button3);
                break;
            case R.id.button4:
                Intent intent_button4 = new Intent(MainActivity.this,ButtonFour.class);
                startActivity(intent_button4);
                break;
            case R.id.button5:
                Intent intent_button5 = new Intent(MainActivity.this,ButtonFive.class);
                startActivity(intent_button5);
                break;
            case R.id.button6:
                Intent intent_button6 = new Intent(MainActivity.this,ButtonSix.class);
                startActivity(intent_button6);
                break;
        }
    }
}