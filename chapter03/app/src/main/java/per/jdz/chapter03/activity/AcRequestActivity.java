package per.jdz.chapter03.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import per.jdz.chapter03.R;

import java.time.LocalDateTime;

public class AcRequestActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String  message = "你睡了吗";
    private ActivityResultLauncher<Intent> register;
    private TextView tvResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac_request);
        TextView textView = findViewById(R.id.tv_request);
        // 设置待发送消息
        textView.setText("待发送消息" + message);
        // 监听
        findViewById(R.id.btn_request).setOnClickListener(this);
        register = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), (result) -> {
            if (result != null) {
                Intent data = result.getData();
                if (data != null && result.getResultCode() == Activity.RESULT_OK) {
                    Bundle extras = data.getExtras();
                    String responseTime = extras.getString("ResponseTime");
                    String responseContent = extras.getString("ResponseContent");
                    String desc = String.format("收到响应消息：\n响应时间为%s\n响应内容为%s", responseTime, responseContent);
                    tvResponse = findViewById(R.id.tv_response);
                    // 把返回消息的详情显示在文本视图上
                    tvResponse.setText(desc);
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("Request_time", LocalDateTime.now().toString());
        bundle.putString("Request_content", message);
        Intent intent = new Intent(this, ActResponseActivity.class).putExtras(bundle);
        register.launch(intent);
    }
}