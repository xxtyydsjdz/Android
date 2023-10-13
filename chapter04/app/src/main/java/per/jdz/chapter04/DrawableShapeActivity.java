package per.jdz.chapter04;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class DrawableShapeActivity extends AppCompatActivity implements View.OnClickListener {

    private View vContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_shape);
        vContent = findViewById(R.id.v_content);
        findViewById(R.id.btn_oval).setOnClickListener(this);
        findViewById(R.id.btn_rect).setOnClickListener(this);
        // vContent的背景设置为圆角矩形
        vContent.setBackgroundResource(R.drawable.shape_rect_gold);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_rect:
                vContent.setBackgroundResource(R.drawable.shape_rect_gold);
                break;
            case R.id.btn_oval:
                vContent.setBackgroundResource(R.drawable.shape_oval_rose);
                break;
        }
    }
}