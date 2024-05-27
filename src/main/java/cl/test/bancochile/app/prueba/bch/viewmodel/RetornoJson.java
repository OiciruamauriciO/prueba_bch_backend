package cl.test.bancochile.app.prueba.bch.viewmodel;

import java.io.Serializable;

public class RetornoJson implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Object content;
	private boolean success;

	public RetornoJson(boolean success, Object object) {
		this.success = success;
		this.content = object;
	}

	public Object getContent() {
		return this.content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public boolean isSuccess() {
		return this.success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
