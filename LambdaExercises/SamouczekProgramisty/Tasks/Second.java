package LambdaExercises.SamouczekProgramisty.Tasks;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Second {

    public static void main(String[] args){

        //z przekazaniem instancji jako argumentu
        Object objectInstance = new Object();
        Predicate<Object> predicate = objectInstance::equals;
        System.out.println(predicate.test(objectInstance));
        //bez przekazania instancji
        BiPredicate<Object, Object> biPredicate = Object::equals;
        System.out.println(biPredicate.test(new Object(), new Object()));

        //korzystanie z konstruktora
        BiFunction<Integer, String, Human> humanCreator = Human::new;
        Human human = humanCreator.apply(5, "Maniek");

        System.out.println("Age: " + human.getAge() + "\tName: " + human.getName());
    }
}
