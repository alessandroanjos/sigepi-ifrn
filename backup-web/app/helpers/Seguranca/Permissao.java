package helpers.Seguranca;

import helpers.Seguranca.AcaoPermissao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import play.mvc.With;

@With(AcaoPermissao.class)
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Permissao {

	String value() default "";
}
