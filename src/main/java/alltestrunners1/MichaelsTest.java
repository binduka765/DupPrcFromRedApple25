package alltestrunners1;

import sel_duplicatedec2023practice.BrowserUtility4;

public class MichaelsTest {

	public static void main(String[] args) {
		
		String browserName = "edge";
		
		BrowserUtility4 util = new BrowserUtility4();
		util.launchBrowser(browserName);
		
		util.launchUrl("https://www.michaels.com/");
		String actTitle = util.getPageTitle();
		
		if(actTitle.contains(" Michaels")) {
			System.out.println("title -- PASS");
		}else {
			System.out.println("title -- FAIL");
		}
		
		String actUrl = util.getPageUrl();
		if(actUrl.contains("michaels.com")) {
			System.out.println("url test---PASS");
		}else {
			System.out.println("url test--FAIL");
		}

		util.closeBrowser();
	}

}
