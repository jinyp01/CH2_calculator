public enum OperatorType {
    PLUS("+"){
        public double calculate(double num1, double num2){
            return num1 + num2;
        }
    },
    MINUS("-"){
        public double calculate(double num1, double num2){
            return num1 - num2;
        }
    },
    MULTIPLY("*"){
        public double calculate(double num1, double num2){
            return num1 * num2;
        }
    },
    DIVIDE("/"){
        public double calculate(double num1, double num2){
            return num1 / num2;
        }
    },
    EXIT("exit"){
        public double calculate(double num1, double num2){
            throw new UnsupportedOperationException();
        }
    },
    DELETE("delete"){
        public double calculate(double num1, double num2){
            throw new UnsupportedOperationException();
        }
    };

    private String op;

    public abstract double calculate(double num1, double num2);


    OperatorType(String op) {
        this.op = op;
    }
    public static OperatorType searchOperator(String operator){
        for(OperatorType op : values() )
            if (op.op.equals(operator)){
                return op;
            }
        return null;
    }
}