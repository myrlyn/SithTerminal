package sithterm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
		private float opacity = 100.0f;
		public float getOpacity()
			{
				return opacity;
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
