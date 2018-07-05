package com.x20180704;

import java.util.Vector;

//�ӵ���
class Shot implements Runnable
{
	int x;
	int y;
	int direct;
	int speed = 3;    //�ӵ��ٶ�
	
	//�Ƿ񻹻���
	boolean isLive = true;
	
	
	public Shot(int x, int y, int direct)
	{
		this.x = x;
		this.y = y;
		this.direct = direct;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			switch(direct)
			{
			case 0: 
				//��
				y-=speed;
				break;
			case 1:
				//��
				x+=speed;
				break;
			case 2:
				y+=speed;
				break;
			case 3:
				x-=speed;
				break;
			}
			
			//System.out.println("x = " + x+"y =  "+ y);
			//�ӵ�����
			
			//�жϸ��ӵ��Ƿ������߽�
			if(x<0 || x>400 || y<0 || y>300)
			{
				this.isLive = false;
				break;
			}
		}
	}
	
}




//̹����
class Tank
{
	//��ʾ̹�˵ĺ�����
	int x =0;
	
	boolean isLive = true;
	
	
	//����
	//0��ʾ�ϣ�1��ʾ�ҡ�2�����£�3��ʾ��
	int direct = 0;
	int color =0;
	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	//̹�˵��ٶ�
	int speed = 1;
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDirect() {
		return direct;
	}

	public void setDirect(int direct) {
		this.direct = direct;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	//̹�˵�������
	int y =0;
	
	public Tank(int x, int y)
	{
		this.x= x;
		this.y = y;
	}
}

//���˵�̹��
class EnemyTank extends Tank implements Runnable
{
	//boolean isLive = true;
	int times =0;
	//����һ�����������Դ�ŵ��˵��ӵ�
	Vector<Shot> ss= new Vector<Shot>();
	
	//���������ӵ���Ӧ���ڸոմ���̹�˺͵��˵�̹���ӵ������˹���
	public EnemyTank(int x, int y)
	{
		super(x,y);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true)
		{
			switch(this.direct)
			{
			case 0:
				//˵��̹�����������ƶ�
				for(int i =0; i<15;i++)
				{
					if(y>0 ){
				y-=speed;}
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				break;
			case 1:
				//����
				for(int i =0; i<15;i++)
				{
					if(x<400){
					x+=speed;}
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				
				break;
			case 2:
				//����
				for(int i =0; i<15;i++)
				{
					if(y<300){
					y+=speed;}
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				break;
			case 3:
				//����
				for(int i =0; i<15;i++)
				{
					if(x>0){
					x-=speed;}
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				break;
			}
			
			this.times++;
			
			//�ж��Ƿ���Ҫ��̹�˼����µ��ӵ�
			if(times%2 ==0)
			{
				if(isLive)
				{
					if(ss.size()<5)
					{
						//System.out.println("et.ss.size() = " + ss.size());
						Shot s = null;
						//û���ӵ�
						//����
						switch(direct)
						{
						case 0:
							//����һ���ӵ�
							s= new Shot(x+10,y,0);
							
							//���ӵ����뵽����
							ss.add(s);
							break;
						case 1:
							s = new Shot(x+30,y+10,1);
							ss.add(s);
							break;
						case 2:
							s= new Shot(x+10,y+30,2);
							ss.add(s);
							break;
						case 3:
							s= new Shot(x,y+10,3);
							ss.add(s);
							break;
						}
						
						//�����ӵ��߳�
						Thread t = new Thread(s);
						t.start();
						}
					}
				}
			
//			//�ж��ӵ��Ƿ�û��
//			if(ss.size()<1)
//			{
//				Shot s = new Shot();
//			}
//			
			//��̹���������һ���µķ���
			this.direct = (int)(Math.random()*4);
			
			//���Է���
			//System.out.println(direct);
			
			//�жϵ���̹���Ƿ�����
			if(this.isLive ==false)
			{
				//��̹���������Ƴ��߳�
				break;
			}
			
			
		}
	}
	
	
}

//ը����
class Bomb
{
	//����ը��������
	int x,y;
	
	//ը��������
	int life = 9;
	
	public Bomb(int x, int y)
	{
		this.x=x;
		this.y =y;
	}
	
	boolean isLive = true;
	//��������ֵ
	public void lifeDown()
	{
		if(life>0)
		{
			life--;
		}
		else
		{
			this.isLive = false;
		}
	}
	
	
}


//�ҵ�̹��
class Hero extends Tank
{
	// �ӵ�
	//Shot s= null;
	
	Vector<Shot> ss = new Vector<Shot>();
	Shot s =null;
	
	public Hero(int x, int y)
	{
		super(x,y);
		
	}
	
	//����
	public void shotEnemy()
	{
		
		
		switch(this.direct)
		{
		case 0:
			//����һ���ӵ�
			s= new Shot(x+10,y,0);
			
			//���ӵ����뵽����
			ss.add(s);
			break;
		case 1:
			s = new Shot(x+30,y+10,1);
			ss.add(s);
			break;
		case 2:
			s= new Shot(x+10,y+30,2);
			ss.add(s);
			break;
		case 3:
			s= new Shot(x,y+10,3);
			ss.add(s);
			break;
		
		}
		//�����ӵ��߳�
		Thread t= new Thread(s);
		t.start();
	
	}
	
	
	
	//̹�������ƶ�
	public void moveUp()
	{
		y = y - speed;
	}
	//̹������
	public void moveRight()
	{
		x+=speed;
	}
	
	//�����ƶ�
	public void moveDown()
	{
		y+=speed;
	}
	
	//�����ƶ�
	public void moveLeft()
	{
		x-=speed;
	}
	
}