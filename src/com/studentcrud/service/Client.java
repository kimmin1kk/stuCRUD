package com.studentcrud.service;

import com.studentcrud.user.Student;
import com.studentcrud.view.UserInterface;

import java.util.Scanner;

public class Client {
    UserInterface ui = new UserInterface();
    StudentManager sm = StudentManager.getInstance();
    Student stu = new Student();
    public void run() {// 학생으로 로그인할지 관리자로 로그인할지 고를 수 있는 초기 페이지.
        int id = 0; String pw = null; int index = 0;
        switch (ui.loginPage()) {
            case 1: // 학생 로그인
              id = ui.inputId();
              pw = ui.inputPw();
              index = sm.findIndex(id);

                if(sm.studentLogin(id, pw)) { //로그인 성공
                    studentMainPage(sm.list.get(index));
                    break;
                }else { //로그인 실패
                    System.out.println("로그인 실패");
                    run();
                    break;
                }

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
    public void adminMainPage() { //어드민으로 로그인했을때 호출되는 메서드
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
                    run(); //break 안 달은 이유 : 로그아웃할 때 현재 창이 종료가 되면서 새로운 창으로 넘어가는 느낌이라서
                case 6 :
                    onOff = false;
                    break;
                default :
                    System.out.println("에러 발생");
                    break;
            }
        }

    }
    public void studentMainPage(Student student) { //학생으로 로그인 했을때 호출되는 메서드
        boolean onOff= true;
        while(onOff) {
            switch(ui.studentMainPage()){
                case 1 :
                    ui.printStudent(student);
                    break;
                case 2:
                    switch(ui.replaceStudentInformation()) {
                        case 1: //이름 변경
                            ui.replaceStudentName(student);
                            break;
                        case 2: //비밀번호 변경
                            ui.replaceStudentPassword(student);
                            break;
                        case 3: //취소
                            studentMainPage(student);
                            break;
                    };
                    break;
                case 3:
                    run();
                case 4:
                    onOff=false;
                    break;
                default :
                    System.out.println("에러 발생");
                    break;
            }

        }

    }



}