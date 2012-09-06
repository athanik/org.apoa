package org.apoa.basic;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IOConsole;
import org.junit.Before;
import org.junit.Test;

public class BasicTextExtractorTest {

	private BasicTextExtractor test;
	
	@Before
	public void setUp() throws Exception {
		test = new BasicTextExtractor();
	}

	@Test
	public void testFilterConsoles() {
		//TODO: include tests from abstract
		assertTrue(test.filterConsoles(new IConsole [] {mock(IConsole.class),mock(IOConsole.class)}));
	}

	@Test
	public void testParseConsole() {
		fail("Not yet implemented");
	}

}
