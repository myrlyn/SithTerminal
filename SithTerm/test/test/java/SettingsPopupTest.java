package test.java;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sithterm.SettingsPopup;
import sithterm.SithTermMainWindow;

class SettingsPopupTest
	{
		SithTermMainWindow win = null;
		SettingsPopup pop = null;
		
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
				pop = win.getSpop();
			}
			
		@AfterEach
		void tearDown()
		    throws Exception
			{
				win.getFrame().setVisible(false);
				win.getFrame().dispose();
				pop.setVisible(false);
				pop.dispose();
			}
			
		@Test
		void testGetSettingsPanel()
			{
				JPanel j = pop.getSettingsPanel();
				assertEquals(true, j instanceof JPanel);
			}
			
		@Test
		void testSetSettingsPanel()
			{
				JPanel j = new JPanel();
				pop.setSettingsPanel(j);
				assertEquals(j, pop.getSettingsPanel());
			}
			
		@Test
		void testSetLblCommand()
			{
				JLabel j = new JLabel("foo");
				pop.setLblCommand(j);
				assertEquals(j, pop.getLblCommand());
			}
			
		@Test
		void testGetLblCharacterSet()
			{
				JLabel j = new JLabel("foo");
				pop.setLblCharacterSet(j);
				assertEquals(j, pop.getLblCharacterSet());
			}
			
		@Test
		void testSetCharSetComboBox()
			{
				JComboBox<String> j = new JComboBox<>();
				pop.setCharSetComboBox(j);
				assertEquals(j, pop.getCharSetComboBox());
			}
			
		@Test
		void testGetLblTermType()
			{
				JLabel j = new JLabel("foo");
				pop.setLblTermType(j);
				assertEquals(j, pop.getLblTermType());
			}
			
		@Test
		void testGetLblDirectory()
			{
				JLabel j = new JLabel("foo");
				pop.setLblDirectory(j);
				assertEquals(j, pop.getLblDirectory());
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetLblOpacity()
			{
				JLabel j = new JLabel("foo");
				pop.setLblOpacity(j);
				assertEquals(j, pop.getLblOpacity());
			}
			
		@Test
		void testGetOpacitySlider()
			{
				JSlider j = new JSlider();
				pop.setOpacitySlider(j);
				assertEquals(j, pop.getOpacitySlider());
			}
			
		@Test
		void testGetLblLineSpacing()
			{
				JLabel j = new JLabel("foo");
				pop.setLblLineSpacing(j);
				assertEquals(j, pop.getLblLineSpacing());
			}
			
		@Test
		void testGetLineSpaceSpinner()
			{
				JSpinner j = new JSpinner();
				pop.setLineSpaceSpinner(j);
				assertEquals(j, pop.getLineSpaceSpinner());
			}
			
		@Test
		void testGetLblLogjConfFile()
			{
				JLabel j = new JLabel("foo");
				pop.setLblLogjConfFile(j);
				assertEquals(j, pop.getLblLogjConfFile());
			}
			
		@Test
		void testGetLblFontSize()
			{
				JLabel j = new JLabel("foo");
				pop.setLblFontSize(j);
				assertEquals(j, pop.getLblFontSize());
			}
			
		@Test
		void testGetBtnApplySettings()
			{
				JButton j = new JButton("foo");
				pop.setBtnApplySettings(j);
				assertEquals(j, pop.getBtnApplySettings());
			}
			
		@Test
		void testGetFontPanel()
			{
				JPanel j = new JPanel();
				pop.setFontPanel(j);
				assertEquals(j, pop.getFontPanel());
			}
			
		@Test
		void testGetLblFont()
			{
				JLabel j = new JLabel("foo");
				pop.setLblFont(j);
				assertEquals(j, pop.getLblFont());
			}
			
		@Test
		void testGetFontComboBox()
			{
				JComboBox<String> j = new JComboBox<>();
				pop.setFontComboBox(j);
				assertEquals(j, pop.getFontComboBox());
			}
			
		@Test
		void testGetFontSizeSpinner()
			{
				JSpinner j = new JSpinner();
				pop.setFontSizeSpinner(j);
				assertEquals(j, pop.getFontSizeSpinner());
			}
			
		@Test
		void testGetLblLinkHighlightStyle()
			{
				JLabel j = new JLabel();
				pop.setLblLinkHighlightStyle(j);
				assertEquals(j, pop.getLblLinkHighlightStyle());
			}
			
		@Test
		void testGetLinkHighlightModeComboBox()
			{
				JComboBox<String> j = new JComboBox<>();
				pop.setLinkHighlightModeComboBox(j);
				assertEquals(j, pop.getLinkHighlightModeComboBox());
			}
			
		@Test
		void testGetPalettePane()
			{
				JTabbedPane j = new JTabbedPane();
				pop.setPalettePane(j);
				assertEquals(j, pop.getPalettePane());
			}
			
		@Test
		void testSetBlackColorChooser()
			{
				JColorChooser j = new JColorChooser();
				pop.setBlackColorChooser(j);
				assertEquals(j, pop.getBlackColorChooser());
			}
			
		@Test
		void testSetRedColorChooser()
			{
				JColorChooser j = new JColorChooser();
				pop.setRedColorChooser(j);
				assertEquals(j, pop.getRedColorChooser());
			}
			
		@Test
		void testGetGreenColorChooser()
			{
				JColorChooser j = new JColorChooser();
				pop.setGreenColorChooser(j);
				assertEquals(j, pop.getGreenColorChooser());
			}
			
		@Test
		void testSetYellowColorChooser()
			{
				JColorChooser j = new JColorChooser();
				pop.setYellowColorChooser(j);
				assertEquals(j, pop.getYellowColorChooser());
			}
			
		@Test
		void testSetMagentaColorChooser()
			{
				JColorChooser j = new JColorChooser();
				pop.setMagentaColorChooser(j);
				assertEquals(j, pop.getMagentaColorChooser());
			}
			
		@Test
		void testSetBlueColorChooser()
			{
				JColorChooser j = new JColorChooser();
				pop.setBlueColorChooser(j);
				assertEquals(j, pop.getBlueColorChooser());
			}
			
		@Test
		void testSetBrightYellowColorChooser()
			{
				JColorChooser j = new JColorChooser();
				pop.setBrightYellowColorChooser(j);
				assertEquals(j, pop.getBrightYellowColorChooser());
			}
			
		@Test
		void testSetBrightMagentaColorChooser()
			{
				JColorChooser j = new JColorChooser();
				pop.setBrightMagentaColorChooser(j);
				assertEquals(j, pop.getBrightMagentaColorChooser());
			}
			
		@Test
		void testSetCyanColorChooser()
			{
				JColorChooser j = new JColorChooser();
				pop.setCyanColorChooser(j);
				assertEquals(j, pop.getCyanColorChooser());
			}
			
		@Test
		void testSetWhiteColorChooser()
			{
				JColorChooser j = new JColorChooser();
				pop.setWhiteColorChooser(j);
				assertEquals(j, pop.getWhiteColorChooser());
			}
			
		@Test
		void testSetBrightRedColorChooser()
			{
				JColorChooser j = new JColorChooser();
				pop.setBrightRedColorChooser(j);
				assertEquals(j, pop.getBrightRedColorChooser());
			}
			
		@Test
		void testSetBrightGreenColorChooser()
			{
				JColorChooser j = new JColorChooser();
				pop.setBrightGreenColorChooser(j);
				assertEquals(j, pop.getBrightGreenColorChooser());
			}
			
		@Test
		void testSetBrightBlueColorChooser()
			{
				JColorChooser j = new JColorChooser();
				pop.setBrightBlueColorChooser(j);
				assertEquals(j, pop.getBrightBlueColorChooser());
			}
			
		@Test
		void testSetBrightCyanColorChooser()
			{
				JColorChooser j = new JColorChooser();
				pop.setBrightCyanColorChooser(j);
				assertEquals(j, pop.getBrightCyanColorChooser());
			}
			
		@Test
		void testSetBrightWhiteColorChooser()
			{
				JColorChooser j = new JColorChooser();
				pop.setBrightWhiteColorChooser(j);
				assertEquals(j, pop.getBrightWhiteColorChooser());
			}
			
		@Test
		void testSetFontColorsPanel()
			{
				JPanel j = new JPanel();
				pop.setFontColorsPanel(j);
				assertEquals(j, pop.getFontColorsPanel());
			}
			
		@Test
		void testGetBrightBlackColorChooser()
			{
				JColorChooser j = new JColorChooser();
				pop.setBrightBlackColorChooser(j);
				assertEquals(j, pop.getBrightBlackColorChooser());
			}
				
		@Test
		void testSetFontColorsTabbedPane()
			{
				JTabbedPane j = new JTabbedPane();
				pop.setFontColorsTabbedPane(j);
				assertEquals(j,pop.getFontColorsTabbedPane());
			}
			
		@Test
		void testSetTextSelectionPanel()
			{
				JPanel j = new JPanel();
				pop.setTextSelectionPanel(j);
				assertEquals(j,pop.getTextSelectionPanel());
			}
			
		@Test
		void testSetSelectionColors()
			{
				JTabbedPane j = new JTabbedPane();
				pop.setSelectionColors(j);
				assertEquals(j,pop.getSelectionColors());
			}
			
		@Test
		void testGetSelectionFGColorChooser()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetSelectionFGColorChooser()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetSelectionBGColorChooser()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetSelectionBGColorChooser()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetPatternFoundPanel()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetPatternFoundPanel()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetPatternFoundTabbedPane()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetPatternFoundTabbedPane()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetFoundPatternForegroundColorChooser()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetFoundPatternForegroundColorChooser()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetFoundPatternBackgroundColorChooser()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetFoundPatternBackgroundColorChooser()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetLinkPanel()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetLinkPanel()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetHyperlinkTabbedPane()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetHyperlinkTabbedPane()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetHyperlinkForegroundColorChooser()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetHyperlinkForegroundColorChooser()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetHyperlinkBackgroundColorChooser()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetHyperlinkBackgroundColorChooser()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetDefaultStylePanel()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetDefaultStylePanel()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetDefstyleTabbedPane()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetDefstyleTabbedPane()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetForegroundColorPanel()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetForegroundColorPanel()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetForegroundColorChooser()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetForegroundColorChooser()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetBackgroundColorsPanel()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetBackgroundColorsPanel()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetBackgroundColorChooser()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetBackgroundColorChooser()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetMiscPanel()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetMiscPanel()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetInverseSelectionColorsCheckbox()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetInverseSelectionColorsCheckbox()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetChckbxCopyOnSelect()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetChckbxCopyOnSelect()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetChckbxConsole()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetChckbxConsole()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetChckbxCygwin()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetChckbxCygwin()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetChckbxPasteOnMiddle()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetChckbxPasteOnMiddle()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetChckbxEmulatexCopypaste()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetChckbxEmulatexCopypaste()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetChckbxUseAntialiasing()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetChckbxUseAntialiasing()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetLblMaxRefreshRate()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetLblMaxRefreshRate()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetMaxRefreshSpinner()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetMaxRefreshSpinner()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetChckbxAudiBell()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetChckbxAudiBell()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetChckbxMouseReporting()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetChckbxMouseReporting()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetLblCaretBlinkMs()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetLblCaretBlinkMs()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetSpinnerCaretBlink()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetSpinnerCaretBlink()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetChckbxScrollToBottom()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetChckbxScrollToBottom()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetChckbxDecCompatibilityMode()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetChckbxDecCompatibilityMode()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetChckbxForceActionOn()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetChckbxForceActionOn()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetLblBufferMaxLines()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetLblBufferMaxLines()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetMaxBufferLinesSpinner()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetMaxBufferLinesSpinner()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetChckbxAltSendsEscape()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetChckbxAltSendsEscape()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetChckbxAmbiguousCharsAre()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetChckbxAmbiguousCharsAre()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetTxtLogjconffield()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetTxtLogjconffield()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetTabbedPane()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetTabbedPane()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetCommandField()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetCommandField()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetDirField()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetDirField()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetTermField()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetTermField()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetSettings()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetSettings()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetWindow()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSetWindow()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testGetSerialversionuid()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSettingsPopupSithTermMainWindow()
			{
				// fail("Not yet implemented");
			}
			
		@Test
		void testSettingsPopupStringSithTermMainWindow()
			{
				// fail("Not yet implemented");
			}
	}
