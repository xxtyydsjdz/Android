package per.jdz.chapter03;

import android.os.Build;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.time.Instant;

public class ButtonStyleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_style);
        View bt = findViewById(R.id.bc1);
        TextView tv_result = findViewById(R.id.tv_result);
        bt.setOnClickListener(view -> {
                String format = String.format("%s 您点击了按钮：%s", Instant.now(), "ddd");
                tv_result.setText(format);

        });
    }
}