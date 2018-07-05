package com.x20180702;

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
	public Hero(int x, int y)
	{
		super(x,y);
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
