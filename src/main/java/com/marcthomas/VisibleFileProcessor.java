package com.marcthomas;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
			List<File> files = Arrays.asList(fileList);
			List<File> filteredFiles = files.stream().filter(checkFile -> !checkFile.isHidden() && checkFile.isFile())
			.collect(Collectors.toList());
			
			for (File file : filteredFiles) {
				System.out.println("Processing file... " + file.getAbsolutePath());
			}
		}
	}

	public static void main(String[] args) {
		VisibleFileProcessor visibleFileProcessor = new VisibleFileProcessor();
		visibleFileProcessor.execute((args.length == 1) ? args[0] : ".");
	}
}