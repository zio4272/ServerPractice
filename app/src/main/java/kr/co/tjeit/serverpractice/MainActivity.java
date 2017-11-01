package kr.co.tjeit.serverpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.serverpractice.Adapter.AbsentAdapter;
import kr.co.tjeit.serverpractice.data.Absent;
import kr.co.tjeit.serverpractice.util.ServerUtil;

public class MainActivity extends BaseActivity {

    private android.widget.ListView postListView;
    private android.widget.Button makePostBtn;
    List<Absent> mAbsentList = new ArrayList<>();
    AbsentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        setupEvent();
        setValues();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ServerUtil.all_absent(mContext, new ServerUtil.JsonResponseHandler() {
            @Override
            public void onResponse(JSONObject json) {

                try {
                    if (json.getBoolean("result")) {
                        JSONArray absents = json.getJSONArray("absent");

                        mAbsentList.clear();

                        for (int i=0 ; i < absents.length() ; i++) {
                            Absent abs = Absent.getAbsentFromJSON(absents.getJSONObject(i));
                            mAbsentList.add(abs);
                        }

                        mAdapter.notifyDataSetChanged();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
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
        mAdapter = new AbsentAdapter(mContext, mAbsentList);
        postListView.setAdapter(mAdapter);
    }

    @Override
    public void bindViews() {

        this.makePostBtn = (Button) findViewById(R.id.makePostBtn);
        this.postListView = (ListView) findViewById(R.id.postListView);

    }
}
