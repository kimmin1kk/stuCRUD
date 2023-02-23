package com.stucrud;
import com.stucrud.function.StudentManager;
import com.stucrud.function.StudentManagerImpl;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Client {

    public void run() {
        Scanner sc = new Scanner(System.in);
        StudentManager sm = new StudentManagerImpl();
        int num=0;
        boolean onOff= true;

        while(onOff==true) {
            System.out.println("-----------------");
            System.out.println("| 학생 관리 시스템 |");
            System.out.println("-----------------------------------------------");
            System.out.println("| 1. 입력 | 2. 검색 | 3. 출력 | 4. 삭제 | 5. 종료 |");
            System.out.println("-----------------------------------------------");
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