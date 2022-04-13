package com.example.fabonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;

public class ButtonThree extends AppCompatActivity {
    private int n = 3;
    private int resultSum = 0, getResultSum_Preview;
    private BigDecimal startTime;
    private BigDecimal endTime;
    private TextView title;
    private TextView count, result, time;
    private BigDecimal divisor = new BigDecimal(1000000000);    //作为除数将纳秒转化成秒

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_three);


        count = (TextView) findViewById(R.id.count);
        result = (TextView) findViewById(R.id.result);
        time = (TextView) findViewById(R.id.time);
        title = (TextView) findViewById(R.id.title_recursion);
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTime = BigDecimal.valueOf(System.nanoTime());
                int a = 1, b = 1;
                while (true) {
                    b = a;
                    a = recursion(n);
                    if (a < 0) {
                        break;
                    }
                    n++;
                }
                result.setText(Integer.toString(b));
                count.setText(Integer.toString(n - 1));
                endTime = BigDecimal.valueOf(System.nanoTime());
                BigDecimal bigDecimal = (endTime.subtract(startTime)).divide(divisor);
                time.setText(bigDecimal.toString());
            }
        });


    }

    //递归算法
    public int recursion(int n) {
        if (n == 1 || n == 2) {
            return 1;                                       //保证前两个数为1
        }
        if (n > 2) {
            return recursion(n - 1) + recursion(n - 2);     //递归调用
        }
        return -1;
    }

}