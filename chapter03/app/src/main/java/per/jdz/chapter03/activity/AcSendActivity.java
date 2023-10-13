package per.jdz.chapter03.activity;

import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import per.jdz.chapter03.R;

import java.time.LocalDateTime;

public class AcSendActivity extends AppCompatActivity {

    private TextView tvSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac_send);
        tvSend = findViewById(R.id.tv_send);
        findViewById(R.id.btn_send).setOnClickListener(view -> {
            Intent intent = new Intent(this, ActReceiveActivity.class);
            // 一个包裹
            Bundle bundle = new Bundle();
            bundle.putString("request_time", LocalDateTime.now().toString());
            bundle.putString("request_content", tvSend.getText().toString());
            intent.putExtras(bundle);
            startActivity(intent);
        });
    }
}