package org.cloudhelper.ddd.demo.ui.web.dto.post;

import org.hibernate.validator.constraints.NotEmpty;

import org.cloudhelper.ddd.demo.ui.web.dto.base.RequestBody;

/**
 * QueryPostDetail请求体
 *
 */
public class QueryPostDetailReqBody extends RequestBody {

	/**
	 * 读者用户编号
	 */
	@NotEmpty(message="{request.userId.not.empty}")
	private String readerId;

	/**
	 * 帖子id
	 */
	@NotEmpty(message="{request.postId.not.empty}")
	private String postId;


	public String getReaderId() {
		return readerId;
	}

	public void setReaderId(String readerId) {
		this.readerId = readerId;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}



}
