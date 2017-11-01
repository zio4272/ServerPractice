package kr.co.tjeit.serverpractice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.Calendar;

import kr.co.tjeit.serverpractice.util.ServerUtil;

public class MakePostActivity extends BaseActivity {

    private android.widget.EditText contentEdt;
    private android.widget.Button okBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_post);
        bindViews();
        setupEvent();
        setValues();



    }

    @Override
    public void setupEvent() {

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ServerUtil.absent(mContext,contentEdt.getText().toString(),  new ServerUtil.JsonResponseHandler() {
                    @Override
                    public void onResponse(JSONObject json) {

                        Toast.makeText(mContext, "게시글 등록됨", Toast.LENGTH_SHORT).show();
                        finish();

                    }
                });

            }
        });

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {

        this.okBtn = (Button) findViewById(R.id.okBtn);
        this.contentEdt = (EditText) findViewById(R.id.contentEdt);

    }
}
