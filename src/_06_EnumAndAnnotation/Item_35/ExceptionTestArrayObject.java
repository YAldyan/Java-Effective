package _06_EnumAndAnnotation.Item_35;

//Annotation type with an array parameter
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTestArrayObject {
	Class<? extends Exception>[] value();
}

