package com.studentcrud.service;

import com.studentcrud.service.StudentManager;
import com.studentcrud.user.User;
import com.studentcrud.user.Student;
import com.studentcrud.view.UserInterface;

import java.util.Scanner;

public class Client {
    UserInterface ui = new UserInterface();
    StudentManager sm = StudentManager.getInstance();
    Student stu = new Student();
    public void run() {// 학생으로 로그인할지 관리자로 로그인할지 고를 수 있는 초기 페이지.
        int id = 0; String pw = null;
        switch (ui.loginPage()) {
            case 1: // 학생 로그인
                switch(ui.studentLogin()) {
                    case 1: //로그인 성공
                        studentMainPage();
                        break;
                    case 2: //로그인 실패
                        run();
                        break;
                }

//                if(sm.studentLogin(id, pw)) {
//                    studentMainPage();
//                    break;
//                }else {
//                    break;
//                }

                ui.studentLogin();
                break;
            case 2: // 어드민 로그인
                switch(ui.adminLogin()) {
                    case 1: // 로그인 성공
                        adminMainPage();
                        break;
                    case 2: // 취소 했을 때
                        run();
                        break;
                }
                break;
        }
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
    public void studentMainPage() {
        boolean onOff= true;
        while(onOff) {
            switch(ui.studentMainPage()){
                case 1 :
                    System.out.println("성적 열람 미구현");
                    break;
                case 2:
                    run();
                case 3:
                    onOff=false;
                    break;
                default :
                    System.out.println("에러 발생");
                    break;
            }

        }

    }



}