import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void main() throws Calculator_Error {

        String[] arr_input_string = {"1+5", "5+5", "V-I","5/3"};
        List<String> right_answers = new ArrayList<>(Arrays.asList("6", "10","IV","1"));
        List<String> answer = new ArrayList<>();

        for (String string_input : arr_input_string) {

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


                    //System.out.println(string_input + " = " + string_result);
                    answer.add(string_result);
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
                    answer.add(string_result);
                    //System.out.println(string_input + " = " + string_result);
                }
            } else {
                throw new Calculator_Error();
            }
        }



        assertArrayEquals(right_answers.toArray(), answer.toArray());
    }
}