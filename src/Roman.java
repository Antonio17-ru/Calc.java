public class Roman {

    private static final int[] intVal = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 30, 40, 50, 90, 100, 400, 500, 900, 1000};
    private static final String[] romanVal = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XX", "XXX", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    public static String ArabRom(int arabNum) throws RomanException{
        if (arabNum < 1 || arabNum > 3999) {
            throw new RomanException ();
        }
        StringBuilder result = new StringBuilder();
        for (int i = intVal.length - 1; i >= 0; i--) {
            if (arabNum >= intVal[i]) {
                arabNum -= intVal[i];
                result.append(romanVal[i]);
            }
        }
        return result.toString();
    }
    public static int RomArab(String a) {
        int result = 0;
        int preValue = 0;
        String symbol = Character.toString(a.charAt(a.length() - 1));
        for (int i = 0; i < romanVal.length - 1; i++) {
            if (symbol.equals(romanVal[i])) {
                result += intVal[i];
                preValue = intVal[i];
            }
        }
        for (int i = a.length() - 2; i >= 0; i--) {
            symbol = Character.toString(a.charAt(i));
            for (int k = 0; k < romanVal.length - 1; k++) {
                if (symbol.equals(romanVal[k])) {
                    if (intVal[k] < preValue) {
                        result -= intVal[k];
                    } else {
                        result += intVal[k];
                        preValue = intVal[k];
                    }
                }
            }
        }
        return result;
    }
}