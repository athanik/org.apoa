package org.apoa.extensions;

import static org.junit.Assert.*;

import java.net.URL;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QueryResultTest {

	private QueryResult test;
	
	@Before
	public void setUp() throws Exception {
		test = new QueryResult();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testName() throws Exception {
		String name = "BLAH";
		test.setName(name);
		assertEquals(name,test.getName());
	}
	
	@Test
	public void testDescription() throws Exception {
		String description = "BLAH";
		test.setDescription(description);
		assertEquals(description,test.getDescription());
	}
	
	@Test
	public void testURL() throws Exception {
		URL url = new URL("http://example.com");
		test.setURL(url);
		assertEquals(url,test.getURL());
	}

}
