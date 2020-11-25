package reflectionexample;

import reflectionexample.rabbit.RabbitAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionChecker {
    public void showClassName(Object object){
        Class clazz = object.getClass();
        System.out.println("class name: " + clazz.getName());
    }

    public void showClassFields(Object object){
        Class clazz = object.getClass();
        Field [] fields = clazz.getDeclaredFields();
        for(Field field: fields){
            System.out.println(field.getName());
        }
    }

    public void showClassMethods(Object object){
        Class clazz = object.getClass();
        Method[] methods = clazz.getMethods();
        for(Method method: methods){
            System.out.println(method.getName());
        }
    }

    public void showFieldsAnnotations (Object object){
        Class clazz = object.getClass();
        Field [] fields = clazz.getDeclaredFields();
        for(Field field: fields){
            Annotation [] annotations = field.getAnnotations();
            for (Annotation annotation: annotations){
                System.out.println("Annotation " + field.getName() + " : " +annotation.toString());
            }
        }
    }

    public void fillPrivateFields(Object object) throws IllegalAccessException {
        Class clazz = object.getClass();
        Field [] fields = clazz.getDeclaredFields();
        for(Field field: fields){
            Annotation annotation = field.getAnnotation(RabbitAnnotation.class);
            if (annotation == null)
                continue;
            else {
                field.setAccessible(true); //поле из приватного сделали доступным
                field.set(object, "It's work!");
                field.setAccessible(false);
            }
        }
    }

    public Object createNewObject(Object object) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = object.getClass();
        return clazz.getDeclaredConstructor().newInstance();
    }
}
