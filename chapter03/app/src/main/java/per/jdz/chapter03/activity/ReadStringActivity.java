package per.jdz.chapter03.activity;

import android.content.Context;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import per.jdz.chapter03.R;

public class ReadStringActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_string);
        TextView tvResource = findViewById(R.id.tv_resource);
        // 从strings.xml获取名叫weather str的字符串值
//        String value = getString(R.string.weather_str);
//        tvResource.setText(value);
        System.out.println("R.string.name: " + R.string.weather_str);
        tvResource.setText(R.string.weather_str);
    }
}