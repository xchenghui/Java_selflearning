/*
 * java��ͼԭ��
 * Component���ṩ�������ͻ�ͼ�������Ҫ�ķ���
 * 1.paint(Graphics g)��ͼ������
 * 2.repaint()ˢ��������
 */

package x20180627;
import javax.swing.*;
import java.awt.*;
public class CircleDraw extends JFrame{

	Mypanel mp=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CircleDraw cd = new CircleDraw();

	}
	public CircleDraw()
	{
		mp = new Mypanel();
		
		this.add(mp);
		
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
}

//����һ��MyPanel(���Լ�����壬�����ڻ�ͼ��ʵ�ֻ�ͼ�Ĺ���)
class Mypanel extends JPanel
{
	//����JPanel��paint����
	//Graphics �ǻ�ͼ����Ҫ�࣬����԰��������һֱ����
	
	public void paint(Graphics g)  //�Զ�����paint(),���ڴ�С�仯��ʱ�򣬻����
	{
		//1.���ø��ຯ����ɳ�ʼ������
		//��仰��������
		super.paint(g);
		
		System.out.println("Paint have been used"); //֤��
		//�Ȼ���һ��԰
//		g.drawOval(10, 10, 30, 30);//��Բ����
//		
//		//�������б߿�
//		g.drawRect(200,100 , 123, 62);
//		
		//������
		//������ɫ
//		g.setColor(Color.PINK);   Ctrl+/
//		g.fillRect(100, 50, 90, 60);
//		g.setColor(Color.LIGHT_GRAY);
//		g.fillRect(70, 60, 50, 30);
		
		//������ϻ���ͼƬ
//		Image im = Toolkit.getDefaultToolkit().getImage
//				(Panel.class.getResource("/Taiyan1.jpg"));
//		//��ʾ
//		g.drawImage(im, 40, 40, 123, 80,this);
		
		//��λ�����
		g.setFont(new Font("����",Font.BOLD,30));
		g.setColor(Color.RED);
		g.drawString("�������", 100, 100);
	}
}





















