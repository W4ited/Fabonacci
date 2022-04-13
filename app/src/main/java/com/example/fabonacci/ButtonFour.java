package com.example.fabonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;

public class ButtonFour extends AppCompatActivity {
    private TextView get_four,count_four,time_four,time_min;
    private TextView click;
    private int num=0;
    public  int count1=3;

    private BigDecimal startTime, endTime;  //时间计算

    private BigDecimal divisor = new BigDecimal(1000000000);    //作为除数将纳秒转化成秒

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_four);

        //获取迭代得到的最大整数的斐波那契数
        click = (TextView) findViewById(R.id.click);
        count_four = (TextView) findViewById(R.id.count_four);
        get_four = (TextView) findViewById(R.id.get_four);
        time_four = (TextView) findViewById(R.id.time_four);
        time_min = (TextView) findViewById(R.id.time_min);
        iteration_int();
        num = count1-1;
        //num = buttonTwo.iteration_int();                      //最大整数斐波那契

        get_four.setText(Integer.toString(num));

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTime = BigDecimal.valueOf(System.nanoTime());
                count_four.setText(Integer.toString(recursion(num)));
                endTime = BigDecimal.valueOf(System.nanoTime());
                BigDecimal bigDecimal = (endTime.subtract(startTime)).divide(divisor);
                time_four.setText(bigDecimal.toString());

                BigDecimal minBigDecimal = new BigDecimal(60);
                int flag = bigDecimal.compareTo(minBigDecimal);
                if(flag ==1){
                    time_min.setText("否");
                }
                if(flag <=1){
                    time_min.setText("是");
                }
            }
        });

    }

    /*
   递归计算斐波那契数列
   指的是这样一个数列：1、1、2、3、5、8、13、21、34、……
   */
    public int recursion(int n) {
        if (n == 1 || n == 2) {
            return 1;                                       //保证前两个数为1

        }
        if (n > 2) {
            return recursion(n - 1) + recursion(n - 2);     //递归调用
        }
        return -1;
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
}