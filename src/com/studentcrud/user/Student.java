package com.studentcrud.user;

public class Student implements User{ //오직 데이터만을 담고있다.
    private String name;
    private int id;
    private int kScore;
    private int eScore;
    private int mScore;
    private int sumScore;
    private int avgScore;

    public Student(String name, int id, int kScore, int eScore, int mScore) {
        this.name = name;
        this.id = id;
        this.kScore = kScore;
        this. eScore = eScore;
        this.mScore = mScore;
        this.sumScore = kScore + eScore + mScore;
        this.avgScore = (kScore + eScore + mScore) / 3;
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

    public int getSumScore() {
        return sumScore;
    }

    public int getAvgScore() {
        return avgScore;
    }
}


