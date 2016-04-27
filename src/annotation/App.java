package annotation;

import java.lang.reflect.Method;

public class App {
	@MethodInfo(author = "chenxuexing@163.com", date = "2014/02/14")
	public String getAppName() {
		return "asdgbc";
	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		App app = new App();
		Method method = app.getClass().getMethod("getAppName");
		MethodInfo i = method.getAnnotation(MethodInfo.class);
		System.out.println(i.date());
	}
}
