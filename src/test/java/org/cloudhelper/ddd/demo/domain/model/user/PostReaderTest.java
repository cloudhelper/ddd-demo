package org.cloudhelper.ddd.demo.domain.model.user;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.cloudhelper.ddd.demo.domain.model.post.Post;
import org.junit.Before;

/**
 * PostReader unit test class
 *
 * @createdate 2017年10月15日
 */
public class PostReaderTest {

	private PostReader postReader;
	private Post post;
	private long userId;

	@Before
	public void setUp() throws Exception {
		userId = 40;
		postReader = new PostReader(userId);
		post = new Post(userId, "测试帖子",  "测试帖子内容，内容必须大于16个字，字数不够我来凑！");
	}


}
