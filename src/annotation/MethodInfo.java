package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//保留到运行时默认是CLASS，但是这样的话程序在运行期间是无法获取到该注释的也就是调用getAnnotation方法返回null
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MethodInfo {
	// 可以通过default关键字设置默认值
	// 只允许 public & abstract 修饰符，默认为 public，不允许抛异常
	String author() default "asdgbc@163.com";

	// 方法返回值只能是基本类型，String, Class, annotation, enumeration 或者是他们的一维数组
	String date();

	// 若只有一个默认属性，可直接用 value() 函数。一个属性都没有表示该 Annotation 为 Mark Annotation
}
