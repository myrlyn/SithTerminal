package sithterm;

import java.awt.Font;

import javax.swing.KeyStroke;

import com.jediterm.terminal.HyperlinkStyle.HighlightMode;
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
				// TODO Auto-generated method stub
				return ColorPalette.WINDOWS_PALETTE;
			}
		@Override
		public Font getTerminalFont()
			{
				// TODO Auto-generated method stub
				return super.getTerminalFont();
			}
		@Override
		public float getTerminalFontSize()
			{
				return super.getTerminalFontSize();
			}
		@Override
		public float getLineSpace()
			{
				// TODO Auto-generated method stub
				return super.getLineSpace();
			}
		@Override
		public TextStyle getDefaultStyle()
			{
				// TODO Auto-generated method stub
				return super.getDefaultStyle();
			}
		@Override
		public TextStyle getSelectionColor()
			{
				// TODO Auto-generated method stub
				return getSelectionColor();
			}
		@Override
		public TextStyle getFoundPatternColor()
			{
				// TODO Auto-generated method stub
				return super.getFoundPatternColor();
			}
		@Override
		public TextStyle getHyperlinkColor()
			{
				// TODO Auto-generated method stub
				return super.getHyperlinkColor();
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
				return super.audibleBell() ;
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
