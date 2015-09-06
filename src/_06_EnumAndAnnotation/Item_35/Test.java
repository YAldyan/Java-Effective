package _06_EnumAndAnnotation.Item_35;

//Marker annotation type declaration
import java.lang.annotation.*;
/**
* Indicates that the annotated method is a test method.
* Use only on parameterless static methods.
*/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {
}

