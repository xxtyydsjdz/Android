package per.jdz.chapter03;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class TextSizeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_size);
        TextView tv_hello = findViewById(R.id.text_size);
        tv_hello.setText(R.string.hello_andriod);
        tv_hello.setTextSize(30);
        Button b3 = findViewById(R.id.b3);
        b3.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setClass(TextSizeActivity.this, TextColorActivity.class);
            startActivity(intent);
        });
    }
}