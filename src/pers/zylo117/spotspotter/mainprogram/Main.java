package pers.zylo117.spotspotter.mainprogram;

import java.util.Scanner;

import pers.zylo117.spotspotter.fileprocessor.FileListener;
import pers.zylo117.spotspotter.patternrecognition.Comparison;

public class Main {

	// ͼƬIO·��ȥPathManagement��java�޸�
	// ʶ�������ȥParameterManagement��java�޸�

public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);

		// ѯ���㷨
		System.out.println("Welcome running Classified Project Argus");
		System.out.println("Press Enter to Go Default");
		String answer = input.nextLine();

		if (answer.equals("1") || answer.equals("1")) {
		}

		FileListener.Autoscript(2);

		System.exit(0);
	}
}
