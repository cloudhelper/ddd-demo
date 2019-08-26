package org.cloudhelper.ddd.demo.infrastructure.repository.memory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import org.cloudhelper.ddd.demo.domain.model.post.Post;
import org.cloudhelper.ddd.demo.domain.repository.IPostRepository;

/**
 * 内存仓库
 *
 */
@Repository
public class PostMemoryRepository implements IPostRepository {

	private static Map<Long, Post> postRepository;

	/**
	 * postID的模拟生成器，相当于数据库的sequence
	 */
	private AtomicLong postIdGenerator = new AtomicLong();

	public PostMemoryRepository() {
		postRepository = new HashMap<Long, Post>();
	}

	@Override
	public Post query(long postId) {
		return postRepository.get(postId);
	}

	@Override
	public int save(Post post) {
		long postId = postIdGenerator.incrementAndGet();
		post.setId(postId);
		postRepository.put(postId, post);
		return 1;
	}

	@Override
	public int delete(Post post) {
		Post toDeletePost = postRepository.remove(post.getId());
		return toDeletePost != null ? 1 : 0;
	}

}
