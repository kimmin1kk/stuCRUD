package com.studentcrud.view;

import com.studentcrud.service.StudentManager;
import com.studentcrud.user.Student;
import java.util.InputMismatchException;
import java.util.Scanner;

import static com.studentcrud.config.Configuration.MAX_SCORE;
import static com.studentcrud.config.Configuration.MIN_SCORE;

public class UserInterface {
    public int inputId() { // 아이디를 입력하는 메서드
        int id = 0;
        System.out.print("학번을 입력하세요 :");
        id = getInput();
        return id;
    }
    public String inputPw() { // 비밀번호를 입력하는 메서드
        Scanner sc = new Scanner(System.in);
        String pw = null;
        System.out.print("비밀번호를 입력하세요 :");
        pw = sc.nextLine();
        return pw;
    }
    public int loginPage() { // 처음 화면을 켰을 때 ui 메서드
        Scanner sc = new Scanner(System.in);
        int choose = 0, num = 0;
        System.out.println();
        System.out.println("로그인 페이지입니다.");
        System.out.println("1. 학생 로그인 | 2. 관리자 로그인");
        while(true){
            choose = getInput();
            if (choose < 1) {
                sc = new Scanner(System.in);
                System.out.println("잘못된 입력입니다.");
            }else if (choose > 2) {
                sc = new Scanner(System.in);
                System.out.println("잘못된 입력입니다.");
            }else {
                    break;
            }
        }
        return choose;
    }
    public int adminLogin() { // 어드민 로그인을 선택했을 때 ui 메서드
        Scanner sc = new Scanner(System.in);
        String check = null;int value=0;
        System.out.println("관리자 비밀번호를 입력해주세요. 취소하려면 cancel을 입력해주세요.");
        while(true) {
            System.out.print("입력 : ");
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

    public int studentMainPage() { // 학생으로 로그인 했을 때 ui 메서드
        Scanner sc = new Scanner(System.in);
        int num=0;
        boolean onOff= true;
        while(onOff) {
            System.out.println("-------------------------");
            System.out.println("| 학생 관리 시스템 (학생용) |");
            System.out.println("-----------------------------------");
            System.out.println("| 1. 성적 열람 | 2 수정 | 3 로그아웃 | 4. 종료 |");
            System.out.println("-----------------------------------");
            try {
                System.out.print("값을 입력해주세요 : ");
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
            }else if (num > 4) {
                sc = new Scanner(System.in);
                System.out.println("잘못된 입력입니다.");
                continue;
            }
            switch(num) {
                case 1:
                    System.out.println("성적 열람을 선택하셨습니다.");break;
                case 2:
                    System.out.println("수정을 선택하셨습니다.");break;
                case 3:
                    System.out.println("로그아웃합니다.");
                    System.out.println("로그인 페이지로 넘어갑니다.");break;
                case 4:
                    System.out.println("학생 관리 시스템을 종료합니다.");break;
            }
            return num;
        }
        return num;
    }
    public int replaceStudentInformation() { // 학생으로 로그인해서 수정을 선택했을 때 호출되는 ui 메서드
        Scanner sc = new Scanner(System.in);
        int num = 0;
        boolean onOff = true;
        while (onOff) {
            System.out.println("----------------");
            System.out.println("| 학생 정보 수정 |");
            System.out.println("--------------------------------------");
            System.out.println("| 1. 이름 변경 | 2 비밀번호 변경 | 3 취소 |");
            System.out.println("--------------------------------------");
            try {
                System.out.print("값을 입력해주세요 : ");
                num = sc.nextInt();
            } catch (InputMismatchException e) {
                sc = new Scanner(System.in);
                System.out.println("정수형만 입력할 수 있습니다.");
                continue;
            }
            if (num < 1) {
                sc = new Scanner(System.in);
                System.out.println("잘못된 입력입니다.");
                continue;
            } else if (num > 3) {
                sc = new Scanner(System.in);
                System.out.println("잘못된 입력입니다.");
                continue;
            }
            switch(num) {
                case 1:
                    System.out.println("이름 변경을 선택하셨습니다.");break;
                case 2:
                    System.out.println("비밀번호 변경을 선택하셨습니다.");break;
                case 3:
                    System.out.println("정보 수정을 취소합니다.");break;
            }
            return num;
        }
        return num;
    }
    public int adminMainPage() { // 어드민 로그인했을 때 ui 메서드
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
                System.out.print("값을 입력해주세요 : ");
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

    public Student typeStudent() { // 학생 데이터 입력받는 메소드
//        Student student = new Student();
        StudentManager sm = StudentManager.getInstance();
        Scanner sc = new Scanner(System.in);
        String name;
        int id, kScore, eScore, mScore;
        System.out.print("이름을 입력하세요 :");
        name = sc.nextLine();
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
        System.out.print("국어 점수를 입력하세요 :");
        kScore = getScore();
        System.out.print("영어 점수를 입력하세요 :");
        eScore = getScore();
        System.out.print("수학 점수를 입력하세요 :");
        mScore = getScore();
        System.out.println("학생이 생성되었습니다. 초기 비밀번호는 학번과 동일합니다.");
        Student student = new Student(name, id, kScore, eScore, mScore);
        return student;
    };

    public int getScore() { //점수 입력할 때 예외처리해둔 메서드
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
                System.out.print("입력 : ");
                continue;
            }
            if(a < MIN_SCORE) {
                System.out.println("최저 점수는 0점입니다. 다시 입력해주세요");
                System.out.print("입력 : ");
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

    public int getInput() { //정수형만 입력받을 수 있는 메서드
        int a=0;
        Scanner sc = new Scanner(System.in);
        while(true) {
            try {
                a = Integer.parseInt(sc.nextLine());
            }catch(InputMismatchException e){
                System.out.println("숫자만 입력하세요. (InputMismatchException 에러 발생");
                System.out.print("입력 : ");
                sc = new Scanner(System.in);
                continue;
            }catch(NumberFormatException e){
                System.out.println("숫자만 입력하세요. (NumberFormatException 에러 발생)");
                System.out.print("입력 : ");
                sc = new Scanner(System.in);
                continue;
            }
                if (a < 0) {
                System.out.println("잘못된 접근입니다.");
                System.out.print("다시 입력 : ");
                sc = new Scanner(System.in);
            }else {
                break;
            }
        }
        return a;
    }


    public void printStudent(Student student) { //출력하는 메서드.
        System.out.println(makeStudentInfo(student));
    }
    private String makeStudentInfo(Student student){ //인자로 받은 student 타입의 ArrayList 를 출력형식에 맞게 가공하는 메서드
        return "|이름 :" + student.getName() + " \t\t| 학번 :" + student.getId() + "\t\t| 국어:" + student.getkScore()+ " \t| 영어:" + student.geteScore()
                + "\t| 수학:" + student.getmScore()+ "\t| 총점:" + (student.getkScore() + student.geteScore() + student.getmScore())+ "\t" +
                "| 평균 :" + (student.getkScore() + student.geteScore() + student.getmScore()) / 3;
    }

    public int findStudent() { // 단순히 입력을 받는 메서드
        System.out.print("학번을 입력해주세요 : ");
        int check = getInput();
        return check;
    }

    public void searchFailed(int search) { // 검색에 실패했을 때 호출되는 메서드
        System.out.printf("학번 : %d와 일치하는 항목이 존재하지 않습니다.\n" , search);
    }

    public void replaceStudentName(Student student) { // 이름을 수정할 때 쓰는 메서드
        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 이름을 입력해주세요 :");
        String name = sc.nextLine();
        student.setName(name);
    }

    public void replaceStudentPassword(Student student) { // 비밀번호를 수정할 때 쓰는 메서드
        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 비밀번호를 입력해주세요 :");
        String pw = sc.nextLine();
        student.setPw(pw);
    }
}
