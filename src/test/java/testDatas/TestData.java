package testDatas;

import org.testng.annotations.DataProvider;

public class TestData {
	@DataProvider(name = "lgData")
	public static Object[][] getData() {
		return new Object[][] { { "shvi1", "tech1" }, { "shvi2", "tech2" }, { "shvi3", "tech3" },
				{ "shvi4", "tech4" }, };

	}
}
