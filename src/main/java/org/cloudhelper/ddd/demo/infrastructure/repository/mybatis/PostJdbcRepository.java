package org.cloudhelper.ddd.demo.infrastructure.repository.mybatis;

import org.cloudhelper.ddd.demo.infrastructure.repository.mybatis.dao.PostMapper;
import org.cloudhelper.ddd.demo.infrastructure.repository.translator.PostRepositoryTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.cloudhelper.ddd.demo.domain.model.post.Post;
import org.cloudhelper.ddd.demo.domain.repository.IPostRepository;
import org.cloudhelper.ddd.demo.infrastructure.repository.mybatis.dao.PostEntity;

/**
 * mybatis 持久化 仓库
 *
 */
@Repository
public class PostJdbcRepository implements IPostRepository {


//	@Autowired
	/**
	 * 帖子相关数据库操作mapper
	 * TODO： 未配置spring-mybatis，为了能启动应用，将@Autowired 注释掉。实际项目中需要放开
	 */
	private PostMapper postMapper;

	@Autowired
	private PostRepositoryTranslator postRepositoryTranslator;

	@Override
	public Post query(long postId) {
		PostEntity postEntity = postMapper.query(postId);
		return postRepositoryTranslator.translateFromPostEntity(postEntity);
	}

	@Override
	public int save(Post post) {
		PostEntity postEntity = postRepositoryTranslator.translateFromPost(post);
		return postMapper.save(postEntity);
	}

	@Override
	public int delete(Post post) {
		//TODO
		return 0;
	}

}
