/**
 *
 */
package org.cloudhelper.ddd.demo.domain.service.contentfilter;

import java.util.Iterator;
import java.util.Set;

import org.cloudhelper.ddd.demo.domain.model.post.Post;

/**
 */
public class PostTitleContentFilterChain {

	private Set<AbstractContentFilter> contentFilters;

	public PostTitleContentFilterChain() {
		AbstractTextContentFilter localTextContentFilter = new LocalTextContentFilter();
		AbstractTextContentFilter remoteTextContentFilter = new RemoteTextContentFilter();
		//优先校验本地的敏感词
		contentFilters.add(localTextContentFilter);
		contentFilters.add(remoteTextContentFilter);
	}

	/**
	 * 过滤标题
	 * @param post
	 * @return
	 *  true —— 通过
	 *  false —— 未通过
	 */
	public boolean filtTitle(Post post) {
		for(Iterator<AbstractContentFilter> it = contentFilters.iterator(); it.hasNext();) {
			if(!it.next().filtContent(post.getTitle())) {
				return false;
			}
		}
		return true;
	}

}
