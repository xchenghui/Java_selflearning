package com.sellTicket;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//����������Ʊ����
		TicketWindow tw1 = new TicketWindow();
		//TicketWindow tw2 = new TicketWindow();
		//TicketWindow tw3 = new TicketWindow();
		
		Thread t1 = new Thread(tw1);
		Thread t2 = new Thread(tw1);
		Thread t3 = new Thread(tw1);
		
		t1.start();
		t2.start();
		t3.start();
	}

}

//��Ʊ������
class TicketWindow implements Runnable
{
	private int nums = 2000; //2000 tickets

	
	private Dog mydog = new Dog();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true)
		{
			
			//��Ʊ�ٶ���1���һ��
			
			//��Ϊif else Ҫ��֤��ԭ���ԡ���ͬ�������
			
			synchronized(mydog) //
			{
			//�ж��Ƿ���Ʊ
			if(nums >0)
			{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//Thread.currentThread().getName()�õ���ǰ�̵߳�����
				System.out.println(Thread.currentThread().getName()+"�����۳�  " + nums + "Ʊ");
				nums--;
			}else
			{
				//��Ʊ���� 
				break;
			}
			}
			
		}
	}
}

class Dog
{
	
}









