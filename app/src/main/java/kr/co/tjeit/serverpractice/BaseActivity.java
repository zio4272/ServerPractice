package kr.co.tjeit.serverpractice;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by the on 2017-10-27.
 */

public abstract class BaseActivity extends AppCompatActivity {

    Context mContext = this;

    public abstract void setupEvent();

    public abstract void setValues();

    public abstract void bindViews();

}
