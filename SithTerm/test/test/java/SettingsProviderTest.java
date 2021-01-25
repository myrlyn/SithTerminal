package test.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jediterm.terminal.TextStyle;

import sithterm.SithSettingsProvider;
import sithterm.SithTermSettings;

class SettingsProviderTest
	{
		SithTermSettings settings = new SithTermSettings();
		SithSettingsProvider provider = null;
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
				provider = new SithSettingsProvider(settings);
			}
			
		@AfterEach
		void tearDown()
		    throws Exception
			{
			}
			
		@Test
		void testGetTerminalFontSize()
			{
				assertEquals(settings.getFontSize(), provider.getTerminalFontSize());
			}
			
		@Test
		void testGetLineSpace()
			{
				assertEquals(settings.getLineSpace(), provider.getLineSpace());
			}
			
		@Test
		void testUseInverseSelectionColor()
			{
				assertEquals(settings.isUseInverseSelectionColor(), provider.useInverseSelectionColor());
			}
			
		@Test
		void testCopyOnSelect()
			{
				assertEquals(settings.isCopyOnSelect(), provider.copyOnSelect());
			}
			
		@Test
		void testPasteOnMiddleMouseClick()
			{
				assertEquals(settings.isPasteOnMiddleMouseClick(), provider.pasteOnMiddleMouseClick());
			}
			
		@Test
		void testEmulateX11CopyPaste()
			{
				assertEquals(settings.isEmulateX11CopyPaste(), provider.emulateX11CopyPaste());
			}
			
		@Test
		void testUseAntialiasing()
			{
				assertEquals(settings.isUseAntiAliasing(), provider.useAntialiasing());
			}
			
		@Test
		void testMaxRefreshRate()
			{
				assertEquals(settings.getMaxRefreshRate(), provider.maxRefreshRate());
			}
			
		@Test
		void testAudibleBell()
			{
				assertEquals(settings.isAudibleBell(), provider.audibleBell());
			}
			
		@Test
		void testEnableMouseReporting()
			{
				assertEquals(settings.isEnableMouseReporting(), provider.enableMouseReporting());
			}
			
		@Test
		void testCaretBlinkingMs()
			{
				assertEquals(settings.getCaretBlinkingMS(), provider.caretBlinkingMs());
			}
			
		@Test
		void testScrollToBottomOnTyping()
			{
				assertEquals(settings.isScrollToBottomOnTyping(), provider.scrollToBottomOnTyping());
			}
			
		@Test
		void testDECCompatibilityMode()
			{
				assertEquals(settings.isDecmode(), provider.DECCompatibilityMode());
			}
			
		@Test
		void testForceActionOnMouseReporting()
			{
				assertEquals(settings.isForceActionOnMouseReporting(), provider.forceActionOnMouseReporting());
			}
			
		@Test
		void testGetBufferMaxLinesCount()
			{
				assertEquals(settings.getBufferMaxLinesCount(), provider.getBufferMaxLinesCount());
			}
			
		@Test
		void testAltSendsEscape()
			{
				assertEquals(settings.isAltSendsEscape(), provider.altSendsEscape());
			}
			
		@Test
		void testAmbiguousCharsAreDoubleWidth()
			{
				assertEquals(settings.isAmbiguousCharsDoubleWidth(), provider.ambiguousCharsAreDoubleWidth());
			}
			
		@Test
		void testGetTerminalColorPalette()
			{
				// assertEquals(settings.getPalette(),provider.getTerminalColorPalette().getIndexColors());
				for (int i = 0; i < settings.getPalette().length; i++)
					{
						assertEquals(settings.getPalette()[i], provider.getTerminalColorPalette().getIndexColors()[i]);
					}
			}
			
		@Test
		void testGetTerminalFont()
			{
				assertEquals(settings.getFontFamily(), provider.getTerminalFont().getFamily());
				assertEquals(settings.getFontSize(), provider.getTerminalFont().getSize());
			}
			
		@Test
		void testGetDefaultStyle()
			{
				TextStyle ts = provider.getDefaultStyle();
				if (ts == null)
					fail();
				else
					{
						int bg = ts.getBackground().toAwtColor().getRGB();
						int fg = ts.getForeground().toAwtColor().getRGB();
						int ebg = settings.getBgColor().getRGB();
						int efg = settings.getFgColor().getRGB();
						assertEquals(ebg, bg);
						assertEquals(efg, fg);
					}
			}
			
		@Test
		void testGetSelectionColor()
			{
				TextStyle sc = provider.getSelectionColor();
				if (sc == null)
					fail();
				else
					{
						int bg = provider.getSelectionColor().getBackground().toAwtColor().getRGB();
						int fg = provider.getSelectionColor().getForeground().toAwtColor().getRGB();
						int ebg = settings.getSelectionBackground().getRGB();
						int efg = settings.getSelectionForeground().getRGB();
						assertEquals(ebg, bg);
						assertEquals(efg, fg);
					}
			}
			
		@Test
		void testGetFoundPatternColor()
			{
				if (provider == null ) {
					fail();
					return;
				}
				TextStyle sc = provider.getSelectionColor();
				if (sc == null)
					fail();
				else
					{
						int bg = provider.getFoundPatternColor().getBackground().toAwtColor().getRGB();
						int fg = provider.getFoundPatternColor().getForeground().toAwtColor().getRGB();
						int ebg = settings.getFoundPatternBackGround().getRGB();
						int efg = settings.getFoundPatternForeGround().getRGB();
						assertEquals(ebg, bg);
						assertEquals(efg, fg);
					}
			}
			
		@Test
		void testGetHyperlinkColor()
			{
				TextStyle sc = provider.getSelectionColor();
				if (sc == null)
					fail();
				else
					{
						int bg = provider.getHyperlinkColor().getBackground().toAwtColor().getRGB();
						int fg = provider.getHyperlinkColor().getForeground().toAwtColor().getRGB();
						int ebg = settings.getHyperlinkBackground().getRGB();
						int efg = settings.getHyperlinkForeground().getRGB();
						System.out.println("Settings: " + settings.getHyperlinkBackground().getRGB());
						System.out.println("provider: " + provider.getHyperlinkColor().getBackground().toAwtColor().getRGB());
						assertEquals(ebg, bg);
						assertEquals(efg, fg);
					}
			}
			
		@Test
		void testGetHyperlinkHighlightingMode()
			{
				assertEquals(settings.getLinkHighlightStyle(), provider.getHyperlinkHighlightingMode());
			}
	}
