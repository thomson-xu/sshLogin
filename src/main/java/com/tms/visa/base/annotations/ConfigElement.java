package com.tms.visa.base.annotations;

import com.tms.visa.base.common.config.DefaultFormatter;
import com.tms.visa.base.common.config.DefaultReader;
import com.tms.visa.base.common.config.Formatter;
import com.tms.visa.base.common.config.Reader;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfigElement {
	
	public String tag() default ""; 
	
	public String type() default "String";
	
	public String property() default "";
	
	public Class<? extends Reader> reader() default DefaultReader.class;
	
	public Class<? extends Formatter> fomatter() default DefaultFormatter.class;

}
