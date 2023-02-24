package com.studentcrud.service;

import com.studentcrud.user.Student;
import com.studentcrud.view.UserInterface;

import java.util.ArrayList;

public class StudentManager { //학생관리와 관련된 기능
    //기능은 입력, 검색, 출력, 삭제가 있음


    ArrayList<Student> list = new ArrayList<>();


    public void inputStudent(Student student) {

        UserInterface ui = new UserInterface();
        list.add(ui.typeStudent());

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
                + "\t| 수학:" + student.getmScore()+ "\t| 총점:" + (student.getkScore() + student.geteScore() + student.getmScore())+ "\t" +
                "| 평균 :" + (student.getkScore() + student.geteScore() + student.getmScore()) / 3;
    }

    public void deleteStudent() {}



}

