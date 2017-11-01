package kr.co.tjeit.serverpractice.data;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.jar.Attributes;

/**
 * Created by the on 2017-11-01.
 */

public class Student implements Serializable {

    private int id;
    private String name;
    private String phone;
    private String loginId;
    private String loginPw;

    public static Student getStudentFromJSON(JSONObject jsonObject) {

        Student s = new Student();

        try {
            s.setId(jsonObject.getInt("id"));
            s.setLoginId(jsonObject.getString("loginId"));
            s.setName(jsonObject.getString("name"));
            s.setPhone(jsonObject.getString("phone"));
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return s;

    }

    public Student() {
    }

    public Student(int id, String name, String phone, String loginId, String loginPw) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.loginId = loginId;
        this.loginPw = loginPw;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLoginPw() {
        return loginPw;
    }

    public void setLoginPw(String loginPw) {
        this.loginPw = loginPw;
    }


}
