package sithterm;

import java.awt.Color;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alee.laf.WebLookAndFeel;
import com.jediterm.terminal.HyperlinkStyle;
import com.jediterm.terminal.model.LinesBuffer;
import com.jediterm.terminal.ui.settings.DefaultSettingsProvider;

public class SithTermSettings implements Serializable
	{
		/**
		 * fields
		 */
		// dark colors
		private Color black = new Color(0x000000);
		private Color red = new Color(0xcd0000);
		private Color green = new Color(0x00cd00);
		private Color yellow = new Color(0xcdcd00);
		private Color blue = new Color(0x1e90ff);
		private Color magenta = new Color(0xcd00cd);
		private Color cyan = new Color(0x00cdcd);
		private Color white = new Color(0xe5e5e5);
		// bright colors
		private Color brightBlack = new Color(0x4c4c4c);
		private Color brightRed = new Color(0xff0000);
		private Color brightGreen = new Color(0x00ff00);
		private Color brightYellow = new Color(0xffff00);
		private Color brightBlue = new Color(0x4682b4);
		private Color brightMagenta = new Color(0xff00ff);
		private Color brightCyan = new Color(0x00ffff);
		private Color brightWhite = new Color(0xffffff);
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
		private Color selectionForeground = new Color(-1);// magic number derived from DefaultSettingsProvider color
		private Color selectionBackground = new Color(-11375195); // magic number derived from DefaultSettingsProvider color
		private Color foundPatternForeGround = new Color(-16777216);// magic number derived from DefaultSettingsProvider color
		private Color foundPatternBackGround = new Color(-256);// magic number derived from DefaultSettingsProvider color
		private Color hyperlinkBackground = new Color(-1);// magic number derived from DefaultSettingsProvider color
		private Color hyperlinkForeground = new Color(-16776961);// magic number derived from DefaultSettingsProvider color
		private HyperlinkStyle.HighlightMode linkHighlightStyle = HyperlinkStyle.HighlightMode.HOVER;
		private boolean useInverseSelectionColor = new DefaultSettingsProvider().useInverseSelectionColor();
		private boolean copyOnSelect = new DefaultSettingsProvider().copyOnSelect();
		private boolean pasteOnMiddleMouseClick = new DefaultSettingsProvider().pasteOnMiddleMouseClick();
		private boolean emulateX11CopyPaste = new DefaultSettingsProvider().emulateX11CopyPaste();
		private boolean useAntiAliasing = new DefaultSettingsProvider().useAntialiasing();
		private int maxRefreshRate = new DefaultSettingsProvider().maxRefreshRate();
		private boolean audibleBell = new DefaultSettingsProvider().audibleBell();
		private boolean enableMouseReporting = new DefaultSettingsProvider().enableMouseReporting();
		private int caretBlinkingMS = new DefaultSettingsProvider().caretBlinkingMs();
		private boolean scrollToBottomOnTyping = new DefaultSettingsProvider().scrollToBottomOnTyping();
		private boolean decmode = new DefaultSettingsProvider().DECCompatibilityMode();
		private boolean forceActionOnMouseReporting = new DefaultSettingsProvider().forceActionOnMouseReporting();
		private int bufferMaxLinesCount = LinesBuffer.DEFAULT_MAX_LINES_COUNT;
		private boolean altSendsEscape = new DefaultSettingsProvider().altSendsEscape();
		private boolean ambiguousCharsDoubleWidth = new DefaultSettingsProvider().ambiguousCharsAreDoubleWidth();
		private boolean cygwin = false;
		private boolean console = false;
		private String log4jconf = System.getProperty("user.home") + File.separator + ".Sith" + File.separator + "log4j.properties";
		private String lookAndFeel = new WebLookAndFeel().getName();
		private int columns = 80;
		private int rows = 24;
		
		public int getColumns()
			{
				return columns;
			}
			
		public void setColumns(int columns)
			{
				this.columns = columns;
			}
			
		public int getRows()
			{
				return rows;
			}
			
		public void setRows(int rows)
			{
				this.rows = rows;
			}
			
		public String getLog4jconf()
			{
				return log4jconf;
			}
			
		public void setLog4jconf(String log4jconf)
			{
				this.log4jconf = log4jconf;
			}
			
		public boolean isCygwin()
			{
				return cygwin;
			}
			
		public void setCygwin(boolean cygwin)
			{
				this.cygwin = cygwin;
			}
			
		public boolean isConsole()
			{
				return console;
			}
			
		public void setConsole(boolean console)
			{
				this.console = console;
			}
			
		public boolean isAmbiguousCharsDoubleWidth()
			{
				return ambiguousCharsDoubleWidth;
			}
			
		public void setAmbiguousCharsDoubleWidth(boolean ambiguousCharsDoubleWidth)
			{
				this.ambiguousCharsDoubleWidth = ambiguousCharsDoubleWidth;
			}
			
		public boolean isAltSendsEscape()
			{
				return altSendsEscape;
			}
			
		public void setAltSendsEscape(boolean altSendsEscape)
			{
				this.altSendsEscape = altSendsEscape;
			}
			
		public int getBufferMaxLinesCount()
			{
				return bufferMaxLinesCount;
			}
			
		public void setBufferMaxLinesCount(int bufferMaxLinesCount)
			{
				this.bufferMaxLinesCount = bufferMaxLinesCount;
			}
			
		public boolean isForceActionOnMouseReporting()
			{
				return forceActionOnMouseReporting;
			}
			
		public void setForceActionOnMouseReporting(boolean forceActionOnMouseReporting)
			{
				this.forceActionOnMouseReporting = forceActionOnMouseReporting;
			}
			
		public boolean isDecmode()
			{
				return decmode;
			}
			
		public void setDecmode(boolean decmode)
			{
				this.decmode = decmode;
			}
			
		public boolean isScrollToBottomOnTyping()
			{
				return scrollToBottomOnTyping;
			}
			
		public void setScrollToBottomOnTyping(boolean scrollToBottomOnTyping)
			{
				this.scrollToBottomOnTyping = scrollToBottomOnTyping;
			}
			
		public int getCaretBlinkingMS()
			{
				return caretBlinkingMS;
			}
			
		public void setCaretBlinkingMS(int caretBlinkingMS)
			{
				this.caretBlinkingMS = caretBlinkingMS;
			}
			
		public boolean isEnableMouseReporting()
			{
				return enableMouseReporting;
			}
			
		public void setEnableMouseReporting(boolean enableMouseReporting)
			{
				this.enableMouseReporting = enableMouseReporting;
			}
			
		public boolean isAudibleBell()
			{
				return audibleBell;
			}
			
		public void setAudibleBell(boolean audibleBell)
			{
				this.audibleBell = audibleBell;
			}
			
		public int getMaxRefreshRate()
			{
				return maxRefreshRate;
			}
			
		public void setMaxRefreshRate(int maxRefreshRate)
			{
				this.maxRefreshRate = maxRefreshRate;
			}
			
		public boolean isUseAntiAliasing()
			{
				return useAntiAliasing;
			}
			
		public void setUseAntiAliasing(boolean useAntiAliasing)
			{
				this.useAntiAliasing = useAntiAliasing;
			}
			
		public boolean isEmulateX11CopyPaste()
			{
				return emulateX11CopyPaste;
			}
			
		public void setEmulateX11CopyPaste(boolean emulateX11CopyPaste)
			{
				this.emulateX11CopyPaste = emulateX11CopyPaste;
			}
			
		public boolean isPasteOnMiddleMouseClick()
			{
				return pasteOnMiddleMouseClick;
			}
			
		public void setPasteOnMiddleMouseClick(boolean pasteOnMiddleMouseClick)
			{
				this.pasteOnMiddleMouseClick = pasteOnMiddleMouseClick;
			}
			
		public boolean isCopyOnSelect()
			{
				return copyOnSelect;
			}
			
		public void setCopyOnSelect(boolean copyOnSelect)
			{
				this.copyOnSelect = copyOnSelect;
			}
			
		public boolean isUseInverseSelectionColor()
			{
				return useInverseSelectionColor;
			}
			
		public void setUseInverseSelectionColor(boolean useInverseSelectionColor)
			{
				this.useInverseSelectionColor = useInverseSelectionColor;
			}
			
		public HyperlinkStyle.HighlightMode getLinkHighlightStyle()
			{
				return linkHighlightStyle;
			}
			
		public void setLinkHighlightStyle(HyperlinkStyle.HighlightMode linkHighlightStyle)
			{
				this.linkHighlightStyle = linkHighlightStyle;
			}
			
		public Color getHyperlinkForeground()
			{
				return hyperlinkForeground;
			}
			
		public void setHyperlinkForeground(Color hyperlinkForeground)
			{
				this.hyperlinkForeground = hyperlinkForeground;
			}
			
		public Color getHyperlinkBackground()
			{
				return hyperlinkBackground;
			}
			
		public void setHyperlinkBackground(Color hyperlinkBackground)
			{
				this.hyperlinkBackground = hyperlinkBackground;
			}
			
		public Color getFoundPatternForeGround()
			{
				return foundPatternForeGround;
			}
			
		public void setFoundPatternForeGround(Color foundPatternForeGround)
			{
				this.foundPatternForeGround = foundPatternForeGround;
			}
			
		public Color getFoundPatternBackGround()
			{
				return foundPatternBackGround;
			}
			
		public void setFoundPatternBackGround(Color foundPatternBackGround)
			{
				this.foundPatternBackGround = foundPatternBackGround;
			}
			
		public Color getSelectionForeground()
			{
				return selectionForeground;
			}
			
		public void setSelectionForeground(Color selectionForeground)
			{
				this.selectionForeground = selectionForeground;
			}
			
		public Color getSelectionBackground()
			{
				return selectionBackground;
			}
			
		public void setSelectionBackground(Color selectionBackground)
			{
				this.selectionBackground = selectionBackground;
			}
			
		public Color[] getPalette()
			{
				return new Color[]
					{ black, red, green, yellow, blue, magenta, cyan, white, brightBlack, brightRed, brightGreen, brightYellow, brightBlue,
					    brightMagenta, brightCyan, brightWhite };
			}
			
		public Color getBlack()
			{
				return black;
			}
			
		public void setBlack(Color black)
			{
				this.black = black;
			}
			
		public Color getRed()
			{
				return red;
			}
			
		public void setRed(Color red)
			{
				this.red = red;
			}
			
		public Color getGreen()
			{
				return green;
			}
			
		public void setGreen(Color green)
			{
				this.green = green;
			}
			
		public Color getYellow()
			{
				return yellow;
			}
			
		public void setYellow(Color yellow)
			{
				this.yellow = yellow;
			}
			
		public Color getBlue()
			{
				return blue;
			}
			
		public void setBlue(Color blue)
			{
				this.blue = blue;
			}
			
		public Color getMagenta()
			{
				return magenta;
			}
			
		public void setMagenta(Color magenta)
			{
				this.magenta = magenta;
			}
			
		public Color getCyan()
			{
				return cyan;
			}
			
		public Color getBrightCyan()
			{
				return brightCyan;
			}
			
		public void setBrightCyan(Color brightCyan)
			{
				this.brightCyan = brightCyan;
			}
			
		public void setCyan(Color cyan)
			{
				this.cyan = cyan;
			}
			
		public Color getWhite()
			{
				return white;
			}
			
		public void setWhite(Color white)
			{
				this.white = white;
			}
			
		public Color getBrightBlack()
			{
				return brightBlack;
			}
			
		public void setBrightBlack(Color brightBlack)
			{
				this.brightBlack = brightBlack;
			}
			
		public Color getBrightRed()
			{
				return brightRed;
			}
			
		public void setBrightRed(Color brightRed)
			{
				this.brightRed = brightRed;
			}
			
		public Color getBrightGreen()
			{
				return brightGreen;
			}
			
		public void setBrightGreen(Color brightGreen)
			{
				this.brightGreen = brightGreen;
			}
			
		public Color getBrightYellow()
			{
				return brightYellow;
			}
			
		public void setBrightYellow(Color brightYellow)
			{
				this.brightYellow = brightYellow;
			}
			
		public Color getBrightBlue()
			{
				return brightBlue;
			}
			
		public void setBrightBlue(Color brightBlue)
			{
				this.brightBlue = brightBlue;
			}
			
		public Color getBrightMagenta()
			{
				return brightMagenta;
			}
			
		public void setBrightMagenta(Color brightMagenta)
			{
				this.brightMagenta = brightMagenta;
			}
			
		public Color getBrightWhite()
			{
				return brightWhite;
			}
			
		public void setBrightWhite(Color brightWhite)
			{
				this.brightWhite = brightWhite;
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
			
		public Color getBgColor()
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
			
		public String getLookAndFeel()
			{
				return lookAndFeel;
			}
			
		public void setLookAndFeel(String lookAndFeel)
			{
				this.lookAndFeel = lookAndFeel;
			}
	}
