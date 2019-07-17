/**
 * 
 */
package Chapter0813;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/** 
public static void search(File folder, String search);
 

���������ĿĿ¼�� e:/project���������Ŀ¼�����е�java�ļ����������ļ��У���
�ҳ��ļ����ݰ��� Magic����Щ�ļ�������ӡ������ 
 * @���⣺���� 5 : ��ϰ-�����ļ����� 
 * @���ߣ�
 * @�汾��
 * @���ڣ�
 */
public class test1 {
	//�����ļ����
	private static int count = 0;
	//�ļ����ݲ��ҷ���
	public static void search(File folder, String search){
		
		//�ж�folder���ļ������ļ���
		//�ļ����������ݲ���
		if (folder.isFile()) {
			try(//ʹ�û������������ݶ�ȡ����ȡ����ֱ��Ϊ�ַ�����ʹ��
					FileReader fr = new FileReader(folder);
					BufferedReader br = new BufferedReader(fr);) {
				while (true) {
	                // һ�ζ�һ��
	                String line = br.readLine();
	                if (null == line)
	                    break;
					//ʹ���ַ�����contains���бȽ�
					if (line.contains(search)) {
						count++;
						System.out.println("�ҵ���" + count + "���ļ�:" + folder);
					}
				 }
			} catch (Exception e) {
				e.printStackTrace();
			}
		//�ļ��У��ǿ��г��ļ�����еݹ�
		} else if(folder.isDirectory()){
			if(null != folder){
				File[] f = folder.listFiles();
				for (File file : f) {
					search(file, search);
				}
			}
		}
	}
	public static void main(String[] args) {
		JFrame jf = new JFrame("�����ļ�");
		jf.setBounds(100, 200, 300, 200);
		jf.setLayout(new FlowLayout());
		
		JButton b = new JButton("�����ļ�");
		jf.add(b);
		
		b.addActionListener(new  ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>(){
					protected Void doInBackground() throws Exception {
						File f = new File("D:\\JAVA_test");
						search(f, "helloword");
						JOptionPane.showMessageDialog(jf, "������ϣ����ҵ���" + count + "���ļ�����" + "helloword");
						return null;
					}
					};
					 worker.execute();
				}
		});
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	
}