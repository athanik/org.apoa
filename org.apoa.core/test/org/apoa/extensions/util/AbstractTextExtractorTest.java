package org.apoa.extensions.util;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Collections;

import org.eclipse.jface.text.Document;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IOConsole;
import org.eclipse.ui.console.TextConsole;
import org.junit.Before;
import org.junit.Test;

public class AbstractTextExtractorTest {

	private AbstractTextExtractor test;
	
	@Before
	public void setUp() throws Exception {
		test = new AbstractTextExtractor() {
			
			@Override
			public String parseConsole() {
				return null;
			}
		};
	}

	@Test
	public void testFilterConsoles() {
		//empty cases
		assertFalse(test.filterConsoles(null));
		assertEquals(test.consoles.size(),0);
		assertFalse(test.filterConsoles(new IConsole [] {}));
		assertEquals(test.consoles.size(),0);
		
		//trivial cases
		assertFalse(test.filterConsoles(new IConsole [] {mock(IConsole.class)}));
		assertEquals(test.consoles.size(),0);
		
		assertTrue(test.filterConsoles(new IConsole [] {mock(IOConsole.class)}));
		assertEquals(test.consoles.size(),1);
		
		//mixed bags
		assertTrue(test.filterConsoles(new IConsole [] {mock(IConsole.class),mock(IOConsole.class)}));
		assertEquals(test.consoles.size(),1);
		
		assertTrue(test.filterConsoles(new IConsole [] {mock(IConsole.class),mock(IOConsole.class),mock(IOConsole.class)}));
		assertEquals(test.consoles.size(),2);
		
		assertFalse(test.filterConsoles(new IConsole [] {mock(IConsole.class),mock(TextConsole.class)}));
		assertEquals(test.consoles.size(),0);
	}
	

	@Test
	public void testGetConsoleContents() {
		final String docuString = "BLAHBLAH!";
		
		IOConsole mock = mock(IOConsole.class);
		Document docuMock = mock(Document.class);
		when(mock.getDocument()).thenReturn(docuMock);
		when(docuMock.get()).thenReturn(docuString);
		
		test.consoles = Collections.singletonList(mock);
		
		
		String val = test.getConsoleContents(0);
		assertEquals(docuString,val);
	}

}
