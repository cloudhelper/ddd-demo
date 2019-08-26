/**
 *
 */
package org.cloudhelper.ddd.demo.domain.model.user;

import org.cloudhelper.ddd.demo.input.ui.constant.ReturnCode;
import org.cloudhelper.ddd.demo.domain.model.post.Post;
import org.cloudhelper.ddd.demo.infrastructure.exception.BusinessException;

/**
 *
 */
public class PostAuthor extends User{

	private final static int MIN_LENGTH_POST_SOURCE_CONTENT = 16;

	public PostAuthor(long id) {
		super(id);
	}
	/**
	 * 发布帖子
	 * @param title
	 * @param sourceContent
	 * @return Post 发布得到的帖子
	 */
	public Post posting(String title, String sourceContent) throws BusinessException {
		if(sourceContent.length() < MIN_LENGTH_POST_SOURCE_CONTENT) {
			 //抛出业务异常
			throw new BusinessException(ReturnCode.POST_SOURCE_CONTENT_AT_LEAST_SIXTEEN_WORDS);
		}
		Post post = new Post(this.getId(), title, sourceContent);
		return post;
	}

	/**
     * 删帖
     * @param post 拟被删除的帖子实体
     * @return post 删帖后的帖子实体
	 * @throws BusinessException
     */
    public Post deletePost(Post post) throws BusinessException {
        if (post == null) {
            throw new BusinessException(ReturnCode.POST_IS_NOT_EXIT);
        }
        if (!this.isMyself(post.getPostAuthor())) {
            throw new BusinessException(ReturnCode.CAN_NOT_DELETE_OTHER_USERS_POST);
        }
        post.delete();
        return post;
    }

}
