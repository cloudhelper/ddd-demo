package org.cloudhelper.ddd.demo.infrastructure.repository.redis;

import org.cloudhelper.ddd.demo.infrastructure.repository.translator.PostRepositoryTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.cloudhelper.ddd.demo.domain.model.post.Post;
import org.cloudhelper.ddd.demo.domain.repository.IPostRepository;

/**
 * redis cache 仓库
 *
 */
@Repository
public class PostRedisRepository implements IPostRepository {

	@Autowired
	private PostRepositoryTranslator postRepositoryTranslator;

	/**
	 * NOTE: maybe return
	 */
	@Override
	public Post query(long postId) {
		//TODO maybe need 'postRepositoryTranslator' to translate entity to domain model object.

		//TODO use redisClient to query cache
		return null;
	}

	@Override
	public int save(Post post) {
		//TODO use redisClient to save cache
		return 1;
	}

	@Override
	public int delete(Post post) {
		//TODO use redisClient to remove cache
		return 0;
	}

}
