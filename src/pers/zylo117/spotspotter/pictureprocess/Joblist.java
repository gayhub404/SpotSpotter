package pers.zylo117.spotspotter.pictureprocess;

import java.io.IOException;
import java.io.File;

import pers.zylo117.spotspotter.fileprocessor.FileDetecter;
import pers.zylo117.spotspotter.fileprocessor.FileListener;
import pers.zylo117.spotspotter.fileprocessor.FileNameTrim;
import pers.zylo117.spotspotter.fileprocessor.Obj2String;
import pers.zylo117.spotspotter.patternrecognition.GetColorValue;

public class Joblist {

	public static void joblist() throws IOException {

		if (null == FileListener.filename || "".equals(FileListener.filename)) {
			System.out.println("Input is null");
		}

		String wipname = PicProcess.original + FileListener.filename;
		String IRCFname = PicProcess.IRCF + FileListener.filename;
		String ROIname = PicProcess.ROI + FileListener.filename;

		// ͼ�ηָ�
		// PicProcess.crop2(wipname, ROIname, "jpg", 82, 86, 570, 340);
		// ROInaive.spitImage(obj2String.o2s(ROIname));
		// System.out.println(wipname);
		
		// ��ȡ���ؾ���,getData(�ļ�,�ӳ�ʱ�䣨����Խǿ���ļ�ԽС���ӳ�ԽС��,ʶ����ʼ��x,ʶ����ʼ��y,ʶ�𳤶�,ʶ����) 
		while (true) {
			if (FileDetecter.judgeFileExists(wipname)) {
				GetColorValue.getData(wipname, 500, 384, 338, 570, 340);
				wipname = null;
				break;
			}
			else System.out.println("File not exists, skipping");
		}
		System.out.println("Spitted");
		System.out.println("");
		// �ļ�����ȡ,����
		// ״̬
		// System.out.println(FileNameTrim.getStatus());
		// ���
		// System.out.println(FileNameTrim.getYear());

	}

}
