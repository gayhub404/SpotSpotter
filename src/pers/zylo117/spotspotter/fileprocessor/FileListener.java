package pers.zylo117.spotspotter.fileprocessor;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import pers.zylo117.spotspotter.pictureprocess.Joblist;
import pers.zylo117.spotspotter.pictureprocess.PicProcess;
import pers.zylo117.spotspotter.pictureprocess.ROInaive;

public class FileListener {

	public static String filename;
	
	public static void Autoscript() throws IOException, InterruptedException {
		WatchService watcher = FileSystems.getDefault().newWatchService();
		// �����ļ�����/ɾ��/�޸�,��֧��JAVA 1.7�����ϰ汾
		Paths.get(PicProcess.original).register(watcher, 
				StandardWatchEventKinds.ENTRY_CREATE,
				StandardWatchEventKinds.ENTRY_DELETE,
				StandardWatchEventKinds.ENTRY_MODIFY);

		while (true) {
			WatchKey key = watcher.take();
			for (WatchEvent<?> event : key.pollEvents()) {
				// �ļ�����/ɾ��/�޸�ʱ֪ͨ
				//System.out.println(event.context() + " comes to " + event.kind());
				Object eventcontext = event.context();
				filename = Obj2String.o2s(eventcontext);
				Object eventkind = event.kind();
				String eventkindstr = Obj2String.o2s(eventkind);

				if (eventkindstr.equals("ENTRY_CREATE")){
					System.out.println(filename  + " Created");
					System.out.println("Ready 2 be spitted");
					
					//�ü��������˹�Ƭ(�ްױ�),���������ͼ�����ؾ���
					Joblist.joblist();
				}
			}

			boolean valid = key.reset();
			if (!valid) {
				break;
			}
		}
	}
}