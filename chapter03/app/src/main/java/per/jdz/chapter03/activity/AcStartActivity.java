package per.jdz.chapter03.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import per.jdz.chapter03.R;

public class AcStartActivity extends AppCompatActivity {

    private static final String TAG = "ning";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate~");
        setContentView(R.layout.activity_ac_start);
        findViewById(R.id.btn_act_next).setOnClickListener(v-> {
            // 在Intent的构造函数中指定
//            startActivity(new Intent(this, AcFinishActivity.class));
            // 调用意图对象的setClass方法指定
//            startActivity(new Intent().setClass(this, AcFinishActivity.class));
            // 调用意图对象的setComponent方法指定
            startActivity(new Intent().setComponent(new ComponentName(this, AcFinishActivity.class)));
        });
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart~");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume~");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause~");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop~");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy~");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart~");
        super.onRestart();
    }
}