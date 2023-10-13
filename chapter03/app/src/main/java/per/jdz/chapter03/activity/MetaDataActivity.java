package per.jdz.chapter03.activity;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import per.jdz.chapter03.R;

public class MetaDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meta_data);
        TextView tvMeta = findViewById(R.id.tv_meta);
        // 获取应用包管理器
        PackageManager packageManager = getPackageManager();
        try {
            // 从应用包管理器中获取当前的活动信息
            ActivityInfo info = packageManager.getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            // 获取活动，附加的元数据信息
            Bundle metaData = info.metaData;
            String weather = metaData.getString("weather");
            tvMeta.setText(weather);
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}