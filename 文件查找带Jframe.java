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
 

假设你的项目目录是 e:/project，遍历这个目录下所有的java文件（包括子文件夹），
找出文件内容包括 Magic的那些文件，并打印出来。 
 * @标题：步骤 5 : 练习-查找文件内容 
 * @作者：
 * @版本：
 * @日期：
 */
public class test1 {
	//查找文件编号
	private static int count = 0;
	//文件内容查找方法
	public static void search(File folder, String search){
		
		//判断folder是文件还是文件夹
		//文件，进行内容查找
		if (folder.isFile()) {
			try(//使用缓存流进行内容读取，读取出来直接为字符串可使用
					FileReader fr = new FileReader(folder);
					BufferedReader br = new BufferedReader(fr);) {
				while (true) {
	                // 一次读一行
	                String line = br.readLine();
	                if (null == line)
	                    break;
					//使用字符串的contains进行比较
					if (line.contains(search)) {
						count++;
						System.out.println("找到第" + count + "个文件:" + folder);
					}
				 }
			} catch (Exception e) {
				e.printStackTrace();
			}
		//文件夹，非空列出文件后进行递归
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
		JFrame jf = new JFrame("查找文件");
		jf.setBounds(100, 200, 300, 200);
		jf.setLayout(new FlowLayout());
		
		JButton b = new JButton("查找文件");
		jf.add(b);
		
		b.addActionListener(new  ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>(){
					protected Void doInBackground() throws Exception {
						File f = new File("D:\\JAVA_test");
						search(f, "helloword");
						JOptionPane.showMessageDialog(jf, "查找完毕，共找到第" + count + "个文件包含" + "helloword");
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