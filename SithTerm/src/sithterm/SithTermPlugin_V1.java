package sithterm;

import java.io.Serializable;

public abstract class SithTermPlugin_V1 implements Serializable
	{
		/**
	 * 
	 */
		private static final long serialVersionUID = 1L;
		private SithTermMainWindow application;
		private SithTermPlugin_V1()
			{
				//hide no-args from other classes
			}
		public SithTermPlugin_V1(SithTermMainWindow application) {
			this();
			this.application = application;
		}
		public abstract void initialize(String jarName);
		public abstract void remove();
		public abstract String getPluginName();
		public SithTermMainWindow getApplication()
			{
				return application;
			}
		public void setApplication(SithTermMainWindow application)
			{
				this.application = application;
			}
		
	}
