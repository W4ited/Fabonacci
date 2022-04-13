package com.example.fabonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.math.BigDecimal;

public class ButtonFive extends AppCompatActivity  implements View.OnClickListener{
    private TextView title_five,click_title;
    private TextView count_recursion_five, time_recursion_five;  //递归 30s内最大斐波那契 和 计算下一个的时间
    private TextView count_iteration_five, time_iteration_five;  //迭代 30s内最大斐波那契 和 计算下一个的时间
    private int n = 2;
    private int m = 2;
    private BigDecimal subtractTime,subtractTime2;
    private BigDecimal minBigDecimal = new BigDecimal(30);  //规定的30s

    private BigDecimal divisor = new BigDecimal(1000000000);    //作为除数将纳秒转化成秒

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_five);

        title_five = (TextView) findViewById(R.id.title_five);
        click_title = (TextView) findViewById(R.id.click_title);
        count_recursion_five = (TextView) findViewById(R.id.count_recursion_five);
        time_recursion_five = (TextView) findViewById(R.id.time_recursion_five);
        count_iteration_five = (TextView) findViewById(R.id.count_iteration_five);
        time_iteration_five = (TextView) findViewById(R.id.time_iteration_five);
        title_five.setOnClickListener(this);
        click_title.setOnClickListener(this);


//        title_five.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //time_recursion_five.setText("20000211");        //??
//                Log.d("111","888999");
//                //test = recursionTime30();
//                //Log.d("111",test);
//                Log.d("111","1234560000");
//                //time_recursion_five.setText("10101033");            //??
//                time_recursion_five.setText(recursionTime30().toString());                   //??
//                count_recursion_five.setText(Integer.toString(n-1));        //??
//                Log.d("111","5555"+recursionTime30());
//                //count_recursion_five.setText(n-1);  //第n个超时，输出前一个，b为不超时的 最大斐波那契的值
//                Log.d("111","1110"+(n-1));
//                //test2 = iterationTime30();
//                //time_iteration_five.setText(test2.toString());
//                //count_iteration_five.setText(Integer.toString(m-1));
//
//            }
//        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_five:
                time_recursion_five.setText(recursionTime30().toString());
                count_recursion_five.setText(Integer.toString(n-1));
                break;
            case R.id.click_title:
                time_iteration_five.setText(iterationTime30().toString());
                count_iteration_five.setText(Integer.toString(m-1));
                break;
        }
    }

    public BigDecimal iterationTime30(){        //迭代 计算机能够在30s内计算出的最大斐波那契是第几个
        long a = 1,b = 1,result = 0;         //b为第一个 a为第二个

        BigDecimal startTime2 = BigDecimal.valueOf(System.nanoTime());
        while (true){
            result = a+b;
            m++;
            b = a;
            a = result;
            BigDecimal endTime2 = BigDecimal.valueOf(System.nanoTime());
            subtractTime2 = (endTime2.subtract(startTime2)).divide(divisor);
            int flag = subtractTime2.compareTo(minBigDecimal);
            if (flag == 1){
                break;
            }
        }
        return subtractTime2;
    }

    public BigDecimal recursionTime30() {
        int a = 1, b = 1;   //b为a前一个
        BigDecimal startTime1 = BigDecimal.valueOf(System.nanoTime());      //开始时间 //计算机能够在30s内计算出的最大斐波那契是第几个
        while (true) {
            n++;
            b = a;
            a = recursion(n);
            BigDecimal endTime1 = BigDecimal.valueOf(System.nanoTime());    //时间点
            subtractTime = (endTime1.subtract(startTime1)).divide(divisor);   //时间差值
            int flag = subtractTime.compareTo(minBigDecimal);           //和30s进行比较
            if (flag ==1){
                break;
            }
        }
        return subtractTime;
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


}