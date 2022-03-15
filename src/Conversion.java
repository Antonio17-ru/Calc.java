import java.util.regex.Pattern;

public class Conversion {
    private String a;
    private OperationRom operation;
    private int x;
    private int y;
    private NumbersType type;
     static final String arabRegex = "^(\\d{1,3})\\s[+-/*]\\s(\\d{1,3})$";
     static final String romanRegex = "^(M{0,3})^(M{0,3})(D?C{0,3}|C[DM])(L?X{0,3}|X[LC])(V?I{0,3}|I[VX])\\s[+-/*]\\s(M{0,3})(D?C{0,3}|C[DM])(L?X{0,3}|X[LC])(V?I{0,3}|I[VX])$";

    public Conversion (String a) {
        this.a = a;
    }
    public int getX() {
        return x;
    }
    public int getY() { return y; }
    public NumbersType getType() { return type; }
    public OperationRom getOperation() {
        return operation;
    }
    public void run() throws NopeException{
        if (Pattern.matches(romanRegex, a)) {
            type = NumbersType.ROMAN;
        } else if (Pattern.matches(arabRegex, a)) {
                type = NumbersType.ARABIC;
            }
        else {throw new NopeException();}

        String[] values = a.split(" ");
        if (type == NumbersType.ROMAN) {
            x = Roman.RomArab(values[0]);
            y = Roman.RomArab(values[2]);
        }
        if (type == NumbersType.ARABIC){
            x = Integer.parseInt(values[0]);
            y = Integer.parseInt(values[2]);
        }
        String oper = values[1];

        if (oper.equals("+")){
            operation = OperationRom.SUM;
        }
        if (oper.equals("-")){
            operation = OperationRom.SUB;
        }
        if (oper.equals("/")){
            operation = OperationRom.DIV;
        }
        if (oper.equals("*")){
            operation = OperationRom.MUL;
        }
    }
}




