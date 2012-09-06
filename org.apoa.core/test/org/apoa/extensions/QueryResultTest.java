package org.apoa.extensions;

import static org.junit.Assert.*;

import java.net.URL;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QueryResultTest {

	private QueryResult test;
	private URL url;
	private String name;
	private String description;
	
	@Before
	public void setUp() throws Exception {
		test = new QueryResult();
		name = "blahName";
		description = "blahDescription";
		url = new URL("http://example.com");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testName() throws Exception {
		test.setName(name);
		assertEquals(name,test.getName());
	}
	
	@Test
	public void testDescription() throws Exception {
		test.setDescription(description);
		assertEquals(description,test.getDescription());
	}
	
	@Test
	public void testURL() throws Exception {
		test.setURL(url);
		assertEquals(url,test.getURL());
	}
	
	@Test
	public void testMultipleFieldConstructor() throws Exception {
		test = new QueryResult(name,description,url);
		
		assertEquals(name,test.getName());
		assertEquals(description,test.getDescription());
		assertEquals(url,test.getURL());
	}
	
	@Test
	public void testToString() throws Exception {
		test = new QueryResult(name,description,url);
		
		assertEquals(test.getClass().getSimpleName()+": "+name+"|"+description+"|"+url.toString(),test.toString());
	}

}
