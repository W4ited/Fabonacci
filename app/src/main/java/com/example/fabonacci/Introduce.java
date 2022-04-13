package com.example.fabonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


/*
第一个按钮 题目说明
 */
public class Introduce extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce);

        textView = (TextView) findViewById(R.id.introduce);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击题目，出现Toast提示
                Toast.makeText(Introduce.this,"You click the Introduce",Toast.LENGTH_LONG).show();
            }
        });
    }
}