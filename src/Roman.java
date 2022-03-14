public class Roman {

    private static final int[] intVal = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    private static final String[] romanVal = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    public static String ArabRom(int arabNum) {
        StringBuilder result = new StringBuilder();
        for (int i = intVal.length - 1; i >= 0; i--) {
            while (arabNum >= intVal[i]) {
                arabNum -= intVal[i];
                result.append(romanVal[i]);
            }
        }
        return result.toString();
    }
    public static int RomArab(String s) {
        int result = 0;
        int preValue = 0;
        String symbol = Character.toString(s.charAt(s.length() - 1));
        for (int i = 0; i < romanVal.length - 1; i++) {
            if (symbol.equals(romanVal[i])) {
                result += intVal[i];
                preValue = intVal[i];
            }
        }
        for (int i = s.length() - 2; i >= 0; i--) {
            symbol = Character.toString(s.charAt(i));
            for (int k = 0; k < romanVal.length - 1; k++) {
                if (symbol.equals(romanVal[k])) {
                    if (intVal[k] < preValue) {
                        result -= intVal[k];
                    } else {
                        result += intVal[k];
                    }
                    preValue = intVal[k];
                }
            }
        }
        return result;
    }
}