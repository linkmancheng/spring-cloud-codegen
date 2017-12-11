package cn.springcloud.codegen.engine.exception;
@SuppressWarnings("serial")
public class InitializrException extends RuntimeException {

	public InitializrException(String message, Throwable cause) {
		super(message, cause);
	}

	public InitializrException(String message) {
		super(message);
	}

}
