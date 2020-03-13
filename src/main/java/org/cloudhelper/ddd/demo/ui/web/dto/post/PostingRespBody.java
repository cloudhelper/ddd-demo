package org.cloudhelper.ddd.demo.ui.web.dto.post;

import org.cloudhelper.ddd.demo.ui.web.dto.base.ResponseBody;

/**
 * Posting响应体
 *
 */
public class PostingRespBody extends ResponseBody {

	private String postId;

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}
}
