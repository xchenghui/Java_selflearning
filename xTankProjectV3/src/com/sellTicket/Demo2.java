package com.sellTicket;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//定义三个售票窗口
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

//售票窗口类
class TicketWindow implements Runnable
{
	private int nums = 2000; //2000 tickets

	
	private Dog mydog = new Dog();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true)
		{
			
			//出票速度是1秒出一张
			
			//认为if else 要保证其原子性【】同步代码块
			
			synchronized(mydog) //
			{
			//判断是否还有票
			if(nums >0)
			{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//Thread.currentThread().getName()得到当前线程的名字
				System.out.println(Thread.currentThread().getName()+"正在售出  " + nums + "票");
				nums--;
			}else
			{
				//售票结束 
				break;
			}
			}
			
		}
	}
}

class Dog
{
	
}










