package test.java;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import sithterm.SithTermMainWindow;

class SithMainWindowTest
	{
		SithTermMainWindow win = null;
		@BeforeAll
		static void setUpBeforeClass()
		    throws Exception
			{
			}
			
		@AfterAll
		static void tearDownAfterClass()
		    throws Exception
			{
			}
			
		@BeforeEach
		void setUp()
		    throws Exception
			{
				win = new SithTermMainWindow();
			}
			
		@AfterEach
		void tearDown()
		    throws Exception
			{
			}
			
		@Test
		void testGetLnfMap()
			{
				java.util.Map<String, String> m = win.getLnfMap();
				for (Entry<String,String> e : m.entrySet()) {
					assertEquals(true,e.getKey() instanceof String);
					assertEquals(true,e.getValue() instanceof String);
				}
			}
			
		@Test
		void testSetLnfMap()
			{
				Map<String,String> foo = new HashMap<String,String>();
				foo.put("a","b");
				win.setLnfMap(foo);
				assertEquals(foo,win.getLnfMap());
			}
			
			
			
		@Test
		void testSetFrame()
			{
				JFrame j = new JFrame();
				win.setFrame(j);
				assertEquals(j,win.getFrame());
			}
			
		@Test
		void testGetMenuBar()
			{
				JMenuBar j = new JMenuBar();
				win.setMenuBar(j);
				assertEquals(j,win.getMenuBar());
			}
			
		
		@Test
		void testGetMnFile()
			{
				JMenu j = new JMenu();
				win.setMnFile(j);
				assertEquals(j,win.getMnFile());
			}
			
	
			
		@Test
		void testGetMnTabs()
			{
				JMenu j = new JMenu();
				win.setMnTabs(j);
				assertEquals(j,win.getMnTabs());
						
			}
			
		@Test
		void testGetMnSettings()
			{
				JMenu j  = new JMenu();
				win.setMnSettings(j);
				assertEquals(j,win.getMnSettings());
			}
			
			
		@Test
		void testGetMntmNewTab()
			{
				JMenuItem j = new JMenuItem();
				win.setMntmNewTab(j);
				assertEquals(j,win.getMntmNewTab());
			}
			
			
		@Test
		void testGetMntmCloseTab()
			{
				//fail("Not yet implemented");
			}
			
			
		@Test
		void testGetPanel()
			{
				//fail("Not yet implemented");
			}
			
		@Test
		void testGetTabbedPane()
			{
				//fail("Not yet implemented");
			}
			
			
		@Test
		void testGetLogger()
			{
				//fail("Not yet implemented");
			}
			
		@Test
		void testGetMntmClose()
			{
				//fail("Not yet implemented");
			}
			
			
		@Test
		void testGetTabNumber()
			{
				//fail("Not yet implemented");
			}
			
			
		@Test
		void testGetSpop()
			{
				//fail("Not yet implemented");
			}
			
			
		@Test
		void testGetSettings()
			{
				//fail("Not yet implemented");
			}
			
		@Test
		void testGetMntmTerminalSettings()
			{
				//fail("Not yet implemented");
			}
			
		@Test
		void testGetWidget()
			{
				//fail("Not yet implemented");
			}
			
		@Test
		void testSaveSettings()
			{
				//fail("Not yet implemented");
			}
			
		@Test
		void testLoadSettings()
			{
				//fail("Not yet implemented");
			}
	}
