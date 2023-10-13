package per.jdz.chapter03;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvResult;
    private String firstNum;
    private String operator = "";
    private String secondNum;
    private String result = "";
    private String showText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        tvResult = findViewById(R.id.tv_result);
        findViewById(R.id.btn_cancel).setOnClickListener(this);
        findViewById(R.id.btn_divide).setOnClickListener(this);//"除法"按钮
        findViewById(R.id.btn_multiply).setOnClickListener(this);//"乘法"按钮
        findViewById(R.id.btn_clear).setOnClickListener(this);//"清除"按钮
        findViewById(R.id.btn_seven).setOnClickListener(this);//数字7
        findViewById(R.id.btn_eight).setOnClickListener(this);//8
        findViewById(R.id.btn_nine).setOnClickListener(this);//9
        findViewById(R.id.btn_plus).setOnClickListener(this);//"加法"按钮
        findViewById(R.id.btn_four).setOnClickListener(this);//4
        findViewById(R.id.btn_five).setOnClickListener(this);//5
        findViewById(R.id.btn_six).setOnClickListener(this);//6
        findViewById(R.id.btn_minus).setOnClickListener(this);//"减法"按钮
        findViewById(R.id.btn_one).setOnClickListener(this);//
        findViewById(R.id.btn_two).setOnClickListener(this);//2
        findViewById(R.id.btn_three).setOnClickListener(this);//3
        findViewById(R.id.btn_reciprocal).setOnClickListener(this);//求倒数按钮
        findViewById(R.id.btn_zero).setOnClickListener(this);//0
        findViewById(R.id.btn_dot).setOnClickListener(this);//"小数点"按钮
        findViewById(R.id.btn_equal).setOnClickListener(this);//"等号"按钮
        findViewById(R.id.btn_sqrt).setOnClickListener(this);//"开平方"按钮
    }

    @Override
    public void onClick(View view) {
        String inputText;
        if (view.getId() == R.id.btn_sqrt) {
            inputText = "√";
        } else {
            inputText = ((TextView) view).getText().toString();

        }
        switch (view.getId()) {
            case R.id.btn_clear:
                clear();
                break;
            case R.id.btn_cancel:
                break;
            case R.id.btn_plus:
                break;
            case R.id.btn_minus:
                break;
            case R.id.btn_multiply:
                break;
            case R.id.btn_divide:
                operator = inputText;
                refreshText(showText + operator);
                break;
            case R.id.btn_equal:
                double calculateResult = calculatorFour();
                refreshOperator(String.valueOf(calculateResult));
                refreshText(showText + " = " + result);
                break;
            case R.id.btn_sqrt:
                break;
            case R.id.btn_reciprocal:
                break;
            default:
                // 无运算符，则继续拼接第一个操作数
                if (operator.equals("")) {
                    firstNum += inputText;
                } else {
                    secondNum += inputText;
                }
                if (showText.equals("0") && !inputText.equals(".")) {
                    refreshText(inputText);
                } else {
                    refreshText(showText + inputText);
                }
                break;
        }
    }

    private double calculatorFour() {
        switch (operator) {
            case "+":
                return Double.parseDouble(firstNum) + Double.parseDouble(secondNum);
            case "-":
                return Double.parseDouble(firstNum) - Double.parseDouble(secondNum);
            case "×":
                return Double.parseDouble(firstNum) * Double.parseDouble(secondNum);
            case "÷":
                return Double.parseDouble(firstNum) / Double.parseDouble(secondNum);
            default:
                return -99999;
        }
    }

    private void clear() {
        refreshOperator("");
        refreshText("0");
    }

    private void refreshOperator(String newResult) {
        result = newResult;
        // 上一次运算结果
        firstNum = result;
        secondNum = "";
        operator = "";
    }

    private void refreshText(String Text) {
        showText = Text;
        tvResult.setText(showText);
    }
}