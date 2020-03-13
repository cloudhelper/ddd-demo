/**
 *
 */
package org.cloudhelper.ddd.demo.application.domain.service.contentfilter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.util.Assert;

/**
 */
public class LocalTextContentFilter extends AbstractTextContentFilter {
	/**
	 * 本地敏感词集合
	 */
	private Set<String> sensitiveWords = new HashSet<String>();

	public  LocalTextContentFilter() {
		sensitiveWords.add("NND");
		sensitiveWords.add("奶奶个熊");
	}


	/* (non-Javadoc)
	 * @see com.dqdl.community.domain.model.post.TextContentFilter#filtContent(Post)
	 */
	@Override
	public boolean filtContent(Object content) {
		Assert.isTrue(content instanceof String, "LocalTextContentFilter filtContent's paramter must be String.");
		for(String sensitiveWord : sensitiveWords) {
			if(((String)content).contains(sensitiveWord)) {
				return false;
			}
		}
		return true;
	}

}
