package com.studentcrud.view;

import com.studentcrud.user.User;

import java.util.Scanner;

public class Client {
    UserInterface ui = new UserInterface();
    public void run() { //이후 접속시 -> ArrayList에 학번이 있다면 1이 가능하게
        // 학생으로 로그인할지 관리자로 로그인할지 고를 수 있는 초기 페이지.
        Scanner sc = new Scanner(System.in);
        UserInterface ui = new UserInterface();
        int choose = 0, num = 0;
        System.out.println();
        System.out.println("로그인 페이지입니다.");
        System.out.println("1. 학생 로그인 | 2. 관리자 로그인");
        choose = Integer.parseInt(sc.nextLine());
        switch (choose) {
            case 1: //여기서 학번을 비교해야함 학번 비교해서 맞으면 student_login();으로 넘어가게
                ui.student_login();
                break;
            case 2:
                ui.adminLogin();
                break;
        }
    }

}