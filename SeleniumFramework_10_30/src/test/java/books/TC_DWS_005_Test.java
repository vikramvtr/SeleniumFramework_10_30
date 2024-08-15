package books;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qsp.genericutility.BaseClass;
import com.qsp.genericutility.ListenerUtility;

@Listeners(ListenerUtility.class)
public class TC_DWS_005_Test extends BaseClass
{
	@Test
	public void clickOnButton() throws EncryptedDocumentException, IOException
	{
		homepage.getBooksLink().click();
		String ExpectedTitle = excelutility.getStringDataFromExcel("Books", 1, 0);
		String actualTitle = driver.getTitle();		
		Assert.assertEquals(actualTitle, ExpectedTitle, "Books page is not working/dispayed");
		Reporter.log("Books page is displayed", true);
		
	}
}
