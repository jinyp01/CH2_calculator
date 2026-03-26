import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;




public class Main {




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Runablecalculate runablecalculate = new Runablecalculate() ;
        // ArithmeticCalculator를 상속받은 runablecalculate 를 인스턴스화 해줍니다.
        Double num1, num2, result;


        while(true){
            System.out.print("0 또는 양수 두 개를 입력하시오 : ");
            try {
                num1 = scanner.nextDouble();
                num2 = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. ");
                scanner.nextLine();
                // 잘못된 입력이었을 때 한줄 비워서 입력값에
                // 오류메시지가 들어가는 현상 막아주기
                continue;
            }
            runablecalculate.setNum1(num1);
            runablecalculate.setNum2(num2);


            if (num1 < 0 || num2 < 0){
                System.out.println("양수를 입력하세요");
                continue;
            }

            scanner.nextLine();
            System.out.print("연산자를 입력하시오 : ");
            String op = scanner.nextLine();


            OperatorType operatorType = OperatorType.searchOperator(op);
            if(operatorType==null){
                System.out.println("잘못된 연산자입니다.");
                continue;
            }
            // operatorType 에서 연산자들을 구분짓기, exit, delete 포함



            try{
                Thread t = new Thread(runablecalculate);
                t.start();
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // 쓰레드를 실행시켜서 입력값보다 큰 결과값들의 모음을 출력해줍니다.
            // 콘솔에서 출력이 겹치는 문제가 발생하여 결과가 출력될 때까지 기다려줍니다.

            if (op.equals("delete")) {
                ArrayList<Double> arrayList = runablecalculate.getResults();
                System.out.println("다음 result 가 삭제됩니다 : " + arrayList.get(0));
                arrayList.remove(0);
                runablecalculate.setResults(arrayList);
                continue;

                // delete가 입력되면 결과값들의 모음을 <Double> arrayList로 받아주고,
                // 첫 번째 항목을 삭제한 다음 다시 저장합니다.
            } else if (op.equals("exit")) {
                break;
            } else {
                result = operatorType.calculate(num1, num2);
            }

            System.out.println("결과는 : " + result);
            runablecalculate.setResult(result);
        }
    }
}