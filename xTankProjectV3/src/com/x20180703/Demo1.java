/*
 * 演示线程注意事项
 */

package com.x20180703;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Cat cat1 = new Cat();
//		cat1.start();
		//cat1.start(); 不能启动两个线程
		
//		Dog dog1 = new Dog();
//		Thread t = new Thread(dog1);
//		Thread t2 = new Thread(dog1);
//		t.start();
//		t2.start();
		
	}

}

class Cat extends Thread
{
	public void run()
	{
		System.out.println("11");
	}
}


class Dog implements Runnable
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("22");
	}
	
}











