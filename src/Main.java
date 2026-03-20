import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        while(true){
            System.out.print("정수 두 개를 입력하시오 : ");
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();

            if (num1 < 0 || num2 < 0){
                System.out.println("양의 정수를 입력하세요");
                continue;
            }

            scanner.nextLine();
            System.out.print("연산자를 입력하시오 : ");
            String op = scanner.nextLine();

            int result = 0;
            if (op.charAt(0) == '+') {
                result = num1 + num2;
            } else if (op.charAt(0) == '-') {
                result = num1 - num2;
            } else if (op.charAt(0) == '*') {
                result = num1 * num2;
            } else if (op.charAt(0) == '/') {
                if(num2 == 0) {
                    System.out.println("나눗셈 연산에서 분모가 0이 될 수 없습니다.");
                }
                result = num1 / num2;
            } else if (op.equals("exit")) {
                break;
            } else {
                System.out.println("잘못된 연산자 입니다.");
                continue;
            }

            System.out.println("결과는 : " + result);
        }
    }
}