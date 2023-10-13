package per.jdz.chapter04.caseLogin;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import per.jdz.chapter04.R;
import per.jdz.chapter04.util.ViewUtil;

import java.util.Random;

public class LoginMainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    private TextView tvPassword;
    private EditText etPassword;
    private Button btnForget;
    private CheckBox ckRemember;
    private EditText etPhone;
    private RadioButton rbPassword;
    private RadioButton rbVerifycode;
    private ActivityResultLauncher<Intent> register;
    private Button btnLongin;
    private final static String password = "123";

    private Integer verifyCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
        tvPassword = findViewById(R.id.tv_password);
        etPhone = findViewById(R.id.et_phone);
        etPassword = findViewById(R.id.et_password);
        btnForget = findViewById(R.id.btn_forget);
        ckRemember = findViewById(R.id.ck_remember);
        rbPassword = findViewById(R.id.rb_password);
        rbVerifycode = findViewById(R.id.rb_verifycode);
        RadioGroup rbLogin = findViewById(R.id.rg_login);
        btnLongin = findViewById(R.id.btn_login);
        rbLogin.setOnCheckedChangeListener(this);
        etPhone.addTextChangedListener(new HideTextWatcher(etPhone, 11));
        etPassword.addTextChangedListener(new HideTextWatcher(etPassword, 6));
        btnForget.setOnClickListener(this);
        btnLongin.setOnClickListener(this);
        register = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_password:
                tvPassword.setText(getString(R.string.login_password));
                etPassword.setText(null);
                etPassword.setHint(getString(R.string.input_password));
                btnForget.setText(getString(R.string.forget_password));
                ckRemember.setVisibility(View.VISIBLE);
                break;
            case R.id.rb_verifycode:
                tvPassword.setText(getString(R.string.verifycode));
                etPassword.setHint(getString(R.string.input_verifycode));
                etPassword.setText(null);
                btnForget.setText(getString(R.string.get_verifycode));
                ckRemember.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        String phone = this.etPhone.getText().toString();
        if (phone.length() < 11) {
            Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
            return;
        }
        switch (v.getId()) {
            case R.id.btn_forget:
                // option password method to verify
                if (rbPassword.isChecked()) {
                    Intent intent = new Intent(this, LoginForgetActivity.class);
                    intent.putExtra("phone", phone);
                    register.launch(intent);
                } else if (rbVerifycode.isChecked()) {
                    Random random = new Random();
                    this.verifyCode = random.nextInt(899999) + 100000;
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("请记住验证码");
                    builder.setMessage("手机号：" + phone + ", 本次验证码是：" + verifyCode + " , 请输入验证码");
                    builder.setPositiveButton("好的", null);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                break;
            case R.id.btn_login:
                if (rbPassword.isChecked()) {
                    if(!password.equals(etPassword.getText().toString())) {
                        Toast.makeText(this, "密码输入错误", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    loginSuccess();
                } else if (rbVerifycode.isChecked()) {
                    if (this.verifyCode != Integer.parseInt(etPassword.getText().toString())) {
                        Toast.makeText(this, "验证码输入错误", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    loginSuccess();
                }
                break;
        }
    }

    private void loginSuccess() {
        String desc = String.format("您的手机号码是%s,恭喜你通过登录验证，点击'确定'按钮返回上个页面", etPhone.getText().toString());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("登录成功！");
        builder.setMessage(desc);
        builder.setPositiveButton("确定", (dialog, which) -> {
            // 结束当前页面
            finish();
        });
        builder.setNegativeButton("我在看看", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private class HideTextWatcher implements TextWatcher {
        private EditText et;
        private int maxLength;
        public HideTextWatcher(EditText et, int maxLength) {
            this.et = et;
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
            if (s.toString().length() == maxLength && this.et.getId() != R.id.et_phone) {
                ViewUtil.hideOneInputMethod(LoginMainActivity.this, et);
            }
        }
    }
}