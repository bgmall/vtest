package service.annotations;

import java.lang.annotation.*;

/**
 * Created by 37 on 2016/9/27.
 */

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ServiceAnno {
    String name() default "";
}
