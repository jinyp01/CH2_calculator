import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;




public class Main {




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();
        Runablecalculate runablecalculate = new Runablecalculate() ;
        //
        Double num1, num2, result;


        while(true){
            System.out.print("0을 포함한 양수 두 개를 입력하시오 : ");
            num1 = scanner.nextDouble();
            num2 = scanner.nextDouble();
            runablecalculate.setNum1(num1);
            runablecalculate.setNum2(num2);

//            arithmeticCalculator
//                    = new ArithmeticCalculator<>(
//                            num1 = scanner.nextDouble(),
//                            num2 = scanner.nextDouble());


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



            try{
                Thread t = new Thread(runablecalculate);
                t.start();
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (op.equals("delete")) {
                ArrayList<Double> arrayList = runablecalculate.getResults();
                System.out.println("다음 result 가 삭제됩니다 : " + arrayList.get(0));
                arrayList.remove(0);
                runablecalculate.setResults(arrayList);
                continue;
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