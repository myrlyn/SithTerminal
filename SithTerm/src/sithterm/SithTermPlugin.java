package sithterm;

import java.io.Serializable;

public abstract class SithTermPlugin implements Serializable
	{
		private static final long serialVersionUID = 1L;
		private SithTermMainWindow application;
		private SithTermPlugin()
			{				//hide no-args from other classes
			}
		public SithTermPlugin(SithTermMainWindow application) {
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
