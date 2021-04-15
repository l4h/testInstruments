import com.sun.istack.internal.NotNull;

import java.util.Arrays;

public class testClass {

    /** 6.2
     Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
     Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
     идущих после последней четверки.
     Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить RuntimeException.
     Написать набор тестов для этого метода (по 3-4 варианта входных данных). Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].*/

     static int[] getSubArrayFromLastFour(@NotNull int[] array) throws RuntimeException {
         for (int i = array.length-1; i > -1; i--) {
             if (array[i]==4){
                 return Arrays.copyOfRange(array,i,array.length);
             }
         }

         throw new RuntimeException("no '4' in array");

     }


    /** 6.3
     * Написать метод, который проверяет состав массива из чисел 1 и 4.
     * Если в нем нет хоть одной четверки или единицы, то метод вернет false;
     * Написать набор тестов для этого метода (по 3-4 варианта входных данных).
     */


    public static boolean isOneOrFourPresent(int[] array){
        for (int element:array) {
            if (element == 1 || element == 4) return true;
        }
        return false;
    }

}
