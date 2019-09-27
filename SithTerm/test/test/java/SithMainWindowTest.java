package test.java;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

import sithterm.SettingsPopup;
import sithterm.SithTermMainWindow;
import sithterm.SithTermPlugin;
import sithterm.SithTermSettings;

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
				for (Entry<String, String> e : m.entrySet())
					{
						assertEquals(true, e.getKey() instanceof String);
						assertEquals(true, e.getValue() instanceof String);
					}
			}
			
		@Test
		void testSetLnfMap()
			{
				Map<String, String> foo = new HashMap<String, String>();
				foo.put("a", "b");
				win.setLnfMap(foo);
				assertEquals(foo, win.getLnfMap());
			}
			
		@Test
		void testSetFrame()
			{
				JFrame j = new JFrame();
				win.setFrame(j);
				assertEquals(j, win.getFrame());
			}
			
		@Test
		void testGetMenuBar()
			{
				JMenuBar j = new JMenuBar();
				win.setMenuBar(j);
				assertEquals(j, win.getMenuBar());
			}
			
		@Test
		void testGetMnFile()
			{
				JMenu j = new JMenu();
				win.setMnFile(j);
				assertEquals(j, win.getMnFile());
			}
			
		@Test
		void testGetMnTabs()
			{
				JMenu j = new JMenu();
				win.setMnTabs(j);
				assertEquals(j, win.getMnTabs());
			}
			
		@Test
		void testGetMnSettings()
			{
				JMenu j = new JMenu();
				win.setMnSettings(j);
				assertEquals(j, win.getMnSettings());
			}
			
		@Test
		void testGetMntmNewTab()
			{
				JMenuItem j = new JMenuItem();
				win.setMntmNewTab(j);
				assertEquals(j, win.getMntmNewTab());
			}
			
		@Test
		void testGetMntmCloseTab()
			{
				JMenuItem j = new JMenuItem();
				win.setMntmCloseTab(j);
				assertEquals(j, win.getMntmCloseTab());
			}
			
		@Test
		void testGetPanel()
			{
				JPanel j = new JPanel();
				win.setPanel(j);
				assertEquals(j, win.getPanel());
			}
			
		@Test
		void testGetTabbedPane()
			{
				JTabbedPane j = new JTabbedPane();
				win.setTabbedPane(j);
				assertEquals(j, win.getTabbedPane());
			}
			
		@Test
		void testGetLogger()
			{
				Logger l = Logger.getRootLogger();
				SithTermMainWindow.setLogger(l);
				assertEquals(l, SithTermMainWindow.getLogger());
			}
			
		@Test
		void testGetMntmClose()
			{
				JMenuItem j = new JMenuItem();
				win.setMntmClose(j);
				assertEquals(j, win.getMntmClose());
			}
			
		@Test
		void testGetTabNumber()
			{
				int tabNumber = 100;
				win.setTabNumber(tabNumber);
				assertEquals(tabNumber, win.getTabNumber());
			}
			
		@Test
		void testGetSpop()
			{
				SettingsPopup j = new SettingsPopup(win);
				win.setSpop(j);
				assertEquals(j, win.getSpop());
			}
			
		@Test
		void testGetSettings()
			{
				SithTermSettings s = new SithTermSettings();
				win.setSettings(s);
				assertEquals(s, win.getSettings());
			}
		
		@Test
		void testGetFrmSithTerm()
		{
			JFrame j = new JFrame();
			win.setFrmSithterm(j);
			assertEquals(j,win.getFrmSithterm());
		}
		@Test
		void testGetJsParser()
		{
			Gson g = new GsonBuilder().create();
			win.setJsParser(g);
			assertEquals(g,win.getJsParser());
		}
		@Test
		void plugMap() {
			SithTermPlugin bar = new SithTermPlugin(win) {
				private static final long serialVersionUID = 1L;

				@Override
				public void initialize(String jarName)
					{
						//nope
						
					}

				@Override
				public void remove()
					{
						// nothing to do
						
					}

				@Override
				public String getPluginName()
					{
						
						return "foo";
					}
			};
			Map<String,SithTermPlugin> m = new HashMap<>();
			m.put(bar.getPluginName(), bar);
			win.setPluginMapV1(m);
			assertEquals(m,win.getPluginMapV1());
		}
	}
