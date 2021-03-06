/**
 *
 */
package org.cloudhelper.ddd.demo.application.domain.model.user;

import org.cloudhelper.ddd.demo.ui.web.constant.ReturnCode;
import org.cloudhelper.ddd.demo.application.domain.model.post.Post;
import org.cloudhelper.ddd.demo.application.domain.model.post.PostStatus;
import org.cloudhelper.ddd.demo.infrastructure.exception.BusinessException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 *
 */
public class PostAuthorTest {

	private PostAuthor postAuthor;
	private long authorId;

	private Post post;

	@Before
	public void setUp() throws Exception {
		authorId = 40;
		postAuthor = new PostAuthor(authorId);
		post = new Post(authorId, "测试帖子",  "测试帖子内容，内容必须大于16个字，字数不够我来凑！");
	}

	@Test
	public void postingSuccess() {
		String title = "测试帖子";
		String sourceContent = "测试帖子内容，内容必须大于16个字，字数不够我来凑！";
		Post post;
		try {
			post = postAuthor.posting(title, sourceContent);
			assertTrue(post != null);
			assertTrue(title.equals(post.getTitle()));
			assertTrue(sourceContent.equals(post.getSourceContent()));
			assertTrue(postAuthor.getId() == post.getAuthorId());
		} catch (BusinessException e) {
			fail("unExpected an BussinessException to be thrown, " + e.getMessage());
		}
	}

	@Test
	public void postingSuccessWhenTitleIsEmpty() {
		String sourceContent = "测试帖子内容，内容必须大于16个字，字数不够我来凑！";
		Post post;
		try {
			post = postAuthor.posting(null, sourceContent);
			assertTrue(post != null);
			assertTrue(sourceContent.equals(post.getSourceContent()));
			assertTrue(postAuthor.getId() == post.getAuthorId());
		} catch (BusinessException e) {
			fail("unExpected an BussinessException to be thrown, " + e.getMessage());
		}
	}

	@Test
	public void postingSuccessWhenSoureContentIsLessThanSixteen() {
		String sourceContent = "测试帖子内容，内容小16个字";
		try {
			postAuthor.posting(null, sourceContent);
			fail("Expected an BussinessException to be thrown, but don‘t catch." );
		} catch (BusinessException e) {
			assertTrue(ReturnCode.POST_SOURCE_CONTENT_AT_LEAST_SIXTEEN_WORDS.equals(e.getMessage()));
		}
	}

	@Test
	public void deletePostSuccess() {
		try {
			post = postAuthor.deletePost(post);
			assertTrue(PostStatus.HAS_DELETED.equals(post.getStatus()));
		} catch (BusinessException e) {
			fail("unExpected an BussinessException to be thrown, " + e.getMessage());
		}
	}

	@Test
	public void deletePostFailWhenPostIsNull() {
		try {
			postAuthor.deletePost(null);
			fail("expected an BussinessException to be thrown, but do not catch.");
		} catch (BusinessException e) {
			assertTrue(ReturnCode.POST_IS_NOT_EXIT.equals(e.getMessage()));
		}
	}

	@Test
	public void deletePostFailWhenPostIsNotMine() {
		try {
			Post otherPost = new Post(41, "测试帖子",  "测试帖子内容，内容必须大于16个字，字数不够我来凑！");
			postAuthor.deletePost(otherPost);
			fail("expected an BussinessException to be thrown, but do not catch.");
		} catch (BusinessException e) {
			assertTrue(ReturnCode.CAN_NOT_DELETE_OTHER_USERS_POST.equals(e.getMessage()));
		}
	}


}
