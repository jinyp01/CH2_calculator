import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Calculator {

    private ArrayList<Integer> results = new ArrayList<>();


    // 생성자
    public void Calculator() {

    }


    public int plus(int num1, int num2){
        int result = num1 + num2;
        return result;
    }

    public int minus(int num1, int num2){
        int result = num1 - num2;
        return result;
    }

    public int multifly(int num1, int num2){
        int result = num1 * num2;
        return result;
    }

    public int divide(int num1, int num2){
        int result = num1 / num2;
        return result;
    }


    public void setResults(ArrayList<Integer> results) {
        this.results = results;
    }

    public ArrayList<Integer> getResults() {
        return results;
    }

    public Integer setResult(Integer result) {
        results.add(result);
        return 0;
    }
}
