/*
 * ���񲼾�
 */

package x20180626;
import java.awt.*;
import javax.swing.*;
public class Demo9_1 extends JFrame{
	
	//�����齨
	JButton jbs[] = new JButton[9];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//����ʵ��
		Demo9_1 de = new Demo9_1();
	}
	
	public Demo9_1()
	{
		//�������
		for(int i=0;i<9;i++)
		{
			jbs[i] = new JButton(String.valueOf(i));
		}
		
		   //�������񲼾�
		this.setLayout(new GridLayout(3,4,10,10));
		
		//������
		for(int i=0;i<9;i++)
		{
			this.add(jbs[i]);
		}
		
		//���ô�������
		this.setTitle("���񲼾�");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(200,300);
		
		//��ʾ
		this.setVisible(true);
		
		
		
	}
}
