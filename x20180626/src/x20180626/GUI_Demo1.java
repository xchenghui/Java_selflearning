/*
 * gui���ܽ��濪����ʾ
 */


package x20180626;

//�����
import java.awt.*;
import javax.swing.*;


public class GUI_Demo1 extends JFrame{
	
	//����Ҫ��swing�齨�������ﶨ��
	JButton jb1 = null;
	public static void main(String []args)
	{
			GUI_Demo1 demo1 = new GUI_Demo1();
	}
	//���캯��
	public GUI_Demo1()
	{
				//������ť���
				 jb1 = new JButton("This is Button");
				
				//���JButton�齨
				this.add(jb1);	
			
				//���������ñ���
				this.setTitle("Hello, World");
				
				//���ô�С�������ؼ���
				this.setSize(200,200);
				
				
				
				//���ó�ʼλ��
				this.setLocation(100,200);
				
			
				//���رմ��ڵ�ʱ�򣬱�֤jvmҲ�Ƴ�
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				//��ʾ
				this.setVisible(true);
			
	}
}





