package com.example.fabonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ButtonSix extends AppCompatActivity implements View.OnClickListener {
    private TextView false_six;
    private TextView resultOne_six, resultTwo_six, resultThree_six;

    private int n = 47;
    private long x = 0, y = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_six);

        false_six = (TextView) findViewById(R.id.false_six);
        resultOne_six = (TextView) findViewById(R.id.resultOne_six);        //显示公式
        resultTwo_six = (TextView) findViewById(R.id.resultTwo_six);        //迭代改进
        resultThree_six = (TextView) findViewById(R.id.resultThree_six);    //误差
        false_six.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.false_six:

                n = compare(n);
                resultOne_six.setText(Long.toString(x));
                resultTwo_six.setText(Long.toString(y));
                resultThree_six.setText(Integer.toString(n));
        }
    }

    //迭代改进算法
    public long iteration_plus(int n) {
        if (n > 1) {
            long a;
            long b = 1;
            n--;
            a = n & 1;
            n /= 2;
            while (n-- > 0) {
                a += b;
                b += a;
            }
            Log.d("1111", "666+" + b);
            return b;
        }
        return n;
    }

    /*
    使用显示公式计算斐波那契数列
    Math.pow(a,b) a的b次方
     */
    public double formulas(int n) {
        double result = 0;
        double temp = Math.sqrt(5.0);
        result = (1 / temp) * (Math.pow((1 + temp) / 2, n) - Math.pow((1 - temp) / 2, n));
        return result;
    }

    public int compare(int n) {
        while (true) {
            x = iteration_plus(n);
            y = (long) formulas(n);
            if (x != y) {
                break;
            }
            n++;
        }
        return n;
    }


}