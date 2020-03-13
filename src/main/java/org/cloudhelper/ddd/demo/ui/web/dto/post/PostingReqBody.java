package org.cloudhelper.ddd.demo.ui.web.dto.post;

import org.hibernate.validator.constraints.NotEmpty;

import org.cloudhelper.ddd.demo.ui.web.dto.base.RequestBody;

/**
 * Posting请求体
 *
 */
public class PostingReqBody extends RequestBody {

	@NotEmpty(message="{request.userId.not.empty}")
	private String userId;

    private String title;

    @NotEmpty(message="{request.post.posting.content.not.empty}")
    private String sourceContent;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSourceContent() {
		return sourceContent;
	}

	public void setSourceContent(String sourceContent) {
		this.sourceContent = sourceContent;
	}

}
