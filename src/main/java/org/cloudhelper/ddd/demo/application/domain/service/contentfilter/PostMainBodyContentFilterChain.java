/**
 *
 */
package org.cloudhelper.ddd.demo.application.domain.service.contentfilter;

import java.util.Iterator;
import java.util.Set;

import org.cloudhelper.ddd.demo.application.domain.model.post.Post;

/**
 */
public class PostMainBodyContentFilterChain {

	private Set<AbstractContentFilter> contentFilters;

	public PostMainBodyContentFilterChain() {
		AbstractTextContentFilter localTextContentFilter = new LocalTextContentFilter();
		AbstractTextContentFilter remoteTextContentFilter = new RemoteTextContentFilter();
		ImageContentFilter imageContentFilter = new ImageContentFilter();
		//优先校验本地的敏感词
		contentFilters.add(localTextContentFilter);
		contentFilters.add(remoteTextContentFilter);
		contentFilters.add(imageContentFilter);
	}

	/**
	 * 过滤标题
	 * @param post
	 * @return
	 *  true —— 通过
	 *  false —— 未通过
	 */
	public boolean filtMainBody(Post post) {
		for(Iterator<AbstractContentFilter> it = contentFilters.iterator(); it.hasNext();) {
			if(!it.next().filtContent(post.getSourceContent())) {
				return false;
			}
		}
		return true;
	}

}
