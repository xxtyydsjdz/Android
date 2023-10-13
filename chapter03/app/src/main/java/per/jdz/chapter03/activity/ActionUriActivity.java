package per.jdz.chapter03.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import per.jdz.chapter03.R;

public class ActionUriActivity extends AppCompatActivity implements View.OnClickListener {

    private static final Intent INTENT = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_uri);
        findViewById(R.id.btn_dial).setOnClickListener(this);
        findViewById(R.id.btn_sms).setOnClickListener(this);
        findViewById(R.id.btn_my).setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        String phoneNo = "12345";
        switch (view.getId()){
            case R.id.btn_dial:
                // 设置意图动作为准备拨号
                INTENT.setAction(Intent.ACTION_DIAL);
                Uri uri = Uri.parse("tel:" + phoneNo);
                INTENT.setData(uri);
                startActivity(INTENT);
                break;
            case R.id.btn_sms:
                INTENT.setAction(Intent.ACTION_SENDTO);
                Uri toSms = Uri.parse("smsto" + phoneNo);
                INTENT.setData(toSms);
                startActivity(INTENT);
                break;
            case R.id.btn_my:
                INTENT.setAction("android.intent.action.NING");
                INTENT.addCategory(Intent.CATEGORY_DEFAULT);
                startActivity(INTENT);
                break;
        }
    }
}