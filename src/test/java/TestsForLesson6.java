import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class TestsForLesson6 {

    public static Stream<Arguments> genArgs4Tests(){
        List <Arguments>intArr = new ArrayList();
        intArr.add(Arguments.arguments(new int[]{1,2,3,4,5},new int[]{4,5}));
        intArr.add(Arguments.arguments(new int[]{1,4,3,3,5},new int[]{4,3,3,5}));
        intArr.add(Arguments.arguments(new int[]{1,3,3,4,5},new int[]{4,3,3,5}));

        return intArr.stream();
    }

    public static Stream<Arguments> genArgs4TestsWithException(){
        List <Arguments>intArr = new ArrayList();
        intArr.add(Arguments.arguments(new int[]{1,2,3,5,5},RuntimeException.class));
        intArr.add(Arguments.arguments(new int[]{1,2,3,5,5},RuntimeException.class));
        intArr.add(Arguments.arguments(new int[]{1,5,3,3,4},RuntimeException.class));

        return intArr.stream();
    }


    @ParameterizedTest
    @MethodSource("genArgs4Tests")
    public void testGetSubArrayFromLastFour(int[] array, int[] expected){
        Assertions.assertArrayEquals(expected,testClass.getSubArrayFromLastFour(array));
    }

    @ParameterizedTest
    @MethodSource("genArgs4TestsWithException")
    public void testGetSubArrayFromLastFourThrows(int[] array, Class classType){
        Assertions.assertThrows(classType ,()->testClass.getSubArrayFromLastFour(array));
    }




    public static Stream<Arguments> genArgs4TestsOneOrFour(){
        List <Arguments>intArr = new ArrayList();
        intArr.add(Arguments.arguments(new int[]{7,2,3,0,5},false));
        intArr.add(Arguments.arguments(new int[]{1,4,3,3,5},false));
        intArr.add(Arguments.arguments(new int[]{1,3,3,4,5},true));

        return intArr.stream();
    }

    @ParameterizedTest
    @MethodSource("genArgs4TestsOneOrFour")
    public void testIsOneOrFourPresent(int[] array, boolean expected){
        Assertions.assertEquals(expected,testClass.isOneOrFourPresent(array));
    }
}
