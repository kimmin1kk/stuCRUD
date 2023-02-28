package com.studentcrud.view;

import com.studentcrud.service.StudentManager;
import com.studentcrud.user.Student;
import com.sun.istack.internal.NotNull;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static com.studentcrud.config.Configuration.MAX_SCORE;
import static com.studentcrud.config.Configuration.MIN_SCORE;

public class UserInterface {
    public int inputId() {
        int id = 0;
        System.out.print("학번을 입력하세요 :");
        id = getInput();
        return id;
    }
    public String inputPw() {
        Scanner sc = new Scanner(System.in);
        String pw = null;
        System.out.print("비밀번호를 입력하세요 :");
        pw = sc.nextLine();
        return pw;
    }
    public int loginPage() {
        Scanner sc = new Scanner(System.in);
        int choose = 0, num = 0;
        System.out.println();
        System.out.println("로그인 페이지입니다.");
        System.out.println("1. 학생 로그인 | 2. 관리자 로그인");
        choose = Integer.parseInt(sc.nextLine());
        return choose;
    }
    public int studentLogin() {
        Scanner sc = new Scanner(System.in);
        int checkId = 0;
        System.out.println("학번(아이디)을 입력하세요");
        checkId = getInput();int value=0;
        //학번 입력을 해서 일치하는 데이터 있으면 그 인덱스 다 가져온채로 메인페이지로 넘어감
        System.out.println();
        studentMainPage();
        return 1;
    }
    public int adminLogin() {
        Scanner sc = new Scanner(System.in);
        String check = null;int value=0;
        System.out.println("관리자 비밀번호를 입력해주세요. 취소하려면 cancel을 입력해주세요.");
        while(true) {
            System.out.printf("입력 : ");
            check = sc.nextLine();
            if(check.equals("admin1234")) {
                System.out.println("관리자로 로그인합니다.");
                value = 1;
                break;
            } else if (check.equals("cancel")) {
                System.out.println("이전 페이지로 넘어갑니다");
                value = 2;
                break;
            } else {
                System.out.println("비밀번호가 틀렸습니다.");
                sc = new Scanner(System.in);
            }
        }
        return value;
    }

    public int studentMainPage() {
        Scanner sc = new Scanner(System.in);
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
            if (num < 1) {
                sc = new Scanner(System.in);
                System.out.println("잘못된 입력입니다.");
                continue;
            }else if (num > 3) {
                sc = new Scanner(System.in);
                System.out.println("잘못된 입력입니다.");
                continue;
            }
            switch(num) {
                case 1:
                    System.out.println("입력을 선택하셨습니다.");break;
                case 2:
                    System.out.println("로그아웃합니다.");
                    System.out.println("로그인 페이지로 넘어갑니다.");break;
                case 3:
                    System.out.println("학생 관리 시스템을 종료합니다.");break;
            }
            return num;
        }
        return num;
    }


    public int adminMainPage() {
        Scanner sc = new Scanner(System.in);
        boolean onOff=true;
        int num=0;
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
            if (num < 1) {
                sc = new Scanner(System.in);
                System.out.println("잘못된 입력입니다.");
                continue;
            }else if (num > 6) {
                sc = new Scanner(System.in);
                System.out.println("잘못된 입력입니다.");
                continue;
            }
            switch(num) {
                case 1:
                    System.out.println("입력을 선택하셨습니다.");break;
                case 2:
                    System.out.println("검색을 선택하셨습니다.");break;
                case 3:
                    System.out.println("출력을 선택하셨습니다.");break;
                case 4:
                    System.out.println("삭제를 선택하셨습니다.");break;
                case 5:
                    System.out.println("로그아웃합니다.");
                    System.out.println("로그인 페이지로 넘어갑니다.");break;
                case 6:
                    onOff=false;
                    System.out.println("학생 관리 시스템을 종료합니다.");
                    break;
            }
            return num;
        }
        return num;
    }
    public Student typeStudent() { //학생 데이터 입력받는 메소드
        Student student = new Student();
        StudentManager sm = StudentManager.getInstance();
        Scanner sc = new Scanner(System.in);
        int id = 0;

        System.out.print("이름을 입력하세요 :");
        student.setName(sc.nextLine());
        while(true) {
            System.out.print("학번을 입력하세요 :");
            id = getInput();
            if(sm.studentExistenceTest(id)) {
                System.out.println("중복된 학번입니다. 다시 입력해주세요.");
                continue;
            }
            else {
                break;
            }
        }
        student.setId(id);
        System.out.print("국어 점수를 입력하세요 :");
        student.setkScore(getScore());
        System.out.print("영어 점수를 입력하세요 :");
        student.seteScore(getScore());
        System.out.print("수학 점수를 입력하세요");
        student.setmScore(getScore());
        System.out.println("학생이 생성되었습니다. 초기 비밀번호는 학번과 동일합니다.");
        return student;
    };









    public int getScore() { //점수 입력할 때 예외처리해둔 메소드
        int a = 0;
        Scanner sc = new Scanner(System.in);
        boolean onOff = true;
        while(onOff) {
            try {
                a = Integer.parseInt(sc.nextLine());
            }
            catch (InputMismatchException e) {
                sc = new Scanner(System.in);
                System.out.println("정수형만 입력할 수 있습니다.");
                System.out.printf("입력 : ");
                continue;
            }
            if(a < MIN_SCORE) {
                System.out.println("최저 점수는 0점입니다. 다시 입력해주세요");
                System.out.printf("입력 : ");
                sc = new Scanner(System.in);
            }else if(a > MAX_SCORE) {
                System.out.println("최대 점수는 100점입니다. 다시 입력해주세요");
                System.out.println("입력 : ");
                sc = new Scanner(System.in);
            }else {
                break;
            }
        }
        return a;
    }

    public int getInput() { //정수형만 입력받을 수 있는 메소드
        int a=0;
        Scanner sc = new Scanner(System.in);
        while(true) {
            try {
                a = Integer.parseInt(sc.nextLine());
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

    private String makeStudentInfo(Student student){
        return "|이름 :" + student.getName() + " \t\t| 학번 :" + student.getId() + "\t\t| 국어:" + student.getkScore()+ " \t| 영어:" + student.geteScore()
                + "\t| 수학:" + student.getmScore()+ "\t| 총점:" + (student.getkScore() + student.geteScore() + student.getmScore())+ "\t" +
                "| 평균 :" + (student.getkScore() + student.geteScore() + student.getmScore()) / 3;
    }

    public int findStudent() { //단순히 입력을 받는정도
        System.out.print("학번을 입력해주세요 : ");
        int check = getInput();
        return check;
    }

    public void searchFailed(int search) {
        System.out.printf("학번 : %d와 일치하는 항목이 존재하지 않습니다.\n" , search);
    }
}
