import java.util.Scanner;

public class Calc {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)  {

        try {

             String a = scanner.nextLine();
                Conversion conversion = new Conversion(a);
                conversion.run();
            Calculator3 calculator3 = new Calculator3(conversion.getX(), conversion.getY(), conversion.getOperation(), conversion.getType());
            calculator3.run();
            System.out.println(" = " + calculator3.getResult());


        } catch (ResException l) { l.printStackTrace(); }
        catch (RomanException j) { j.printStackTrace(); }
        catch (CharException d) { d.printStackTrace(); }
        catch (NopeException e) { e.printStackTrace(); }
    }
}




class CharException extends Exception {
public CharException() {
    System.out.println("Неверный символ");
}
}
