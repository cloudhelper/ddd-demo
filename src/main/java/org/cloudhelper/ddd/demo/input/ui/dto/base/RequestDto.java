package org.cloudhelper.ddd.demo.input.ui.dto.base;

import javax.validation.Valid;

/**
 * 请求dto
 *
 * @param <T>
 */
public class RequestDto<T> implements UIDto {

	/**
	 * 请求渠道
	 */
	private String channel;

	/**
	 * 请求id
	 */
	private String requestId;

	/**
	 * 对body使用validation
	 */
	@Valid
	private T body;

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}


	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}

}
