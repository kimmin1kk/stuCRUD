package com.studentcrud.user;

import com.studentcrud.service.StudentManager;
import com.studentcrud.service.StudentManagerImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Administrator implements User{ //관리자(교수)가 담아야 할 데이터 뭐가 있을까

    public void login(){
        Scanner sc = new Scanner(System.in);
        String check = null;
        System.out.println("관리자 비밀번호를 입력해주세요. 취소하려면 cancel을 입력해주세요.");
        while(true) {
            System.out.printf("입력 : ");
            check = sc.nextLine();
            if(check.equals("admin1234")) {
                System.out.println("관리자로 로그인합니다.");
                mainPage();
                break;
            } else if (check.equals("cancel")) {
                System.out.println("이전 페이지로 넘어갑니다");
                break;
            } else {
                System.out.println("비밀번호가 틀렸습니다.");
                sc = new Scanner(System.in);
            }
        }
    }
    public void logout() {

    }
    public void mainPage() {
        Scanner sc = new Scanner(System.in);
        StudentManager sm = new StudentManagerImpl();
        int num=0;
        boolean onOff= true;

        while(onOff) {
            System.out.println("---------------------------");
            System.out.println("| 학생 관리 시스템 (관리자용) |");
            System.out.println("------------------------------------------------------------");
            System.out.println("| 1. 입력 | 2. 검색 | 3. 출력 | 4. 삭제 | 5. 로그아웃 | 6. 종료 |");
            System.out.println("------------------------------------------------------------");
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
                    System.out.println("입력을 선택하셨습니다.");
                    sm.typeStudent();
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
                    System.out.println("로그아웃합니다.");
                    System.out.println("로그인 페이지로 넘어갑니다.");
                    login();
                case 6 :
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
