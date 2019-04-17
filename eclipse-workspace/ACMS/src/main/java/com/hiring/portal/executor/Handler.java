package com.hiring.portal.executor;

import org.springframework.web.bind.annotation.ModelAttribute;

import com.hiring.portal.model.CodeArea;
import com.hiring.portal.model.Path;
import com.hiring.portal.model.Question;

public class Handler {

	public void getSample(@ModelAttribute CodeArea code_attr, @ModelAttribute Question q) {
		String code = code_attr.getContent();
		String libraries = "import java.util.*;" + "\n" + "import java.io.*;" + "\n" + "import java.lang.*;" + "\n";
		String classname = "public class hello{" + "\n";
		String call = "public static void main(String[] args){" + "\n" + "Scanner sc = new Scanner(System.in);" + "\n";
		String readycode = libraries + classname + code + call + q.getBody();
		storeFile(readycode, q.getSampleinput(), q.getSampleoutput());
		String inp = q.getSampleinput();
		code_attr.setInput(inp.substring(2));
		code_attr.setOutput(q.getSampleoutput());
		try {
			checkSampleError(code_attr, q.getSampleoutput());
		} catch (Exception e) {
			System.out.println("error in code");
		}
	}

	public int TestCode(String code, @ModelAttribute Question q) throws Exception {
		System.out.println("in test code");
		System.out.println(code);
		System.out.print(q.getBody());
		String libraries = "import java.util.*;" + "\n" + "import java.io.*;" + "\n" + "import java.lang.*;" + "\n";
		String classname = "public class hello{" + "\n";
		String call = "public static void main(String[] args){" + "\n" + "Scanner sc = new Scanner(System.in);" + "\n";
		String readycode = libraries + classname + code + call + q.getBody();
		storeFile(readycode, q.getTestinput(), q.getTestoutput());
		ReadWrite w = new ReadWrite();
		return w.writeTestOutput(q.getTestoutput());
	}

	public void storeFile(String data, String in, String out) {
		ReadWrite w = new ReadWrite();
		w.writeUsingOutputStream(data, "hello.java");
		w.writeUsingOutputStream(in, "input1");
		w.writeUsingOutputStream(out, "output1");
		Head h = new Head();
		h.execute(in);
	}

	public void storeSampleOutput(@ModelAttribute CodeArea CodeArea, String out) throws Exception {
		ReadWrite w = new ReadWrite();
		String output = w.writeSampleOutput(out);
		CodeArea.setUserOutput(output);
	}

	public void checkSampleError(@ModelAttribute CodeArea CodeArea, String out) throws Exception {
		ReadWrite w = new ReadWrite();
		String err = w.writeFileToError();
		if (err.length() == 0) {
			CodeArea.setError("1");
			storeSampleOutput(CodeArea, out);
		} else {
			String sendErr = err.replaceAll(Path.path + "/iofiles/hello.java", "");
			CodeArea.setError(sendErr);
		}
	}

	public void checkTestError(@ModelAttribute CodeArea CodeArea, String out) throws Exception {
		ReadWrite w = new ReadWrite();
		String err = w.writeFileToError();
		if (err.length() == 0) {
			CodeArea.setError("Compilation Successful!!");
			// storeTestOutput(CodeArea , out);
		} else {
			String sendErr = err.replaceAll(Path.path + "/iofiles/hello.java", "");
			CodeArea.setError(sendErr);
		}
	}

	/*
	 * public void calculateMarks(Long id) throws Exception { //calculate MCQ marks
	 * List<UserResponse> results = questionService.getMCQResponse(id);
	 * System.out.println("still fine"); for(UserResponse result : results) {
	 * System.out.println(result.getResponse()); String s1 = result.getResponse(); q
	 * = questionService.getQues(result.getQuestionid()); String s2 = q.getAnswer();
	 * if(s1.equals(s2)) { questionService.setMarks(result.getRid() , 1); } }
	 * 
	 * //calculate Code marks List<UserResponse> res =
	 * questionService.getCodeResponse(id); for(UserResponse r : res) {
	 * System.out.println(r.getResponse()); String s = r.getResponse(); q =
	 * questionService.getQues(r.getQuestionid()) ; int marks = TestCode(s,q);
	 * questionService.setMarks(r.getRid() , marks); } }
	 */

}
