package pers.zylo117.spotspotter.pictureprocess;

import java.util.Scanner;

import pers.zylo117.spotspotter.fileprocessor.FileListener;
import pers.zylo117.spotspotter.patternrecognition.Comparison;
import pers.zylo117.spotspotter.pictureprocess.PicProcess;

public class Main {

	// ͼƬIO·��ȥPicProcess��java�޸�

	// GA Spotʶ�����
	// ����ROI��ʼx/y,ROI���񳤿�
	public static int GA_ROIstart_x = 394;
	public static int GA_ROIstart_y = 338;
	public static int GA_ROIWidth = 560;
	public static int GA_ROIHeight = 320;

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);

		// ѯ���㷨
		System.out.println("Welcome running Classified Project Argus");
		System.out.println("Press 1 to Version 1 algorithm");
		System.out.println("Press Enter to Go Default");
		String answer = input.nextLine();

		if (answer.equals("1") || answer.equals("1")) {
			// Version1 ����ͼ�Աȷ�,��2��ɫֵƫ��
			// ���������Ա�ͼ�����ؾ���
			Comparison.getperfectData(PicProcess.perfect, GA_ROIstart_x, GA_ROIstart_y, GA_ROIWidth, GA_ROIHeight);
			// Autoscript,�Զ�����ļ�����,ִ��ͼ��Ա��㷨
			FileListener.Autoscript(1);
		}

		FileListener.Autoscript(2);

		System.exit(0);
	}
}
