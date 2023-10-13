package per.jdz.chapter04;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import per.jdz.chapter04.util.ViewUtil;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        EditText etPhone = findViewById(R.id.et_phone);
        EditText etPassword = findViewById(R.id.et_password);
        etPhone.addTextChangedListener(new HideTextWatcher(etPhone, 11));
        // 用焦点变更事件而非点击事件
        etPassword.setOnFocusChangeListener((v, hasFocus) -> {
            if(hasFocus) {
                String number = etPhone.getText().toString();
                // <11
                if(TextUtils.isEmpty(number) || number.length() < 11) {
                    // 手机号码编辑框请求焦点
                    etPhone.requestFocus();
                    Toast.makeText(this, "请输入11位手机号码", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

//    定义一个编辑框监听器，在输入文本达到指定长度时自动隐藏输入法
    private class HideTextWatcher implements TextWatcher {
        private EditText view;
        private int maxLength;
        public HideTextWatcher(EditText phone, int maxLength) {
            this.view = phone;
            this.maxLength = maxLength;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            //  获得已输入的文本字符串
            String str = s.toString();
            if(str.length() == maxLength) {
                // hide
                ViewUtil.hideOneInputMethod(EditActivity.this, view);
            }
        }
    }
}