package com.studentcrud.service;

import java.util.*;


import com.studentcrud.user.Student;
public class StudentManager { //여기에 기능들을 넣을 예정
    //기능은 입력, 검색, 출력, 삭제가 있음

    Scanner sc = new Scanner(System.in);
    ArrayList<Student> list = new ArrayList<>();



    public void typeStudent() {
        String name;
        int id, kScore=0, eScore=0, mScore=0;
        System.out.printf("이름을 입력하세요 :");
        name = sc.nextLine();
        System.out.printf("학번을 입력하세요 :");
        id = Integer.parseInt(sc.nextLine());
        System.out.println("국어 점수를 입력하세요 :");
        kScore = scoreInput(kScore);
        System.out.println("영어 점수를 입력하세요 :");
        eScore = scoreInput(eScore);
        System.out.println("수학 점수를 입력하세요");
        mScore = scoreInput(mScore);
        Student st = new Student(name, id, kScore, eScore, mScore) {
        };
        list.add(st);

    }

    public void searchStudent() {}

    public void printStudent() {
//        Iterator<Student> iterator = list.iterator();
//        while(iterator.hasNext()) {
//            Student stu = iterator.next();
//            System.out.println(stu.toString());
//        }
        for(Student std : list) {
            System.out.println(makeStudentInfo(std));
        }
    }
    private String makeStudentInfo(Student student){
        return "|이름 :" + student.getName() + " \t\t| 학번 :" + student.getId() + "\t\t| 국어:" + student.getkScore()+ " \t| 영어:" + student.geteScore()
                + "\t| 수학:" + student.getmScore()+ "\t| 총점:" + student.getSumScore()+ "\t| 평균 :" + student.getAvgScore();
    }

    public void deleteStudent() {}

    public int scoreInput (int a) {
        Scanner sc = new Scanner(System.in);
        boolean onOff = true;
        while(onOff) {
            try {
                a = sc.nextInt();
            }
            catch (InputMismatchException e) {
                sc = new Scanner(System.in);
                System.out.println("정수형만 입력할 수 있습니다.");
                System.out.printf("입력 : ");
                continue;
            }
            if(a < 0) {
                System.out.println("최저 점수는 0점입니다. 다시 입력해주세요");
                System.out.printf("입력 : ");
                sc = new Scanner(System.in);
            }else if(a > 100) {
                System.out.println("최대 점수는 100점입니다. 다시 입력해주세요");
                System.out.println("입력 : ");
                sc = new Scanner(System.in);
            }else {
                break;
            }
        }
        return a;
    }

}

