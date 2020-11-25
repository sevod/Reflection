package reflectionexample;

import reflectionexample.rabbit.Rabbit;

import java.lang.reflect.InvocationTargetException;

public class ReflectionExample {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        ReflectionChecker checker = new ReflectionChecker();
        Rabbit rabbit = new Rabbit();

//        checker.showClassName(rabbit);
//        checker.showClassFields(rabbit);
//        checker.showClassMethods(checker);

 //       checker.showFieldsAnnotations(rabbit);

        //checker.fillPrivateFields(rabbit);

//        System.out.println(rabbit.getRabbitAge());
//        System.out.println(rabbit.getRabbitName());

        Object clone = checker.createNewObject(rabbit);
        checker.showClassName(clone);

    }
}
