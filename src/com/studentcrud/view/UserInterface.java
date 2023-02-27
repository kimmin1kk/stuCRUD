package com.studentcrud.view;

import com.studentcrud.service.StudentManager;
import com.studentcrud.user.Student;
import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
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

    public void adminLogin(){
        Scanner sc = new Scanner(System.in);
        String check = null;
        System.out.println("관리자 비밀번호를 입력해주세요. 취소하려면 cancel을 입력해주세요.");
        while(true) {
            System.out.printf("입력 : ");
            check = sc.nextLine();
            if(check.equals("admin1234")) {
                System.out.println("관리자로 로그인합니다.");
                adminMainPage();
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
    public void adminMainPage() {
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
    public Student typeStudent() { //학생 데이터 입력받는 메소드
        Student student = new Student();
        String name=null;
        int id=0, kScore=0, eScore=0, mScore=0;
        Scanner sc = new Scanner(System.in);
        System.out.printf("이름을 입력하세요 :");
        student.setName(sc.nextLine());
        System.out.printf("학번을 입력하세요 :");
        student.setId(onlyInputNumber());
//        student.setId(Integer.parseInt(sc.nextLine()));
        System.out.println("국어 점수를 입력하세요 :");
        student.setkScore(scoreInput(kScore));
        System.out.println("영어 점수를 입력하세요 :");
        student.seteScore(scoreInput(eScore));
        System.out.println("수학 점수를 입력하세요");
        student.setmScore(scoreInput(mScore));
        return student;
    };
    public int scoreInput(int a) { //점수 입력할 때 예외처리해둔 메소드
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

    public int onlyInputNumber() {
        int a=0;
        Scanner sc = new Scanner(System.in);
        while(true) {
            try {
                a = Integer.parseInt(sc.nextLine());
//                a = sc.nextInt();
            }catch(InputMismatchException e){
                System.out.println("숫자만 입력하세요. (InputMismatchException 에러 발생");
                System.out.printf("입력 : ");
                sc = new Scanner(System.in);
                continue;
            }catch(NumberFormatException e){
                System.out.println("숫자만 입력하세요. (NumberFormatException 에러 발생)");
                System.out.printf("입력 : ");
                sc = new Scanner(System.in);
                continue;
            }
                if (a < 0) {
                System.out.println("잘못된 접근입니다.");
                System.out.printf("다시 입력 : ");
                sc = new Scanner(System.in);
            }else {
                break;
            }
        }
        return a;
    }


    public void printStudent(Student student) {
        System.out.println(makeStudentInfo(student));
    }

    public String makeStudentInfo(Student student){
        return "|이름 :" + student.getName() + " \t\t| 학번 :" + student.getId() + "\t\t| 국어:" + student.getkScore()+ " \t| 영어:" + student.geteScore()
                + "\t| 수학:" + student.getmScore()+ "\t| 총점:" + (student.getkScore() + student.geteScore() + student.getmScore())+ "\t" +
                "| 평균 :" + (student.getkScore() + student.geteScore() + student.getmScore()) / 3;
    }

    public int findStudent() {
        int check=0;
        System.out.print("학번을 입력해주세요 : ");
        check = onlyInputNumber();

        return check;
    }

    public void searchFailed(int search) {
        System.out.printf("학번 : %d와 일치하는 항목이 존재하지 않습니다.\n" , search);
    }

}
