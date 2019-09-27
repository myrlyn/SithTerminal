package test.java;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jediterm.terminal.HyperlinkStyle;
import com.jediterm.terminal.ui.settings.DefaultSettingsProvider;

import sithterm.SithTermSettings;

class SithTermSettingsTest
	{
		private static SithTermSettings settings = new SithTermSettings();
		
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
				settings = new SithTermSettings();
			}
			
		@AfterEach
		void tearDown()
		    throws Exception
			{
			}
			
		@Test
		void setAndGetBgColor()
			{
				Color c = new Color(0);
				settings.setBgcolor(c);
				assertEquals(c.getRGB(), settings.getBgColor().getRGB());
			}
			
		@Test
		void setAndGetBlack()
			{
				Color c = new Color(0);
				settings.setBlack(c);
				assertEquals(c.getRGB(), settings.getBlack().getRGB());
			}
			
		@Test
		void getBlue()
			{
				Color c = new Color(0);
				settings.setBlue(c);
				assertEquals(c.getRGB(), settings.getBlue().getRGB());
			}
			
		@Test
		void getBrightBlack()
			{
				Color c = new Color(0);
				settings.setBrightBlack(c);
				assertEquals(c.getRGB(), settings.getBrightBlack().getRGB());
			}
			
		@Test
		void getBrightBlue()
			{
				Color c = new Color(0);
				settings.setBrightBlue(c);
				assertEquals(c.getRGB(), settings.getBrightBlue().getRGB());
			}
			
		@Test
		void getBrightCyan()
			{
				Color c = new Color(0);
				settings.setBrightCyan(c);
				assertEquals(c.getRGB(), settings.getBrightCyan().getRGB());
			}
			
		@Test
		void getBrightGreen()
			{
				Color c = new Color(0);
				settings.setBrightGreen(c);
				assertEquals(c.getRGB(), settings.getBrightGreen().getRGB());
			}
			
		@Test
		void getBrightMagenta()
			{
				Color c = new Color(0);
				settings.setBrightMagenta(c);
				assertEquals(c.getRGB(), settings.getBrightMagenta().getRGB());
			}
			
		@Test
		void getBrightRed()
			{
				Color c = new Color(0);
				settings.setBrightRed(c);
				assertEquals(c.getRGB(), settings.getBrightRed().getRGB());
			}
			
		@Test
		void getBrightWhite()
			{
				Color c = new Color(0);
				settings.setBrightWhite(c);
				assertEquals(c.getRGB(), settings.getBrightWhite().getRGB());
			}
			
		@Test
		void getBrightYellow()
			{
				Color c = new Color(0);
				settings.setBrightYellow(c);
				assertEquals(c.getRGB(), settings.getBrightYellow().getRGB());
			}
			
		@Test
		void getBufferMaxLinesCount()
			{
				settings.setBufferMaxLinesCount(5001);
				assertEquals(5001, settings.getBufferMaxLinesCount());
			}
			
		@Test
		void getCaretBlinkingMS()
			{
				settings.setCaretBlinkingMS(2);
				assertEquals(2, settings.getCaretBlinkingMS());
			}
			
		@Test
		void getCharSetName()
			{
				settings.setCharSetName("FOO");
				assertEquals("FOO", settings.getCharSetName());
			}
			
		@Test
		void getColumns()
			{
				settings.setColumns(42);
				assertEquals(42, settings.getColumns());
			}
			
		@Test
		void getCommand()
			{
				String[] foo =
					{ "beep", "boop" };
				settings.setCommand(Arrays.asList(foo));
				assertEquals(2, settings.getCommand().size());
				assertEquals("beep", settings.getCommand().get(0));
				assertEquals("boop", settings.getCommand().get(1));
			}
			
		@Test
		void getCyan()
			{
				Color c = new Color(0);
				settings.setCyan(c);
				assertEquals(c.getRGB(), settings.getCyan().getRGB());
			}
			
		@Test
		void getDir()
			{
				assertEquals(System.getProperty("user.home"), settings.getDir());
				settings.setDir("FOO");
				assertEquals("FOO", settings.getDir());
			}
			
		@Test
		void getFgColor()
			{
				Color c = new Color(0);
				settings.setFgColor(c);
				assertEquals(c.getRGB(), settings.getFgColor().getRGB());
			}
			
		@Test
		void getFontFamily()
			{
				assertEquals(new DefaultSettingsProvider().getTerminalFont().getFamily(), settings.getFontFamily());
				settings.setFontFamily("BAR");
				assertEquals("BAR", settings.getFontFamily());
			}
			
		@Test
		void getFontSize()
			{
				assertEquals(new DefaultSettingsProvider().getTerminalFontSize(), settings.getFontSize());
				settings.setFontSize(0.0f);
				assertEquals(0.0f, settings.getFontSize());
			}
			
		@Test
		void getFoundPatternBackground()
			{
				Color c = new Color(0);
				settings.setFoundPatternBackGround(c);
				assertEquals(c.getRGB(), settings.getFoundPatternBackGround().getRGB());
			}
			
		@Test
		void getGreen()
			{
				Color c = new Color(0);
				settings.setGreen(c);
				assertEquals(c.getRGB(), settings.getGreen().getRGB());
			}
			
		@Test
		void getHyperlinkForeground()
			{
				Color c = new Color(0);
				settings.setHyperlinkForeground(c);
				assertEquals(c.getRGB(), settings.getHyperlinkForeground().getRGB());
			}
			
		@Test
		void getHyperlinkBackground()
			{
				Color c = new Color(0);
				settings.setHyperlinkBackground(c);
				assertEquals(c.getRGB(), settings.getHyperlinkBackground().getRGB());
			}
			
		@Test
		void getLineSpace()
			{
				assertEquals(0.0, settings.getLineSpace());
				settings.setLineSpace(3.3f);
				assertEquals(3.3f, settings.getLineSpace());
			}
			
		@Test
		void getLinkHighlightStyle()
			{
				assertEquals(HyperlinkStyle.HighlightMode.HOVER, settings.getLinkHighlightStyle());
				settings.setLinkHighlightStyle(HyperlinkStyle.HighlightMode.NEVER);
				assertEquals(HyperlinkStyle.HighlightMode.NEVER, settings.getLinkHighlightStyle());
			}
			
		@Test
		void setAndTestLog4jConf()
			{
				settings.setLog4jconf("foo");
				assertEquals("foo", settings.getLog4jconf());
			}
			
		@Test
		void lookAndFeel()
			{
				settings.setLookAndFeel("UGLY");
				assertEquals("UGLY", settings.getLookAndFeel());
			}
			
		@Test
		void getMagenta()
			{
				Color c = new Color(0);
				settings.setMagenta(c);
				assertEquals(c.getRGB(), settings.getMagenta().getRGB());
			}
			
		@Test
		void maxRefreshRate()
			{
				settings.setMaxRefreshRate(43);
				assertEquals(43, settings.getMaxRefreshRate());
			}
			
		@Test
		void Opacity()
			{
				assertEquals(1.0f, settings.getOpacity());
				settings.setOpacity(0.0f);
				assertEquals(0.0f, settings.getOpacity());
			}
			
		@Test
		void getPalette()
			{
				assertEquals(16, settings.getPalette().length);
				for (Color c : settings.getPalette())
					assertNotEquals(null, c);
			}
			
		@Test
		void PluginSettings()
			{
				Map<String, Serializable> s = new HashMap<>();
				s.put("foo", "bar");
				settings.setPluginSettings(s);
				assertEquals(s, settings.getPluginSettings());
			}
			
		@Test
		void getRed()
			{
				Color c = new Color(1);
				settings.setGreen(c);
				assertEquals(c.getRGB(), settings.getGreen().getRGB());
			}
			
		@Test
		void getRows()
			{
				int r = 32;
				settings.setRows(r);
				assertEquals(r, settings.getRows());
			}
			
		@Test
		void getSelectionBackground()
			{
				Color c = new Color(1);
				settings.setSelectionBackground(c);
				assertEquals(c.getRGB(), settings.getSelectionBackground().getRGB());
			}
			
		@Test
		void getSelectionForeground()
			{
				Color c = new Color(1);
				settings.setSelectionForeground(c);
				assertEquals(c.getRGB(), settings.getSelectionForeground().getRGB());
			}
			
		@Test
		void TermType()
			{
				String termType = "b";
				settings.setTermType(termType);
				assertEquals(termType, settings.getTermType());
			}
			
		@Test
		void getWhite()
			{
				Color c = new Color(22);
				settings.setWhite(c);
				assertEquals(c.getRGB(), settings.getWhite().getRGB());
			}
			
		@Test
		void getYellow()
			{
				assertEquals(false, settings.isAltSendsEscape());
				settings.setAltSendsEscape(true);
				assertEquals(true, settings.isAltSendsEscape());
			}
			
		@Test
		void DoubleWidthAmbiguousChars()
			{
				assertEquals(false, settings.isAmbiguousCharsDoubleWidth());
				settings.setAmbiguousCharsDoubleWidth(true);
				assertEquals(true, settings.isAmbiguousCharsDoubleWidth());
			}
			
		@Test
		void AudibleBell()
			{
				assertEquals(true, settings.isAudibleBell());
				settings.setAudibleBell(false);
				assertEquals(false, settings.isAudibleBell());
			}
			
		@Test
		void Console()
			{
				assertEquals(false, settings.isConsole());
				settings.setConsole(true);
				assertEquals(true, settings.isConsole());
			}
			
		@Test
		void CopyOnSelect()
			{
				assertEquals(false, settings.isCopyOnSelect());
				settings.setCopyOnSelect(true);
				assertEquals(true, settings.isCopyOnSelect());
			}
			
		@Test
		void Cygwin()
			{
				assertEquals(false, settings.isCygwin());
				settings.setCygwin(true);
				assertEquals(true, settings.isCygwin());
			}
			
		@Test
		void Dec()
			{
				assertEquals(true, settings.isDecmode());
				settings.setDecmode(false);
				assertEquals(false, settings.isDecmode());
			}
			
		@Test
		void X11()
			{
				assertEquals(false, settings.isEmulateX11CopyPaste());
				settings.setEmulateX11CopyPaste(true);
				assertEquals(true, settings.isEmulateX11CopyPaste());
			}
			
		@Test
		void MouseReporting()
			{
				assertEquals(true, settings.isEnableMouseReporting());
				settings.setEmulateX11CopyPaste(false);
				assertEquals(true, settings.isEnableMouseReporting());
			}
			
		@Test
		void ForeActionOnMouseReporting()
			{
				assertEquals(false, settings.isForceActionOnMouseReporting());
				settings.setForceActionOnMouseReporting(true);
				assertEquals(true, settings.isEnableMouseReporting());
			}
			
		@Test
		void MiddleClickPaste()
			{
				assertEquals(false, settings.isPasteOnMiddleMouseClick());
				settings.setPasteOnMiddleMouseClick(true);
				assertEquals(true, settings.isPasteOnMiddleMouseClick());
			}
			
		@Test
		void ScrollToBottom()
			{
				assertEquals(true, settings.isScrollToBottomOnTyping());
				settings.setScrollToBottomOnTyping(false);
				assertEquals(false, settings.isScrollToBottomOnTyping());
			}
			
		@Test
		void AntiAliasing()
			{
				assertEquals(true, settings.isUseAntiAliasing());
				settings.setUseAntiAliasing(false);
				assertEquals(false, settings.isUseAntiAliasing());
			}
			
		@Test
		void SelectionColorInvert()
			{
				assertEquals(true, settings.isUseInverseSelectionColor());
				settings.setUseInverseSelectionColor(false);
				assertEquals(false, settings.isUseInverseSelectionColor());
			}
	}
