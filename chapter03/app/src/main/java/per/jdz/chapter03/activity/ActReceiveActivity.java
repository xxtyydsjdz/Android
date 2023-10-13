package per.jdz.chapter03.activity;

import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import per.jdz.chapter03.R;

public class ActReceiveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_receive);
        TextView tvReceive = findViewById(R.id.tv_receive);
        // 从上一个页面传来的意图中获取快递包裹
        Bundle extras = getIntent().getExtras();
        String requestTime = extras.getString("request_time");
        String requestContent = extras.getString("request_content");
        String desc = String.format("收到请求消息：\n请求时间为%s\n请求内容为%s", requestTime, requestContent);
        tvReceive.setText(desc);
    }
}