package org.cloudhelper.ddd.demo.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.cloudhelper.ddd.demo.domain.model.post.Post;
import org.cloudhelper.ddd.demo.domain.repository.IPostRepository;
/**
 * 帖子仓库实现类
 *
 */
@Repository
public class PostRepository implements IPostRepository {
	private IPostRepository postJdbcRepository;
	private IPostRepository postRedisRepository;
	@Override
	public Post query(long postId) {
		/**
		 * NOTE： 如果使用redis做cache，那么这里会先查询redis，然后再查询主存
		 * 		示例中，将memory仓库作为主存使用
		 */
		//1、查询缓存
		Post post = postRedisRepository.query(postId);
		if(post == null) {
			//2.1、缓存为空，查询主存
			post = postJdbcRepository.query(postId);
			//2.2、将主存中查询到的结果缓存
			postRedisRepository.save(post);
		}
		//3、返回查询结果
		return post;
	}

	@Override
	public int save(Post post) {
		//1、写入缓存
		postRedisRepository.save(post);
		//2、写入关系型数据库
		return postJdbcRepository.save(post);
	}

	@Override
	public int delete(Post post) {
		//1、删除缓存
		postRedisRepository.delete(post);
		//2、删除主存
		return postJdbcRepository.delete(post);
	}

}
