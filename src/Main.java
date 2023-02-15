import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
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
                    break;
                case 2 :
                    break;
                case 3 :
                    break;
                case 4 :
                    break;
                case 5 :
                    onOff=false;
                    System.out.println("학생 관리 시스템을 종료합니다.");
                    break;
                default :
                    sc = new Scanner(System.in);
                    System.out.println("1~5사이의 값을 입력해주세요.");



            }

        }
    }
}