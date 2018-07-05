/*
 * 如何通过继承Thread来开发线程
 */


package com.x20180702;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//创建一个Cat、对象
		Cat cat = new Cat();
		
		//启动线程--自动运行run 函数
		//cat.start(); ->>Thread
		//创建一个线程
		Thread t = new Thread(cat);
		t.start();
		
	}

}

class Cat implements Runnable
{
	//重新编写run函数
	public void run()
	{
		int time =0;
		while(true)
		{
			//休眠一秒
			//1000表示1000毫秒
			//sleep就会让该线程进入到Blocked状态
			//释放自己占用的cpu资源
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			time++;
			System.out.println("Hello, World" + time);
			if(time ==10)
			{
				break;
			}
		}
	}
}











