package pers.zylo117.spotspotter.patternrecognition;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageReader;

import pers.zylo117.spotspotter.toolbox.File2ImageStream;
import pers.zylo117.spotspotter.toolbox.GetMaxMin;
import pers.zylo117.spotspotter.toolbox.GetPostfixReader;

public class SpotSpotter {

	public static double resultCenter;

	// colorvalue Ϊ10���ƣ�0~255����
	public static void marking(String input, int x, int y, int matrixsize, double theshold) throws IOException {

		long beginTime = new Date().getTime();

		// ��ȡͼƬ��ʽ
		File file = new File(input);
		String formatname = GetPostfixReader.getPostfix(file);

		// ͼƬ�������
		ImageReader reader = File2ImageStream.F2IS(input, formatname);
		int width = (int) Math.floor(reader.getWidth(0));
		int height = (int) Math.floor(reader.getHeight(0));

		int spottedSpot = 0;

		// ���㷨���������ܱ�Ե���أ��������ص�ֵA����ȥ��Χ8��ֵ(ȥ�������С���6������ƽ��ֵB��A-B�ľ���ֵ������B���õ�C,һ��0~������Ĳ���ֵ
		// Center
		for (matrixsize = 1; matrixsize < 10; matrixsize++) {
			for (int i = matrixsize; i < width - matrixsize; i += matrixsize) {
				for (int j = matrixsize; j < height - matrixsize; j += matrixsize) {

					double a1 = (double) GetPixelArray.colorvalue[i - 1][j - 1];
					double a2 = (double) GetPixelArray.colorvalue[i - 1][j];
					double a3 = (double) GetPixelArray.colorvalue[i - 1][j + 1];
					double a4 = (double) GetPixelArray.colorvalue[i][j - 1];
					double a5 = (double) GetPixelArray.colorvalue[i][j + 1];
					double a6 = (double) GetPixelArray.colorvalue[i + 1][j - 1];
					double a7 = (double) GetPixelArray.colorvalue[i + 1][j];
					double a8 = (double) GetPixelArray.colorvalue[i + 1][j + 1];

					List<Double> list = new ArrayList<Double>();
					list.add(a1);
					list.add(a2);
					list.add(a3);
					list.add(a4);
					list.add(a5);
					list.add(a6);
					list.add(a7);
					list.add(a8);

					double maxB = GetMaxMin.getMax(list);
					double minB = GetMaxMin.getMin(list);
					double avgB = (a1 + a2 + a3 + a4 + a5 + a6 + a7 + a8 - maxB - minB) / 6;
					resultCenter = (GetPixelArray.colorvalue[i][j] - avgB) / avgB;

					if (resultCenter > theshold) {
						spottedSpot++;
						System.out.println("Center"+"\tMatrix: " + matrixsize + "\tX: " + i + "\tY: " + j + "\tDifference "
								+ resultCenter * 100 + "%");
					}
				}
			}
		}


		System.out.println("Total Spot = " + spottedSpot);

		long endTime = new Date().getTime();
		System.out.println("Spotting Tact Time:[" + (endTime - beginTime) + "]ms");
		System.out.println("");
	}
}