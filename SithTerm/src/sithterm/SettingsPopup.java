package sithterm;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

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
				// TODO make work with other LOOK AND FEEL, currently only works with METAL
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
				JButton btnApplySettings = new JButton("Apply Settings");
				GridBagConstraints gbc_btnApplySettings = new GridBagConstraints();
				gbc_btnApplySettings.anchor = GridBagConstraints.WEST;
				gbc_btnApplySettings.insets = new Insets(0, 0, 0, 5);
				gbc_btnApplySettings.gridx = 0;
				gbc_btnApplySettings.gridy = 9;
				settingsPanel.add(btnApplySettings, gbc_btnApplySettings);
				JPanel backgroundColorsPanel = new JPanel();
				backgroundColorsPanel.setToolTipText("color for terminal background");
				tabbedPane.addTab("Background Color", null, backgroundColorsPanel, null);
				JColorChooser backgroundColorChooser = new JColorChooser();
				backgroundColorsPanel.add(backgroundColorChooser);
				JPanel foregroundColorPanel = new JPanel();
				tabbedPane.addTab("Foreground Color", null, foregroundColorPanel, null);
				backgroundColorChooser.setColor(settings.getBgcolor());
				JColorChooser foregroundColorChooser = new JColorChooser();
				foregroundColorChooser.setToolTipText("color for foreground of the terminal");
				foregroundColorPanel.add(foregroundColorChooser);
				foregroundColorChooser.setColor(settings.getFgColor());
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
				gbc_fontComboBox.insets = new Insets(0, 0, 5, 0);
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
				gbc_fontSizeSpinner.insets = new Insets(0, 0, 5, 0);
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
				JComboBox<String> linkHighlightModeComboBox = new JComboBox<>();
				GridBagConstraints gbc_comboBox = new GridBagConstraints();
				gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBox.gridx = 1;
				gbc_comboBox.gridy = 2;
				fontPanel.add(linkHighlightModeComboBox);
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
				JTabbedPane colorTabPane = new JTabbedPane(JTabbedPane.TOP);
				tabbedPane.addTab("Palette", null, colorTabPane, "Color Palette for 16-color terminal");
				JColorChooser blackColorChooser = new JColorChooser();
				colorTabPane.addTab("Black", null, blackColorChooser, null);
				blackColorChooser.setColor(settings.getBlack());
				JColorChooser redColorChooser = new JColorChooser();
				colorTabPane.addTab("Red", null, redColorChooser, null);
				redColorChooser.setColor(settings.getRed());
				JColorChooser greenColorChooser = new JColorChooser();
				colorTabPane.addTab("Green", null, greenColorChooser, null);
				greenColorChooser.setColor(settings.getGreen());
				JColorChooser yellowColorChooser = new JColorChooser();
				colorTabPane.addTab("Yellow", null, yellowColorChooser, null);
				yellowColorChooser.setColor(settings.getYellow());
				JColorChooser blueColorChooser = new JColorChooser();
				colorTabPane.addTab("Blue", null, blueColorChooser, null);
				blueColorChooser.setColor(settings.getBlue());
				JColorChooser brightYellowColorChooser = new JColorChooser();
				colorTabPane.addTab("Bright Yellow", null, brightYellowColorChooser, null);
				brightYellowColorChooser.setColor(settings.getBrightYellow());
				JColorChooser magentaColorChooser = new JColorChooser();
				colorTabPane.addTab("Magenta", null, magentaColorChooser, null);
				magentaColorChooser.setColor(settings.getMagenta());
				JColorChooser brightMagentaColorChooser = new JColorChooser();
				colorTabPane.addTab("Bright Magenta", null, brightMagentaColorChooser, null);
				brightMagentaColorChooser.setColor(settings.getBrightMagenta());
				JColorChooser cyanColorChooser = new JColorChooser();
				colorTabPane.addTab("Cyan", null, cyanColorChooser, null);
				cyanColorChooser.setColor(settings.getCyan());
				JColorChooser whiteColorChooser = new JColorChooser();
				colorTabPane.addTab("White", null, whiteColorChooser, null);
				whiteColorChooser.setColor(settings.getWhite());
				JColorChooser brightBlackColorChooser = new JColorChooser();
				colorTabPane.addTab("Bright Black", null, brightBlackColorChooser, null);
				brightBlackColorChooser.setColor(settings.getBrightBlack());
				JColorChooser brightRedColorChooser = new JColorChooser();
				colorTabPane.addTab("Bright Red", null, brightRedColorChooser, null);
				brightRedColorChooser.setColor(settings.getBrightRed());
				JColorChooser brightGreenColorChooser = new JColorChooser();
				colorTabPane.addTab("Bright Green", null, brightGreenColorChooser, null);
				brightGreenColorChooser.setColor(settings.getBrightGreen());
				JColorChooser brightBlueColorChooser = new JColorChooser();
				colorTabPane.addTab("Bright Blue", null, brightBlueColorChooser, null);
				brightBlueColorChooser.setColor(settings.getBrightBlack());
				JColorChooser brightCyanColorChooser = new JColorChooser();
				colorTabPane.addTab("Bright Cyan", null, brightCyanColorChooser, null);
				brightCyanColorChooser.setColor(settings.getBrightCyan());
				JColorChooser brightWhiteColorChooser = new JColorChooser();
				colorTabPane.addTab("Bright White", null, brightWhiteColorChooser, null);
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
				JPanel panel = new JPanel();
				selectionColors.addTab("Hyperlink", null, panel, null);
				JTabbedPane hyperlinkTabbedPane = new JTabbedPane(JTabbedPane.TOP);
				panel.add(hyperlinkTabbedPane);
				JColorChooser hyperlinkForegroundColorChooser = new JColorChooser();
				hyperlinkTabbedPane.addTab("Foreground", null, hyperlinkForegroundColorChooser, null);
				hyperlinkForegroundColorChooser.setColor(settings.getHyperlinkForeground());
				JColorChooser hyperlinkBackgroundColorChooser = new JColorChooser();
				hyperlinkTabbedPane.addTab("Background", null, hyperlinkBackgroundColorChooser, null);
				hyperlinkBackgroundColorChooser.setColor(settings.getHyperlinkBackground());
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
					settings.setLineSpace((float) lineSpaceSpinner.getValue());
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
					else
						settings.setLinkHighlightStyle(HyperlinkStyle.HighlightMode.HOVER);
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
