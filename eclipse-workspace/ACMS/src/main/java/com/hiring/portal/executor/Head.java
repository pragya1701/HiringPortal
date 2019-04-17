package com.hiring.portal.executor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.hiring.portal.model.Path;

public class Head {

	public void execute(String in) {
		try {
			// runProcess("pwd");
			System.out.println("**********");
			String file = Path.path + "/iofiles/runit.sh";
			String inputfile = "/iofiles/input1";
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			String script = "#!/bin/bash\n" + "javac " + Path.path + "/iofiles/hello.java 2> " + Path.path
					+ "/iofiles/error\n" + "java -cp iofiles hello < " + Path.path + inputfile + " > " + Path.path
					+ "/iofiles/output";
			bw.write(script);
			bw.close();
			System.out.println(script);

			String command = "sh " + file;
			runProcess(command);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void printLines(String cmd, InputStream ins) throws Exception {
		String line = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(ins));
		while ((line = in.readLine()) != null) {
			System.out.println(cmd + " " + line);
		}
	}

	private static void runProcess(String command) throws Exception {
		Process pro = Runtime.getRuntime().exec(command);
		printLines(command + " stdout:", pro.getInputStream());
		printLines(command + " stderr:", pro.getErrorStream());
		pro.waitFor();
		System.out.println(command + " exitValue() " + pro.exitValue());
	}

}
