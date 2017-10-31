package kr.co.tjeit.serverpractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import kr.co.tjeit.serverpractice.util.ServerUtil;

public class LoginActivity extends AppCompatActivity {

    private android.widget.Button button;
    private Button signupBtn;
    private android.widget.EditText idEdt;
    private android.widget.EditText pwEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.pwEdt = (EditText) findViewById(R.id.pwEdt);
        this.idEdt = (EditText) findViewById(R.id.idEdt);
        this.signupBtn = (Button) findViewById(R.id.signupBtn);
        this.button = (Button) findViewById(R.id.button);



        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ServerUtil.sign_In(LoginActivity.this, idEdt.getText().toString(), pwEdt.getText().toString(), new ServerUtil.JsonResponseHandler() {
                    @Override
                    public void onResponse(JSONObject json) {

                        try {
                            if(json.getBoolean("result")) {
                                Toast.makeText(LoginActivity.this, "로그인 한 사용자 : " + json.getJSONObject("student").getString("name"), Toast.LENGTH_SHORT).show();
                                
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                                
                            }
                            else {
                                Toast.makeText(LoginActivity.this, "로그인에 실패했습니다.", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });

            }
        });


    }
}
