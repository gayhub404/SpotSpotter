package pers.zylo117.spotspotter.pictureprocess;

import java.util.Scanner;

import pers.zylo117.spotspotter.fileprocessor.FileListener;
import pers.zylo117.spotspotter.patternrecognition.Comparison;
import pers.zylo117.spotspotter.pictureprocess.PicProcess;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);

		// ѯ���Ƿ�����
		System.out.println("Press E/e to Expert mode");
		System.out.println("Press Enter to Continue");
		String answer = input.nextLine();
		
		if (answer.equals("E") || answer.equals("e")) {
			// ������
		}
		
		// ͼƬIO·��ȥPicProcess��java�޸�
		
		//Version1 ����ͼ�Աȷ�,��2��ɫֵƫ��
		//���������Ա�ͼ�����ؾ���
		Comparison.getperfectData(PicProcess.perfect, 394, 338, 560, 320);
		
		// Autoscript,�Զ�����ļ�����,ִ��Job list
		FileListener.Autoscript();
		System.exit(0);
	}
}
