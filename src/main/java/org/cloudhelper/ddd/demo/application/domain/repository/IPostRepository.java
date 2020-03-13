package org.cloudhelper.ddd.demo.application.domain.repository;

import org.cloudhelper.ddd.demo.application.domain.model.post.Post;

/**
 * 帖子仓库接口
 *
 */
public interface IPostRepository {
	/**
	 * 查询指定帖子信息
	 * @param postId
	 * @return Post
	 */
	Post query(long postId);
	/**
	 * 保存指定帖子
	 * @param post
	 * @return int
	 */
	int save(Post post);
	/**
	 * 删除指定帖子
	 * @param post
	 * @return int
	 */
	int delete(Post post);

}
