/**
 * 
 */
package Chapter0211;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/** 
public static void search(File folder, String search);
 

���������ĿĿ¼�� e:/project���������Ŀ¼�����е�java�ļ����������ļ��У���
�ҳ��ļ����ݰ��� helloword����Щ�ļ�������ӡ������ 
 * @���⣺���� 5 : ��ϰ-�����ļ����� 
 * @���ߣ�
 * @�汾��
 * @���ڣ�
 */
public class test3 {
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
		File f = new File("D:\\JAVA_test");
		search(f, "helloword");
		System.out.println("������ϣ����ҵ���" + count + "���ļ�����" + "helloword");
	}
	
}