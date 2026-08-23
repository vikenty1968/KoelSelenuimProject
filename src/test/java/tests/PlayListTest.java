package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PlayListPage;

public class PlayListTest extends AuthenticatedTest {
    @Test
    public void checkFlow(){
        System.out.println("Flow is working");
    }
    @Test(groups = "smoke")
    public void createPlistWithPlusBtn(){
        PlayListPage playListPage = new PlayListPage(getDriver());
        String pListName = "Automation Playlist";
        playListPage.clickPlusBtn();
        playListPage.openSimplePlistForm();
        playListPage.enterPlistName(pListName);
        Assert.assertTrue(playListPage.isSuccessBannerDisplayed());

    }
}
