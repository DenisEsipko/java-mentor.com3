import java.util.Scanner;

/**
 * main class
 *
 * @autor Iesipko Denys
 */

public class Main {
    /**
     * open the scanner and read expressions before the first error
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {

            while (true) {
                System.out.print("> ");

                String string_input = in.nextLine();
                System.out.println("***" + string_input);
                // check string for compliance
                if (Validation.validation(string_input)) {
                    //if the string with roman numerals is converted
                    boolean is_rome = Validation.isResultRome(string_input);

                    // строка для изменнеых даннх для риских цифр
                    String converse_string_Rome = null;
                    if (is_rome) {
                        converse_string_Rome = RomanToArabic.romanToArabic(string_input);
                        //calculate the result
                        Object calculation_result = Calculator.Сalculation(converse_string_Rome);
                        // округляем дло целого чила
                        int result = (int) Math.floor(Double.parseDouble(String.valueOf(calculation_result)));
                        String string_result = String.valueOf(result);
                        // проверяем на ноль
                        if (result == 0) {
                            System.out.println(" в задание нет  числа 0  как и римской цифры 0 так что ошибка )");
                            throw new Calculator_Error();
                        }
                        // преобразовываем ответ в римскийе цифры
                        string_result = ArabicToRoman.arabicToRoman(result);
                        System.out.println(string_input + " = " + string_result);
                    } else {
                        //calculate the result
                        Object calculation_result = Calculator.Сalculation(string_input);
                        // округляем дло целого чила
                        int result = (int) Math.floor(Double.parseDouble(String.valueOf(calculation_result)));
                        String string_result = String.valueOf(result);
                        // проверяем на ноль
                        if (result == 0) {
                            System.out.println(" в задание нет  числа 0  как и римской цифры 0 так что ошибка )");
                            throw new Calculator_Error();
                        }
                        System.out.println(string_input + " = " + string_result);
                    }
                } else {
                    throw new Calculator_Error();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
    }
}
