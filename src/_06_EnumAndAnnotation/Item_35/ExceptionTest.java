package _06_EnumAndAnnotation.Item_35;

//Annotation type with a parameter
import java.lang.annotation.*;
/**
* Indicates that the annotated method is a test method that
* must throw the designated exception to succeed.
*/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTest {
	Class<? extends Exception> value();
}

