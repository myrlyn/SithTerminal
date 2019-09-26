package sithterm;

import java.awt.Color;
import java.awt.Font;
import com.jediterm.terminal.HyperlinkStyle.HighlightMode;
import com.jediterm.terminal.TerminalColor;
import com.jediterm.terminal.TextStyle;
import com.jediterm.terminal.emulator.ColorPalette;
import com.jediterm.terminal.ui.settings.DefaultSettingsProvider;
import com.jediterm.terminal.ui.settings.SystemSettingsProvider;
import com.jediterm.terminal.ui.settings.UserSettingsProvider;

public class SithSettingsProvider extends DefaultSettingsProvider implements UserSettingsProvider, SystemSettingsProvider
	{
		SithTermSettings settings = new SithTermSettings();
		
		public SithSettingsProvider(SithTermSettings set)
			{
				this.settings = set;
			}
			
		@Override
		public ColorPalette getTerminalColorPalette()
			{
				return new ColorPalette()
					{
						@Override
						public Color[] getIndexColors()
							{
								return settings.getPalette();
							}
					};
			}
			
		@Override
		public Font getTerminalFont()
			{
				Font f = new Font(settings.getFontFamily(), Font.PLAIN, (int) settings.getFontSize());
				f = f.deriveFont(settings.getFontSize());
				return f;
			}
			
		@Override
		public float getTerminalFontSize()
			{
				return settings.getFontSize();
			}
			
		@Override
		public float getLineSpace()
			{
				return settings.getLineSpace();
			}
			
		@Override
		public TextStyle getDefaultStyle()
			{
				TerminalColor bg = TerminalColor.awt(settings.getBgColor());
				TerminalColor fg = TerminalColor.awt(settings.getFgColor());
				return new TextStyle(fg, bg);
			}
			
		@Override
		public TextStyle getSelectionColor()
			{
				TerminalColor fgc = TerminalColor.awt(settings.getSelectionForeground());
				TerminalColor bgc = TerminalColor.awt(settings.getSelectionBackground());
				return new TextStyle(fgc, bgc);
			}
			
		@Override
		public TextStyle getFoundPatternColor()
			{
				return new TextStyle(TerminalColor.awt(settings.getFoundPatternForeGround()),
				    TerminalColor.awt(settings.getFoundPatternBackGround()));
			}
			
		@Override
		public TextStyle getHyperlinkColor()
			{
				return new TextStyle(TerminalColor.awt(settings.getHyperlinkForeground()),
				    TerminalColor.awt(settings.getHyperlinkBackground()));
			}
			
		@Override
		public HighlightMode getHyperlinkHighlightingMode()
			{
				return settings.getLinkHighlightStyle();
			}
			
		@Override
		public boolean useInverseSelectionColor()
			{
				return settings.isUseInverseSelectionColor();
			}
			
		@Override
		public boolean copyOnSelect()
			{
				return settings.isCopyOnSelect();
			}
			
		@Override
		public boolean pasteOnMiddleMouseClick()
			{
				return settings.isPasteOnMiddleMouseClick();
			}
			
		@Override
		public boolean emulateX11CopyPaste()
			{
				return settings.isEmulateX11CopyPaste();
			}
			
		@Override
		public boolean useAntialiasing()
			{
				return settings.isUseAntiAliasing();
			}
			
		@Override
		public int maxRefreshRate()
			{
				return settings.getMaxRefreshRate();
			}
			
		@Override
		public boolean audibleBell()
			{
				return settings.isAudibleBell();
			}
			
		@Override
		public boolean enableMouseReporting()
			{
				return settings.isEnableMouseReporting();
			}
			
		@Override
		public int caretBlinkingMs()
			{
				return settings.getCaretBlinkingMS();
			}
			
		@Override
		public boolean scrollToBottomOnTyping()
			{
				return settings.isScrollToBottomOnTyping();
			}
			
		@Override
		public boolean DECCompatibilityMode()
			{
				return settings.isDecmode();
			}
			
		@Override
		public boolean forceActionOnMouseReporting()
			{
				return settings.isForceActionOnMouseReporting();
			}
			
		@Override
		public int getBufferMaxLinesCount()
			{
				return settings.getBufferMaxLinesCount();
			}
			
		@Override
		public boolean altSendsEscape()
			{
				return settings.isAltSendsEscape();
			}
			
		@Override
		public boolean ambiguousCharsAreDoubleWidth()
			{
				return settings.isAmbiguousCharsDoubleWidth();
			}
	}
