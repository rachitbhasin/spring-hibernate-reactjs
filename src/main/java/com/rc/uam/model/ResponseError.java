package com.rc.uam.model;

public class ResponseError {
	private int status;
	private int lineNumber = 0;
	private String message = "";
	private String className = "";
	private String methodName = "";
	private String fileName = "";
	private StackTraceElement[] stackTrace;

	public ResponseError(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public ResponseError(int status, int lineNumber, String message, String className, String methodName,
			String fileName) {
		super();
		this.status = status;
		this.lineNumber = lineNumber;
		this.message = message;
		this.className = className;
		this.methodName = methodName;
		this.fileName = fileName;
	}

	public ResponseError(int status, int lineNumber, String message, String className, String methodName,
			String fileName, StackTraceElement[] stackTrace) {
		super();
		this.status = status;
		this.lineNumber = lineNumber;
		this.message = message;
		this.className = className;
		this.methodName = methodName;
		this.fileName = fileName;
		this.stackTrace = stackTrace;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param className
	 *            the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * @return the methodName
	 */
	public String getMethodName() {
		return methodName;
	}

	/**
	 * @param methodName
	 *            the methodName to set
	 */
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName
	 *            the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the lineNumber
	 */
	public int getLineNumber() {
		return lineNumber;
	}

	/**
	 * @param lineNumber
	 *            the lineNumber to set
	 */
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	/**
	 * @return the stackTrace
	 */
	public StackTraceElement[] getStackTrace() {
		return stackTrace;
	}

	/**
	 * @param stackTrace
	 *            the stackTrace to set
	 */
	public void setStackTrace(StackTraceElement[] stackTrace) {
		this.stackTrace = stackTrace;
	}
}
