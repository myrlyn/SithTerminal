package test.java;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sithterm.SithTermSettings;

class SithTermSettingsTest
	{
		private static SithTermSettings settings = new SithTermSettings();
		@BeforeAll
		static void setUpBeforeClass()
		    throws Exception
			{
				
			}
			
		@AfterAll
		static void tearDownAfterClass()
		    throws Exception
			{
			}
			
		@BeforeEach
		void setUp()
		    throws Exception
			{
			}
			
		@AfterEach
		void tearDown()
		    throws Exception
			{
			}
			
		@Test
		void getBgColor()
			{
				Color c = settings.getBgcolor();
				if (!(c instanceof Color))
					fail("Not yet implemented");
			}
		@Test
		void setBgColor() {
			Color c = new Color(0);
			settings.setBgcolor(c);
			assertEquals(c.getRGB(),settings.getBgcolor().getRGB());
		}
		@Test
		void getBlack()
		{
			if (!(settings.getBlack() instanceof Color))
				fail("Black should be a Color");
		}
		
	}
