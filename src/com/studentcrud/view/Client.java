package com.studentcrud.view;

import com.studentcrud.service.StudentManager;
import com.studentcrud.user.User;
import com.studentcrud.user.Student;

import java.util.Scanner;

public class Client {
    UserInterface ui = new UserInterface();
    StudentManager sm = StudentManager.getInstance();
    Student stu = new Student();
    public void run() { //이후 접속시 -> ArrayList에 학번이 있다면 1이 가능하게
        // 학생으로 로그인할지 관리자로 로그인할지 고를 수 있는 초기 페이지.
        switch (ui.loginPage()) {
            case 1: //여기서 학번을 비교해야함 학번 비교해서 맞으면 student_login();으로 넘어가게
                ui.studentLogin();
                break;
            case 2:
                ui.adminLogin();
                break;
        }
    }
    public void studentLogin() {

    }

    public void adminLogin() {

    }

    public void adminMainPage() {
        boolean onOff= true;
        while(onOff) {
            switch (ui.adminMainPage()) {
                case 1 :
                    sm.inputStudent(stu);
                    break;
                case 2 :
                    sm.searchStudent();
                    break;
                case 3 :
                    sm.printStudent();
                    break;
                case 4 :
                    sm.deleteStudent();
                    break;
                case 5 :
                    run();
                case 6 :
                    onOff = false;
                    break;
                default :
                    System.out.println("에러 발생");
                    break;
            }
        }

    }



}