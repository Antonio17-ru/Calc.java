public class Calculator3 {
    int x;
    int y;
    OperationRom operation;
    private String result;
    private NumbersType type;

    public String getResult() {
        return result;
    }

    public Calculator3(int x, int y, OperationRom operation, NumbersType type) {
        this.type = type;
        this.operation = operation;
        this.x = x;
        this.y = y;
    }

    public void run() throws ResException, CharException, RomanException {
        if (x > 10 || y > 10 || x < 1 || y < 1) {
            throw new ResException();
        }

        if (operation == null) {
            System.out.println("Operation = null");
        } else {
            int resultInt = 0;
            switch (operation) {
                case SUM:
                    resultInt = x + y;
                    break;
                case SUB:
                    resultInt = x - y;
                    break;
                case MUL:
                    resultInt = x * y;
                    break;
                case DIV:
                    resultInt = x / y;
                    break;
                default:
                    throw new CharException();
            }

            if (type == NumbersType.ROMAN) {
                result = Roman.ArabRom(resultInt);
            } else {
                result = Integer.toString(resultInt);
            }
        }
    }
}


