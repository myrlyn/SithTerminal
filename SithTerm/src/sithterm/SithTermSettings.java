package sithterm;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jediterm.terminal.ui.settings.DefaultSettingsProvider;

public class SithTermSettings implements Serializable
	{
		/**
		* 
		*/
		private static final long serialVersionUID = 1L;
		private List<String> command = new ArrayList<>();
		private String dir = System.getProperty("user.home");
		private String charSetName = "UTF-8";
		private String termType = "xterm";
		private Map<String, Serializable> pluginSettings = new HashMap<>();
		private float opacity = 1.0f;
		private Color bgcolor = Color.BLACK;
		private Color fgColor = Color.WHITE;
		private String fontFamily = new DefaultSettingsProvider().getTerminalFont().getFamily();
		private float fontSize = new DefaultSettingsProvider().getTerminalFontSize();
		private float lineSpace = 0.0f;
		private String lnf =javax.swing.plaf.metal.MetalLookAndFeel.class.getName();
		public String getLnf()
			{
				return lnf;
			}

		public void setLnf(String lnf)
			{
				this.lnf = lnf;
			}

		public float getLineSpace()
			{
				return lineSpace;
			}

		public void setLineSpace(float lineSpace)
			{
				this.lineSpace = lineSpace;
			}

		public float getFontSize()
			{
				return fontSize;
			}

		public void setFontSize(float fontSize)
			{
				this.fontSize = fontSize;
			}

		public String getFontFamily()
			{
				return fontFamily;
			}

		public void setFontFamily(String fontFamily)
			{
				this.fontFamily = fontFamily;
			}

		public float getOpacity()
			{
				return opacity;
			}

		public Color getBgcolor()
			{
				return bgcolor;
			}

		public void setBgcolor(Color bgcolor)
			{
				this.bgcolor = bgcolor;
			}

		public Color getFgColor()
			{
				return fgColor;
			}

		public void setFgColor(Color fgColor)
			{
				this.fgColor = fgColor;
			}

		public void setOpacity(float opacity)
			{
				this.opacity = opacity;
			}

		public static long getSerialversionuid()
			{
				return serialVersionUID;
			}

		public Map<String, Serializable> getPluginSettings()
			{
				return pluginSettings;
			}
			
		public void setPluginSettings(Map<String, Serializable> pluginSettings)
			{
				this.pluginSettings = pluginSettings;
			}
			
		public SithTermSettings()
			{
				String[] foo =
					{ "cmd.exe" };
				command = Arrays.asList(foo);
			}
			
		public List<String> getCommand()
			{
				return command;
			}
			
		public void setCommand(List<String> command)
			{
				this.command = command;
			}
			
		public String getDir()
			{
				return dir;
			}
			
		public void setDir(String dir)
			{
				this.dir = dir;
			}
			
		public String getCharSetName()
			{
				return charSetName;
			}
			
		public void setCharSetName(String charSetName)
			{
				this.charSetName = charSetName;
			}
			
		public String getTermType()
			{
				return termType;
			}
			
		public void setTermType(String termType)
			{
				this.termType = termType;
			}
	}
