package sithterm;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.jediterm.terminal.HyperlinkStyle;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JColorChooser;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.GraphicsEnvironment;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import java.awt.Font;

public class SettingsPopup extends JDialog
	{
		private static final String HOVER = "HOVER";
		private static final String NEVER = "NEVER";
		private static final String ALWAYS = "ALWAYS";
		private static final String BACKGROUND = "Background";
		private static final String FOREGROUND = "Foreground";
		private static final int OPACITY_SLIDER_MAX = 100;
		/**
		* 
		*/
		private static final long serialVersionUID = 1L;
		private JTextField commandField;
		private JTextField dirField;
		private JTextField termField;
		private SithTermSettings settings = null;
		private SithTermMainWindow window = null;
		private JTextField txtLogjconffield;
		private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		private JPanel settingsPanel = new JPanel();
		private JLabel lblCommand = new JLabel("Command");
		private JLabel lblCharacterSet = new JLabel("Character Set");
		private JComboBox<String> charSetComboBox = new JComboBox<>();
		private JLabel lblTermType = new JLabel("Term Type");
		private JLabel lblDirectory = new JLabel("Directory");
		private JLabel lblOpacity = new JLabel("Opacity*");
		private JSlider opacitySlider = new JSlider();
		private JLabel lblLineSpacing = new JLabel("Line Spacing");
		private JSpinner lineSpaceSpinner = new JSpinner();
		private JLabel lblLogjConfFile = new JLabel("Log4J Conf File");
		private JLabel lblFontSize = new JLabel("Font Size");
		private JButton btnApplySettings = new JButton("Apply Settings");
		private JPanel fontPanel = new JPanel();
		private JLabel lblFont = new JLabel("Font");
		private JComboBox<String> fontComboBox = new JComboBox<>();
		private 		JSpinner fontSizeSpinner = new JSpinner();
		private JLabel lblLinkHighlightStyle = new JLabel("Link Highlight Style");
		private JComboBox<String> linkHighlightModeComboBox = new JComboBox<>();
		private JTabbedPane palettePane = new JTabbedPane(JTabbedPane.TOP);
		private JColorChooser blackColorChooser = new JColorChooser();
		private JColorChooser redColorChooser = new JColorChooser();
		private JColorChooser greenColorChooser = new JColorChooser();
		private JColorChooser yellowColorChooser = new JColorChooser();
		private JColorChooser magentaColorChooser = new JColorChooser();
		private JColorChooser blueColorChooser = new JColorChooser();
		private JColorChooser brightYellowColorChooser = new JColorChooser();
		private JColorChooser brightMagentaColorChooser = new JColorChooser();
		private JColorChooser cyanColorChooser = new JColorChooser();
		private JColorChooser whiteColorChooser = new JColorChooser();
		private JColorChooser brightRedColorChooser = new JColorChooser();
		private JColorChooser brightGreenColorChooser = new JColorChooser();
		private JColorChooser brightBlueColorChooser = new JColorChooser();
		private JColorChooser brightCyanColorChooser = new JColorChooser();
		private JColorChooser brightWhiteColorChooser = new JColorChooser();
		private JPanel fontColorsJPanel = new JPanel();
		private JColorChooser brightBlackColorChooser = new JColorChooser();
		private JTabbedPane fontColorsTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		private JPanel textSelectionPanel = new JPanel();
		private JTabbedPane selectionColors = new JTabbedPane(JTabbedPane.TOP);
		private JColorChooser selectionFGColorChooser = new JColorChooser();
		private JColorChooser selectionBGColorChooser = new JColorChooser();
		private JPanel patternFoundPanel = new JPanel();
		private JTabbedPane patternFoundTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		private JColorChooser foundPatternForegroundColorChooser = new JColorChooser();
		private JColorChooser foundPatternBackgroundColorChooser = new JColorChooser();
		private JPanel linkPanel = new JPanel();
		private JTabbedPane hyperlinkTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		private JColorChooser hyperlinkForegroundColorChooser = new JColorChooser();
		private JColorChooser hyperlinkBackgroundColorChooser = new JColorChooser();
		private JPanel defaultStylePanel = new JPanel();
		private JTabbedPane defstyleTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		private JPanel foregroundColorPanel = new JPanel();
		private JColorChooser foregroundColorChooser = new JColorChooser();
		private JPanel backgroundColorsPanel = new JPanel();
		private JColorChooser backgroundColorChooser = new JColorChooser();
		private JPanel miscPanel = new JPanel();
		private JCheckBox inverseSelectionColorsCheckbox = new JCheckBox("Use Inverse Selection Colors");
		private JCheckBox chckbxCopyOnSelect = new JCheckBox("Copy On Select");
		private JCheckBox chckbxConsole = new JCheckBox("Console");
		private JCheckBox chckbxCygwin = new JCheckBox("Cygwin");
		private JCheckBox chckbxPasteOnMiddle = new JCheckBox("Paste On Middle Mouse Click");
		private JCheckBox chckbxEmulatexCopypaste = new JCheckBox("EmulateX11 Copy/Paste");
		private JCheckBox chckbxUseAntialiasing = new JCheckBox("Use Antialiasing");
		private JLabel lblMaxRefreshRate = new JLabel("Max Refresh Rate");
		private JSpinner maxRefreshSpinner = new JSpinner();
		private JCheckBox chckbxAudiBell = new JCheckBox("Audible Bell");
		private JCheckBox chckbxMouseReporting = new JCheckBox("Enable Mouse Reporting");
		private JLabel lblCaretBlinkMs = new JLabel("Caret Blink MS");
		private JSpinner spinnerCaretBlink = new JSpinner();
		private JCheckBox chckbxScrollToBottom = new JCheckBox("Scroll To Bottom On Type");
		private JCheckBox chckbxDecCompatibilityMode = new JCheckBox("DEC Compatibility Mode");
		private JCheckBox chckbxForceActionOn = new JCheckBox("Force Action On Mouse Report");
		private JLabel lblBufferMaxLines = new JLabel("Buffer Max Lines");
		private JSpinner maxBufferLinesSpinner = new JSpinner();
		private JCheckBox chckbxAltSendsEscape = new JCheckBox("Alt Sends Escape");
		private JCheckBox chckbxAmbiguousCharsAre = new JCheckBox("Ambiguous Chars are Double Width");
		private final JLabel lblLookAndFeel = new JLabel("Look And Feel*");
		private final JComboBox<String> lafComboBox = new JComboBox<>();
		private final JLabel lblFineprint = new JLabel("* = may require application restart to display correctly, not all look and feel classes support transparency(try Metal, or WebLookAndFeel for that).");
		private final JLabel lblColumns = new JLabel("COLUMNS");
		private final JLabel lblLines = new JLabel("LINES");
		private final JSpinner columnsSpinner = new JSpinner();
		private final JSpinner linesSpinner = new JSpinner();


		
		public JPanel getSettingsPanel()
			{
				return settingsPanel;
			}

		public void setSettingsPanel(JPanel settingsPanel)
			{
				this.settingsPanel = settingsPanel;
			}

		public JLabel getLblCommand()
			{
				return lblCommand;
			}

		public void setLblCommand(JLabel lblCommand)
			{
				this.lblCommand = lblCommand;
			}

		public JLabel getLblCharacterSet()
			{
				return lblCharacterSet;
			}

		public void setLblCharacterSet(JLabel lblCharacterSet)
			{
				this.lblCharacterSet = lblCharacterSet;
			}

		public JComboBox<String> getCharSetComboBox()
			{
				return charSetComboBox;
			}

		public void setCharSetComboBox(JComboBox<String> charSetComboBox)
			{
				this.charSetComboBox = charSetComboBox;
			}

		public JLabel getLblTermType()
			{
				return lblTermType;
			}

		public void setLblTermType(JLabel lblTermType)
			{
				this.lblTermType = lblTermType;
			}

		public JLabel getLblDirectory()
			{
				return lblDirectory;
			}

		public void setLblDirectory(JLabel lblDirectory)
			{
				this.lblDirectory = lblDirectory;
			}

		public JLabel getLblOpacity()
			{
				return lblOpacity;
			}

		public void setLblOpacity(JLabel lblOpacity)
			{
				this.lblOpacity = lblOpacity;
			}

		public JSlider getOpacitySlider()
			{
				return opacitySlider;
			}

		public void setOpacitySlider(JSlider opacitySlider)
			{
				this.opacitySlider = opacitySlider;
			}

		public JLabel getLblLineSpacing()
			{
				return lblLineSpacing;
			}

		public void setLblLineSpacing(JLabel lblLineSpacing)
			{
				this.lblLineSpacing = lblLineSpacing;
			}

		public JSpinner getLineSpaceSpinner()
			{
				return lineSpaceSpinner;
			}

		public void setLineSpaceSpinner(JSpinner lineSpaceSpinner)
			{
				this.lineSpaceSpinner = lineSpaceSpinner;
			}

		public JLabel getLblLogjConfFile()
			{
				return lblLogjConfFile;
			}

		public void setLblLogjConfFile(JLabel lblLogjConfFile)
			{
				this.lblLogjConfFile = lblLogjConfFile;
			}

		public JLabel getLblFontSize()
			{
				return lblFontSize;
			}

		public void setLblFontSize(JLabel lblFontSize)
			{
				this.lblFontSize = lblFontSize;
			}

		public JButton getBtnApplySettings()
			{
				return btnApplySettings;
			}

		public void setBtnApplySettings(JButton btnApplySettings)
			{
				this.btnApplySettings = btnApplySettings;
			}

		public JPanel getFontPanel()
			{
				return fontPanel;
			}

		public void setFontPanel(JPanel fontPanel)
			{
				this.fontPanel = fontPanel;
			}

		public JLabel getLblFont()
			{
				return lblFont;
			}

		public void setLblFont(JLabel lblFont)
			{
				this.lblFont = lblFont;
			}

		public JComboBox<String> getFontComboBox()
			{
				return fontComboBox;
			}

		public void setFontComboBox(JComboBox<String> fontComboBox)
			{
				this.fontComboBox = fontComboBox;
			}

		public JSpinner getFontSizeSpinner()
			{
				return fontSizeSpinner;
			}

		public void setFontSizeSpinner(JSpinner fontSizeSpinner)
			{
				this.fontSizeSpinner = fontSizeSpinner;
			}

		public JLabel getLblLinkHighlightStyle()
			{
				return lblLinkHighlightStyle;
			}

		public void setLblLinkHighlightStyle(JLabel lblLinkHighlightStyle)
			{
				this.lblLinkHighlightStyle = lblLinkHighlightStyle;
			}

		public JComboBox<String> getLinkHighlightModeComboBox()
			{
				return linkHighlightModeComboBox;
			}

		public void setLinkHighlightModeComboBox(JComboBox<String> linkHighlightModeComboBox)
			{
				this.linkHighlightModeComboBox = linkHighlightModeComboBox;
			}

		public JTabbedPane getPalettePane()
			{
				return palettePane;
			}

		public void setPalettePane(JTabbedPane palettePane)
			{
				this.palettePane = palettePane;
			}

		public JColorChooser getBlackColorChooser()
			{
				return blackColorChooser;
			}

		public void setBlackColorChooser(JColorChooser blackColorChooser)
			{
				this.blackColorChooser = blackColorChooser;
			}

		public JColorChooser getRedColorChooser()
			{
				return redColorChooser;
			}

		public void setRedColorChooser(JColorChooser redColorChooser)
			{
				this.redColorChooser = redColorChooser;
			}

		public JColorChooser getGreenColorChooser()
			{
				return greenColorChooser;
			}

		public void setGreenColorChooser(JColorChooser greenColorChooser)
			{
				this.greenColorChooser = greenColorChooser;
			}

		public JColorChooser getYellowColorChooser()
			{
				return yellowColorChooser;
			}

		public void setYellowColorChooser(JColorChooser yellowColorChooser)
			{
				this.yellowColorChooser = yellowColorChooser;
			}

		public JColorChooser getMagentaColorChooser()
			{
				return magentaColorChooser;
			}

		public void setMagentaColorChooser(JColorChooser magentaColorChooser)
			{
				this.magentaColorChooser = magentaColorChooser;
			}

		public JColorChooser getBlueColorChooser()
			{
				return blueColorChooser;
			}

		public void setBlueColorChooser(JColorChooser blueColorChooser)
			{
				this.blueColorChooser = blueColorChooser;
			}

		public JColorChooser getBrightYellowColorChooser()
			{
				return brightYellowColorChooser;
			}

		public void setBrightYellowColorChooser(JColorChooser brightYellowColorChooser)
			{
				this.brightYellowColorChooser = brightYellowColorChooser;
			}

		public JColorChooser getBrightMagentaColorChooser()
			{
				return brightMagentaColorChooser;
			}

		public void setBrightMagentaColorChooser(JColorChooser brightMagentaColorChooser)
			{
				this.brightMagentaColorChooser = brightMagentaColorChooser;
			}

		public JColorChooser getCyanColorChooser()
			{
				return cyanColorChooser;
			}

		public void setCyanColorChooser(JColorChooser cyanColorChooser)
			{
				this.cyanColorChooser = cyanColorChooser;
			}

		public JColorChooser getWhiteColorChooser()
			{
				return whiteColorChooser;
			}

		public void setWhiteColorChooser(JColorChooser whiteColorChooser)
			{
				this.whiteColorChooser = whiteColorChooser;
			}

		public JColorChooser getBrightRedColorChooser()
			{
				return brightRedColorChooser;
			}

		public void setBrightRedColorChooser(JColorChooser brightRedColorChooser)
			{
				this.brightRedColorChooser = brightRedColorChooser;
			}

		public JColorChooser getBrightGreenColorChooser()
			{
				return brightGreenColorChooser;
			}

		public void setBrightGreenColorChooser(JColorChooser brightGreenColorChooser)
			{
				this.brightGreenColorChooser = brightGreenColorChooser;
			}

		public JColorChooser getBrightBlueColorChooser()
			{
				return brightBlueColorChooser;
			}

		public void setBrightBlueColorChooser(JColorChooser brightBlueColorChooser)
			{
				this.brightBlueColorChooser = brightBlueColorChooser;
			}

		public JColorChooser getBrightCyanColorChooser()
			{
				return brightCyanColorChooser;
			}

		public void setBrightCyanColorChooser(JColorChooser brightCyanColorChooser)
			{
				this.brightCyanColorChooser = brightCyanColorChooser;
			}

		public JColorChooser getBrightWhiteColorChooser()
			{
				return brightWhiteColorChooser;
			}

		public void setBrightWhiteColorChooser(JColorChooser brightWhiteColorChooser)
			{
				this.brightWhiteColorChooser = brightWhiteColorChooser;
			}

		public JPanel getFontColorsPanel()
			{
				return fontColorsJPanel;
			}

		public void setFontColorsPanel(JPanel fontColorsPanel)
			{
				fontColorsJPanel = fontColorsPanel;
			}

		public JColorChooser getBrightBlackColorChooser()
			{
				return brightBlackColorChooser;
			}

		public void setBrightBlackColorChooser(JColorChooser brightBlackColorChooser)
			{
				this.brightBlackColorChooser = brightBlackColorChooser;
			}

		public JTabbedPane getFontColorsTabbedPane()
			{
				return fontColorsTabbedPane;
			}

		public void setFontColorsTabbedPane(JTabbedPane fontColorsTabbedPane)
			{
				this.fontColorsTabbedPane = fontColorsTabbedPane;
			}

		public JPanel getTextSelectionPanel()
			{
				return textSelectionPanel;
			}

		public void setTextSelectionPanel(JPanel textSelectionPanel)
			{
				this.textSelectionPanel = textSelectionPanel;
			}

		public JTabbedPane getSelectionColors()
			{
				return selectionColors;
			}

		public void setSelectionColors(JTabbedPane selectionColors)
			{
				this.selectionColors = selectionColors;
			}

		public JColorChooser getSelectionFGColorChooser()
			{
				return selectionFGColorChooser;
			}

		public void setSelectionFGColorChooser(JColorChooser selectionFGColorChooser)
			{
				this.selectionFGColorChooser = selectionFGColorChooser;
			}

		public JColorChooser getSelectionBGColorChooser()
			{
				return selectionBGColorChooser;
			}

		public void setSelectionBGColorChooser(JColorChooser selectionBGColorChooser)
			{
				this.selectionBGColorChooser = selectionBGColorChooser;
			}

		public JPanel getPatternFoundPanel()
			{
				return patternFoundPanel;
			}

		public void setPatternFoundPanel(JPanel patternFoundPanel)
			{
				this.patternFoundPanel = patternFoundPanel;
			}

		public JTabbedPane getPatternFoundTabbedPane()
			{
				return patternFoundTabbedPane;
			}

		public void setPatternFoundTabbedPane(JTabbedPane patternFoundTabbedPane)
			{
				this.patternFoundTabbedPane = patternFoundTabbedPane;
			}

		public JColorChooser getFoundPatternForegroundColorChooser()
			{
				return foundPatternForegroundColorChooser;
			}

		public void setFoundPatternForegroundColorChooser(JColorChooser foundPatternForegroundColorChooser)
			{
				this.foundPatternForegroundColorChooser = foundPatternForegroundColorChooser;
			}

		public JColorChooser getFoundPatternBackgroundColorChooser()
			{
				return foundPatternBackgroundColorChooser;
			}

		public void setFoundPatternBackgroundColorChooser(JColorChooser foundPatternBackgroundColorChooser)
			{
				this.foundPatternBackgroundColorChooser = foundPatternBackgroundColorChooser;
			}

		public JPanel getLinkPanel()
			{
				return linkPanel;
			}

		public void setLinkPanel(JPanel linkPanel)
			{
				this.linkPanel = linkPanel;
			}

		public JTabbedPane getHyperlinkTabbedPane()
			{
				return hyperlinkTabbedPane;
			}

		public void setHyperlinkTabbedPane(JTabbedPane hyperlinkTabbedPane)
			{
				this.hyperlinkTabbedPane = hyperlinkTabbedPane;
			}

		public JColorChooser getHyperlinkForegroundColorChooser()
			{
				return hyperlinkForegroundColorChooser;
			}

		public void setHyperlinkForegroundColorChooser(JColorChooser hyperlinkForegroundColorChooser)
			{
				this.hyperlinkForegroundColorChooser = hyperlinkForegroundColorChooser;
			}

		public JColorChooser getHyperlinkBackgroundColorChooser()
			{
				return hyperlinkBackgroundColorChooser;
			}

		public void setHyperlinkBackgroundColorChooser(JColorChooser hyperlinkBackgroundColorChooser)
			{
				this.hyperlinkBackgroundColorChooser = hyperlinkBackgroundColorChooser;
			}

		public JPanel getDefaultStylePanel()
			{
				return defaultStylePanel;
			}

		public void setDefaultStylePanel(JPanel defaultStylePanel)
			{
				this.defaultStylePanel = defaultStylePanel;
			}

		public JTabbedPane getDefstyleTabbedPane()
			{
				return defstyleTabbedPane;
			}

		public void setDefstyleTabbedPane(JTabbedPane defstyleTabbedPane)
			{
				this.defstyleTabbedPane = defstyleTabbedPane;
			}

		public JPanel getForegroundColorPanel()
			{
				return foregroundColorPanel;
			}

		public void setForegroundColorPanel(JPanel foregroundColorPanel)
			{
				this.foregroundColorPanel = foregroundColorPanel;
			}

		public JColorChooser getForegroundColorChooser()
			{
				return foregroundColorChooser;
			}

		public void setForegroundColorChooser(JColorChooser foregroundColorChooser)
			{
				this.foregroundColorChooser = foregroundColorChooser;
			}

		public JPanel getBackgroundColorsPanel()
			{
				return backgroundColorsPanel;
			}

		public void setBackgroundColorsPanel(JPanel backgroundColorsPanel)
			{
				this.backgroundColorsPanel = backgroundColorsPanel;
			}

		public JColorChooser getBackgroundColorChooser()
			{
				return backgroundColorChooser;
			}

		public void setBackgroundColorChooser(JColorChooser backgroundColorChooser)
			{
				this.backgroundColorChooser = backgroundColorChooser;
			}

		public JPanel getMiscPanel()
			{
				return miscPanel;
			}

		public void setMiscPanel(JPanel miscPanel)
			{
				this.miscPanel = miscPanel;
			}

		public JCheckBox getInverseSelectionColorsCheckbox()
			{
				return inverseSelectionColorsCheckbox;
			}

		public void setInverseSelectionColorsCheckbox(JCheckBox inverseSelectionColorsCheckbox)
			{
				this.inverseSelectionColorsCheckbox = inverseSelectionColorsCheckbox;
			}

		public JCheckBox getChckbxCopyOnSelect()
			{
				return chckbxCopyOnSelect;
			}

		public void setChckbxCopyOnSelect(JCheckBox chckbxCopyOnSelect)
			{
				this.chckbxCopyOnSelect = chckbxCopyOnSelect;
			}

		public JCheckBox getChckbxConsole()
			{
				return chckbxConsole;
			}

		public void setChckbxConsole(JCheckBox chckbxConsole)
			{
				this.chckbxConsole = chckbxConsole;
			}

		public JCheckBox getChckbxCygwin()
			{
				return chckbxCygwin;
			}

		public void setChckbxCygwin(JCheckBox chckbxCygwin)
			{
				this.chckbxCygwin = chckbxCygwin;
			}

		public JCheckBox getChckbxPasteOnMiddle()
			{
				return chckbxPasteOnMiddle;
			}

		public void setChckbxPasteOnMiddle(JCheckBox chckbxPasteOnMiddle)
			{
				this.chckbxPasteOnMiddle = chckbxPasteOnMiddle;
			}

		public JCheckBox getChckbxEmulatexCopypaste()
			{
				return chckbxEmulatexCopypaste;
			}

		public void setChckbxEmulatexCopypaste(JCheckBox chckbxEmulatexCopypaste)
			{
				this.chckbxEmulatexCopypaste = chckbxEmulatexCopypaste;
			}

		public JCheckBox getChckbxUseAntialiasing()
			{
				return chckbxUseAntialiasing;
			}

		public void setChckbxUseAntialiasing(JCheckBox chckbxUseAntialiasing)
			{
				this.chckbxUseAntialiasing = chckbxUseAntialiasing;
			}

		public JLabel getLblMaxRefreshRate()
			{
				return lblMaxRefreshRate;
			}

		public void setLblMaxRefreshRate(JLabel lblMaxRefreshRate)
			{
				this.lblMaxRefreshRate = lblMaxRefreshRate;
			}

		public JSpinner getMaxRefreshSpinner()
			{
				return maxRefreshSpinner;
			}

		public void setMaxRefreshSpinner(JSpinner maxRefreshSpinner)
			{
				this.maxRefreshSpinner = maxRefreshSpinner;
			}

		public JCheckBox getChckbxAudiBell()
			{
				return chckbxAudiBell;
			}

		public void setChckbxAudiBell(JCheckBox chckbxAudiBell)
			{
				this.chckbxAudiBell = chckbxAudiBell;
			}

		public JCheckBox getChckbxMouseReporting()
			{
				return chckbxMouseReporting;
			}

		public void setChckbxMouseReporting(JCheckBox chckbxMouseReporting)
			{
				this.chckbxMouseReporting = chckbxMouseReporting;
			}

		public JLabel getLblCaretBlinkMs()
			{
				return lblCaretBlinkMs;
			}

		public void setLblCaretBlinkMs(JLabel lblCaretBlinkMs)
			{
				this.lblCaretBlinkMs = lblCaretBlinkMs;
			}

		public JSpinner getSpinnerCaretBlink()
			{
				return spinnerCaretBlink;
			}

		public void setSpinnerCaretBlink(JSpinner spinnerCaretBlink)
			{
				this.spinnerCaretBlink = spinnerCaretBlink;
			}

		public JCheckBox getChckbxScrollToBottom()
			{
				return chckbxScrollToBottom;
			}

		public void setChckbxScrollToBottom(JCheckBox chckbxScrollToBottom)
			{
				this.chckbxScrollToBottom = chckbxScrollToBottom;
			}

		public JCheckBox getChckbxDecCompatibilityMode()
			{
				return chckbxDecCompatibilityMode;
			}

		public void setChckbxDecCompatibilityMode(JCheckBox chckbxDecCompatibilityMode)
			{
				this.chckbxDecCompatibilityMode = chckbxDecCompatibilityMode;
			}

		public JCheckBox getChckbxForceActionOn()
			{
				return chckbxForceActionOn;
			}

		public void setChckbxForceActionOn(JCheckBox chckbxForceActionOn)
			{
				this.chckbxForceActionOn = chckbxForceActionOn;
			}

		public JLabel getLblBufferMaxLines()
			{
				return lblBufferMaxLines;
			}

		public void setLblBufferMaxLines(JLabel lblBufferMaxLines)
			{
				this.lblBufferMaxLines = lblBufferMaxLines;
			}

		public JSpinner getMaxBufferLinesSpinner()
			{
				return maxBufferLinesSpinner;
			}

		public void setMaxBufferLinesSpinner(JSpinner maxBufferLinesSpinner)
			{
				this.maxBufferLinesSpinner = maxBufferLinesSpinner;
			}

		public JCheckBox getChckbxAltSendsEscape()
			{
				return chckbxAltSendsEscape;
			}

		public void setChckbxAltSendsEscape(JCheckBox chckbxAltSendsEscape)
			{
				this.chckbxAltSendsEscape = chckbxAltSendsEscape;
			}

		public JCheckBox getChckbxAmbiguousCharsAre()
			{
				return chckbxAmbiguousCharsAre;
			}

		public void setChckbxAmbiguousCharsAre(JCheckBox chckbxAmbiguousCharsAre)
			{
				this.chckbxAmbiguousCharsAre = chckbxAmbiguousCharsAre;
			}

		public JTextField getTxtLogjconffield()
			{
				return txtLogjconffield;
			}
			
		public void setTxtLogjconffield(JTextField txtLogjconffield)
			{
				this.txtLogjconffield = txtLogjconffield;
			}
			
		public JTabbedPane getTabbedPane()
			{
				return tabbedPane;
			}
			
		public void setTabbedPane(JTabbedPane tabbedPane)
			{
				this.tabbedPane = tabbedPane;
			}
			
		public JTextField getCommandField()
			{
				return commandField;
			}
			
		public void setCommandField(JTextField commandField)
			{
				this.commandField = commandField;
			}
			
		public JTextField getDirField()
			{
				return dirField;
			}
			
		public void setDirField(JTextField dirField)
			{
				this.dirField = dirField;
			}
			
		public JTextField getTermField()
			{
				return termField;
			}
			
		public void setTermField(JTextField termField)
			{
				this.termField = termField;
			}
			
		public SithTermSettings getSettings()
			{
				return settings;
			}
			
		public void setSettings(SithTermSettings settings)
			{
				this.settings = settings;
			}
			
		public SithTermMainWindow getWindow()
			{
				return window;
			}
			
		public void setWindow(SithTermMainWindow window)
			{
				this.window = window;
			}
			
		public static long getSerialversionuid()
			{
				return serialVersionUID;
			}
			
		public SettingsPopup(SithTermMainWindow win)
			{
				this.window = win;
				settings = win.getSettings();
				String commandString = getCommandString();
				Map<String, Charset> optList = Charset.availableCharsets();
				getContentPane().add(tabbedPane, BorderLayout.NORTH);
				tabbedPane.addTab("Terminal Settings", null, settingsPanel, null);
				GridBagLayout gbl_settingsPanel = new GridBagLayout();
				gbl_settingsPanel.columnWidths = new int[]
					{ 0, 0, 0 };
				gbl_settingsPanel.rowHeights = new int[]
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
				gbl_settingsPanel.columnWeights = new double[]
					{ 0.0, 1.0, Double.MIN_VALUE };
				gbl_settingsPanel.rowWeights = new double[]
					{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
				settingsPanel.setLayout(gbl_settingsPanel);
				lblCommand.setToolTipText("Command to start in each tab");
				GridBagConstraints gbc_lblCommand = new GridBagConstraints();
				gbc_lblCommand.anchor = GridBagConstraints.WEST;
				gbc_lblCommand.insets = new Insets(0, 0, 5, 5);
				gbc_lblCommand.gridx = 0;
				gbc_lblCommand.gridy = 0;
				settingsPanel.add(lblCommand, gbc_lblCommand);
				commandField = new JTextField();
				GridBagConstraints gbc_commandField = new GridBagConstraints();
				gbc_commandField.anchor = GridBagConstraints.WEST;
				gbc_commandField.insets = new Insets(0, 0, 5, 0);
				gbc_commandField.fill = GridBagConstraints.BOTH;
				gbc_commandField.gridx = 1;
				gbc_commandField.gridy = 0;
				settingsPanel.add(commandField, gbc_commandField);
				commandField.setColumns(10);
				commandField.setText(commandString);
				lblDirectory.setToolTipText("Directory to start in...");
				GridBagConstraints gbc_lblDirectory = new GridBagConstraints();
				gbc_lblDirectory.anchor = GridBagConstraints.WEST;
				gbc_lblDirectory.insets = new Insets(0, 0, 5, 5);
				gbc_lblDirectory.gridx = 0;
				gbc_lblDirectory.gridy = 1;
				settingsPanel.add(lblDirectory, gbc_lblDirectory);
				dirField = new JTextField();
				GridBagConstraints gbc_dirField = new GridBagConstraints();
				gbc_dirField.insets = new Insets(0, 0, 5, 0);
				gbc_dirField.fill = GridBagConstraints.HORIZONTAL;
				gbc_dirField.gridx = 1;
				gbc_dirField.gridy = 1;
				settingsPanel.add(dirField, gbc_dirField);
				dirField.setColumns(10);
				dirField.setText(settings.getDir());
				lblCharacterSet.setToolTipText("Character set for the terminals...");
				GridBagConstraints gbc_lblCharacterSet = new GridBagConstraints();
				gbc_lblCharacterSet.anchor = GridBagConstraints.WEST;
				gbc_lblCharacterSet.insets = new Insets(0, 0, 5, 5);
				gbc_lblCharacterSet.gridx = 0;
				gbc_lblCharacterSet.gridy = 2;
				settingsPanel.add(lblCharacterSet, gbc_lblCharacterSet);
				GridBagConstraints gbc_charSetComboBox = new GridBagConstraints();
				gbc_charSetComboBox.insets = new Insets(0, 0, 5, 0);
				gbc_charSetComboBox.fill = GridBagConstraints.HORIZONTAL;
				gbc_charSetComboBox.gridx = 1;
				gbc_charSetComboBox.gridy = 2;
				settingsPanel.add(charSetComboBox, gbc_charSetComboBox);
				for (String key : optList.keySet())
					{
						charSetComboBox.addItem(key);
					}
				charSetComboBox.setSelectedItem(settings.getCharSetName());
				lblTermType.setToolTipText("set the environment variable TERM");
				GridBagConstraints gbc_lblTermType = new GridBagConstraints();
				gbc_lblTermType.anchor = GridBagConstraints.WEST;
				gbc_lblTermType.insets = new Insets(0, 0, 5, 5);
				gbc_lblTermType.gridx = 0;
				gbc_lblTermType.gridy = 3;
				settingsPanel.add(lblTermType, gbc_lblTermType);
				termField = new JTextField();
				GridBagConstraints gbc_termField = new GridBagConstraints();
				gbc_termField.insets = new Insets(0, 0, 5, 0);
				gbc_termField.fill = GridBagConstraints.HORIZONTAL;
				gbc_termField.gridx = 1;
				gbc_termField.gridy = 3;
				settingsPanel.add(termField, gbc_termField);
				termField.setColumns(10);
				termField.setText(settings.getTermType());
				lblOpacity.setToolTipText("set the opacity of the main window");
				GridBagConstraints gbc_lblOpacity = new GridBagConstraints();
				gbc_lblOpacity.anchor = GridBagConstraints.WEST;
				gbc_lblOpacity.insets = new Insets(0, 0, 5, 5);
				gbc_lblOpacity.gridx = 0;
				gbc_lblOpacity.gridy = 4;
				settingsPanel.add(lblOpacity, gbc_lblOpacity);
				opacitySlider.setMinimum(0);
				opacitySlider.setMajorTickSpacing(5);
				opacitySlider.setMinorTickSpacing(5);
				opacitySlider.setMaximum(OPACITY_SLIDER_MAX);
				opacitySlider.setValue((int) (OPACITY_SLIDER_MAX * settings.getOpacity()));
				opacitySlider.addChangeListener(evt -> window.getFrame().setOpacity(getOpacityFromInt(opacitySlider.getValue())));
				GridBagConstraints gbc_opacitySlider = new GridBagConstraints();
				gbc_opacitySlider.fill = GridBagConstraints.HORIZONTAL;
				gbc_opacitySlider.insets = new Insets(0, 0, 5, 0);
				gbc_opacitySlider.gridx = 1;
				gbc_opacitySlider.gridy = 4;
				settingsPanel.add(opacitySlider, gbc_opacitySlider);
				lblLineSpacing.setToolTipText("spacing between new terminal lines");
				GridBagConstraints gbc_lblLineSpacing = new GridBagConstraints();
				gbc_lblLineSpacing.anchor = GridBagConstraints.WEST;
				gbc_lblLineSpacing.insets = new Insets(0, 0, 5, 5);
				gbc_lblLineSpacing.gridx = 0;
				gbc_lblLineSpacing.gridy = 5;
				settingsPanel.add(lblLineSpacing, gbc_lblLineSpacing);
				lineSpaceSpinner.setModel(new SpinnerNumberModel(settings.getLineSpace(), -0.1f, 64.0f, 0.1f));
				GridBagConstraints gbc_lineSpaceSpinner = new GridBagConstraints();
				gbc_lineSpaceSpinner.fill = GridBagConstraints.HORIZONTAL;
				gbc_lineSpaceSpinner.insets = new Insets(0, 0, 5, 0);
				gbc_lineSpaceSpinner.gridx = 1;
				gbc_lineSpaceSpinner.gridy = 5;
				settingsPanel.add(lineSpaceSpinner, gbc_lineSpaceSpinner);
				lblLogjConfFile.setToolTipText("requires restart");
				GridBagConstraints gbc_lblLogjConfFile = new GridBagConstraints();
				gbc_lblLogjConfFile.anchor = GridBagConstraints.WEST;
				gbc_lblLogjConfFile.insets = new Insets(0, 0, 5, 5);
				gbc_lblLogjConfFile.gridx = 0;
				gbc_lblLogjConfFile.gridy = 6;
				settingsPanel.add(lblLogjConfFile, gbc_lblLogjConfFile);
				txtLogjconffield = new JTextField();
				txtLogjconffield.setToolTipText("requires restart");
				GridBagConstraints gbc_txtLogjconffield = new GridBagConstraints();
				gbc_txtLogjconffield.insets = new Insets(0, 0, 5, 0);
				gbc_txtLogjconffield.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtLogjconffield.gridx = 1;
				gbc_txtLogjconffield.gridy = 6;
				settingsPanel.add(txtLogjconffield, gbc_txtLogjconffield);
				txtLogjconffield.setColumns(10);
				txtLogjconffield.setText(settings.getLog4jconf());
				
				GridBagConstraints gbc_lblColumns = new GridBagConstraints();
				gbc_lblColumns.anchor = GridBagConstraints.WEST;
				gbc_lblColumns.insets = new Insets(0, 0, 5, 5);
				gbc_lblColumns.gridx = 0;
				gbc_lblColumns.gridy = 7;
				lblColumns.setToolTipText("initial value for the COLUMNS environment variable");
				settingsPanel.add(lblColumns, gbc_lblColumns);
				
				GridBagConstraints gbc_initcolumnsSpinner = new GridBagConstraints();
				gbc_initcolumnsSpinner.fill = GridBagConstraints.HORIZONTAL;
				gbc_initcolumnsSpinner.insets = new Insets(0, 0, 5, 0);
				gbc_initcolumnsSpinner.gridx = 1;
				gbc_initcolumnsSpinner.gridy = 7;
				settingsPanel.add(columnsSpinner, gbc_initcolumnsSpinner);
				columnsSpinner.setValue(settings.getColumns());
				
				GridBagConstraints gbc_lblLines = new GridBagConstraints();
				gbc_lblLines.anchor = GridBagConstraints.WEST;
				gbc_lblLines.insets = new Insets(0, 0, 5, 5);
				gbc_lblLines.gridx = 0;
				gbc_lblLines.gridy = 8;
				lblLines.setToolTipText("Initial value for the LINES environment value");
				settingsPanel.add(lblLines, gbc_lblLines);
				
				GridBagConstraints gbc_linesSpinner = new GridBagConstraints();
				gbc_linesSpinner.fill = GridBagConstraints.HORIZONTAL;
				gbc_linesSpinner.insets = new Insets(0, 0, 5, 0);
				gbc_linesSpinner.gridx = 1;
				gbc_linesSpinner.gridy = 8;
				settingsPanel.add(linesSpinner, gbc_linesSpinner);
				linesSpinner.setValue(settings.getRows());
				GridBagConstraints gbc_btnApplySettings = new GridBagConstraints();
				gbc_btnApplySettings.anchor = GridBagConstraints.WEST;
				gbc_btnApplySettings.insets = new Insets(0, 0, 0, 5);
				gbc_btnApplySettings.gridx = 0;
				gbc_btnApplySettings.gridy = 9;
				settingsPanel.add(btnApplySettings, gbc_btnApplySettings);
				tabbedPane.addTab("Font", null, fontPanel, null);
				GridBagLayout gbl_fontPanel = new GridBagLayout();
				gbl_fontPanel.columnWidths = new int[]
					{ 0, 0, 0 };
				gbl_fontPanel.rowHeights = new int[]
					{ 0, 0, 0, 0 };
				gbl_fontPanel.columnWeights = new double[]
					{ 0.0, 1.0, Double.MIN_VALUE };
				gbl_fontPanel.rowWeights = new double[]
					{ 0.0, 0.0, 0.0, Double.MIN_VALUE };
				fontPanel.setLayout(gbl_fontPanel);
				lblFont.setToolTipText("name of the font family, not all will actually work");
				GridBagConstraints gbc_lblFont = new GridBagConstraints();
				gbc_lblFont.insets = new Insets(0, 0, 5, 5);
				gbc_lblFont.gridx = 0;
				gbc_lblFont.gridy = 0;
				fontPanel.add(lblFont, gbc_lblFont);
				GridBagConstraints gbc_fontComboBox = new GridBagConstraints();
				gbc_fontComboBox.insets = new Insets(0, 0, 5, 5);
				gbc_fontComboBox.anchor = GridBagConstraints.WEST;
				gbc_fontComboBox.fill = GridBagConstraints.BOTH;
				gbc_fontComboBox.gridx = 1;
				gbc_fontComboBox.gridy = 0;
				fontPanel.add(fontComboBox, gbc_fontComboBox);
				String[] fontList = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
				for (String font : fontList)
					{
						fontComboBox.addItem(font);
					}
				fontComboBox.setSelectedItem(settings.getFontFamily());
				lblFontSize.setToolTipText("font size for terminal text");
				GridBagConstraints gbc_lblFontSize = new GridBagConstraints();
				gbc_lblFontSize.insets = new Insets(0, 0, 5, 5);
				gbc_lblFontSize.gridx = 0;
				gbc_lblFontSize.gridy = 1;
				fontPanel.add(lblFontSize, gbc_lblFontSize);
				fontSizeSpinner.setModel(new SpinnerNumberModel(settings.getFontSize(), 3.0f, 64.0f, 0.5f));
				GridBagConstraints gbc_fontSizeSpinner = new GridBagConstraints();
				gbc_fontSizeSpinner.anchor = GridBagConstraints.WEST;
				gbc_fontSizeSpinner.insets = new Insets(0, 0, 5, 5);
				gbc_fontSizeSpinner.gridx = 1;
				gbc_fontSizeSpinner.gridy = 1;
				fontPanel.add(fontSizeSpinner, gbc_fontSizeSpinner);
				GridBagConstraints gbc_lblLinkHighlightStyle = new GridBagConstraints();
				gbc_lblLinkHighlightStyle.anchor = GridBagConstraints.EAST;
				gbc_lblLinkHighlightStyle.insets = new Insets(0, 0, 0, 5);
				gbc_lblLinkHighlightStyle.gridx = 0;
				gbc_lblLinkHighlightStyle.gridy = 2;
				fontPanel.add(lblLinkHighlightStyle, gbc_lblLinkHighlightStyle);
				GridBagConstraints gbc_linkHighlightModeComboBox = new GridBagConstraints();
				gbc_linkHighlightModeComboBox.anchor = GridBagConstraints.WEST;
				gbc_linkHighlightModeComboBox.insets = new Insets(0, 0, 0, 5);
				gbc_linkHighlightModeComboBox.gridx = 1;
				gbc_linkHighlightModeComboBox.gridy = 2;
				fontPanel.add(linkHighlightModeComboBox, gbc_linkHighlightModeComboBox);
				linkHighlightModeComboBox.addItem(ALWAYS);
				linkHighlightModeComboBox.addItem(NEVER);
				linkHighlightModeComboBox.addItem(HOVER);
				setCurrentLinkHiglightMode();
				tabbedPane.addTab("Indexed Palette", null, palettePane, "Color Palette for 16-color terminal");
				palettePane.addTab("Black", null, blackColorChooser, null);
				blackColorChooser.setColor(settings.getBlack());
				palettePane.addTab("Red", null, redColorChooser, null);
				redColorChooser.setColor(settings.getRed());
				palettePane.addTab("Green", null, greenColorChooser, null);
				greenColorChooser.setColor(settings.getGreen());
				palettePane.addTab("Yellow", null, yellowColorChooser, null);
				yellowColorChooser.setColor(settings.getYellow());
				palettePane.addTab("Blue", null, blueColorChooser, null);
				blueColorChooser.setColor(settings.getBlue());
				palettePane.addTab("Bright Yellow", null, brightYellowColorChooser, null);
				brightYellowColorChooser.setColor(settings.getBrightYellow());
				palettePane.addTab("Magenta", null, magentaColorChooser, null);
				magentaColorChooser.setColor(settings.getMagenta());
				palettePane.addTab("Bright Magenta", null, brightMagentaColorChooser, null);
				brightMagentaColorChooser.setColor(settings.getBrightMagenta());
				palettePane.addTab("Cyan", null, cyanColorChooser, null);
				cyanColorChooser.setColor(settings.getCyan());
				palettePane.addTab("White", null, whiteColorChooser, null);
				whiteColorChooser.setColor(settings.getWhite());
				palettePane.addTab("Bright Black", null, brightBlackColorChooser, null);
				brightBlackColorChooser.setColor(settings.getBrightBlack());
				palettePane.addTab("Bright Red", null, brightRedColorChooser, null);
				brightRedColorChooser.setColor(settings.getBrightRed());
				palettePane.addTab("Bright Green", null, brightGreenColorChooser, null);
				brightGreenColorChooser.setColor(settings.getBrightGreen());
				palettePane.addTab("Bright Blue", null, brightBlueColorChooser, null);
				brightBlueColorChooser.setColor(settings.getBrightBlack());
				palettePane.addTab("Bright Cyan", null, brightCyanColorChooser, null);
				brightCyanColorChooser.setColor(settings.getBrightCyan());
				palettePane.addTab("Bright White", null, brightWhiteColorChooser, null);
				brightWhiteColorChooser.setColor(settings.getBrightWhite());
				tabbedPane.addTab("Text Styles", null, fontColorsJPanel, null);
				fontColorsJPanel.add(fontColorsTabbedPane);
				fontColorsTabbedPane.addTab("Selection", null, textSelectionPanel, null);
				textSelectionPanel.add(selectionColors);
				selectionColors.addTab(FOREGROUND, null, selectionFGColorChooser, null);
				selectionFGColorChooser.setColor(settings.getSelectionForeground());
				selectionColors.addTab(BACKGROUND, null, selectionBGColorChooser, null);
				selectionBGColorChooser.setColor(settings.getSelectionBackground());
				fontColorsTabbedPane.addTab("Pattern Found", null, patternFoundPanel, null);
				patternFoundPanel.add(patternFoundTabbedPane);
				patternFoundTabbedPane.addTab(FOREGROUND, null, foundPatternForegroundColorChooser, null);
				foundPatternForegroundColorChooser.setColor(settings.getFoundPatternForeGround());
				patternFoundTabbedPane.addTab(BACKGROUND, null, foundPatternBackgroundColorChooser, null);
				foundPatternBackgroundColorChooser.setColor(settings.getFoundPatternBackGround());
				fontColorsTabbedPane.addTab("Links", null, linkPanel, null);
				linkPanel.add(hyperlinkTabbedPane);
				hyperlinkTabbedPane.addTab(FOREGROUND, null, hyperlinkForegroundColorChooser, null);
				hyperlinkForegroundColorChooser.setColor(settings.getHyperlinkForeground());
				hyperlinkTabbedPane.addTab(BACKGROUND, null, hyperlinkBackgroundColorChooser, null);
				hyperlinkBackgroundColorChooser.setColor(settings.getHyperlinkBackground());
				fontColorsTabbedPane.addTab("Default", null, defaultStylePanel, null);
				defaultStylePanel.add(defstyleTabbedPane);
				defstyleTabbedPane.addTab(FOREGROUND, null, foregroundColorPanel, null);
				foregroundColorChooser.setToolTipText("color for foreground of the terminal");
				foregroundColorPanel.add(foregroundColorChooser);
				foregroundColorChooser.setColor(settings.getFgColor());
				defstyleTabbedPane.addTab(BACKGROUND, null, backgroundColorsPanel, null);
				backgroundColorsPanel.setToolTipText("color for terminal background");
				backgroundColorsPanel.add(backgroundColorChooser);
				backgroundColorChooser.setColor(settings.getBgcolor());
				tabbedPane.addTab("Misc.", null, miscPanel, null);
				GridBagLayout gbl_miscPanel = new GridBagLayout();
				gbl_miscPanel.columnWidths = new int[]
					{ 0, 0, 0 };
				gbl_miscPanel.rowHeights = new int[]
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
				gbl_miscPanel.columnWeights = new double[]
					{ 0.0, 1.0, Double.MIN_VALUE };
				gbl_miscPanel.rowWeights = new double[]
					{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
				miscPanel.setLayout(gbl_miscPanel);
				
				GridBagConstraints gbc_lblLookAndFeel = new GridBagConstraints();
				gbc_lblLookAndFeel.anchor = GridBagConstraints.WEST;
				gbc_lblLookAndFeel.insets = new Insets(0, 0, 5, 5);
				gbc_lblLookAndFeel.gridx = 0;
				gbc_lblLookAndFeel.gridy = 0;
				miscPanel.add(lblLookAndFeel, gbc_lblLookAndFeel);
				GridBagConstraints gbc_lafComboBox = new GridBagConstraints();
				gbc_lafComboBox.insets = new Insets(0, 0, 5, 0);
				gbc_lafComboBox.fill = GridBagConstraints.HORIZONTAL;
				gbc_lafComboBox.gridx = 1;
				gbc_lafComboBox.gridy = 0;
				
				
				miscPanel.add(lafComboBox, gbc_lafComboBox);
				lafComboBox.setSelectedItem(settings.getLookAndFeel());
				GridBagConstraints gbc_inverseSelectionColorsCheckbox = new GridBagConstraints();
				gbc_inverseSelectionColorsCheckbox.anchor = GridBagConstraints.WEST;
				gbc_inverseSelectionColorsCheckbox.insets = new Insets(0, 0, 5, 5);
				gbc_inverseSelectionColorsCheckbox.gridx = 0;
				gbc_inverseSelectionColorsCheckbox.gridy = 1;
				miscPanel.add(inverseSelectionColorsCheckbox, gbc_inverseSelectionColorsCheckbox);
				inverseSelectionColorsCheckbox.setSelected(settings.isUseInverseSelectionColor());
				GridBagConstraints gbc_chckbxCopyOnSelect = new GridBagConstraints();
				gbc_chckbxCopyOnSelect.anchor = GridBagConstraints.WEST;
				gbc_chckbxCopyOnSelect.insets = new Insets(0, 0, 5, 5);
				gbc_chckbxCopyOnSelect.gridx = 0;
				gbc_chckbxCopyOnSelect.gridy = 2;
				miscPanel.add(chckbxCopyOnSelect, gbc_chckbxCopyOnSelect);
				chckbxCopyOnSelect.setSelected(settings.isCopyOnSelect());
				GridBagConstraints gbc_chckbxConsole = new GridBagConstraints();
				gbc_chckbxConsole.anchor = GridBagConstraints.WEST;
				gbc_chckbxConsole.insets = new Insets(0, 0, 5, 5);
				gbc_chckbxConsole.gridx = 0;
				gbc_chckbxConsole.gridy = 3;
				miscPanel.add(chckbxConsole, gbc_chckbxConsole);
				chckbxConsole.setSelected(settings.isConsole());
				GridBagConstraints gbc_chckbxCygwin = new GridBagConstraints();
				gbc_chckbxCygwin.anchor = GridBagConstraints.WEST;
				gbc_chckbxCygwin.insets = new Insets(0, 0, 5, 5);
				gbc_chckbxCygwin.gridx = 0;
				gbc_chckbxCygwin.gridy = 4;
				miscPanel.add(chckbxCygwin, gbc_chckbxCygwin);
				chckbxCygwin.setSelected(settings.isCygwin());
				GridBagConstraints gbc_chckbxPasteOnMiddle = new GridBagConstraints();
				gbc_chckbxPasteOnMiddle.anchor = GridBagConstraints.WEST;
				gbc_chckbxPasteOnMiddle.insets = new Insets(0, 0, 5, 5);
				gbc_chckbxPasteOnMiddle.gridx = 0;
				gbc_chckbxPasteOnMiddle.gridy = 5;
				miscPanel.add(chckbxPasteOnMiddle, gbc_chckbxPasteOnMiddle);
				chckbxPasteOnMiddle.setSelected(settings.isPasteOnMiddleMouseClick());
				GridBagConstraints gbc_chckbxEmulatexCopypaste = new GridBagConstraints();
				gbc_chckbxEmulatexCopypaste.anchor = GridBagConstraints.WEST;
				gbc_chckbxEmulatexCopypaste.insets = new Insets(0, 0, 5, 5);
				gbc_chckbxEmulatexCopypaste.gridx = 0;
				gbc_chckbxEmulatexCopypaste.gridy = 6;
				miscPanel.add(chckbxEmulatexCopypaste, gbc_chckbxEmulatexCopypaste);
				chckbxEmulatexCopypaste.setSelected(settings.isEmulateX11CopyPaste());
				GridBagConstraints gbc_chckbxUseAntialiasing = new GridBagConstraints();
				gbc_chckbxUseAntialiasing.anchor = GridBagConstraints.WEST;
				gbc_chckbxUseAntialiasing.insets = new Insets(0, 0, 5, 5);
				gbc_chckbxUseAntialiasing.gridx = 0;
				gbc_chckbxUseAntialiasing.gridy = 7;
				miscPanel.add(chckbxUseAntialiasing, gbc_chckbxUseAntialiasing);
				chckbxUseAntialiasing.setSelected(settings.isUseAntiAliasing());
				GridBagConstraints gbc_lblMaxRefreshRate = new GridBagConstraints();
				gbc_lblMaxRefreshRate.anchor = GridBagConstraints.WEST;
				gbc_lblMaxRefreshRate.insets = new Insets(0, 0, 5, 5);
				gbc_lblMaxRefreshRate.gridx = 0;
				gbc_lblMaxRefreshRate.gridy = 8;
				miscPanel.add(lblMaxRefreshRate, gbc_lblMaxRefreshRate);
				GridBagConstraints gbc_spinnerCaretBlink = new GridBagConstraints();
				gbc_spinnerCaretBlink.insets = new Insets(0, 0, 5, 0);
				gbc_spinnerCaretBlink.fill = GridBagConstraints.HORIZONTAL;
				gbc_spinnerCaretBlink.anchor = GridBagConstraints.WEST;
				gbc_spinnerCaretBlink.gridx = 1;
				gbc_spinnerCaretBlink.gridy = 8;
				miscPanel.add(maxRefreshSpinner, gbc_spinnerCaretBlink);
				maxRefreshSpinner.setValue(settings.getMaxRefreshRate());
				GridBagConstraints gbc_chckbxAudiBell = new GridBagConstraints();
				gbc_chckbxAudiBell.anchor = GridBagConstraints.WEST;
				gbc_chckbxAudiBell.insets = new Insets(0, 0, 5, 5);
				gbc_chckbxAudiBell.gridx = 0;
				gbc_chckbxAudiBell.gridy = 9;
				miscPanel.add(chckbxAudiBell, gbc_chckbxAudiBell);
				chckbxAudiBell.setSelected(settings.isAudibleBell());
				GridBagConstraints gbc_chckbxMouseReporting = new GridBagConstraints();
				gbc_chckbxMouseReporting.anchor = GridBagConstraints.WEST;
				gbc_chckbxMouseReporting.insets = new Insets(0, 0, 5, 5);
				gbc_chckbxMouseReporting.gridx = 0;
				gbc_chckbxMouseReporting.gridy = 10;
				miscPanel.add(chckbxMouseReporting, gbc_chckbxMouseReporting);
				chckbxMouseReporting.setSelected(settings.isEnableMouseReporting());
				GridBagConstraints gbc_lblCaretBlinkMs = new GridBagConstraints();
				gbc_lblCaretBlinkMs.anchor = GridBagConstraints.WEST;
				gbc_lblCaretBlinkMs.insets = new Insets(0, 0, 5, 5);
				gbc_lblCaretBlinkMs.gridx = 0;
				gbc_lblCaretBlinkMs.gridy = 11;
				miscPanel.add(lblCaretBlinkMs, gbc_lblCaretBlinkMs);
				GridBagConstraints gbc_spinnerCaretBlinkMS = new GridBagConstraints();
				gbc_spinnerCaretBlinkMS.insets = new Insets(0, 0, 5, 0);
				gbc_spinnerCaretBlinkMS.anchor = GridBagConstraints.WEST;
				gbc_spinnerCaretBlinkMS.gridx = 1;
				gbc_spinnerCaretBlinkMS.gridy = 11;
				miscPanel.add(spinnerCaretBlink, gbc_spinnerCaretBlinkMS);
				spinnerCaretBlink.setValue(settings.getCaretBlinkingMS());
				GridBagConstraints gbc_chckbxScrollToBottom = new GridBagConstraints();
				gbc_chckbxScrollToBottom.anchor = GridBagConstraints.WEST;
				gbc_chckbxScrollToBottom.insets = new Insets(0, 0, 5, 5);
				gbc_chckbxScrollToBottom.gridx = 0;
				gbc_chckbxScrollToBottom.gridy = 12;
				miscPanel.add(chckbxScrollToBottom, gbc_chckbxScrollToBottom);
				chckbxScrollToBottom.setSelected(settings.isScrollToBottomOnTyping());
				GridBagConstraints gbc_chckbxDecCompatibilityMode = new GridBagConstraints();
				gbc_chckbxDecCompatibilityMode.anchor = GridBagConstraints.WEST;
				gbc_chckbxDecCompatibilityMode.insets = new Insets(0, 0, 5, 5);
				gbc_chckbxDecCompatibilityMode.gridx = 0;
				gbc_chckbxDecCompatibilityMode.gridy = 13;
				miscPanel.add(chckbxDecCompatibilityMode, gbc_chckbxDecCompatibilityMode);
				chckbxDecCompatibilityMode.setSelected(settings.isDecmode());
				GridBagConstraints gbc_chckbxForceActionOn = new GridBagConstraints();
				gbc_chckbxForceActionOn.anchor = GridBagConstraints.WEST;
				gbc_chckbxForceActionOn.insets = new Insets(0, 0, 5, 5);
				gbc_chckbxForceActionOn.gridx = 0;
				gbc_chckbxForceActionOn.gridy = 14;
				miscPanel.add(chckbxForceActionOn, gbc_chckbxForceActionOn);
				chckbxForceActionOn.setSelected(settings.isForceActionOnMouseReporting());
				GridBagConstraints gbc_lblBufferMaxLines = new GridBagConstraints();
				gbc_lblBufferMaxLines.anchor = GridBagConstraints.WEST;
				gbc_lblBufferMaxLines.insets = new Insets(0, 0, 5, 5);
				gbc_lblBufferMaxLines.gridx = 0;
				gbc_lblBufferMaxLines.gridy = 15;
				miscPanel.add(lblBufferMaxLines, gbc_lblBufferMaxLines);
				GridBagConstraints gbc_columnsSpinner = new GridBagConstraints();
				gbc_columnsSpinner.insets = new Insets(0, 0, 5, 0);
				gbc_columnsSpinner.anchor = GridBagConstraints.WEST;
				gbc_columnsSpinner.gridx = 1;
				gbc_columnsSpinner.gridy = 15;
				miscPanel.add(maxBufferLinesSpinner, gbc_columnsSpinner);
				maxBufferLinesSpinner.setValue(settings.getBufferMaxLinesCount());
				GridBagConstraints gbc_chckbxAltSendsEscape = new GridBagConstraints();
				gbc_chckbxAltSendsEscape.anchor = GridBagConstraints.WEST;
				gbc_chckbxAltSendsEscape.insets = new Insets(0, 0, 5, 5);
				gbc_chckbxAltSendsEscape.gridx = 0;
				gbc_chckbxAltSendsEscape.gridy = 16;
				miscPanel.add(chckbxAltSendsEscape, gbc_chckbxAltSendsEscape);
				chckbxAltSendsEscape.setSelected(settings.isAltSendsEscape());
				GridBagConstraints gbc_chckbxAmbiguousCharsAre = new GridBagConstraints();
				gbc_chckbxAmbiguousCharsAre.anchor = GridBagConstraints.WEST;
				gbc_chckbxAmbiguousCharsAre.insets = new Insets(0, 0, 0, 5);
				gbc_chckbxAmbiguousCharsAre.gridx = 0;
				gbc_chckbxAmbiguousCharsAre.gridy = 17;
				miscPanel.add(chckbxAmbiguousCharsAre, gbc_chckbxAmbiguousCharsAre);
				chckbxAmbiguousCharsAre.setSelected(settings.isAmbiguousCharsDoubleWidth());
				lblFineprint.setFont(new Font("Tahoma", Font.ITALIC, 11));
				
				getContentPane().add(lblFineprint, BorderLayout.SOUTH);
				Map<String, String> lnfs = window.getLnfMap();
				for (String s : lnfs.keySet()) {
					lafComboBox.addItem(s);
				}
				lafComboBox.setSelectedItem(settings.getLookAndFeel());
				
				
				btnApplySettings.addActionListener(evt -> {
					settings.setCharSetName(charSetComboBox.getSelectedItem().toString());
					settings.setDir(dirField.getText());
					settings.setTermType(termField.getText());
					String[] cmd = commandField.getText().split("\\s");
					settings.setCommand(Arrays.asList(cmd));
					settings.setOpacity(getOpacityFromInt(opacitySlider.getValue()));
					settings.setBgcolor(backgroundColorChooser.getColor());
					settings.setFgColor(foregroundColorChooser.getColor());
					settings.setFontFamily(fontComboBox.getSelectedItem().toString());
					settings.setFontSize(((Double) fontSizeSpinner.getValue()).floatValue());
					settings.setLineSpace(((Double) lineSpaceSpinner.getValue()).floatValue());
					settings.setBlack(blackColorChooser.getColor());
					settings.setBlue(blueColorChooser.getColor());
					settings.setBrightBlack(brightBlackColorChooser.getColor());
					settings.setBrightBlue(brightBlueColorChooser.getColor());
					settings.setBrightCyan(brightCyanColorChooser.getColor());
					settings.setBrightGreen(brightGreenColorChooser.getColor());
					settings.setBrightMagenta(brightMagentaColorChooser.getColor());
					settings.setBrightRed(brightRedColorChooser.getColor());
					settings.setBrightWhite(brightWhiteColorChooser.getColor());
					settings.setBrightWhite(brightWhiteColorChooser.getColor());
					settings.setCyan(cyanColorChooser.getColor());
					settings.setGreen(greenColorChooser.getColor());
					settings.setMagenta(magentaColorChooser.getColor());
					settings.setRed(redColorChooser.getColor());
					settings.setWhite(whiteColorChooser.getColor());
					settings.setYellow(yellowColorChooser.getColor());
					settings.setSelectionBackground(selectionBGColorChooser.getColor());
					settings.setSelectionForeground(selectionFGColorChooser.getColor());
					settings.setFoundPatternBackGround(foundPatternBackgroundColorChooser.getColor());
					settings.setFoundPatternForeGround(foundPatternForegroundColorChooser.getColor());
					settings.setHyperlinkForeground(hyperlinkForegroundColorChooser.getColor());
					settings.setHyperlinkBackground(hyperlinkBackgroundColorChooser.getColor());
					getSelectedLinkHilightMode();
					settings.setUseInverseSelectionColor(inverseSelectionColorsCheckbox.isSelected());
					settings.setCopyOnSelect(chckbxCopyOnSelect.isSelected());
					settings.setPasteOnMiddleMouseClick(chckbxPasteOnMiddle.isSelected());
					settings.setEmulateX11CopyPaste(chckbxEmulatexCopypaste.isSelected());
					settings.setUseAntiAliasing(chckbxUseAntialiasing.isSelected());
					settings.setMaxRefreshRate((Integer) maxRefreshSpinner.getValue());
					settings.setAudibleBell(chckbxAudiBell.isSelected());
					settings.setEnableMouseReporting(chckbxMouseReporting.isSelected());
					settings.setCaretBlinkingMS((Integer) spinnerCaretBlink.getValue());
					settings.setScrollToBottomOnTyping(chckbxScrollToBottom.isSelected());
					settings.setDecmode(chckbxDecCompatibilityMode.isSelected());
					settings.setForceActionOnMouseReporting(chckbxForceActionOn.isSelected());
					settings.setBufferMaxLinesCount((Integer) maxBufferLinesSpinner.getValue());
					settings.setAltSendsEscape(chckbxAltSendsEscape.isSelected());
					settings.setAmbiguousCharsDoubleWidth(chckbxAmbiguousCharsAre.isSelected());
					settings.setConsole(chckbxConsole.isSelected());
					settings.setCygwin(chckbxCygwin.isSelected());
					settings.setLog4jconf(txtLogjconffield.getText());
					settings.setLookAndFeel(lafComboBox.getSelectedItem().toString());
					settings.setColumns((Integer)columnsSpinner.getValue());
					settings.setRows((Integer)linesSpinner.getValue());
					changeLookAndFeel();

					// save settings
					window.saveSettings();
				});
			}

		private void changeLookAndFeel()
			{
				String lafClass = window.getLnfMap().get(lafComboBox.getSelectedItem());
				if (lafClass != null) {
					try
						{
							UIManager.setLookAndFeel(lafClass);
							SwingUtilities.updateComponentTreeUI(window.getFrame());
							SwingUtilities.updateComponentTreeUI(this);
							
						}
					catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e)
						{
							SithTermMainWindow.getLogger().error("Could not change look and feel!",e);
						}
					
				}
			}

		private void getSelectedLinkHilightMode()
			{
				if (linkHighlightModeComboBox.getSelectedItem().toString().equals(ALWAYS))
					{
						settings.setLinkHighlightStyle(HyperlinkStyle.HighlightMode.ALWAYS);
					}
				else if (linkHighlightModeComboBox.getSelectedItem().toString().equals(NEVER))
					{
						settings.setLinkHighlightStyle(HyperlinkStyle.HighlightMode.NEVER);
					}
				else
					{
						settings.setLinkHighlightStyle(HyperlinkStyle.HighlightMode.HOVER);
					}
			}

		private void setCurrentLinkHiglightMode()
			{
				if (settings.getLinkHighlightStyle() == HyperlinkStyle.HighlightMode.ALWAYS)
					{
						linkHighlightModeComboBox.setSelectedItem(ALWAYS);
					}
				else if (settings.getLinkHighlightStyle() == HyperlinkStyle.HighlightMode.NEVER)
					{
						linkHighlightModeComboBox.setSelectedItem(NEVER);
					}
				else
					{
						linkHighlightModeComboBox.setSelectedItem(HOVER);
					}
			}

		private String getCommandString()
			{
				StringBuilder sb = new StringBuilder();
				for (String s : settings.getCommand())
					{
						sb.append(s).append(" ");
					}
				return sb.toString().trim();
			}
			
		private float getOpacityFromInt(int value)
			{
				return ((float) value) / ((float) (OPACITY_SLIDER_MAX));
			}
			
		/**
		 * @wbp.parser.constructor
		 */
		public SettingsPopup(String label, SithTermMainWindow win)
			{
				this(win);
				this.setTitle(label);
			}
	}
