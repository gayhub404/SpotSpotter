package pers.zylo117.spotspotter.pictureprocess;

import java.io.IOException;
import pers.zylo117.spotspotter.fileprocessor.FileDetecter;
import pers.zylo117.spotspotter.fileprocessor.FileListener;
import pers.zylo117.spotspotter.patternrecognition.GetPixelArray;
import pers.zylo117.spotspotter.patternrecognition.Binaryzation;
import pers.zylo117.spotspotter.patternrecognition.SpotSpotter;
import pers.zylo117.spotspotter.patternrecognition.Comparison;

public class AlgoList {

	public static void compareAlgo() throws IOException {

		// �ж��ļ��Ƿ��Ƿ�д��InputStream
		if (null == FileListener.filename || "".equals(FileListener.filename)) {
			System.out.println("Input is null");
		}

		String inputimage = PicProcess.inputdir + FileListener.filename;
		String rawoutputimage = PicProcess.rawoutputdir + FileListener.filename;
		String bipicoutputimage = PicProcess.bipicdir + FileListener.filename;
		String finaloutputimage = PicProcess.finaloutputdir + FileListener.filename;

		// ��һ��
		// ��ȡ���ؾ���ǰ���ļ��Ƿ���ڽ����ж�
		while (true) {
			if (FileDetecter.judgeFileExists(inputimage)) {
				// ��ȡ���ؾ���,getData(�ļ�,�����ӳ�ʱ�䣨����Խǿ���ļ�ԽС���ӳ�ԽС��,ʶ����ʼ��x,ʶ����ʼ��y,ʶ�𳤶�,ʶ����)
				GetPixelArray.getData(inputimage, rawoutputimage, 100, Main.ROIstart_x, Main.ROIstart_y,
						Main.ROIlength_x, Main.ROIlength_y);
				inputimage = null;
				break;
			} else
				System.out.println("File not exists, skipping");
		}

		// �ڶ���
		// �����ɵ�ԭʼ������ж����ֵࣩ������
		while (true) {
			if (FileDetecter.judgeFileExists(rawoutputimage)) {
				// �ж����ֵࣩ������ bipic(���룬���������Խ��Խ��ϸ��)
				Binaryzation.bipic(rawoutputimage, bipicoutputimage, 32);
				rawoutputimage = null;
				break;
			} else
				System.out.println("File not exists, skipping");
		}

	}

	public static void markingAlgo() throws IOException {

		// �ж��ļ��Ƿ��Ƿ�д��InputStream
		if (null == FileListener.filename || "".equals(FileListener.filename)) {
			System.out.println("Input is null");
		}

		String inputimage = PicProcess.inputdir + FileListener.filename;
		String rawoutputimage = PicProcess.rawoutputdir + FileListener.filename;
		String bipicoutputimage = PicProcess.bipicdir + FileListener.filename;
		String finaloutputimage = PicProcess.finaloutputdir + FileListener.filename;

		// ��һ��
		// ��ȡ���ؾ���ǰ���ļ��Ƿ���ڽ����ж�
		while (true) {
			if (FileDetecter.judgeFileExists(inputimage)) {
				// ��ȡ���ؾ���,getData(�ļ�,�����ӳ�ʱ�䣨����Խǿ���ļ�ԽС���ӳ�ԽС��,ʶ����ʼ��x,ʶ����ʼ��y,ʶ�𳤶�,ʶ����)
				GetPixelArray.getData(inputimage, rawoutputimage, 100, Main.ROIstart_x, Main.ROIstart_y,
						Main.ROIlength_x, Main.ROIlength_y);
				inputimage = null;
				break;
			} else
				System.out.println("File not exists, skipping");
		}

		SpotSpotter.marking(finaloutputimage, Main.ROIlength_x, Main.ROIlength_y, 1, 0.05);
	}

}