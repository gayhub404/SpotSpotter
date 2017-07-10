package pers.zylo117.spotspotter.pictureprocess;

import java.io.IOException;
import pers.zylo117.spotspotter.fileprocessor.FileDetecter;
import pers.zylo117.spotspotter.fileprocessor.FileListener;
import pers.zylo117.spotspotter.patternrecognition.GetPixelArray;
import pers.zylo117.spotspotter.patternrecognition.Binaryzation;
import pers.zylo117.spotspotter.patternrecognition.Comparison;

public class Joblist {

	public static void joblist() throws IOException {

		// 判断文件是否是否写入InputStream
		if (null == FileListener.filename || "".equals(FileListener.filename)) {
			System.out.println("Input is null");
		}

		String inputimage = PicProcess.inputdir + FileListener.filename;
		String rawoutputimage = PicProcess.rawoutputdir + FileListener.filename;
		String bipicoutputimage = PicProcess.bipicdir + FileListener.filename;
		String finaloutputimage = PicProcess.finaloutputdir + FileListener.filename;

		// 第一项
		// 提取像素矩阵前对文件是否存在进行判断
		while (true) {
			if (FileDetecter.judgeFileExists(inputimage)) {
				// 提取像素矩阵,getData(文件,缓冲延迟时间（机器越强，文件越小，延迟越小）,识别起始点x,识别起始点y,识别长度,识别宽度)
				GetPixelArray.getData(inputimage, rawoutputimage, 100, Comparison.ROIstart_x, Comparison.ROIstart_y, Comparison.ROIlength_x, Comparison.ROIlength_y);
				inputimage = null;
				break;
			} else
				System.out.println("File not exists, skipping");
		}

		// 第二项
		// 对生成的原始画像进行二（多）值化处理
		while (true) {
			if (FileDetecter.judgeFileExists(rawoutputimage)) {
				// 行二（多）值化处理 bipic(输入，输出，级别（越低越精细）)
				Binaryzation.bipic(rawoutputimage, bipicoutputimage, 32);
				rawoutputimage = null;
				break;
			} else
				System.out.println("File not exists, skipping");
		}

	}
}
