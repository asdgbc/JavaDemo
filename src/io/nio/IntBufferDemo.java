package io.nio;

import java.nio.IntBuffer;

public class IntBufferDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 分配新的int缓冲区，参数为缓冲区容量  
        // 新缓冲区的当前位置将为零，其界限(限制位置)将为其容量。它将具有一个底层实现数组，其数组偏移量将为零。  
		IntBuffer ib = IntBuffer.allocate(8);
		for (int i = 0; i < ib.capacity(); i++) {
			// 将给定整数写入此缓冲区的当前位置，当前位置递增  
			ib.put(i);
		}
		// 重设此缓冲区，将限制设置为当前位置，然后将当前位置设置为0  
		ib.flip();
		while (ib.hasRemaining()) {
			// 读取此缓冲区当前位置的整数，然后当前位置递增  
			int j = ib.get();
			System.out.println(j);
		}
	}

}
