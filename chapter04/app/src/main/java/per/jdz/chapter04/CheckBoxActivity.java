package per.jdz.chapter04;

import android.view.View;
import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class CheckBoxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        CheckBox checkBox = findViewById(R.id.ck_custom);
        checkBox.setOnClickListener(v -> {
            if (checkBox.isChecked()) {
                checkBox.setText("you have click it!");
            } else {
                checkBox.setText("you don't click it");
            }
        });
    }
}