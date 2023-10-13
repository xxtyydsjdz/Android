package per.jdz;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ShareWriteActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etName;
    private EditText etAge;
    private EditText etHeight;
    private EditText etWeight;
    private CheckBox ckMarried;
    private SharedPreferences config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_write);
        etName = findViewById(R.id.et_name);
        etAge = findViewById(R.id.et_age);
        etHeight = findViewById(R.id.et_height);
        etWeight = findViewById(R.id.et_weight);
        ckMarried = findViewById(R.id.ck_married);
        findViewById(R.id.btn_save).setOnClickListener(this);
        config = getSharedPreferences("config", Context.MODE_PRIVATE);
        reload();
    }

    private void reload() {
        String name = config.getString("name", null);
        if (name != null) {
            etName.setText(name);
        }
        Integer age = config.getInt("age", -1);
        if (age != -1) {
            etAge.setText(String.valueOf(age));
        }
        Float height = config.getFloat("height", -1L);
        if (height != -1L) {
            etHeight.setText(String.valueOf(height));
        }
        Float weight = config.getFloat("weight", -1L);
        if (weight != -1L) {
            etWeight.setText(String.valueOf(weight));
        }
        boolean married = config.getBoolean("married", false);
        ckMarried.setChecked(married);
    }

    @Override
    public void onClick(View v) {
        String name = etName.getText().toString();
        String age = etAge.getText().toString();
        String height = etHeight.getText().toString();
        String weight = etWeight.getText().toString();
        SharedPreferences.Editor edit = config.edit();
        edit.putString("name", name);
        edit.putInt("age", Integer.parseInt(age));
        edit.putFloat("height", Float.parseFloat(height));
        edit.putFloat("weight", Float.parseFloat(weight));
        edit.putBoolean("married", ckMarried.isChecked());
        edit.apply();
    }
}