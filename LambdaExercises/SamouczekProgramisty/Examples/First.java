package LambdaExercises.SamouczekProgramisty.Examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class First {
    public static void main(String[] args){
        //odwoływanie się do metod
        Object objectInstance = new Object();
        IntSupplier equalsMethodOnObject = objectInstance::hashCode;
        System.out.println(equalsMethodOnObject.getAsInt());

        //Odwoływanie się do metod bez podania instancji
        ToIntFunction<Object> hashCodeMethodOnClass = Object::hashCode;
        Object objectInstance2 = new Object();
        System.out.println(hashCodeMethodOnClass.applyAsInt(objectInstance2));

        //Odwoływanie się do konstruktora

        Supplier<Object> objectCreator = Object::new;
        System.out.println(objectCreator.get());

        //przykład
        List<Integer> list = Arrays.asList(1,2,3,4);
        Consumer<Integer> printData = n -> System.out.println(n);
        list.forEach(printData);

        //przykład jeszcze krótszy
        list.forEach(System.out::println);


    }
}
