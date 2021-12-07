package support.browser;

import com.microsoft.playwright.Page;
import cucumber.api.Scenario;
import lombok.extern.log4j.Log4j2;

import static support.report.Report.takeScreenShot;

@Log4j2
public class BrowserManager extends BrowserFactory{

    private static final int TIME_MULTIPLICATION = 4000;

    public static void tentarIrPara(String url){
        try{getPage().navigate(url);}
        catch (Exception e){
            log.warn(e.getMessage());
        }
    }
    public static boolean pageExist(){
        return BrowserManager.getContext().pages().size() < 1;
    }

    public static void createNewPage(){
        BrowserFactory.setPage(getContext().newPage());
        page.setDefaultTimeout(configuration.timeout() * TIME_MULTIPLICATION);
        log.info(String.format("[TAB %s] - New tab created in browser.", getContext().pages().size()));
    }

    public static Page createAnotherPageWithoutFocus(){
        Page newPage = getContext().newPage();
        newPage.setDefaultTimeout(configuration.timeout() * TIME_MULTIPLICATION);
        log.info(String.format("[TAB %s] - New tab created in browser.", getContext().pages().size()));
        return newPage;
    }

    public static Page changeFocusPage(int pageNumber){
        if(pageNumber < 0 || pageNumber > getContext().pages().size())
            throw new IllegalStateException("Error when trying to change page focus: Page not found.");

        setPage(getContext().pages().get(pageNumber));
        log.info(String.format("Driver switched focus to %s browser tab.", (pageNumber++)));
        return BrowserFactory.getPage();
    }

    public static void closeOtherTabs(){
        while(getContext().pages().size() > 1)  getContext().pages().get(0).close();
        changeFocusPage(0);
    }

    public static void closeAllTabs(){
        while(getContext().pages().size() > 0)  getContext().pages().get(0).close();
    }

    public static void finishScenario(Scenario scenario){
        if(scenario.isFailed()){
            takeScreenShot();
        }
        closeOtherTabs();
    }

    public static void quit(){
        getBrowser().close();
        setBrowser(null);
    }
}
