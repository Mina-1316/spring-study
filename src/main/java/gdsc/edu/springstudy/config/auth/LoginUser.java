package gdsc.edu.springstudy.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)  // 어노테이션의 LifeCycle 지정 - https://jeong-pro.tistory.com/234
public @interface LoginUser {

}
