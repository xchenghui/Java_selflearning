package com.x20180702v3;

//�ӵ���
class Shot implements Runnable
{
	int x;
	int y;
	int direct;
	int speed = 5;    //�ӵ��ٶ�
	
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
			
			System.out.println("x = " + x+"y =  "+ y);
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
class EnemyTank extends Tank
{
	
	public EnemyTank(int x, int y)
	{
		super(x,y);
	}
	
	
}

//�ҵ�̹��
class Hero extends Tank
{
	// �ӵ�
	Shot s= null;
	
	
	
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
			s= new Shot(x+10,y,0);
			break;
		case 1:
			s = new Shot(x+30,y+10,1);
			break;
		case 2:
			s= new Shot(x+10,y+30,2);
			break;
		case 3:
			s= new Shot(x,y+10,3);
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