package service.annotations;

import java.lang.annotation.*;

/**
 * Created by 37 on 2016/9/27.
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ComponentAnno {
    String serviceName() default "";
    String gameobjectName() default "";
    int[] actionEventIds();
    String[] gameEventIds();
}
