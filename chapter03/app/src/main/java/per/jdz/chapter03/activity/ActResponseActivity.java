package per.jdz.chapter03.activity;

import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import per.jdz.chapter03.R;

import java.time.LocalDateTime;

public class ActResponseActivity extends AppCompatActivity {

    private static final String resp = "没睡";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_response);
        TextView tvRequest = findViewById(R.id.tv_request);
        // 从上一个页面传来的，意图中获取快递包裹
        Bundle extras = getIntent().getExtras();
        String requestTime = extras.getString("Request_time");
        String requestContent = extras.getString("Request_content");
        String desc = String.format("收到请求消息：\n请求时间为%s\n请求内容为%s", requestTime, requestContent);
        tvRequest.setText(desc);
        findViewById(R.id.btn_response).setOnClickListener(view -> {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("ResponseTime", LocalDateTime.now().toString());
            bundle.putString("ResponseContent", resp);
            intent.putExtras(bundle);
            // 携带意图返回上一个页面。RESULT_OK表示处理成功
            setResult(Activity.RESULT_OK, intent);
            finish();
        });
        TextView tvResponse = findViewById(R.id.tv_response);
        tvResponse.setText("待返回的消息" + resp);
    }
}