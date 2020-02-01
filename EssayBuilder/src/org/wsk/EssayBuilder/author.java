package org.wsk.EssayBuilder;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
@author(value = "wsk")
@Retention(RUNTIME)
@Target({ TYPE, METHOD })
public @interface author {
	String value() default "unnamed author";

}
