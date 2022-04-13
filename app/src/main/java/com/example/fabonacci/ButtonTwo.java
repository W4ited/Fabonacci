package com.example.fabonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.math.BigDecimal;

public class ButtonTwo extends AppCompatActivity {

    private TextView title;
    private TextView maxNumber1,maxNumber2,maxTime1,maxTime2;       //用于显示找到的最大整数和时间
    private TextView result1,result2;
    private BigDecimal startTime1, startTime2;          //用于计算时间--开始
    private BigDecimal endTime1, endTime2;              //用于计算时间--结束

    public  int count1=3;
    private long count2=3;

    private BigDecimal divisor = new BigDecimal(1000000000);    //作为除数将纳秒转化成秒

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_two);

        maxNumber1 = (TextView) findViewById(R.id.maxNumber1);
        maxNumber2 = (TextView) findViewById(R.id.maxNumber2);
        result1 = (TextView) findViewById(R.id.result1);
        result2 = (TextView) findViewById(R.id.result2);
        maxTime1 = (TextView) findViewById(R.id.maxTime1);
        maxTime2 = (TextView) findViewById(R.id.maxTime2);
        title = (TextView) findViewById(R.id.title);
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTime1 = BigDecimal.valueOf(System.nanoTime());
                result1.setText(Integer.toString(iteration_int()));
                maxNumber1.setText(Integer.toString(count1-1));
                endTime1 = BigDecimal.valueOf(System.nanoTime());
                BigDecimal bigDecimal1 = (endTime1.subtract(startTime1)).divide(divisor);
                maxTime1.setText(bigDecimal1.toString());

                startTime2 = BigDecimal.valueOf(System.nanoTime());
                result2.setText(Long.toString(iteration_long()));
                maxNumber2.setText(Long.toString(count2-1));
                endTime2 = BigDecimal.valueOf(System.nanoTime());
                BigDecimal bigDecimal2 = (endTime2.subtract(startTime2)).divide(divisor);
                maxTime2.setText(bigDecimal2.toString());
            }
        });

    }

    /*
        用迭代法寻找编程环境支持的最大整数(int型)的斐波那契数是第几个斐波那契数
         */
    public int iteration_int() {
        int a = 1, b = 1, c = 2;
        for (; b < c; ) {               //一旦c达到编程环境最大斐波那契数，便会产生内存溢出，从而变成一个负数，到此循环结束
            a = b;
            b = c;
            c = a + b;
            count1++;
        }
        return b;
    }

    //用迭代法寻找编程环境支持的最大整数(long型)的斐波那契数是第几个斐波那契数
    public long iteration_long() {
        long a = 1, b = 1, c = 2;
        for (; b < c; ) {               //一旦c达到编程环境最大斐波那契数，便会产生内存溢出，从而变成一个负数，到此循环结束
            a = b;
            b = c;
            c = a + b;
            count2++;
        }
        return b;
    }
}