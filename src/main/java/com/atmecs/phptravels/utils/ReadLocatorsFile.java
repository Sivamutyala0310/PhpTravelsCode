package com.atmecs.phptravels.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadLocatorsFile {
		
		static Properties properties;
		static FileReader reader;
		static File file;

		public static Properties loadProperty(String filePath) throws IOException {
			properties = new Properties();
			file = new File(filePath);
			reader = new FileReader(file);
			properties.load(reader);
			return properties;
		}

		public static String getData(String data) throws IOException {

			String filedata = properties.getProperty(data);
			return filedata;
		}
	}
