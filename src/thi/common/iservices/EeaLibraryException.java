package thi.common.iservices;

import java.util.List;

public class EeaLibraryException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<String> detailErrors;
	
	public EeaLibraryException() {
	}

	public EeaLibraryException(String message) {
		super(message);
	}

	public EeaLibraryException(Throwable cause) {
		super(cause);
	}

	public EeaLibraryException(String message, Throwable cause) {
		super(message, cause);
	}

	public EeaLibraryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EeaLibraryException(String message, List<String> detailErrors ) {
		super(message);
		this.detailErrors = detailErrors;
	}
	
	public List<String> getDetailErrors() {
		return detailErrors;
	}

}
