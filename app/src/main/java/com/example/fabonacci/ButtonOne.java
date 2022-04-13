package com.example.fabonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.math.BigDecimal;

public class ButtonOne extends AppCompatActivity {

    private TextInputEditText textInputEditText;                //输入的编辑框
    private Button button;                                      //确认计算按钮
    private TextView result1, result2, result3, result4, result5;   //结果    用于显示
    private TextView count1, count2, count3, count4, count5;    //操作次数  用于显示
    private TextView time1, time2, time3, time4, time5;     //时间    用于显示

    private BigDecimal bigDecimal1, bigDecimal2, bigDecimal3, bigDecimal4, bigDecimal5; //程序执行开始时间
    private BigDecimal endBigDecimal1, endBigDecimal2, endBigDecimal3, endBigDecimal4, endBigDecimal5;  //程序执行结束时间

    private BigDecimal divisor = new BigDecimal(1000000000);    //作为除数将纳秒转化成秒

    private double startTime1, startTime2, startTime3, startTime4, startTime5;
    private double endTime1, endTime2, endTime3, endTime4, endTime5;

    //countNumber用于计算操作次数，n为编辑框输入的需要计算的第几个斐波那契数
    private long countNumber1 = 0;
    private int n, countNumber2 = 0, countNumber3 = 0, countNumber4 = 0, countNumber5 = 0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_one);
        init();     //初始化
    }

    //初始化找到实例
    private void init() {
        textInputEditText = (TextInputEditText) findViewById(R.id.number);  //编辑框获取实例
        button = (Button) findViewById(R.id.submit);            //提交按钮获取实例

        //获取输入的内容,应该在计算时候获取（改在下面点击事件使用）
        //n = Integer.parseInt(textInputEditText.getText().toString());

        //递归算法获取实例
        result1 = (TextView) findViewById(R.id.result1);
        count1 = (TextView) findViewById(R.id.count1);
        time1 = (TextView) findViewById(R.id.time1);

        //迭代算法获取实例
        result2 = (TextView) findViewById(R.id.result2);
        count2 = (TextView) findViewById(R.id.count2);
        time2 = (TextView) findViewById(R.id.time2);

        //迭代改进获取实例
        result3 = (TextView) findViewById(R.id.result3);
        count3 = (TextView) findViewById(R.id.count3);
        time3 = (TextView) findViewById(R.id.time3);

        //显示公式获取实例
        result4 = (TextView) findViewById(R.id.result4);
        count4 = (TextView) findViewById(R.id.count4);
        time4 = (TextView) findViewById(R.id.time4);

        //矩阵获取实例
        result5 = (TextView) findViewById(R.id.result5);
        count5 = (TextView) findViewById(R.id.count5);
        time5 = (TextView) findViewById(R.id.time5);

        //提交按钮的点击事件
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //result1.setText(recursion(n));
                countNumber1 = 0;
                countNumber2 = 0;
                countNumber3 = 0;
                countNumber4 = 0;
                countNumber5 = 0;

                //n为编辑输入框输入的数字，因为编辑框得到的内容为Editable类的，所以编辑框输入的内容先转为字符串再转为int类型
                n = Integer.parseInt(textInputEditText.getText().toString());

                //显示结果————计算的结果
                //显示结果————基本操作次数
                //显示结果————时间
                //startTime1 = System.nanoTime();
                bigDecimal1 = BigDecimal.valueOf(System.nanoTime());
                result1.setText(Long.toString(recursion(n)));                //！！不转为字符串类型会闪退！！
                count1.setText(Long.toString(countNumber1));
                //endTime1 = System.nanoTime();
                endBigDecimal1 = BigDecimal.valueOf(System.nanoTime());
                //double second1 = endTime1 - startTime1;

                BigDecimal big1 = (endBigDecimal1.subtract(bigDecimal1)).divide(divisor);
                time1.setText(big1.toString());
                //time1.setText(Double.toString(endTime-startTime));

                //startTime2 = System.nanoTime();
                bigDecimal2 = BigDecimal.valueOf(System.nanoTime());
                result2.setText(Long.toString(iteration(n)));
                count2.setText(Integer.toString(countNumber2));
                endBigDecimal2 = BigDecimal.valueOf(System.nanoTime());
                BigDecimal big2 = (endBigDecimal2.subtract(bigDecimal2)).divide(divisor);
                time2.setText(big2.toString());
                //endTime2 = System.nanoTime();
                //double second2 = endTime2 - startTime2;

                //time2.setText(String.format("%f", second2 /1000));


                bigDecimal3 = BigDecimal.valueOf(System.nanoTime());
                result3.setText(Long.toString(iteration_plus(n)));
                count3.setText(Integer.toString(countNumber3));
                endBigDecimal3 = BigDecimal.valueOf(System.nanoTime());
                BigDecimal big3 = (endBigDecimal3.subtract(bigDecimal3)).divide(divisor);
                time3.setText(big3.toString());
                //startTime3 = System.nanoTime();
                //result3.setText(Integer.toString(iteration_plus(n)));
                //count3.setText(Integer.toString(countNumber3));
                //endTime3 = System.nanoTime();
                //double second3 = endTime3 - startTime3;

                //time3.setText(String.format("%f", second3 /1000));

//                startTime4 = System.nanoTime();
//                result4.setText((Integer.toString((int) formulas(n))));
//                count4.setText(Integer.toString(countNumber4));
//                endTime4 = System.nanoTime();
//                double second4 = endTime4 - startTime4;
//
//                time4.setText(String.format("%f", second4 / 1000));
                bigDecimal4 = BigDecimal.valueOf(System.nanoTime());
                result4.setText((Long.toString((long) formulas(n))));
                count4.setText(Integer.toString(countNumber4));
                endBigDecimal4 = BigDecimal.valueOf(System.nanoTime());
                BigDecimal big4 = (endBigDecimal4.subtract(bigDecimal4)).divide(divisor);
                time4.setText(big4.toString());

//                startTime5 = System.nanoTime();
//                result5.setText(Integer.toString(matrix(n)));
//                count5.setText(Integer.toString(countNumber5));
//                endTime5 = System.nanoTime();
//                double second5 = endTime5 - startTime5;
//
//                time5.setText(String.format("%f", second5 / 1000));
                bigDecimal5 = BigDecimal.valueOf(System.nanoTime());
                result5.setText(Long.toString(matrix(n)));
                count5.setText(Integer.toString(countNumber5));
                endBigDecimal5 = BigDecimal.valueOf(System.nanoTime());
                BigDecimal big5 = (endBigDecimal5.subtract(bigDecimal5)).divide(divisor);
                time5.setText(big5.toString());

                //long t1 = System.currentTimeMillis();
                //int [][]m = fb(n);
                //long t2 = System.currentTimeMillis();

            }
        });
    }

    /*
    递归计算斐波那契数列
    指的是这样一个数列：1、1、2、3、5、8、13、21、34、……
    */
    public long recursion(int n) {
        countNumber1++;
        if (n == 1 || n == 2) {
            return 1;                                       //保证前两个数为1

        }
        if (n > 2) {
            return recursion(n - 1) + recursion(n - 2);     //递归调用
        }
        return -1;
    }

    /*
    迭代计算斐波那契数列
    指的是这样一个数列：1、1、2、3、5、8、13、21、34、…
    普通迭代
    */
    public long iteration(int n) {
        long result = 0, previous = 1, previousPro = 1;    //previous为前一个，previousPro为再前一个
        if (n == 1 || n == 2) {
            countNumber2 = 1;
            return 1;
        }
        if (n > 2) {
            for (int i = 2; i < n; i++) {
                countNumber2++;
                result = previous + previousPro;
                previousPro = previous;
                previous = result;
            }
            return result;
        }
        return -1;
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
                countNumber3++;
                a += b;
                b += a;
            }
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
        countNumber4 = 2 * (n - 1) + 1;
        return result;
    }


    /*
    斐波那契数列矩阵算法
    */
    // 关联矩阵
    private static final long[][] UNIT = {{1, 1}, {1, 0}};  //定义一个上面公式中需要计算的二维数组
    // 全0矩阵
    private static final long[][] ZERO = {{0, 0}, {0, 0}};  //定义一个元素均为0的二维数组

    /**
     * 求斐波那契数列
     *
     * @param n
     * @return
     */
    public long[][] fb(int n) {
        if (n == 0) {  //指数n为0时返回该数组
            return ZERO;
        }
        if (n == 1) {  //指数n为1时返回该数组
            return UNIT;
        }
        // n是偶数
        if ((n & 1) == 0) {  //把（n&1） == 0换成（n%2） == 0等价 ， 唯一区别在于（n&1） == 0计算效率高
            long[][] matrix = fb(n >> 1);  //n >> 1意思是指将n的二进制数向右移动1位，最高位补0。相当于把n除以2
            return matrixMultiply(matrix, matrix);
        }
        // n是奇数
        long[][] matrix = fb((n - 1) >> 1);
        return matrixMultiply(matrixMultiply(matrix, matrix), UNIT);
    }

    /**
     * 矩阵相乘
     *
     * @param m r1*c1
     * @param n c1*c2
     * @return 新矩阵, r1*c2
     */
    public long[][] matrixMultiply(long[][] m, long[][] n) {
        int rows = m.length;
        int cols = n[0].length;
        long[][] r = new long[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                r[i][j] = 0;
                for (int k = 0; k < m[i].length; k++) {
                    countNumber5++;
                    r[i][j] += m[i][k] * n[k][j];
                }
            }
        }
        return r;
    }

    //具体实现矩阵相乘算法,斐波那契数矩阵计算结果
    public long matrix(int n) {
        long[][] m = fb(n);
        return m[0][1];
    }
}