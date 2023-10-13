package per.jdz;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvDatabase;
    private String path;
    private String desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDatabase = findViewById(R.id.tv_content);
        findViewById(R.id.btn_create).setOnClickListener(this);
        findViewById(R.id.btn_delete).setOnClickListener(this);
        path = getFilesDir() + "/test.db";
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_create:
                SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(path, Context.MODE_PRIVATE, null);
                desc = String.format("数据库%s创建%s", sqLiteDatabase.getPath(), (sqLiteDatabase != null? "成功": "失败"));
                tvDatabase.setText(desc);
                break;
            case R.id.btn_delete:
                boolean result = deleteDatabase(path);
                desc = String.format("数据库%s删除%s", path, result? "成功": "失败");
                tvDatabase.setText(desc);
                break;
        }
    }
}