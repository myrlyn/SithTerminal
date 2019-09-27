package test.java;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sithterm.SettingsPopup;
import sithterm.SithTermMainWindow;
import sithterm.SithTermSettings;

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
				assertEquals(j, pop.getFontColorsTabbedPane());
			}
			
		@Test
		void testSetTextSelectionPanel()
			{
				JPanel j = new JPanel();
				pop.setTextSelectionPanel(j);
				assertEquals(j, pop.getTextSelectionPanel());
			}
			
		@Test
		void testSetSelectionColors()
			{
				JTabbedPane j = new JTabbedPane();
				pop.setSelectionColors(j);
				assertEquals(j, pop.getSelectionColors());
			}
			
		@Test
		void testSetSelectionFGColorChooser()
			{
				JColorChooser j = new JColorChooser();
				pop.setSelectionFGColorChooser(j);
				assertEquals(j, pop.getSelectionFGColorChooser());
			}
			
		@Test
		void testSetSelectionBGColorChooser()
			{
				JColorChooser j = new JColorChooser();
				pop.setSelectionBGColorChooser(j);
				assertEquals(j, pop.getSelectionBGColorChooser());
			}
			
		@Test
		void testSetPatternFoundPanel()
			{
				JPanel j = new JPanel();
				pop.setPatternFoundPanel(j);
				assertEquals(j, pop.getPatternFoundPanel());
			}
			
		@Test
		void testSetPatternFoundTabbedPane()
			{
				JTabbedPane j = new JTabbedPane();
				pop.setPatternFoundTabbedPane(j);
				assertEquals(j, pop.getPatternFoundTabbedPane());
			}
			
		@Test
		void testGetFoundPatternForegroundColorChooser()
			{
				JColorChooser j = new JColorChooser();
				pop.setFoundPatternForegroundColorChooser(j);
				assertEquals(j, pop.getFoundPatternForegroundColorChooser());
			}
			
		@Test
		void testGetFoundPatternBackgroundColorChooser()
			{
				JColorChooser j = new JColorChooser();
				pop.setFoundPatternBackgroundColorChooser(j);
				assertEquals(j, pop.getFoundPatternBackgroundColorChooser());
			}
			
		@Test
		void testGetLinkPanel()
			{
				JPanel j = new JPanel();
				pop.setLinkPanel(j);
				assertEquals(j, pop.getLinkPanel());
			}
			
		@Test
		void testGetHyperlinkTabbedPane()
			{
				JTabbedPane j = new JTabbedPane();
				pop.setHyperlinkTabbedPane(j);
				assertEquals(j, pop.getHyperlinkTabbedPane());
			}
			
		@Test
		void testGetHyperlinkForegroundColorChooser()
			{
				JColorChooser j = new JColorChooser();
				pop.setHyperlinkForegroundColorChooser(j);
				assertEquals(j, pop.getHyperlinkForegroundColorChooser());
			}
			
		@Test
		void testGetHyperlinkBackgroundColorChooser()
			{
				JColorChooser j = new JColorChooser();
				pop.setHyperlinkBackgroundColorChooser(j);
				assertEquals(j, pop.getHyperlinkBackgroundColorChooser());
			}
			
		@Test
		void testGetDefaultStylePanel()
			{
				JPanel j = new JPanel();
				pop.setDefaultStylePanel(j);
				assertEquals(j, pop.getDefaultStylePanel());
			}
			
		@Test
		void testGetDefstyleTabbedPane()
			{
				JTabbedPane j = new JTabbedPane();
				pop.setDefstyleTabbedPane(j);
				assertEquals(j, pop.getDefstyleTabbedPane());
			}
			
		@Test
		void testGetForegroundColorPanel()
			{
				JPanel j = new JPanel();
				pop.setForegroundColorPanel(j);
				assertEquals(j, pop.getForegroundColorPanel());
			}
			
		@Test
		void testGetForegroundColorChooser()
			{
				JColorChooser j = new JColorChooser();
				pop.setForegroundColorChooser(j);
				assertEquals(j, pop.getForegroundColorChooser());
			}
			
		@Test
		void testGetBackgroundColorsPanel()
			{
				JPanel j = new JPanel();
				pop.setBackgroundColorsPanel(j);
				assertEquals(j, pop.getBackgroundColorsPanel());
			}
			
		@Test
		void testGetBackgroundColorChooser()
			{
				JColorChooser j = new JColorChooser();
				pop.setBackgroundColorChooser(j);
				assertEquals(j, pop.getBackgroundColorChooser());
			}
			
		@Test
		void testGetMiscPanel()
			{
				JPanel j = new JPanel();
				pop.setMiscPanel(j);
				assertEquals(j, pop.getMiscPanel());
			}
			
		@Test
		void testGetInverseSelectionColorsCheckbox()
			{
				JCheckBox j = new JCheckBox();
				pop.setInverseSelectionColorsCheckbox(j);
				assertEquals(j, pop.getInverseSelectionColorsCheckbox());
			}
			
		@Test
		void testGetChckbxCopyOnSelect()
			{
				JCheckBox j = new JCheckBox();
				pop.setChckbxCopyOnSelect(j);
				assertEquals(j, pop.getChckbxCopyOnSelect());
			}
			
		@Test
		void testGetChckbxConsole()
			{
				JCheckBox j = new JCheckBox();
				pop.setChckbxConsole(j);
				assertEquals(j, pop.getChckbxConsole());
			}
			
		@Test
		void testGetChckbxCygwin()
			{
				JCheckBox j = new JCheckBox();
				pop.setChckbxCygwin(j);
				assertEquals(j, pop.getChckbxCygwin());
			}
			
		@Test
		void testGetChckbxPasteOnMiddle()
			{
				JCheckBox j = new JCheckBox();
				pop.setChckbxPasteOnMiddle(j);
				assertEquals(j, pop.getChckbxPasteOnMiddle());
			}
			
		@Test
		void testGetChckbxEmulatexCopypaste()
			{
				JCheckBox j = new JCheckBox();
				pop.setChckbxEmulatexCopypaste(j);
				assertEquals(j, pop.getChckbxEmulatexCopypaste());
			}
			
		@Test
		void testGetChckbxUseAntialiasing()
			{
				JCheckBox j = new JCheckBox();
				pop.setChckbxUseAntialiasing(j);
				assertEquals(j, pop.getChckbxUseAntialiasing());
			}
			
		@Test
		void testGetLblMaxRefreshRate()
			{
				JLabel j = new JLabel();
				pop.setLblMaxRefreshRate(j);
				assertEquals(j, pop.getLblMaxRefreshRate());
			}
			
		@Test
		void testGetMaxRefreshSpinner()
			{
				JSpinner j = new JSpinner();
				pop.setMaxRefreshSpinner(j);
				assertEquals(j, pop.getMaxRefreshSpinner());
			}
			
		@Test
		void testGetChckbxAudiBell()
			{
				JCheckBox j = new JCheckBox();
				pop.setChckbxAudiBell(j);
				assertEquals(j, pop.getChckbxAudiBell());
			}
			
		@Test
		void testGetChckbxMouseReporting()
			{
				JCheckBox j = new JCheckBox();
				pop.setChckbxMouseReporting(j);
				assertEquals(j, pop.getChckbxMouseReporting());
			}
			
		@Test
		void testGetLblCaretBlinkMs()
			{
				JLabel j = new JLabel();
				pop.setLblCaretBlinkMs(j);
				assertEquals(j, pop.getLblCaretBlinkMs());
			}
			
		@Test
		void testGetSpinnerCaretBlink()
			{
				JSpinner j = new JSpinner();
				pop.setSpinnerCaretBlink(j);
				assertEquals(j, pop.getSpinnerCaretBlink());
			}
			
		@Test
		void testGetChckbxScrollToBottom()
			{
				JCheckBox j = new JCheckBox();
				pop.setChckbxScrollToBottom(j);
				assertEquals(j, pop.getChckbxScrollToBottom());
			}
			
		@Test
		void testGetChckbxDecCompatibilityMode()
			{
				JCheckBox j = new JCheckBox();
				pop.setChckbxDecCompatibilityMode(j);
				assertEquals(j, pop.getChckbxDecCompatibilityMode());
			}
			
		@Test
		void testGetChckbxForceActionOn()
			{
				JCheckBox j = new JCheckBox();
				pop.setChckbxForceActionOn(j);
				assertEquals(j, pop.getChckbxForceActionOn());
			}
			
		@Test
		void testGetLblBufferMaxLines()
			{
				JLabel j = new JLabel();
				pop.setLblBufferMaxLines(j);
				assertEquals(j, pop.getLblBufferMaxLines());
			}
			
		@Test
		void testGetMaxBufferLinesSpinner()
			{
				JSpinner j = new JSpinner();
				pop.setMaxBufferLinesSpinner(j);
				assertEquals(j, pop.getMaxBufferLinesSpinner());
			}
			
		@Test
		void testGetChckbxAltSendsEscape()
			{
				JCheckBox j = new JCheckBox();
				pop.setChckbxAltSendsEscape(j);
				assertEquals(j, pop.getChckbxAltSendsEscape());
			}
			
		@Test
		void testGetChckbxAmbiguousCharsAre()
			{
				JCheckBox j = new JCheckBox();
				pop.setChckbxAmbiguousCharsAre(j);
				assertEquals(j, pop.getChckbxAmbiguousCharsAre());
			}
			
		@Test
		void testGetTxtLogjconffield()
			{
				JTextField j = new JTextField();
				pop.setTxtLogjconffield(j);
				assertEquals(j, pop.getTxtLogjconffield());
			}
			
		@Test
		void testGetTabbedPane()
			{
				JTabbedPane j = new JTabbedPane();
				pop.setTabbedPane(j);
				assertEquals(j, pop.getTabbedPane());
			}
			
		@Test
		void testGetCommandField()
			{
				JTextField j = new JTextField();
				pop.setCommandField(j);
				assertEquals(j, pop.getCommandField());
			}
			
		@Test
		void testGetDirField()
			{
				JTextField j = new JTextField();
				pop.setDirField(j);
				assertEquals(j, pop.getDirField());
			}
			
		@Test
		void testGetTermField()
			{
				JTextField j = new JTextField();
				pop.setTermField(j);
				assertEquals(j, pop.getTermField());
			}
			
		@Test
		void testSetSettings()
			{
				SithTermSettings s = new SithTermSettings();
				pop.setSettings(s);
				assertEquals(s, pop.getSettings());
			}
			
		@Test
		void testGetWindow()
			{
				SithTermMainWindow j = new SithTermMainWindow();
				pop.setWindow(j);
				assertEquals(j, pop.getWindow());
			}
	}
