package org.cloudhelper.ddd.demo.application.service;

import org.cloudhelper.ddd.demo.infrastructure.exception.BusinessException;
import org.cloudhelper.ddd.demo.input.ui.dto.base.RequestDto;
import org.cloudhelper.ddd.demo.input.ui.dto.post.DeletePostReqBody;
import org.cloudhelper.ddd.demo.input.ui.dto.post.DeletePostRespBody;
import org.cloudhelper.ddd.demo.input.ui.dto.post.PostingReqBody;
import org.cloudhelper.ddd.demo.input.ui.dto.post.PostingRespBody;
import org.cloudhelper.ddd.demo.input.ui.dto.post.QueryPostDetailReqBody;
import org.cloudhelper.ddd.demo.input.ui.dto.post.QueryPostDetailRespBody;

/**
 *
 *
 */
public interface PostService {
	/**
	 * 删除指定帖子
	 * @param requestDto
	 * @return DeletePostRespBody
	 * @throws BusinessException
	 */
	DeletePostRespBody delete( RequestDto<DeletePostReqBody> requestDto ) throws BusinessException ;
	/**
	 * 发帖
	 * @param requestDto
	 * @return PostingRespBody
	 * @throws BusinessException
	 */
	PostingRespBody posting( RequestDto<PostingReqBody> requestDto ) throws BusinessException ;
	/**
	 * 查询帖子详情
	 * @param requestDto
	 * @return QueryPostDetailRespBody
	 * @throws BusinessException
	 */
	QueryPostDetailRespBody queryPostDetail( RequestDto<QueryPostDetailReqBody> requestDto ) throws BusinessException ;

}
