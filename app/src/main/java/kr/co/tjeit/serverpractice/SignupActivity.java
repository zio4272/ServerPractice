package kr.co.tjeit.serverpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import org.json.JSONObject;

import kr.co.tjeit.serverpractice.util.ServerUtil;

public class SignupActivity extends BaseActivity {

    private android.widget.EditText idEdt;
    private android.widget.EditText pwEdt;
    private android.widget.EditText nameEdt;
    private android.widget.RadioButton man;
    private android.widget.RadioButton woman;
    private android.widget.Button signBtn;
    private EditText phoneEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        bindViews();
        setupEvent();
        setValues();


        signBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ServerUtil.register_user(SignupActivity.this, idEdt.getText().toString(), pwEdt.getText().toString(), nameEdt.getText().toString(), phoneEdt.getText().toString(), new ServerUtil.JsonResponseHandler() {
                    @Override
                    public void onResponse(JSONObject json) {
                        Toast.makeText(mContext, "회원가입에 성공하였습니다.", Toast.LENGTH_SHORT).show();

                    }
                });


//                ServerUtil.sign_Up(SignupActivity.this, idEdt.getText().toString(), pwEdt.getText().toString(), nameEdt.getText().toString(), phoneEdt.getText().toString(), new ServerUtil.JsonResponseHandler() {
//                    @Override
//                    public void onResponse(JSONObject json) {
//
//                    }
//                });

            }
        });


    }

    @Override
    public void setupEvent() {

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.phoneEdt = (EditText) findViewById(R.id.phoneEdt);
        this.signBtn = (Button) findViewById(R.id.signBtn);
//        this.woman = (RadioButton) findViewById(R.id.woman);
//        this.man = (RadioButton) findViewById(R.id.man);
        this.nameEdt = (EditText) findViewById(R.id.nameEdt);
        this.pwEdt = (EditText) findViewById(R.id.pwEdt);
        this.idEdt = (EditText) findViewById(R.id.idEdt);

    }
}
