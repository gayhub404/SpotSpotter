package pers.zylo117.spotspotter.pictureprocess;

import java.io.IOException;
import java.io.File;

import pers.zylo117.spotspotter.fileprocessor.FileDetecter;
import pers.zylo117.spotspotter.fileprocessor.FileListener;
import pers.zylo117.spotspotter.fileprocessor.FileNameTrim;
import pers.zylo117.spotspotter.fileprocessor.Obj2String;
import pers.zylo117.spotspotter.patternrecognition.GetPixelArray;
import pers.zylo117.spotspotter.patternrecognition.ImageStream2File;

public class Joblist {

	public static void joblist() throws IOException {
		
		// �ж��ļ��Ƿ��Ƿ�д��InputStream
		if (null == FileListener.filename || "".equals(FileListener.filename)) {
			System.out.println("Input is null");
		}

		String inputimage = PicProcess.inputdir + FileListener.filename;
		String rawoutputimage = PicProcess.rawoutputdir + FileListener.filename;
		String finaloutputimage = PicProcess.finaloutputdir + FileListener.filename;

		// ��ȡ���ؾ���ǰ���ļ��Ƿ���ڽ����ж�
		while (true) {
			if (FileDetecter.judgeFileExists(inputimage)) {
				// ��ȡ���ؾ���,getData(�ļ�,�����ӳ�ʱ�䣨����Խǿ���ļ�ԽС���ӳ�ԽС��,ʶ����ʼ��x,ʶ����ʼ��y,ʶ�𳤶�,ʶ����)
				GetPixelArray.getData(inputimage, rawoutputimage, 1, 384, 338, 570, 340);
				inputimage = null;
				break;
			} else
				System.out.println("File not exists, skipping");
		}
	}

}
