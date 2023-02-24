package com.studentcrud.user;

import com.studentcrud.service.StudentManager;
import com.studentcrud.service.StudentManagerImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

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

    public void login(){
        System.out.println("학번을 입력하세요");
        //학번 입력을 해서 일치하는 데이터 있으면 그 인덱스 다 가져온채로 메인페이지로 넘어감
        mainPage();
    }
    public void logout() {

    }
    public void mainPage() {
        Scanner sc = new Scanner(System.in);
        StudentManager sm = new StudentManagerImpl();
        int num=0;
        boolean onOff= true;

        while(onOff) {
            System.out.println("-------------------------");
            System.out.println("| 학생 관리 시스템 (학생용) |");
            System.out.println("-----------------------------------");
            System.out.println("| 1. 성적 열람 | 2 로그아웃 | 3. 종료 |");
            System.out.println("-----------------------------------");
            try {
                System.out.printf("값을 입력해주세요 : ");
                num = sc.nextInt();
            }
            catch (InputMismatchException e) {
                sc = new Scanner(System.in);
                System.out.println("정수형만 입력할 수 있습니다.");
                continue;
            }

            switch (num) {
                case 1 :
                    System.out.println("성적열람을 선택하셨습니다.");

                    break;
                case 2 :

                    break;
                case 3 :
                    onOff=false;
                    System.out.println("학생 관리 시스템을 종료합니다.");
                    break;
                default :
                    sc = new Scanner(System.in);
                    System.out.println("1~5사이의 값을 입력해주세요.");
                    break;
            }
        }
    }

}


