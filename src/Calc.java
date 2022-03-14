import java.util.Scanner;

public class Calc {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)  {
         String x = scanner.next();
        String operation = scanner.next();
        String y = scanner.next();
        try {
         if((Roman.RomArab(String.valueOf(x)) != 0) && (Roman.RomArab(String.valueOf(y)) != 0)){
             String a = scanner.nextLine();
                Conversion conversion = new Conversion(a);
                conversion.run();
            Calculator3 calculator3 = new Calculator3(conversion.getX(), conversion.getY(), conversion.getOperation(), conversion.getType());
            calculator3.run();
            System.out.println(" = " + calculator3.getResult());}
         else if ((Integer.parseInt(String.valueOf(x)) <= 10 && (Integer.parseInt(y)) <= 10) && (Integer.parseInt(String.valueOf(x)) >= 1 && (Integer.parseInt(y)) >= 1)) {
             System.out.println(" = " + Integer.parseInt(Calculator2.result(x, operation,y)));
         }
         else {throw new ResException();}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class Calculator2{
    public static String result (String x, String operation, String y) throws CharException{
        return switch (operation) {
            case ("+") -> Operation.sum(Integer.parseInt(String.valueOf(x)), Integer.parseInt(y));
            case ("-") -> Operation.sub(Integer.parseInt(String.valueOf(x)), Integer.parseInt(y));
            case ("*") -> Operation.mul(Integer.parseInt(String.valueOf(x)), Integer.parseInt(y));
            case ("/") -> Operation.div(Integer.parseInt(String.valueOf(x)), Integer.parseInt(y));
            default -> throw new CharException();
        };
   }
}
class Operation {
    static String sum(int x, int y){
        return String.valueOf(x + y);
    }
    static String sub(int x, int y){
        return String.valueOf(x - y);
    }
    static String mul(int x, int y){
        return String.valueOf(x * y);
    }
    static String div(int x, int y){
        return String.valueOf(x / y);
    }
}
class CharException extends Exception {
public CharException() {
    System.out.println("Неверный символ");
}
}
