package com.cgi.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.cgi.interfc.A;

public class MainClass {

	public static void main(String[] args) {

		A a = new A();
		try {
			Method m, m1;
			Field m2 = null;
			// accessing private method m1() from class A
			m = A.class.getDeclaredMethod("m1");
			m.setAccessible(true);
			m.invoke(a);

			// accessing private method m2(int i) from class A
			m1 = A.class.getDeclaredMethod("m2", new Class[] { int.class });
			m1.setAccessible(true);
			m1.invoke(a, 10);
			
			// accessing the private field
			m2 = A.class.getDeclaredField("i");
			m2.setAccessible(true);
			int j=m2.getInt(a);
			System.out.println(j);
			j=20;
			System.out.println("New j value: "+j);
			
			// to get the public method
			Method m3= A.class.getMethod("m2");
			m3.invoke(a);
			//or   a.m2();
			
		} catch (NoSuchMethodException | SecurityException e) {

			e.printStackTrace();
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {

			e.printStackTrace();
		} catch (NoSuchFieldException e) {

			e.printStackTrace();
		}
	}

}
