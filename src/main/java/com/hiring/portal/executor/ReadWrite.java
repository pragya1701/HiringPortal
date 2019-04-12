package com.hiring.portal.executor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

import com.hiring.portal.model.Path;

public class ReadWrite {
	public void writeUsingOutputStream(String data, String filename) {
		OutputStream os = null;
		try {
			String fileName = Path.path + "/iofiles/" + filename;
			os = new FileOutputStream(new File(fileName));
			os.write(data.getBytes(), 0, data.length());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public int writeTestOutput(String getout) throws Exception {
		File file1 = new File(Path.path + "/iofiles/output1");
		File file2 = new File(Path.path + "/iofiles/output");
		BufferedReader reader1 = new BufferedReader(new FileReader(file1));
		BufferedReader reader2 = new BufferedReader(new FileReader(file2));
		String st1 = "", st2 = "";
		int marks = 0;
		while ((st1 = reader1.readLine()) != null) {
			st2 = reader2.readLine();
			if (st1.equals(st2)) {
				marks += 5;
			}
		}
		reader1.close();
		reader2.close();
		return marks;
	}

	public String writeSampleOutput(String getout) throws Exception {
		File file1 = new File(Path.path + "/iofiles/output");
		BufferedReader reader1 = new BufferedReader(new FileReader(file1));
		StringBuilder sb = new StringBuilder("");
		String st = "", out = "";
		while ((st = reader1.readLine()) != null) {
			sb.append(st);
		}
		out = sb.toString();
		System.out.println(out);
		reader1.close();
		return out;
	}

	public String writeFileToError() throws Exception {
		File file = new File(Path.path + "/iofiles/error");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st = "", err = "";
		while ((st = br.readLine()) != null) {
			err += st + "\n";
		}
		br.close();
		return err;
	}

}
