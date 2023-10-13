package per.jdz.chapter03;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ImageScaleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_scale);
        ImageView ivScale = findViewById(R.id.iv_scale);
        ivScale.setImageResource(R.drawable.duck);
        ivScale.setScaleType(ImageView.ScaleType.FIT_START);
    }
}