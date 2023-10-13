package per.jdz.chapter04.caseLogin;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import per.jdz.chapter04.R;

import java.util.Random;

public class LoginForgetActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etNewPassword;
    private EditText etNewPasswordAgain;
    private EditText etVerifyCode;
    private Button btnConfirm;
    private Button btnGetCode;
    private int verifyCode;
    private String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_forget);
        etNewPassword = findViewById(R.id.et_new_password);
        etNewPasswordAgain = findViewById(R.id.et_new_password_again);
        etVerifyCode = findViewById(R.id.et_verifyCode);
        btnGetCode = findViewById(R.id.btn_get_verify_code);
        btnConfirm = findViewById(R.id.btn_confirm);
        // 从上个页面获取到手机号码
        phone = getIntent().getStringExtra("phone");
        btnGetCode.setOnClickListener(this);
        btnConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_get_verify_code:
                Random random = new Random();
                verifyCode = random.nextInt(899999) + 100000;
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("验证码");
                builder.setMessage("您的验证码是：" + verifyCode);
                builder.setPositiveButton("好的", null);
                AlertDialog dialog = builder.create();
                dialog.show();
                break;
            case R.id.btn_confirm:
                if(etNewPassword.getText().toString().isEmpty()
                        || etNewPasswordAgain.getText().toString().isEmpty()
                        || etVerifyCode.getText().toString().isEmpty()) {
                    Toast.makeText(this, "请将信息补充完整！", Toast.LENGTH_SHORT).show();
                } else if(!etNewPassword.getText().toString().equals(etNewPasswordAgain.getText().toString())
                        || verifyCode != Integer.parseInt(etVerifyCode.getText().toString())) {
                    Toast.makeText(this, "验证码或密码不匹配！", Toast.LENGTH_SHORT).show();
                } else {
                    Success();
                }
                break;
        }
    }

    private void Success() {
        AlertDialog.Builder success = new AlertDialog.Builder(this);
        String desc = String.format("您的手机号码是%s,恭喜你通过找回成功，点击'确定'按钮返回上个页面", phone);
        success.setTitle("找回成功");
        success.setMessage(desc);
        success.setPositiveButton("确定", (d, which) -> {
            // 结束当前页面
            finish();
        });
        success.setNegativeButton("我在看看", null);
        AlertDialog ad = success.create();
        ad.show();
    }
}