package com.test;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.core.BaseTest;
import com.core.GlobalProperty;
import com.core.SpreadsheetData;
import com.page.DetailPage;
import com.page.MainPage;

public class DataDrivenCountryTest extends BaseTest {

	private DetailPage detailPage;
	private MainPage mainPage;

	@BeforeTest
	public void setUp() {
		mainPage = new MainPage();		
	}

	@Test(dataProvider = "countriesList")
	public void testSearchCountry(String searchCountry, String expectedCountry) throws InterruptedException {
		mainPage.open(GlobalProperty.getProperty("webdriver.url.dese"));
		Thread.sleep(1000);
		detailPage = mainPage.search(searchCountry);
		Thread.sleep(1000);

		assertEquals(detailPage.getTitleCountry(), expectedCountry);
	}

	@DataProvider(name = "countriesList")
	public Object[][] dataProviderCountries() {
		return new Object[][] { { "India", "India" }, { "Brazil", "Brazil" }, { "Argentina", "Argentina" },
				{ "Italy", "Italy" }, { "Venezuela", "Venezuela" }, { "United States", "United States" } };
	}

	@Test(dataProvider = "countriesExcel")
	public void testSearchCountryExcel(String searchCountry, String expectedCountry) throws InterruptedException {
		mainPage.open(GlobalProperty.getProperty("webdriver.url.dese"));
		Thread.sleep(1000);
		detailPage = mainPage.search(searchCountry);
		Thread.sleep(1000);

		assertEquals(detailPage.getTitleCountry(), expectedCountry);
	}

	@DataProvider(name = "countriesExcel")
	public Object[][] dataProviderCountriesExcel() {
		Object[][] testData = SpreadsheetData.readExcelData("Paises",
				"src" + File.separator + "test" + File.separator + "resources" + File.separator + "paises.xls",
				"Dados");
		return testData;

	};
}
