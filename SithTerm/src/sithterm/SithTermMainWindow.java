package sithterm;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jediterm.pty.PtyProcessTtyConnector;
import com.jediterm.terminal.TtyConnector;
import com.jediterm.terminal.ui.JediTermWidget;
import com.pty4j.PtyProcess;
import com.pty4j.PtyProcessBuilder;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class SithTermMainWindow implements Serializable
	{
		/**
		* 
		*/
		private static final long serialVersionUID = 1L;
		private JFrame frame;
		private JMenuBar menuBar = new JMenuBar();
		private JMenu mnFile = new JMenu("File");
		private JMenu mnTabs = new JMenu("Tabs");
		private JMenu mnSettings = new JMenu("Settings");
		private JMenuItem mntmNewTab = new JMenuItem("New Tab");
		private JMenuItem mntmCloseTab = new JMenuItem("Close Tab");
		private JPanel panel = new JPanel();
		private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		private static Logger logger = Logger.getLogger(SithTermMainWindow.class);
		private final JMenuItem mntmTerminalSettings = new JMenuItem("Terminal Settings");
		private JMenuItem mntmClose = new JMenuItem("Close");
		private int tabNumber = 1;
		private SettingsPopup spop = null;
		private SithTermSettings settings = new SithTermSettings();
		private transient Gson jsParser = new GsonBuilder().setPrettyPrinting().setLenient().create();
		private Map<String,String> lnfMap = new HashMap<>();
		public static void main(String[] args)
			{ 
				
				BasicConfigurator.configure();
				EventQueue.invokeLater(() -> {
					try
						{
							SithTermMainWindow window = new SithTermMainWindow();
							window.frame.setVisible(true);
						}
					catch (Exception e)
						{
							logger.error("ERROR Starting Window", e);
						}
				});
			}
			
		/**
		 * Create the application.
		 * 
		 * @wbp.parser.entryPoint
		 */
		public SithTermMainWindow()
			{
				initialize();
			}
			
		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize()
			{	
				JDialog.setDefaultLookAndFeelDecorated(true);
				JFrame.setDefaultLookAndFeelDecorated(true);
				//initialize the look and feel that should work everwhere
				try
				{
					UIManager.setLookAndFeel(javax.swing.plaf.metal.MetalLookAndFeel.class.getName());
					
				}
			catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException  e)
				{
					logger.error("Unsupported Look and Feel", e);
				}
			
				UIManager.LookAndFeelInfo[] lnfs = UIManager.getInstalledLookAndFeels();
				for (UIManager.LookAndFeelInfo lnf : lnfs ) {
					lnfMap.put(lnf.getName(), lnf.getClassName());
				}
			
				loadSettings();
				spop = new SettingsPopup("JediTerm Settings", this);
				spop.setBounds(100, 100, 500, 500);
				frame = new JFrame();
				frame.setIconImage(Toolkit.getDefaultToolkit().getImage(SithTermMainWindow.class.getResource("/sw.png")));
				
				frame.setBounds(100, 100, 450, 300);
				frame.setOpacity(settings.getOpacity());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setJMenuBar(menuBar);
				menuBar.add(mnFile);
				mntmClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
				mntmClose.addActionListener(evt -> System.exit(0));
				mnFile.add(mntmClose);
				menuBar.add(mnTabs);
				mntmNewTab.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
				mntmNewTab.addActionListener(evt -> addNewTab());
				mnTabs.add(mntmNewTab);
				mntmCloseTab.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_MASK));
				mntmCloseTab.addActionListener(evt -> closeCurrentTab());
				mnTabs.add(mntmCloseTab);
				menuBar.add(mnSettings);
				mntmTerminalSettings.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
				mntmTerminalSettings.addActionListener(evt -> spop.setVisible(true));
				mnSettings.add(mntmTerminalSettings);
				frame.getContentPane().add(panel, BorderLayout.CENTER);
				panel.setLayout(new BorderLayout(0, 0));
				panel.add(tabbedPane, BorderLayout.CENTER);
				addNewTab();
			}
			
		public Map<String, String> getLnfMap()
			{
				return lnfMap;
			}

		public void setLnfMap(Map<String, String> lnfMap)
			{
				this.lnfMap = lnfMap;
			}

		public static long getSerialversionuid()
			{
				return serialVersionUID;
			}

		private void closeCurrentTab()
			{
				Component c = tabbedPane.getSelectedComponent();
				if (c instanceof JediTermWidget)
					{
						JediTermWidget jtw = (JediTermWidget) c;
						jtw.close();
					}
				else if (c instanceof Closeable)
					{
						try
							{
								((Closeable) c).close();
							}
						catch (IOException e1)
							{
								logger.error("Error closing tab! ", e1);
							}
					}
				else
					{
						logger.warn("Tab not closeable!");
					}
				tabbedPane.remove(c);
			}
			
		private void addNewTab()
			{
				List<String> cmdList = settings.getCommand();
				String[] command = new String[cmdList.size()];
				for (int i=0; i < command.length; i++) {
					logger.info(cmdList.get(i));
					command[i]=cmdList.get(i);
				}
				int initialRows = 26;
				int initialColumns = 80;
				boolean windowAnsiColor = true;
				String dir = ".";
				String chsetName = "UTF-8";
				String termType = "xterm";
				tabbedPane.addTab("Term: " + this.tabNumber++,
				    this.getWidget(command, initialRows, initialColumns, windowAnsiColor, dir, chsetName, termType));
			}
			
		public JFrame getFrame()
			{
				return frame;
			}
			
		public void setFrame(JFrame frame)
			{
				this.frame = frame;
			}
			
		public JMenuBar getMenuBar()
			{
				return menuBar;
			}
			
		public void setMenuBar(JMenuBar menuBar)
			{
				this.menuBar = menuBar;
			}
			
		public JMenu getMnFile()
			{
				return mnFile;
			}
			
		public void setMnFile(JMenu mnFile)
			{
				this.mnFile = mnFile;
			}
			
		public JMenu getMnTabs()
			{
				return mnTabs;
			}
			
		public void setMnTabs(JMenu mnTabs)
			{
				this.mnTabs = mnTabs;
			}
			
		public JMenu getMnSettings()
			{
				return mnSettings;
			}
			
		public void setMnSettings(JMenu mnSettings)
			{
				this.mnSettings = mnSettings;
			}
			
		public JMenuItem getMntmNewTab()
			{
				return mntmNewTab;
			}
			
		public void setMntmNewTab(JMenuItem mntmNewTab)
			{
				this.mntmNewTab = mntmNewTab;
			}
			
		public JMenuItem getMntmCloseTab()
			{
				return mntmCloseTab;
			}
			
		public void setMntmCloseTab(JMenuItem mntmCloseTab)
			{
				this.mntmCloseTab = mntmCloseTab;
			}
			
		public JPanel getPanel()
			{
				return panel;
			}
			
		public void setPanel(JPanel panel)
			{
				this.panel = panel;
			}
			
		public JTabbedPane getTabbedPane()
			{
				return tabbedPane;
			}
			
		public void setTabbedPane(JTabbedPane tabbedPane)
			{
				this.tabbedPane = tabbedPane;
			}
			
		public static Logger getLogger()
			{
				return logger;
			}
			
		public static void setLogger(Logger logger)
			{
				SithTermMainWindow.logger = logger;
			}
			
		public JMenuItem getMntmClose()
			{
				return mntmClose;
			}
			
		public void setMntmClose(JMenuItem mntmClose)
			{
				this.mntmClose = mntmClose;
			}
			
		public int getTabNumber()
			{
				return tabNumber;
			}
			
		public void setTabNumber(int tabNumber)
			{
				this.tabNumber = tabNumber;
			}
			
		public SettingsPopup getSpop()
			{
				return spop;
			}
			
		public void setSpop(SettingsPopup spop)
			{
				this.spop = spop;
			}
			
		public SithTermSettings getSettings()
			{
				return settings;
			}
			
		public void setSettings(SithTermSettings settings)
			{
				this.settings = settings;
			}
			
		public JMenuItem getMntmTerminalSettings()
			{
				return mntmTerminalSettings;
			}
			
		public JediTermWidget getWidget(
		    String[] command, int initialRows, int initialColumns, boolean windowAnsiColor, String dir, String chsetName, String termType
		)
			{
				boolean isConsole = false;
				boolean isCygwin = false;
				Map<String, String> environment = System.getenv();
				Map<String, String> tmpEnv = new HashMap<>();
				if (termType == null)
					{
						termType = "vt100";
					}
				for (Map.Entry<String, String> e : environment.entrySet())
					{
						tmpEnv.put(e.getKey(), e.getValue());
					}
				tmpEnv.put("TERM", termType);
				environment = tmpEnv;
				PtyProcessBuilder procBuilder = new PtyProcessBuilder();
				procBuilder.setCommand(command);
				procBuilder.setEnvironment(environment);
				procBuilder.setInitialRows(initialRows);
				procBuilder.setInitialColumns(initialColumns);
				procBuilder.setWindowsAnsiColorEnabled(windowAnsiColor);
				procBuilder.setDirectory(dir);
				Charset cset = Charset.forName(chsetName);
				procBuilder.setConsole(isConsole);
				procBuilder.setCygwin(isCygwin);
				SithSettingsProvider settingsProvider = new SithSettingsProvider(settings);
				JediTermWidget jtw = new JediTermWidget(settingsProvider);
				
				logger.info("Setting bgcolor"+settings.getBgcolor().toString());
				jtw.setBackground(settings.getBgcolor());
				
				logger.info("Setting fgcolor"+settings.getFgColor().toString());
				jtw.setForeground(settings.getFgColor());
				
				try
					{
						PtyProcess myProcess = procBuilder.start();
						TtyConnector tc = new PtyProcessTtyConnector(myProcess, cset);
						jtw.setTtyConnector(tc);
					}
				catch (IOException e)
					{
						logger.error("IO Exception building PTY Process", e);
					}
				jtw.start(); 
				return jtw; 
			}
			
		public void saveSettings()
			{
				String settingsContent = jsParser.toJson(settings);
				String homedir = System.getProperty("user.home");
				String sithDir = homedir + File.separator + ".Sith";
				String settingsFileName = sithDir + File.separator + "settings.json";
				File sithDirFile = new File(sithDir);
				if (!sithDirFile.exists())
					{
						sithDirFile.mkdirs();
					}
				File settingsFile = new File(settingsFileName);
				try (FileWriter fw = new FileWriter(settingsFile))
					{
						fw.write(settingsContent);
						fw.flush();
					}
				catch (IOException e)
					{
						logger.error("Could not write to settings file! ", e);
					}
			}
			
		public void loadSettings()
			{
				String homedir = System.getProperty("user.home");
				String sithDir = homedir + File.separator + ".Sith";
				String settingsFileName = sithDir + File.separator + "settings.json";
				File sithDirFile = new File(sithDir);
				if (!sithDirFile.exists())
					{
						sithDirFile.mkdirs();
					}
				File settingsFile = new File(settingsFileName);
				if (settingsFile.exists() && settingsFile.isFile())
					{
						StringBuilder settingsBuilder = new StringBuilder();
						try (BufferedReader fr = new BufferedReader(new FileReader(settingsFile)))
							{
								String line = fr.readLine();
								while (line != null)
									{
										settingsBuilder.append(line).append("\n");
										line = fr.readLine();
									}
								String settingsContent = settingsBuilder.toString();
								SithTermSettings tsettings = jsParser.fromJson(settingsContent, SithTermSettings.class);
								if (tsettings == null)
									{
										tsettings = new SithTermSettings();
									}
								
								settings = tsettings;
							}
						catch (IOException e)
							{
								logger.error("Error loading settings file!", e);
							}
					}
			}
	}
