package per.jdz.chapter03.button;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import per.jdz.chapter03.R;

import java.time.Instant;

public class ButtonEnableActivity extends AppCompatActivity implements View.OnClickListener {

    private  Button btnTest;
    private TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_enable);
        Button btnEable = findViewById(R.id.btn_able);
        Button btnDisable = findViewById(R.id.btn_disable);
        tvResult = findViewById(R.id.tv_result);
        btnTest = findViewById(R.id.btn_test);
        btnEable.setOnClickListener(this);
        btnDisable.setOnClickListener(this);
        btnTest.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_able:
                btnTest.setEnabled(true);
                btnTest.setTextColor(Color.BLACK);
                break;
            case R.id.btn_disable:
                btnTest.setEnabled(false);
                btnTest.setTextColor(Color.GRAY);
                tvResult.setText("当前状态不可看");
                break;
            case R.id.btn_test:
                String format = String.format("%s 您点击了按钮：%s", Instant.now(), (Button) view);
                tvResult.setText(format);
                break;
        }
    }
}