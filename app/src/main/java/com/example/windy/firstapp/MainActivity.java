package com.example.windy.firstapp;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //声明所有控件
    Button btn0 = null;
    Button btn1 = null;
    Button btn2 = null;
    Button btn3 = null;
    Button btn4 = null;
    Button btn5 = null;
    Button btn6 = null;
    Button btn7 = null;
    Button btn8 = null;
    Button btn9 = null;

    Button btnBackspace = null;
    Button btnCE = null;
    Button btnC = null;

    Button btnAdd = null;
    Button btnSub = null;
    Button btnMul = null;
    Button btnDiv = null;
    Button btnEqu = null;
    TextView tvResult = null;

    //测试动画效果的控件
    ImageView imageView = null;
    Button btnAnimator = null;
    static int x = 0 , xx = 0 , y = 0 , yy = 0;

    //两个跳转Activity的按钮
    Button btn2acti2 = null;
    Button btn2acti3 = null;


    //声明两个参数。接收tvResult前后的值
    double num1 = 0;
    double num2 = 0;
    double Result = 0;    //计算结果
    int op = 0;   //判断操作数，
    boolean isClickEqu = false;   //判断是否按了“=”按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        //从布局文件中获取控件，
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);

        btnBackspace = (Button) findViewById(R.id.btnBackspace);
        btnCE = (Button) findViewById(R.id.btnCE);
        btnC = (Button) findViewById(R.id.btnC);

        btnEqu = (Button) findViewById(R.id.btnEqu);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        tvResult = (TextView) findViewById(R.id.tvResult);

        //找到动画效果的两个控件
        imageView = (ImageView) findViewById(R.id.imageView);
        btnAnimator = (Button) findViewById(R.id.button);

        //找到两个跳转按钮
        btn2acti2 = (Button) findViewById(R.id.btn_to_acti2);
        btn2acti3 = (Button) findViewById(R.id.btn_to_acti3);

        //给按钮分别添加监听
        btnBackspace.setOnClickListener(this);
        btnCE.setOnClickListener(this);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);


        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnEqu.setOnClickListener(this);
    }

    public void imgClick(View view){
        Toast.makeText(this, "ImageView", Toast.LENGTH_SHORT).show();
    }

    //动态图片按钮
    public void buttonClick(View view){

//         xx += 20;
//         TranslateAnimation ta = new TranslateAnimation(x, xx, y, yy);//设置动画的偏移位移
//         x += 20;
//        ta.setDuration(1000);//设置动画的时长
//        ta.setFillAfter(true);//设置动画结束后停留在该位置
//        imageView.startAnimation(ta);

        //属性动画调用start()方法后是一个异步操作
//        ObjectAnimator.ofFloat(imageView, "translationX", 0F, 360F).setDuration(1000).start();//X轴平移旋转
//        ObjectAnimator.ofFloat(imageView, "translationY", 0F, 360F).setDuration(1000).start();//Y轴平移旋转
//        ObjectAnimator.ofFloat(imageView, "rotation", 0F, 360F).setDuration(1000).start();//360度旋转

        //同步动画设计
//        PropertyValuesHolder p1 = PropertyValuesHolder.ofFloat("translationX", 0, 360F);
//        PropertyValuesHolder p2 = PropertyValuesHolder.ofFloat("translationY", 0, 360F);
//        PropertyValuesHolder p3 = PropertyValuesHolder.ofFloat("rotation", 0, 360F);
//        ObjectAnimator.ofPropertyValuesHolder(imageView, p1, p2 ,p3).setDuration(1000).start();

        //通过AnimatiorSet来设计同步执行的多个属性动画
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageView, "translationX", 0F, 360F);//X轴平移旋转
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(imageView, "translationY", 0F, 360F);//Y轴平移旋转
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(imageView, "rotation", 0F, 360F);//360度旋转
        AnimatorSet set = new AnimatorSet();
        //set.playSequentially(animator1, animator2, animator3);//分步执行
        //set.playTogether(animator1, animator2, animator3);//同步执行

        //属性动画的执行顺序控制
        //先同步执行动画animator2和animator3,然后再执行animator1
        //set.play(animator2).with(animator3);
        //set.play(animator2).after(animator1);
        set.play(animator3).after(animator2);
        set.play(animator2).after(animator1);


        set.setDuration(1000);
        set.start();

    }

    //跳转到Activity2,随手指移动的图片
    public void buttonClick1(View view){
        Intent intent22 = new Intent();
        intent22.setClass(MainActivity.this,Activity2.class);
        startActivity(intent22);
    }

    //跳转到Activity3
    public void buttonClick2(View view){
        Intent intent23 = new Intent();
        intent23.setClass(MainActivity.this,Activity3.class);
        startActivity(intent23);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //btnBackspace和CE--------------------
            case R.id.btnBackspace:
                String myStr = tvResult.getText().toString();
                try {
                    tvResult.setText(myStr.substring(0, myStr.length() - 1));
                } catch (Exception e) {
                    tvResult.setText("");
                }
                break;
            case R.id.btnCE:
                tvResult.setText(null);
                break;

            //btn0--9---------------------------
            case R.id.btn0:
                if (isClickEqu) {
                    tvResult.setText(null);
                    isClickEqu = false;
                }
                String myString = tvResult.getText().toString();
                myString += "0";
                tvResult.setText(myString);
                break;
            case R.id.btn1:
                if (isClickEqu) {
                    tvResult.setText(null);
                    isClickEqu = false;
                }
                String myString1 = tvResult.getText().toString();
                myString1 += "1";
                tvResult.setText(myString1);
                break;
            case R.id.btn2:
                if (isClickEqu) {
                    tvResult.setText(null);
                    isClickEqu = false;
                }
                String myString2 = tvResult.getText().toString();
                myString2 += "2";
                tvResult.setText(myString2);
                break;
            case R.id.btn3:
                if (isClickEqu) {
                    tvResult.setText(null);
                    isClickEqu = false;
                }
                String myString3 = tvResult.getText().toString();
                myString3 += "3";
                tvResult.setText(myString3);
                break;
            case R.id.btn4:
                if (isClickEqu) {
                    tvResult.setText(null);
                    isClickEqu = false;
                }
                String myString4 = tvResult.getText().toString();
                myString4 += "4";
                tvResult.setText(myString4);
                break;
            case R.id.btn5:
                if (isClickEqu) {
                    tvResult.setText(null);
                    isClickEqu = false;
                }
                String myString5 = tvResult.getText().toString();
                myString5 += "5";
                tvResult.setText(myString5);
                break;
            case R.id.btn6:
                if (isClickEqu) {
                    tvResult.setText(null);
                    isClickEqu = false;
                }
                String myString6 = tvResult.getText().toString();
                myString6 += "6";
                tvResult.setText(myString6);
                break;
            case R.id.btn7:
                if (isClickEqu) {
                    tvResult.setText(null);
                    isClickEqu = false;
                }
                String myString7 = tvResult.getText().toString();
                myString7 += "7";
                tvResult.setText(myString7);
                break;
            case R.id.btn8:
                if (isClickEqu) {
                    tvResult.setText(null);
                    isClickEqu = false;
                }
                String myString8 = tvResult.getText().toString();
                myString8 += "8";
                tvResult.setText(myString8);
                break;
            case R.id.btn9:
                if (isClickEqu) {
                    tvResult.setText(null);
                    isClickEqu = false;
                }
                String myString9 = tvResult.getText().toString();
                myString9 += "9";
                tvResult.setText(myString9);
                break;

            //btn加减乘除，op代表运算状态的数，1234分别会对应加减乘除--------------------------------
            case R.id.btnAdd:
                String myStringAdd = tvResult.getText().toString();
                if (myStringAdd.equals(null)) {
                    return;
                }
                num1 = Double.valueOf(myStringAdd);
                tvResult.setText(null);
                op = 1;
                isClickEqu = false;
                break;

            case R.id.btnSub:
                String myStringSub = tvResult.getText().toString();
                if (myStringSub.equals(null)) {
                    return;
                }
                num1 = Double.valueOf(myStringSub);
                tvResult.setText(null);
                op = 2;
                isClickEqu = false;
                break;
            case R.id.btnMul:
                String myStringMul = tvResult.getText().toString();
                if (myStringMul.equals(null)) {
                    return;
                }
                num1 = Double.valueOf(myStringMul);
                tvResult.setText(null);
                op = 3;
                isClickEqu = false;
                break;
            case R.id.btnDiv:
                String myStringDiv = tvResult.getText().toString();
                if (myStringDiv.equals(null)) {
                    return;
                }
                num1 = Double.valueOf(myStringDiv);
                tvResult.setText(null);
                op = 4;
                isClickEqu = false;
                break;
            case R.id.btnEqu:
                String myStringEqu = tvResult.getText().toString();
                if (myStringEqu.equals(null)) {
                    return;
                }
                num2 = Double.valueOf(myStringEqu);
                tvResult.setText(null);
                switch (op) {
                    case 0:
                        Result = num2;
                        break;
                    case 1:
                        Result = num1 + num2;
                        break;
                    case 2:
                        Result = num1 - num2;
                        break;
                    case 3:
                        Result = num1 * num2;
                        break;
                    case 4:
                        Result = num1 / num2;
                        break;
                    default:
                        Result = 0;
                        break;
                }
                tvResult.setText(String.valueOf(Result));
                isClickEqu = true;
                break;

            /*这两个按钮，这样写，不起作用，得在xml里绑定才管用，不知道为什么
            //跳转到Activity2的按钮
            case R.id.btn_to_acti2:
                Intent intent22 = new Intent();
                intent22.setClass(MainActivity.this,Activity2.class);
                startActivity(intent22);
                break;

            //跳转到Activity3的按钮
            case R.id.btn_to_acti3:
                Intent intent23 = new Intent();
                intent23.setClass(MainActivity.this,Activity3.class);
                startActivity(intent23);
                break;
            */

            default:
                break;
        }
    }
}
