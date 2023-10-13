package per.jdz.chapter03;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * ClassName: TextViewActivity
 * Description:
 *
 * @Author: Jdz
 * @Create: 2023/9/7 - 9:12
 */
public class TextViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        TextView tv_hello = findViewById(R.id.text_view);
        tv_hello.setText(R.string.hello);
        Button b2 = findViewById(R.id.b2);
        b2.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setClass(TextViewActivity.this, TextSizeActivity.class);
            startActivity(intent);
        });
    }
}
