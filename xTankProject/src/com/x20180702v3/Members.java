package com.x20180702v3;

//子弹类
class Shot implements Runnable
{
	int x;
	int y;
	int direct;
	int speed = 5;    //子弹速度
	
	//是否还活着
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
				//上
				y-=speed;
				break;
			case 1:
				//右
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
			//子弹死亡
			
			//判断该子弹是否碰到边界
			if(x<0 || x>400 || y<0 || y>300)
			{
				this.isLive = false;
				break;
			}
		}
	}
	
}




//坦克类
class Tank
{
	//表示坦克的横坐标
	int x =0;
	
	//方向
	//0表示上，1表示右。2便是下，3表示左
	int direct = 0;
	int color =0;
	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	//坦克的速度
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

	//坦克的纵坐标
	int y =0;
	
	public Tank(int x, int y)
	{
		this.x= x;
		this.y = y;
	}
}

//敌人的坦克
class EnemyTank extends Tank
{
	
	public EnemyTank(int x, int y)
	{
		super(x,y);
	}
	
	
}

//我的坦克
class Hero extends Tank
{
	// 子弹
	Shot s= null;
	
	
	
	public Hero(int x, int y)
	{
		super(x,y);
		
	}
	
	//开火
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
		//启动子弹线程
		Thread t= new Thread(s);
		t.start();
	
	}
	
	
	
	//坦克向上移动
	public void moveUp()
	{
		y = y - speed;
	}
	//坦克向右
	public void moveRight()
	{
		x+=speed;
	}
	
	//向下移动
	public void moveDown()
	{
		y+=speed;
	}
	
	//向左移动
	public void moveLeft()
	{
		x-=speed;
	}
	
}
