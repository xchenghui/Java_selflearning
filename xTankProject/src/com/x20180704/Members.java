package com.x20180704;

import java.util.Vector;

//子弹类
class Shot implements Runnable
{
	int x;
	int y;
	int direct;
	int speed = 3;    //子弹速度
	
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
			
			//System.out.println("x = " + x+"y =  "+ y);
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
	
	boolean isLive = true;
	
	
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
class EnemyTank extends Tank implements Runnable
{
	//boolean isLive = true;
	int times =0;
	//定义一个向量，可以存放敌人的子弹
	Vector<Shot> ss= new Vector<Shot>();
	
	//敌人添加子弹，应当在刚刚创建坦克和敌人的坦克子弹死亡了过后。
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
				//说明坦克正在向上移动
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
				//向右
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
				//向下
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
				//向左
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
			
			//判断是否需要给坦克加入新的子弹
			if(times%2 ==0)
			{
				if(isLive)
				{
					if(ss.size()<5)
					{
						//System.out.println("et.ss.size() = " + ss.size());
						Shot s = null;
						//没有子弹
						//添加
						switch(direct)
						{
						case 0:
							//创建一颗子弹
							s= new Shot(x+10,y,0);
							
							//吧子弹加入到向量
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
						
						//启动子弹线程
						Thread t = new Thread(s);
						t.start();
						}
					}
				}
			
//			//判断子弹是否没有
//			if(ss.size()<1)
//			{
//				Shot s = new Shot();
//			}
//			
			//让坦克随机产生一个新的方向
			this.direct = (int)(Math.random()*4);
			
			//测试方向
			//System.out.println(direct);
			
			//判断敌人坦克是否死亡
			if(this.isLive ==false)
			{
				//让坦克死亡后，推出线程
				break;
			}
			
			
		}
	}
	
	
}

//炸弹类
class Bomb
{
	//定义炸弹的坐标
	int x,y;
	
	//炸弹的生命
	int life = 9;
	
	public Bomb(int x, int y)
	{
		this.x=x;
		this.y =y;
	}
	
	boolean isLive = true;
	//减少生命值
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


//我的坦克
class Hero extends Tank
{
	// 子弹
	//Shot s= null;
	
	Vector<Shot> ss = new Vector<Shot>();
	Shot s =null;
	
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
			//创建一颗子弹
			s= new Shot(x+10,y,0);
			
			//吧子弹加入到向量
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
