import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T> {

    private T num1;
    private T num2;

    public void setNum1(T num1) {
        this.num1 = num1;
    }

    public void setNum2(T num2) {
        this.num2 = num2;
    }

    ArrayList<T> results = new ArrayList<>();


    public ArithmeticCalculator() {

    }

    public ArithmeticCalculator(T num1, T num2){
        this.num1 = num1;
        this.num2 = num2;
    }

    public T getNum1() {
        return this.num1;
    }

    public T getNum2() {
        return this.num2;
    }

    public ArrayList<T> getResults() {
        return results;
    }

    public void setResults(ArrayList<T> results) {
        this.results = results;
    }

    public T setResult(T result) {
        results.add(result);
        return null;
    }

    public void findBig() {
        double n1 = Double.parseDouble(String.valueOf(num1));
        double n2 = Double.parseDouble(String.valueOf(num2));

        List<Double> Big = results.stream()
                .map(n -> Double.parseDouble(String.valueOf(n)) )
                .filter(num -> (num > n1 && num > n2))
                .collect(Collectors.toList());
        System.out.println("입력값보다 큰 수는 : " + Big);
    }

//    MyThread myThread = new MyThread() {
//
//        @Override
//        public void run() {
//            super.run();
//
//            String threadName = Thread.currentThread().getName();
//            System.out.println(threadName + " 탐색 시작 ");
//            double n1 = Double.parseDouble(String.valueOf(num1));
//            double n2 = Double.parseDouble(String.valueOf(num2));
//
//            List<Double> Big = results.stream()
//                    .map(n -> Double.parseDouble((String) n) )
//                    .filter(num -> (num > n1 && num > n2))
//                    .collect(Collectors.toList());
//            System.out.println(Big);
//        }
//    };
    // 이런식으로 구현해두니 쓰레드는 재사용이 불가능 하다는 오류가 발생하여 처음 작동을
    // 제외하고는 모두 오류가 발생하였다.



}
