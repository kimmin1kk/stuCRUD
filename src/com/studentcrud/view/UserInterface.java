package com.studentcrud.view;

import com.studentcrud.service.StudentManager;
import com.studentcrud.user.Student;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    Student stu = new Student();

    public void student_login(){
        System.out.println("학번을 입력하세요");
        //학번 입력을 해서 일치하는 데이터 있으면 그 인덱스 다 가져온채로 메인페이지로 넘어감
        student_mainPage();
    }
    public void student_mainPage() {
        Scanner sc = new Scanner(System.in);
        StudentManager sm = new StudentManager();
        Client cl = new Client();
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
                    System.out.println("로그아웃합니다.");
                    System.out.println("로그인 페이지로 넘어갑니다.");
                    cl.run();
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

    public void admin_login(){
        Scanner sc = new Scanner(System.in);
        String check = null;
        System.out.println("관리자 비밀번호를 입력해주세요. 취소하려면 cancel을 입력해주세요.");
        while(true) {
            System.out.printf("입력 : ");
            check = sc.nextLine();
            if(check.equals("admin1234")) {
                System.out.println("관리자로 로그인합니다.");
                admin_mainPage();
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
    public void admin_mainPage() {
        Scanner sc = new Scanner(System.in);
        StudentManager sm = new StudentManager();
        Client cl = new Client();
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
                    System.out.println("로그아웃합니다.");
                    System.out.println("로그인 페이지로 넘어갑니다.");
                    cl.run();
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
    public Student typeStudent() {
        Student student = new Student();
        String name=null;
        int id=0, kScore=0, eScore=0, mScore=0;
        Scanner sc = new Scanner(System.in);
        System.out.printf("이름을 입력하세요 :");
        student.setName(sc.nextLine());
        System.out.printf("학번을 입력하세요 :");
        student.setId(Integer.parseInt(sc.nextLine()));
        System.out.println("국어 점수를 입력하세요 :");
        student.setkScore(scoreInput(kScore));
        System.out.println("영어 점수를 입력하세요 :");
        student.seteScore(scoreInput(eScore));
        System.out.println("수학 점수를 입력하세요");
        student.setmScore(scoreInput(mScore));
        return student;
    };
    public int scoreInput(int a) {
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
