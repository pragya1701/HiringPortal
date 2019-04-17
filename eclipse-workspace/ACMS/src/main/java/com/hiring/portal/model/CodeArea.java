package com.hiring.portal.model;

public class CodeArea {
	private String content;
	private String input;
	private String output;
    private String userOutput;
    private String error;

	public CodeArea() {
		this.content = "";
		this.input = "";
		this.output = "";
		this.userOutput = "";
		this.error = "";
	}

	public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output += output;
	}
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getUserOutput() {
		return userOutput;
	}

	public void setUserOutput(String userOutput) {
		this.userOutput = userOutput;
	}

}
