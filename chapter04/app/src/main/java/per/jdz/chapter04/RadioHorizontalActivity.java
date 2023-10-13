package per.jdz.chapter04;

import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class RadioHorizontalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_horizontal);
        TextView tvResult = findViewById(R.id.tv_result);

        RadioGroup radioGroup = findViewById(R.id.rg_gender);
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.rb_male:
                    tvResult.setText("You are handsome");
                    break;
                case R.id.rb_female:
                    tvResult.setText("You are beautiful");
                    break;
            }
        });
    }
}