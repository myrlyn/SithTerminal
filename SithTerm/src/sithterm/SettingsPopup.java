package sithterm;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import org.apache.log4j.Level;

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

public class SettingsPopup extends JDialog
	{// TODO make the rest of the items in SithSettingsProvider configurable here
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
				StringBuilder sb = new StringBuilder();
				for (String s : settings.getCommand())
					{
						sb.append(s).append(" ");
					}
				Map<String, Charset> optList = Charset.availableCharsets();
				JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
				getContentPane().add(tabbedPane, BorderLayout.NORTH);
				JPanel settingsPanel = new JPanel();
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
				JLabel lblCommand = new JLabel("Command");
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
				commandField.setText(sb.toString().trim());
				JLabel lblDirectory = new JLabel("Directory");
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
				JLabel lblCharacterSet = new JLabel("Character Set");
				lblCharacterSet.setToolTipText("Character set for the terminals...");
				GridBagConstraints gbc_lblCharacterSet = new GridBagConstraints();
				gbc_lblCharacterSet.anchor = GridBagConstraints.WEST;
				gbc_lblCharacterSet.insets = new Insets(0, 0, 5, 5);
				gbc_lblCharacterSet.gridx = 0;
				gbc_lblCharacterSet.gridy = 2;
				settingsPanel.add(lblCharacterSet, gbc_lblCharacterSet);
				JComboBox<String> charSetComboBox = new JComboBox<>();
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
				JLabel lblTermType = new JLabel("Term Type");
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
				JLabel lblOpacity = new JLabel("Opacity");
				lblOpacity.setToolTipText("set the opacity of the main window");
				GridBagConstraints gbc_lblOpacity = new GridBagConstraints();
				gbc_lblOpacity.anchor = GridBagConstraints.WEST;
				gbc_lblOpacity.insets = new Insets(0, 0, 5, 5);
				gbc_lblOpacity.gridx = 0;
				gbc_lblOpacity.gridy = 4;
				settingsPanel.add(lblOpacity, gbc_lblOpacity);
				JSlider opacitySlider = new JSlider();
				opacitySlider.setMinimum(0);
				opacitySlider.setMajorTickSpacing(5);
				opacitySlider.setMinorTickSpacing(5);
				opacitySlider.setMaximum(OPACITY_SLIDER_MAX);
				opacitySlider.setValue((int) (OPACITY_SLIDER_MAX * settings.getOpacity()));
				// TODO make work with other LOOK AND FEEL, currently only works with METAL and WEBLAF
				opacitySlider.addChangeListener(evt -> window.getFrame().setOpacity(getOpacityFromInt(opacitySlider.getValue())));
				GridBagConstraints gbc_opacitySlider = new GridBagConstraints();
				gbc_opacitySlider.fill = GridBagConstraints.HORIZONTAL;
				gbc_opacitySlider.insets = new Insets(0, 0, 5, 0);
				gbc_opacitySlider.gridx = 1;
				gbc_opacitySlider.gridy = 4;
				settingsPanel.add(opacitySlider, gbc_opacitySlider);
				JLabel lblLineSpacing = new JLabel("Line Spacing");
				lblLineSpacing.setToolTipText("spacing between new terminal lines");
				GridBagConstraints gbc_lblLineSpacing = new GridBagConstraints();
				gbc_lblLineSpacing.anchor = GridBagConstraints.WEST;
				gbc_lblLineSpacing.insets = new Insets(0, 0, 5, 5);
				gbc_lblLineSpacing.gridx = 0;
				gbc_lblLineSpacing.gridy = 5;
				settingsPanel.add(lblLineSpacing, gbc_lblLineSpacing);
				JSpinner lineSpaceSpinner = new JSpinner();
				lineSpaceSpinner.setModel(new SpinnerNumberModel(settings.getLineSpace(), -0.1f, 64.0f, 0.1f));
				GridBagConstraints gbc_lineSpaceSpinner = new GridBagConstraints();
				gbc_lineSpaceSpinner.insets = new Insets(0, 0, 5, 0);
				gbc_lineSpaceSpinner.gridx = 1;
				gbc_lineSpaceSpinner.gridy = 5;
				settingsPanel.add(lineSpaceSpinner, gbc_lineSpaceSpinner);
				
				JLabel lblLoglevel = new JLabel("LogLevel");
				GridBagConstraints gbc_lblLoglevel = new GridBagConstraints();
				gbc_lblLoglevel.anchor = GridBagConstraints.EAST;
				gbc_lblLoglevel.insets = new Insets(0, 0, 5, 5);
				gbc_lblLoglevel.gridx = 0;
				gbc_lblLoglevel.gridy = 6;
				settingsPanel.add(lblLoglevel, gbc_lblLoglevel);
				
				JComboBox<String> logLevelComboBox = new JComboBox<>();
				GridBagConstraints gbc_llcomboBox = new GridBagConstraints();
				gbc_llcomboBox.insets = new Insets(0, 0, 5, 0);
				gbc_llcomboBox.fill = GridBagConstraints.HORIZONTAL;
				gbc_llcomboBox.gridx = 1;
				gbc_llcomboBox.gridy = 6;
				settingsPanel.add(logLevelComboBox, gbc_llcomboBox);
				logLevelComboBox.addItem(Level.ALL.toString());
				logLevelComboBox.addItem(Level.DEBUG.toString());
				logLevelComboBox.addItem(Level.TRACE.toString());
				logLevelComboBox.addItem(Level.INFO.toString());
				logLevelComboBox.addItem(Level.WARN.toString());
				logLevelComboBox.addItem(Level.ERROR.toString());
				logLevelComboBox.addItem(Level.FATAL.toString());
				logLevelComboBox.addItem(Level.TRACE.toString());
				logLevelComboBox.addItem(Level.OFF.toString());
				logLevelComboBox.setSelectedItem(SithTermMainWindow.getLogger().getLevel().toString());
				JButton btnApplySettings = new JButton("Apply Settings");
				GridBagConstraints gbc_btnApplySettings = new GridBagConstraints();
				gbc_btnApplySettings.anchor = GridBagConstraints.WEST;
				gbc_btnApplySettings.insets = new Insets(0, 0, 0, 5);
				gbc_btnApplySettings.gridx = 0;
				gbc_btnApplySettings.gridy = 9;
				settingsPanel.add(btnApplySettings, gbc_btnApplySettings);
				JPanel fontPanel = new JPanel();
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
				JLabel lblFont = new JLabel("Font");
				lblFont.setToolTipText("name of the font family, not all will actually work");
				GridBagConstraints gbc_lblFont = new GridBagConstraints();
				gbc_lblFont.insets = new Insets(0, 0, 5, 5);
				gbc_lblFont.gridx = 0;
				gbc_lblFont.gridy = 0;
				fontPanel.add(lblFont, gbc_lblFont);
				JComboBox<String> fontComboBox = new JComboBox<>();
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
				JLabel lblFontSize = new JLabel("Font Size");
				lblFontSize.setToolTipText("font size for terminal text");
				GridBagConstraints gbc_lblFontSize = new GridBagConstraints();
				gbc_lblFontSize.insets = new Insets(0, 0, 5, 5);
				gbc_lblFontSize.gridx = 0;
				gbc_lblFontSize.gridy = 1;
				fontPanel.add(lblFontSize, gbc_lblFontSize);
				JSpinner fontSizeSpinner = new JSpinner();
				fontSizeSpinner.setModel(new SpinnerNumberModel(settings.getFontSize(), 3.0f, 64.0f, 0.5f));
				GridBagConstraints gbc_fontSizeSpinner = new GridBagConstraints();
				gbc_fontSizeSpinner.anchor = GridBagConstraints.WEST;
				gbc_fontSizeSpinner.insets = new Insets(0, 0, 5, 5);
				gbc_fontSizeSpinner.gridx = 1;
				gbc_fontSizeSpinner.gridy = 1;
				fontPanel.add(fontSizeSpinner, gbc_fontSizeSpinner);
				JLabel lblLinkHighlightStyle = new JLabel("Link Highlight Style");
				GridBagConstraints gbc_lblLinkHighlightStyle = new GridBagConstraints();
				gbc_lblLinkHighlightStyle.anchor = GridBagConstraints.EAST;
				gbc_lblLinkHighlightStyle.insets = new Insets(0, 0, 0, 5);
				gbc_lblLinkHighlightStyle.gridx = 0;
				gbc_lblLinkHighlightStyle.gridy = 2;
				fontPanel.add(lblLinkHighlightStyle, gbc_lblLinkHighlightStyle);
				GridBagConstraints gbc_comboBox = new GridBagConstraints();
				gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBox.gridx = 1;
				gbc_comboBox.gridy = 2;
				JComboBox<String> linkHighlightModeComboBox = new JComboBox<>();
				GridBagConstraints gbc_linkHighlightModeComboBox = new GridBagConstraints();
				gbc_linkHighlightModeComboBox.anchor = GridBagConstraints.WEST;
				gbc_linkHighlightModeComboBox.insets = new Insets(0, 0, 0, 5);
				gbc_linkHighlightModeComboBox.gridx = 1;
				gbc_linkHighlightModeComboBox.gridy = 2;
				fontPanel.add(linkHighlightModeComboBox, gbc_linkHighlightModeComboBox);
				linkHighlightModeComboBox.addItem("ALWAYS");
				linkHighlightModeComboBox.addItem("NEVER");
				linkHighlightModeComboBox.addItem("HOVER");
				if (settings.getLinkHighlightStyle() == HyperlinkStyle.HighlightMode.ALWAYS)
					{
						linkHighlightModeComboBox.setSelectedItem("ALWAYS");
					}
				else if (settings.getLinkHighlightStyle() == HyperlinkStyle.HighlightMode.NEVER)
					{
						linkHighlightModeComboBox.setSelectedItem("NEVER");
					}
				else
					{
						linkHighlightModeComboBox.setSelectedItem("HOVER");
					}
				JTabbedPane palettePane = new JTabbedPane(JTabbedPane.TOP);
				tabbedPane.addTab("Indexed Palette", null, palettePane, "Color Palette for 16-color terminal");
				JColorChooser blackColorChooser = new JColorChooser();
				palettePane.addTab("Black", null, blackColorChooser, null);
				blackColorChooser.setColor(settings.getBlack());
				JColorChooser redColorChooser = new JColorChooser();
				palettePane.addTab("Red", null, redColorChooser, null);
				redColorChooser.setColor(settings.getRed());
				JColorChooser greenColorChooser = new JColorChooser();
				palettePane.addTab("Green", null, greenColorChooser, null);
				greenColorChooser.setColor(settings.getGreen());
				JColorChooser yellowColorChooser = new JColorChooser();
				palettePane.addTab("Yellow", null, yellowColorChooser, null);
				yellowColorChooser.setColor(settings.getYellow());
				JColorChooser blueColorChooser = new JColorChooser();
				palettePane.addTab("Blue", null, blueColorChooser, null);
				blueColorChooser.setColor(settings.getBlue());
				JColorChooser brightYellowColorChooser = new JColorChooser();
				palettePane.addTab("Bright Yellow", null, brightYellowColorChooser, null);
				brightYellowColorChooser.setColor(settings.getBrightYellow());
				JColorChooser magentaColorChooser = new JColorChooser();
				palettePane.addTab("Magenta", null, magentaColorChooser, null);
				magentaColorChooser.setColor(settings.getMagenta());
				JColorChooser brightMagentaColorChooser = new JColorChooser();
				palettePane.addTab("Bright Magenta", null, brightMagentaColorChooser, null);
				brightMagentaColorChooser.setColor(settings.getBrightMagenta());
				JColorChooser cyanColorChooser = new JColorChooser();
				palettePane.addTab("Cyan", null, cyanColorChooser, null);
				cyanColorChooser.setColor(settings.getCyan());
				JColorChooser whiteColorChooser = new JColorChooser();
				palettePane.addTab("White", null, whiteColorChooser, null);
				whiteColorChooser.setColor(settings.getWhite());
				JColorChooser brightBlackColorChooser = new JColorChooser();
				palettePane.addTab("Bright Black", null, brightBlackColorChooser, null);
				brightBlackColorChooser.setColor(settings.getBrightBlack());
				JColorChooser brightRedColorChooser = new JColorChooser();
				palettePane.addTab("Bright Red", null, brightRedColorChooser, null);
				brightRedColorChooser.setColor(settings.getBrightRed());
				JColorChooser brightGreenColorChooser = new JColorChooser();
				palettePane.addTab("Bright Green", null, brightGreenColorChooser, null);
				brightGreenColorChooser.setColor(settings.getBrightGreen());
				JColorChooser brightBlueColorChooser = new JColorChooser();
				palettePane.addTab("Bright Blue", null, brightBlueColorChooser, null);
				brightBlueColorChooser.setColor(settings.getBrightBlack());
				JColorChooser brightCyanColorChooser = new JColorChooser();
				palettePane.addTab("Bright Cyan", null, brightCyanColorChooser, null);
				brightCyanColorChooser.setColor(settings.getBrightCyan());
				JColorChooser brightWhiteColorChooser = new JColorChooser();
				palettePane.addTab("Bright White", null, brightWhiteColorChooser, null);
				brightWhiteColorChooser.setColor(settings.getBrightWhite());
				JPanel FontColorsPanel = new JPanel();
				tabbedPane.addTab("Text Styles", null, FontColorsPanel, null);
				JTabbedPane fontColorsTabbedPane = new JTabbedPane(JTabbedPane.TOP);
				FontColorsPanel.add(fontColorsTabbedPane);
				JPanel textSelectionPanel = new JPanel();
				fontColorsTabbedPane.addTab("Selection", null, textSelectionPanel, null);
				JTabbedPane selectionColors = new JTabbedPane(JTabbedPane.TOP);
				textSelectionPanel.add(selectionColors);
				JColorChooser selectionFGColorChooser = new JColorChooser();
				selectionColors.addTab("Foreground", null, selectionFGColorChooser, null);
				selectionFGColorChooser.setColor(settings.getSelectionForeground());
				JColorChooser selectionBGColorChooser = new JColorChooser();
				selectionColors.addTab("Background", null, selectionBGColorChooser, null);
				selectionBGColorChooser.setColor(settings.getSelectionBackground());
				JPanel patternFoundPanel = new JPanel();
				fontColorsTabbedPane.addTab("Pattern Found", null, patternFoundPanel, null);
				JTabbedPane patternFoundTabbedPane = new JTabbedPane(JTabbedPane.TOP);
				patternFoundPanel.add(patternFoundTabbedPane);
				JColorChooser foundPatternForegroundColorChooser = new JColorChooser();
				patternFoundTabbedPane.addTab("Foreground", null, foundPatternForegroundColorChooser, null);
				foundPatternForegroundColorChooser.setColor(settings.getFoundPatternForeGround());
				JColorChooser foundPatternBackgroundColorChooser = new JColorChooser();
				patternFoundTabbedPane.addTab("Background", null, foundPatternBackgroundColorChooser, null);
				foundPatternBackgroundColorChooser.setColor(settings.getFoundPatternBackGround());
				JPanel linkPanel = new JPanel();
				fontColorsTabbedPane.addTab("Links", null, linkPanel, null);
				JTabbedPane hyperlinkTabbedPane = new JTabbedPane(JTabbedPane.TOP);
				linkPanel.add(hyperlinkTabbedPane);
				JColorChooser hyperlinkForegroundColorChooser = new JColorChooser();
				hyperlinkTabbedPane.addTab("Foreground", null, hyperlinkForegroundColorChooser, null);
				hyperlinkForegroundColorChooser.setColor(settings.getHyperlinkForeground());
				JColorChooser hyperlinkBackgroundColorChooser = new JColorChooser();
				hyperlinkTabbedPane.addTab("Background", null, hyperlinkBackgroundColorChooser, null);
				hyperlinkBackgroundColorChooser.setColor(settings.getHyperlinkBackground());
				
				JPanel defaultStylePanel = new JPanel();
				fontColorsTabbedPane.addTab("Default", null, defaultStylePanel, null);
				
				JTabbedPane defstyleTabbedPane = new JTabbedPane(JTabbedPane.TOP);
				defaultStylePanel.add(defstyleTabbedPane);
				JPanel foregroundColorPanel = new JPanel();
				defstyleTabbedPane.addTab("Foreground", null, foregroundColorPanel, null);
				JColorChooser foregroundColorChooser = new JColorChooser();
				foregroundColorChooser.setToolTipText("color for foreground of the terminal");
				foregroundColorPanel.add(foregroundColorChooser);
				foregroundColorChooser.setColor(settings.getFgColor());
				JPanel backgroundColorsPanel = new JPanel();
				defstyleTabbedPane.addTab("Background", null, backgroundColorsPanel, null);
				backgroundColorsPanel.setToolTipText("color for terminal background");
				JColorChooser backgroundColorChooser = new JColorChooser();
				backgroundColorsPanel.add(backgroundColorChooser);
				backgroundColorChooser.setColor(settings.getBgcolor());
				
				JPanel miscPanel = new JPanel();
				tabbedPane.addTab("Misc.", null, miscPanel, null);
				GridBagLayout gbl_miscPanel = new GridBagLayout();
				gbl_miscPanel.columnWidths = new int[]{0, 0, 0};
				gbl_miscPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
				gbl_miscPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
				gbl_miscPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				miscPanel.setLayout(gbl_miscPanel);
				
				JCheckBox inverseSelectionColorsCheckbox = new JCheckBox("Use Inverse Selection Colors");
				GridBagConstraints gbc_inverseSelectionColorsCheckbox = new GridBagConstraints();
				gbc_inverseSelectionColorsCheckbox.anchor = GridBagConstraints.WEST;
				gbc_inverseSelectionColorsCheckbox.insets = new Insets(0, 0, 5, 5);
				gbc_inverseSelectionColorsCheckbox.gridx = 0;
				gbc_inverseSelectionColorsCheckbox.gridy = 0;
				miscPanel.add(inverseSelectionColorsCheckbox, gbc_inverseSelectionColorsCheckbox);
				inverseSelectionColorsCheckbox.setSelected(settings.isUseInverseSelectionColor());
				
				JCheckBox chckbxCopyOnSelect = new JCheckBox("Copy On Select");
				GridBagConstraints gbc_chckbxCopyOnSelect = new GridBagConstraints();
				gbc_chckbxCopyOnSelect.anchor = GridBagConstraints.WEST;
				gbc_chckbxCopyOnSelect.insets = new Insets(0, 0, 5, 5);
				gbc_chckbxCopyOnSelect.gridx = 0;
				gbc_chckbxCopyOnSelect.gridy = 1;
				miscPanel.add(chckbxCopyOnSelect, gbc_chckbxCopyOnSelect);
				chckbxCopyOnSelect.setSelected(settings.isCopyOnSelect());
				
				JCheckBox chckbxConsole = new JCheckBox("Console");
				GridBagConstraints gbc_chckbxConsole = new GridBagConstraints();
				gbc_chckbxConsole.anchor = GridBagConstraints.WEST;
				gbc_chckbxConsole.insets = new Insets(0, 0, 5, 5);
				gbc_chckbxConsole.gridx = 0;
				gbc_chckbxConsole.gridy = 2;
				miscPanel.add(chckbxConsole, gbc_chckbxConsole);
				chckbxConsole.setSelected(settings.isConsole());
				
				JCheckBox chckbxCygwin = new JCheckBox("Cygwin");
				GridBagConstraints gbc_chckbxCygwin = new GridBagConstraints();
				gbc_chckbxCygwin.anchor = GridBagConstraints.WEST;
				gbc_chckbxCygwin.insets = new Insets(0, 0, 5, 5);
				gbc_chckbxCygwin.gridx = 0;
				gbc_chckbxCygwin.gridy = 3;
				miscPanel.add(chckbxCygwin, gbc_chckbxCygwin);
				chckbxCygwin.setSelected(settings.isCygwin());
				
				JCheckBox chckbxPasteOnMiddle = new JCheckBox("Paste On Middle Mouse Click");
				GridBagConstraints gbc_chckbxPasteOnMiddle = new GridBagConstraints();
				gbc_chckbxPasteOnMiddle.anchor = GridBagConstraints.WEST;
				gbc_chckbxPasteOnMiddle.insets = new Insets(0, 0, 5, 5);
				gbc_chckbxPasteOnMiddle.gridx = 0;
				gbc_chckbxPasteOnMiddle.gridy = 4;
				miscPanel.add(chckbxPasteOnMiddle, gbc_chckbxPasteOnMiddle);
				chckbxPasteOnMiddle.setSelected(settings.isPasteOnMiddleMouseClick());
				
				JCheckBox chckbxEmulatexCopypaste = new JCheckBox("EmulateX11 Copy/Paste");
				GridBagConstraints gbc_chckbxEmulatexCopypaste = new GridBagConstraints();
				gbc_chckbxEmulatexCopypaste.anchor = GridBagConstraints.WEST;
				gbc_chckbxEmulatexCopypaste.insets = new Insets(0, 0, 5, 5);
				gbc_chckbxEmulatexCopypaste.gridx = 0;
				gbc_chckbxEmulatexCopypaste.gridy = 5;
				miscPanel.add(chckbxEmulatexCopypaste, gbc_chckbxEmulatexCopypaste);
				chckbxEmulatexCopypaste.setSelected(settings.isEmulateX11CopyPaste());
				
				JCheckBox chckbxUseAntialiasing = new JCheckBox("Use Antialiasing");
				GridBagConstraints gbc_chckbxUseAntialiasing = new GridBagConstraints();
				gbc_chckbxUseAntialiasing.anchor = GridBagConstraints.WEST;
				gbc_chckbxUseAntialiasing.insets = new Insets(0, 0, 5, 5);
				gbc_chckbxUseAntialiasing.gridx = 0;
				gbc_chckbxUseAntialiasing.gridy = 6;
				miscPanel.add(chckbxUseAntialiasing, gbc_chckbxUseAntialiasing);
				chckbxUseAntialiasing.setSelected(settings.isUseAntiAliasing());
				
				JLabel lblMaxRefreshRate = new JLabel("Max Refresh Rate");
				GridBagConstraints gbc_lblMaxRefreshRate = new GridBagConstraints();
				gbc_lblMaxRefreshRate.anchor = GridBagConstraints.WEST;
				gbc_lblMaxRefreshRate.insets = new Insets(0, 0, 5, 5);
				gbc_lblMaxRefreshRate.gridx = 0;
				gbc_lblMaxRefreshRate.gridy = 7;
				miscPanel.add(lblMaxRefreshRate, gbc_lblMaxRefreshRate);
				
				JSpinner maxRefreshSpinner = new JSpinner();
				GridBagConstraints gbc_spinnerCaretBlink = new GridBagConstraints();
				gbc_spinnerCaretBlink.insets = new Insets(0, 0, 5, 0);
				gbc_spinnerCaretBlink.fill = GridBagConstraints.HORIZONTAL;
				gbc_spinnerCaretBlink.anchor = GridBagConstraints.WEST;
				gbc_spinnerCaretBlink.gridx = 1;
				gbc_spinnerCaretBlink.gridy = 7;
				miscPanel.add(maxRefreshSpinner, gbc_spinnerCaretBlink);
				maxRefreshSpinner.setValue(settings.getMaxRefreshRate());
				
				JCheckBox chckbxAudiBell = new JCheckBox("Audible Bell");
				GridBagConstraints gbc_chckbxAudiBell = new GridBagConstraints();
				gbc_chckbxAudiBell.anchor = GridBagConstraints.WEST;
				gbc_chckbxAudiBell.insets = new Insets(0, 0, 5, 5);
				gbc_chckbxAudiBell.gridx = 0;
				gbc_chckbxAudiBell.gridy = 8;
				miscPanel.add(chckbxAudiBell, gbc_chckbxAudiBell);
				chckbxAudiBell.setSelected(settings.isAudibleBell());
				
				JCheckBox chckbxMouseReporting = new JCheckBox("Enable Mouse Reporting");
				GridBagConstraints gbc_chckbxMouseReporting = new GridBagConstraints();
				gbc_chckbxMouseReporting.anchor = GridBagConstraints.WEST;
				gbc_chckbxMouseReporting.insets = new Insets(0, 0, 5, 5);
				gbc_chckbxMouseReporting.gridx = 0;
				gbc_chckbxMouseReporting.gridy = 9;
				miscPanel.add(chckbxMouseReporting, gbc_chckbxMouseReporting);
				chckbxMouseReporting.setSelected(settings.isEnableMouseReporting());
				
				JLabel lblCaretBlinkMs = new JLabel("Caret Blink MS");
				GridBagConstraints gbc_lblCaretBlinkMs = new GridBagConstraints();
				gbc_lblCaretBlinkMs.anchor = GridBagConstraints.WEST;
				gbc_lblCaretBlinkMs.insets = new Insets(0, 0, 5, 5);
				gbc_lblCaretBlinkMs.gridx = 0;
				gbc_lblCaretBlinkMs.gridy = 10;
				miscPanel.add(lblCaretBlinkMs, gbc_lblCaretBlinkMs);
				
				JSpinner spinnerCaretBlink = new JSpinner();
				GridBagConstraints gbc_spinnerCaretBlinkMS = new GridBagConstraints();
				gbc_spinnerCaretBlinkMS.insets = new Insets(0, 0, 5, 0);
				gbc_spinnerCaretBlinkMS.anchor = GridBagConstraints.WEST;
				gbc_spinnerCaretBlinkMS.gridx = 1;
				gbc_spinnerCaretBlinkMS.gridy = 10;
				miscPanel.add(spinnerCaretBlink, gbc_spinnerCaretBlinkMS);
				spinnerCaretBlink.setValue(settings.getCaretBlinkingMS());
				
				JCheckBox chckbxScrollToBottom = new JCheckBox("Scroll To Bottom On Type");
				GridBagConstraints gbc_chckbxScrollToBottom = new GridBagConstraints();
				gbc_chckbxScrollToBottom.anchor = GridBagConstraints.WEST;
				gbc_chckbxScrollToBottom.insets = new Insets(0, 0, 5, 5);
				gbc_chckbxScrollToBottom.gridx = 0;
				gbc_chckbxScrollToBottom.gridy = 11;
				miscPanel.add(chckbxScrollToBottom, gbc_chckbxScrollToBottom);
				chckbxScrollToBottom.setSelected(settings.isScrollToBottomOnTyping());
				
				JCheckBox chckbxDecCompatibilityMode = new JCheckBox("DEC Compatibility Mode");
				GridBagConstraints gbc_chckbxDecCompatibilityMode = new GridBagConstraints();
				gbc_chckbxDecCompatibilityMode.anchor = GridBagConstraints.WEST;
				gbc_chckbxDecCompatibilityMode.insets = new Insets(0, 0, 5, 5);
				gbc_chckbxDecCompatibilityMode.gridx = 0;
				gbc_chckbxDecCompatibilityMode.gridy = 12;
				miscPanel.add(chckbxDecCompatibilityMode, gbc_chckbxDecCompatibilityMode);
				chckbxDecCompatibilityMode.setSelected(settings.isDecmode());
				
				JCheckBox chckbxForceActionOn = new JCheckBox("Force Action On Mouse Report");
				GridBagConstraints gbc_chckbxForceActionOn = new GridBagConstraints();
				gbc_chckbxForceActionOn.anchor = GridBagConstraints.WEST;
				gbc_chckbxForceActionOn.insets = new Insets(0, 0, 5, 5);
				gbc_chckbxForceActionOn.gridx = 0;
				gbc_chckbxForceActionOn.gridy = 13;
				miscPanel.add(chckbxForceActionOn, gbc_chckbxForceActionOn);
				chckbxForceActionOn.setSelected(settings.isForceActionOnMouseReporting());
				
				JLabel lblBufferMaxLines = new JLabel("Buffer Max Lines");
				GridBagConstraints gbc_lblBufferMaxLines = new GridBagConstraints();
				gbc_lblBufferMaxLines.anchor = GridBagConstraints.WEST;
				gbc_lblBufferMaxLines.insets = new Insets(0, 0, 5, 5);
				gbc_lblBufferMaxLines.gridx = 0;
				gbc_lblBufferMaxLines.gridy = 14;
				miscPanel.add(lblBufferMaxLines, gbc_lblBufferMaxLines);
				
				JSpinner maxBufferLinesSpinner = new JSpinner();
				GridBagConstraints gbc_spinner = new GridBagConstraints();
				gbc_spinner.insets = new Insets(0, 0, 5, 0);
				gbc_spinner.anchor = GridBagConstraints.WEST;
				gbc_spinner.gridx = 1;
				gbc_spinner.gridy = 14;
				miscPanel.add(maxBufferLinesSpinner, gbc_spinner);
				maxBufferLinesSpinner.setValue(settings.getBufferMaxLinesCount());
				
				JCheckBox chckbxAltSendsEscape = new JCheckBox("Alt Sends Escape");
				GridBagConstraints gbc_chckbxAltSendsEscape = new GridBagConstraints();
				gbc_chckbxAltSendsEscape.anchor = GridBagConstraints.WEST;
				gbc_chckbxAltSendsEscape.insets = new Insets(0, 0, 5, 5);
				gbc_chckbxAltSendsEscape.gridx = 0;
				gbc_chckbxAltSendsEscape.gridy = 15;
				miscPanel.add(chckbxAltSendsEscape, gbc_chckbxAltSendsEscape);
				chckbxAltSendsEscape.setSelected(settings.isAltSendsEscape());
				
				JCheckBox chckbxAmbiguousCharsAre = new JCheckBox("Ambiguous Chars are Double Width");
				GridBagConstraints gbc_chckbxAmbiguousCharsAre = new GridBagConstraints();
				gbc_chckbxAmbiguousCharsAre.anchor = GridBagConstraints.WEST;
				gbc_chckbxAmbiguousCharsAre.insets = new Insets(0, 0, 0, 5);
				gbc_chckbxAmbiguousCharsAre.gridx = 0;
				gbc_chckbxAmbiguousCharsAre.gridy = 16;
				miscPanel.add(chckbxAmbiguousCharsAre, gbc_chckbxAmbiguousCharsAre);
				chckbxAmbiguousCharsAre.setSelected(settings.isAmbiguousCharsDoubleWidth());
				
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
					if (linkHighlightModeComboBox.getSelectedItem().toString().equals("ALWAYS"))
						{
							settings.setLinkHighlightStyle(HyperlinkStyle.HighlightMode.ALWAYS);
						}
					else if (linkHighlightModeComboBox.getSelectedItem().toString().equals("NEVER"))
						{
							settings.setLinkHighlightStyle(HyperlinkStyle.HighlightMode.NEVER);
						}
					else {
						settings.setLinkHighlightStyle(HyperlinkStyle.HighlightMode.HOVER);
					}
					settings.setUseInverseSelectionColor(inverseSelectionColorsCheckbox.isSelected());
					settings.setCopyOnSelect(chckbxCopyOnSelect.isSelected());
					settings.setPasteOnMiddleMouseClick(chckbxPasteOnMiddle.isSelected());
					settings.setEmulateX11CopyPaste(chckbxEmulatexCopypaste.isSelected());
					settings.setUseAntiAliasing(chckbxUseAntialiasing.isSelected());
					settings.setMaxRefreshRate((Integer)maxRefreshSpinner.getValue());
					settings.setAudibleBell(chckbxAudiBell.isSelected());
					settings.setEnableMouseReporting(chckbxMouseReporting.isSelected());
					settings.setCaretBlinkingMS((Integer)spinnerCaretBlink.getValue());
					settings.setScrollToBottomOnTyping(chckbxScrollToBottom.isSelected());
					settings.setDecmode(chckbxDecCompatibilityMode.isSelected());
					settings.setForceActionOnMouseReporting(chckbxForceActionOn.isSelected());
					settings.setBufferMaxLinesCount((Integer)maxBufferLinesSpinner.getValue());
					settings.setAltSendsEscape(chckbxAltSendsEscape.isSelected());
					settings.setAmbiguousCharsDoubleWidth(chckbxAmbiguousCharsAre.isSelected());
					settings.setConsole(chckbxConsole.isSelected());
					settings.setCygwin(chckbxCygwin.isSelected());
					settings.setLogLevel(logLevelComboBox.getSelectedItem().toString());
					SithTermMainWindow.getLogger().setLevel(Level.toLevel(settings.getLogLevel()));
					
					
					//save settings
					window.saveSettings();
				});
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
