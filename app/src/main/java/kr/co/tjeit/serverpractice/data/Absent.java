package kr.co.tjeit.serverpractice.data;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by the on 2017-11-01.
 */

public class Absent implements Serializable {

    // 자체 속성
    private int id;
    private Calendar absentDate;
    private String reason;

    // 다른 클래스와의 관계를 위한 재료
    private int student_id; // 외래키 : 학생정보와 연동
    private int lecture_id; // 외래키 : 강의정보와 연동

    // 실제로 연동되는 클래스 (관계정의)
    private Student student;

    public static Absent getAbsentFromJSON(JSONObject jsonObject) {
        Absent abs = new Absent();

        return abs;

    }

    public Absent() {
    }

    public Absent(int id, Calendar absentDate, String reason, int student_id, int lecture_id, Student student) {
        this.id = id;
        this.absentDate = absentDate;
        this.reason = reason;
        this.student_id = student_id;
        this.lecture_id = lecture_id;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getAbsentDate() {
        return absentDate;
    }

    public void setAbsentDate(Calendar absentDate) {
        this.absentDate = absentDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getLecture_id() {
        return lecture_id;
    }

    public void setLecture_id(int lecture_id) {
        this.lecture_id = lecture_id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
