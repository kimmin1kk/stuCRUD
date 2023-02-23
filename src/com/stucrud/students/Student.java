package com.stucrud.students;

public class Student { //오직 데이터만을 담고있다.
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

    public String get_name () {
        return this.name;
    }
    public int get_id() {
        return this.id;
    }
    public int get_kScore() {
        return this.kScore;
    }
    public int get_eScore() {
        return this.eScore;
    }
    public int get_mScore() {
        return this.mScore;
    }
    public int get_sumScore() { return this.sumScore;}
    public int get_avgScore() { return this.avgScore;}

}


