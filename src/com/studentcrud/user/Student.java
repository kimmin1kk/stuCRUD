package com.studentcrud.user;

public class Student extends User{ //오직 데이터만을 담고있다.
    private String name;
    private int id;
    private int kScore;
    private int eScore;
    private int mScore;
    public Student(String name, int id, int kScore, int eScore, int mScore) {
        this.name = name;
        this.id = id;
        this.kScore = kScore;
        this. eScore = eScore;
        this.mScore = mScore;
    }
    public Student() { //오버로딩

    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getkScore() {
        return kScore;
    }

    public int geteScore() {
        return eScore;
    }

    public int getmScore() {
        return mScore;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setkScore(int kScore) {
        this.kScore = kScore;
    }

    public void seteScore(int eScore) {
        this.eScore = eScore;
    }

    public void setmScore(int mScore) {
        this.mScore = mScore;
    }

}


