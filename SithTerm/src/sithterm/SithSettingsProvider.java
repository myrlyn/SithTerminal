package sithterm;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

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
				TerminalColor bg = TerminalColor.awt(settings.getBgcolor());
				TerminalColor fg = TerminalColor.awt(settings.getFgColor());
				return new TextStyle(fg, bg);
			}
			
		@Override
		public TextStyle getSelectionColor()
			{
				TerminalColor fgc  =  TerminalColor.awt(settings.getSelectionForeground());
				TerminalColor bgc  =  TerminalColor.awt(settings.getSelectionBackground());
				TextStyle ts = new TextStyle(fgc, bgc);
				return ts;
			}
			
		@Override
		public TextStyle getFoundPatternColor()
			{
				return new TextStyle(TerminalColor.awt(settings.getFoundPatternForeGround()), TerminalColor.awt(settings.getFoundPatternBackGround()));
			}
			
		@Override
		public TextStyle getHyperlinkColor()
			{
				return new TextStyle(TerminalColor.awt(settings.getFoundPatternForeGround()), TerminalColor.awt(settings.getFoundPatternBackGround()));
			}
			
		@Override
		public HighlightMode getHyperlinkHighlightingMode()
			{
				// TODO Auto-generated method stub
				return super.getHyperlinkHighlightingMode();
			}
			
		@Override
		public boolean useInverseSelectionColor()
			{
				// TODO Auto-generated method stub
				return super.useInverseSelectionColor();
			}
			
		@Override
		public boolean copyOnSelect()
			{
				// TODO Auto-generated method stub
				return super.copyOnSelect();
			}
			
		@Override
		public boolean pasteOnMiddleMouseClick()
			{
				// TODO Auto-generated method stub
				return super.pasteOnMiddleMouseClick();
			}
			
		@Override
		public boolean emulateX11CopyPaste()
			{
				// TODO Auto-generated method stub
				return super.emulateX11CopyPaste();
			}
			
		@Override
		public boolean useAntialiasing()
			{
				// TODO Auto-generated method stub
				return super.useAntialiasing();
			}
			
		@Override
		public int maxRefreshRate()
			{
				// TODO Auto-generated method stub
				return super.maxRefreshRate();
			}
			
		@Override
		public boolean audibleBell()
			{
				// TODO Auto-generated method stub
				return super.audibleBell();
			}
			
		@Override
		public boolean enableMouseReporting()
			{
				// TODO Auto-generated method stub
				return super.enableMouseReporting();
			}
			
		@Override
		public int caretBlinkingMs()
			{
				// TODO Auto-generated method stub
				return super.caretBlinkingMs();
			}
			
		@Override
		public boolean scrollToBottomOnTyping()
			{
				// TODO Auto-generated method stub
				return super.scrollToBottomOnTyping();
			}
			
		@Override
		public boolean DECCompatibilityMode()
			{
				// TODO Auto-generated method stub
				return super.DECCompatibilityMode();
			}
			
		@Override
		public boolean forceActionOnMouseReporting()
			{
				// TODO Auto-generated method stub
				return super.forceActionOnMouseReporting();
			}
			
		@Override
		public int getBufferMaxLinesCount()
			{
				// TODO Auto-generated method stub
				return super.getBufferMaxLinesCount();
			}
			
		@Override
		public boolean altSendsEscape()
			{
				// TODO Auto-generated method stub
				return super.altSendsEscape();
			}
			
		@Override
		public boolean ambiguousCharsAreDoubleWidth()
			{
				// TODO Auto-generated method stub
				return super.ambiguousCharsAreDoubleWidth();
			}
	}
