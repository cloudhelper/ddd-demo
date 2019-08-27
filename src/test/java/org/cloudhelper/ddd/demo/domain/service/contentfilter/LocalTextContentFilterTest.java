/**
 *
 */
package org.cloudhelper.ddd.demo.domain.service.contentfilter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * 内容过滤单元测试
 */
public class LocalTextContentFilterTest {

	private LocalTextContentFilter localTextContentFilter;

	@Before
	public void setUp() {
		localTextContentFilter = new LocalTextContentFilter();
	}

	@Test
	public void filtContentPassedWhenContentIsValid() {
		String content = "合法的内容";
		boolean ret = localTextContentFilter.filtContent(content);
		assertTrue(ret);
	}

	@Test
	public void filtContentNotPassedWhenContentIsInvalid() {
		String content = "NND";
		boolean ret = localTextContentFilter.filtContent(content);
		assertFalse(ret);
	}

}
