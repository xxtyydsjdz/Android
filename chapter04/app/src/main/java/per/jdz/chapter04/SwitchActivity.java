package per.jdz.chapter04;

import android.view.View;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SwitchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switchctivity);
        Switch mySw = findViewById(R.id.sw_status);
        TextView textView = findViewById(R.id.tv_result);
        mySw.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                textView.setText("开关开启");
            } else {
                textView.setText("开关关闭");
            }
        });
    }
}