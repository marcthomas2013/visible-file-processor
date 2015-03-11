package com.marcthomas;

import java.io.File;
import java.util.function.Predicate;

/**
 * This class is responsible for taking the provided folder path and process all of the
 * files in that path that aren't hidden.
 * 
 * @author marcthomas
 */
public class VisibleFileProcessor {
	public void execute(String folderPath) {
		File[] fileList = new File(folderPath).listFiles();

		if (fileList != null) {
			processFiles(fileList, checkFile -> !checkFile.isHidden() && checkFile.isFile());
		}
	}

	private void processFiles(File[] fileList, Predicate<File> checkFile) {
		for (File file : fileList) {
			if (checkFile.test(file)) {
				System.out.println("Processing file... " + file.getAbsolutePath());
			}
		}
	}

	public static void main(String[] args) {
		VisibleFileProcessor visibleFileProcessor = new VisibleFileProcessor();
		visibleFileProcessor.execute((args.length == 1) ? args[0] : ".");
	}
}