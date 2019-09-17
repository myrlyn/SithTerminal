package sithterm;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JColorChooser;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

public class SettingsPopup extends JDialog
	{
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
					{ 0, 0, 0, 0, 0, 0, 0, 0, 0 };
				gbl_settingsPanel.columnWeights = new double[]
					{ 0.0, 1.0, Double.MIN_VALUE };
				gbl_settingsPanel.rowWeights = new double[]
					{ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
				settingsPanel.setLayout(gbl_settingsPanel);
				JLabel lblCommand = new JLabel("Command");
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
				opacitySlider.setValue((int)(OPACITY_SLIDER_MAX*settings.getOpacity()));
				opacitySlider.addChangeListener(evt -> {
					//window.getFrame().setUndecorated(true);
					window.getFrame().setOpacity(getOpacityFromInt(opacitySlider.getValue()));
					//window.getFrame().setUndecorated(false);
					
				});
				GridBagConstraints gbc_opacitySlider = new GridBagConstraints();
				gbc_opacitySlider.fill = GridBagConstraints.HORIZONTAL;
				gbc_opacitySlider.insets = new Insets(0, 0, 5, 0);
				gbc_opacitySlider.gridx = 1;
				gbc_opacitySlider.gridy = 4;
				settingsPanel.add(opacitySlider, gbc_opacitySlider);
				JButton btnApplySettings = new JButton("Apply Settings");
				GridBagConstraints gbc_btnApplySettings = new GridBagConstraints();
				gbc_btnApplySettings.anchor = GridBagConstraints.WEST;
				gbc_btnApplySettings.insets = new Insets(0, 0, 0, 5);
				gbc_btnApplySettings.gridx = 0;
				gbc_btnApplySettings.gridy = 7;
				settingsPanel.add(btnApplySettings, gbc_btnApplySettings);
				
				JPanel backgroundColorsPanel = new JPanel();
				tabbedPane.addTab("Background Color", null, backgroundColorsPanel, null);
				
				JColorChooser backgroundColorChooser = new JColorChooser();
				backgroundColorsPanel.add(backgroundColorChooser);
				
				JPanel foregroundColorPanel = new JPanel();
				tabbedPane.addTab("Foreground Color", null, foregroundColorPanel, null);
				
				JColorChooser foregroundColorChooser = new JColorChooser();
				foregroundColorPanel.add(foregroundColorChooser);
				btnApplySettings.addActionListener(evt -> {
					settings.setCharSetName(charSetComboBox.getSelectedItem().toString());
					settings.setDir(dirField.getText());
					settings.setTermType(termField.getText());
					String[] cmd = commandField.getText().split("\\s");
					settings.setCommand(Arrays.asList(cmd));
					settings.setOpacity(getOpacityFromInt(opacitySlider.getValue()));
					window.saveSettings();
				});
			}
			
		private float getOpacityFromInt(int value)
			{
				return ((float) value) / ((float)(OPACITY_SLIDER_MAX));
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
