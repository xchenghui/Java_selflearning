/*
 * ���ͨ���̳�Thread�������߳�
 */


package com.x20180702;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//����һ��Cat������
		Cat cat = new Cat();
		
		//�����߳�--�Զ�����run ����
		//cat.start(); ->>Thread
		//����һ���߳�
		Thread t = new Thread(cat);
		t.start();
		
	}

}

class Cat implements Runnable
{
	//���±�дrun����
	public void run()
	{
		int time =0;
		while(true)
		{
			//����һ��
			//1000��ʾ1000����
			//sleep�ͻ��ø��߳̽��뵽Blocked״̬
			//�ͷ��Լ�ռ�õ�cpu��Դ
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










