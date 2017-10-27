package kr.co.tjeit.serverpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends BaseActivity {

    private android.widget.ListView postListView;
    private android.widget.Button makePostBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        setupEvent();
        setValues();
    }

    @Override
    public void setupEvent() {

        makePostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, MakePostActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {

        this.makePostBtn = (Button) findViewById(R.id.makePostBtn);
        this.postListView = (ListView) findViewById(R.id.postListView);

    }
}
