package per.jdz.chapter03;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.time.Instant;

public class ButtonLongClickActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_long_click);
        Button btn = findViewById(R.id.btn_long_click);
        TextView tv_result = findViewById(R.id.tv_result);
        btn.setOnLongClickListener(view -> {
            String format = String.format("%s 您点击了按钮：%s", Instant.now(), (Button) view);
            tv_result.setText(format);
            return true;
        });
    }
}