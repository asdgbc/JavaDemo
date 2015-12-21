package customclassloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CustomClassLoader extends ClassLoader {

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String classPath = CustomClassLoader.class.getResource("/").getPath();
		String fileName = name.replace(".", "/") + ".class";
		File classFile = new File(classPath, fileName);
		if (!classFile.exists()) {
			throw new ClassNotFoundException(classFile.getPath() + " 不存在");
		}
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ByteBuffer bf = ByteBuffer.allocate(1024);
		FileInputStream fis = null;
		FileChannel fc = null;

		try {
			fis = new FileInputStream(classFile);
			fc = fis.getChannel();
			while (fc.read(bf) > 0) {
				bf.flip();
				bos.write(bf.array(), 0, bf.limit());
				bf.clear();
			}
		} catch (Exception e) {
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return defineClass(null, bos.toByteArray(), 0, bos.toByteArray().length);
	}

	public static void main(String[] args) throws ClassNotFoundException {
		int i = 0;

		while (true) {
			CustomClassLoader instance = new CustomClassLoader();
			System.out.println(instance.getParent());
			Class<?> personClass = instance.findClass("customclassloader.Person");

			try {
				// 手动修改Person类中的say方法可以实现
				// 热替换效果
				Object person = personClass.newInstance();
				Method say = personClass.getMethod("say");
				say.invoke(person);
				System.out.println(++i);
			} catch (Exception e) {
			}

			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}

		}

	}

}
