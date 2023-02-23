package com.studentcrud.service;

import java.util.*;


import com.studentcrud.user.Student;
public class StudentManagerImpl implements StudentManager{ //여기에 기능들을 넣을 예정
    //기능은 입력, 검색, 출력, 삭제가 있음

    Scanner sc = new Scanner(System.in);
    ArrayList<Student> list = new ArrayList<>();


    @Override
    public void typeStudent() {
        String name;
        int id, kScore, eScore, mScore;
        System.out.printf("이름을 입력하세요 :");
        name = sc.nextLine();
        System.out.printf("학번을 입력하세요 :");
        id = Integer.parseInt(sc.nextLine());
        System.out.println("국어 점수를 입력하세요 :");
        kScore = Integer.parseInt(sc.nextLine());
        System.out.println("영어 점수를 입력하세요 :");
        eScore = Integer.parseInt(sc.nextLine());
        System.out.println("수학 점수를 입력하세요");
        mScore = Integer.parseInt(sc.nextLine());
        Student st = new Student(name, id, kScore, eScore, mScore) {
        };
        list.add(st);

    }


    @Override
    public void searchStudent() {}



    @Override
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
        return "|이름 :" + student.get_name() + " \t\t| 학번 :" + student.get_id() + "\t\t| 국어:" + student.get_kScore()+ " \t| 영어:" + student.get_eScore()
                + "\t| 수학:" + student.get_mScore()+ "\t| 총점:" + student.get_sumScore()+ "\t| 평균 :" + student.get_avgScore();
    }


    @Override
    public void deleteStudent() {}
}
