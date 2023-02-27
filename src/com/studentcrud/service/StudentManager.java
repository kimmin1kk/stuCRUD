package com.studentcrud.service;

import com.studentcrud.config.Configuration;
import com.studentcrud.user.Student;
import com.studentcrud.user.User;
import com.studentcrud.view.UserInterface;

import java.util.ArrayList;

public class StudentManager { //학생관리와 관련된 기능
    //기능은 입력, 검색, 출력, 삭제가 있음

    private static StudentManager studentManager = null;

    private StudentManager() {}

    public static StudentManager getInstance() {
        if(studentManager == null) {
            studentManager = new StudentManager();
        }
        return studentManager;
    }


    ArrayList<Student> list = new ArrayList<>();
    public void inputStudent(Student student) {
        UserInterface ui = new UserInterface();
        list.add(ui.typeStudent());
    }
    public void searchStudent() {
        UserInterface ui = new UserInterface();
        int search = ui.findStudent();
        Student findedStudent = null;
        for (Student std : list) {
            if (search == std.getId()) {
                findedStudent = std;
            }
        }
        if(findedStudent instanceof Student){
            ui.printStudent(findedStudent);
        }else {
            ui.searchFailed(search);
        }
    }
    public void deleteStudent() {
        UserInterface ui = new UserInterface();
        int search = ui.findStudent(); int cnt = 0;
        for (Student std : list) {
            if (search == std.getId()) {
                list.remove(cnt);
                break;
            }
            cnt ++;
        }
    }
    public void printStudent() {
        UserInterface ui = new UserInterface();
        for(Student std : list) {
            ui.printStudent(std);
        }

    }




}



