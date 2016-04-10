package com.lone.service.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;

import bsh.EvalError;
import bsh.Interpreter;

public class MainActivity extends AppCompatActivity {
    EditText reText = null;//定义显示器
    boolean isClear = false;//记录显示器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();//实例化控件
    }

    //按钮点击事件
    public void Click(View e) {
        Button btn = (Button) e;
        String exp = reText.getText().toString();
        if (isClear && (exp.equals("输入格式错误")
                || btn.getText().equals("0")
                || btn.getText().equals("1")
                || btn.getText().equals("2")
                || btn.getText().equals("3")
                || btn.getText().equals("4")
                || btn.getText().equals("5")
                || btn.getText().equals("6")
                || btn.getText().equals("7")
                || btn.getText().equals("8")
                || btn.getText().equals("9"))) {
            reText.setText("");
            isClear = false;
        }
        if (btn.getText().equals("清屏")) {//清屏按钮
            reText.setText("");
        } else if (btn.getText().equals("退格")) {//退格按钮
            if (exp == null || exp.trim().length() == 0) return;//判断显示器是否有内容
            else reText.setText(exp.substring(0, exp.length() - 1));//清除一个
        } else if (btn.getText().equals("=")) {//==按钮
            if (exp == null || exp.trim().length() == 0) return;//判断显示器是否有内容
            exp = getRs(exp);//获取结果
            if (exp.endsWith(".0")) {//判断是否有小数位
                exp = exp.substring(0, exp.indexOf(".0"));
            }
            reText.setText(exp);
        } else {
            reText.setText(reText.getText() + "" + btn.getText());
            isClear = false;
        }
        reText.setSelection(reText.getText().length());//移动光标到最后
    }
    //获取结果
    private String getRs(String exp) {
        Interpreter bsh = new Interpreter();
        Number result = null;
        try {
            result = (Number) bsh.eval(exp);
            isClear = true;
        } catch (EvalError evalError) {
            evalError.printStackTrace();
            isClear = true;
            return "输入格式错误";
        }
        return result.doubleValue() + "";
    }


    private void initView() {
        reText = (EditText) findViewById(R.id.reText);
    }
}
