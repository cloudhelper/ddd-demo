package org.cloudhelper.ddd.demo.infrastructure.repository.mybatis.dao;

/**
 * 帖子实体相关数据库操作接口
 *
 */
public interface PostMapper {

	/**
	 * 查询指定帖子entity
	 * @param postId
	 * @return PostEntity
	 */
	PostEntity query(long postId);

    /**
     * 保存帖子
     * @param postEntity
     * @return int
     *
     */
    int save(PostEntity postEntity);

    /**
     * 更新帖子状态
     * @param postEntity
     * @return int
     */
    int updatePostStatus(PostEntity postEntity);

}
