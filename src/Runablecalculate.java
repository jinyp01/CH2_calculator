public class Runablecalculate extends ArithmeticCalculator implements Runnable{

    @Override
    public void run() {
        findBig();
    }

    // ArithmeticCalculator를 상속받은 Runablecalculate 클래스
    // run() 메소드에서 입력값보다 큰 결과값들을 출력해주는 findBig() 함수를 실행합니다.
}
