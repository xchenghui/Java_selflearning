/*
 * �����߳�ͬʱ�˶��İ���
 */

package com.test3;

public class Demo10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pig pig = new Pig(10);
		Bird bird = new Bird(10);
		
		//�����߳�
		Thread t1 = new Thread(pig);
		Thread t2 = new Thread(bird);
		
		t1.start();
		t2.start();
	}

}

//��ӡ
class Pig implements Runnable
{
	int n =0;
	int times = 0;
	public Pig(int n )
	{
		this.n = n;
	}
	public void run()
	{
		while(true)
		{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			times++;
			System.out.println("����һ���سǣ� �������   "+ times+ "Hello, World" );
			
			if(times == n)
			{
				break;
			}
		}
	}
}




//����ѧ��
class Bird implements Runnable
{

	int n =0;
	int result =0;
	int times =0;
	public Bird(int n)
	{
		this.n = n;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			result+=(++times);
			System.out.println("��ǰ���" + result);
			if(times ==n)
			{
				System.out.println("Final result" + result);
				break;
			}
		}
		
	}
	
}

























