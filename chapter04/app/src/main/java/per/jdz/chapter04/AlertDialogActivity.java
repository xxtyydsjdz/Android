package per.jdz.chapter04;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.time.LocalDate;

public class AlertDialogActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private TextView textView;
    private DatePicker picker;
    private TextView tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        textView = findViewById(R.id.tv_alert);
        findViewById(R.id.btn_alert).setOnClickListener(v->{
            // 创建对话框的建造器
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("尊敬的用户");
            // 对话框内容文本
            builder.setMessage("不要卸载我啊!");
            builder.setPositiveButton("残忍卸载", (dialog, which) -> {
                textView.setText("跑路跑路");
            });
            builder.setNegativeButton("我同意", (dialog, which)->{
                textView.setText("陪你陪你");
            });
            // 根据建造器创建对话框对象
            AlertDialog alertDialog = builder.create();
            // 显示出来
            alertDialog.show();
        });
        findViewById(R.id.btn_ok).setOnClickListener(this);
        findViewById(R.id.btn_date).setOnClickListener(this);
        tvDate = findViewById(R.id.tv_date);
        picker = findViewById(R.id.dp_date);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ok:
                String format = String.format("%d年%d月%d日", picker.getYear(), picker.getMonth() + 1, picker.getDayOfMonth());
                tvDate.setText(format);
                break;
            case R.id.btn_date:
                LocalDate now = LocalDate.now();
                DatePickerDialog dateDialog = new DatePickerDialog(this,this, now.getYear(), now.getMonth().getValue(), now.getDayOfMonth());
                dateDialog.show();
                break;
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String format = String.format("%d年%d月%d日", year, month, dayOfMonth);
        tvDate.setText(format);
    }
}