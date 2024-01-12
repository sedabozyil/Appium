package Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.WebElement;

public class Page {
    public static AndroidDriver driver;
    public WebDriverWait wait;

    By NotKabul = By.id("com.android.permissioncontroller:id/permission_allow_button");
    By KategoriTık = By.id("com.solidict.ebebek:id/navCategories");
    By BebekOdasıTık = By.xpath("(//*[@resource-id='com.solidict.ebebek:id/iv_arrow'])[2]");
    By BebekYatağıTık = By.xpath("(//*[@resource-id='com.solidict.ebebek:id/iv_arrow'])[2]");
    By Filtrele = By.xpath("//*[contains(@text, \"Filtrele\")]");
    By FiyatAralığı = By.xpath("(//*[@resource-id='com.solidict.ebebek:id/imgArrow'])[3]");
    By Fiyat5001000 = By.xpath("(//*[@resource-id='com.solidict.ebebek:id/cbFilter'])[2]");

    By Uygula = By.xpath("//*[contains(@text, \"Uygula\")]");
    By ÜrünleriGör = By.xpath("//*[contains(@text, \"Ürünleri Gör\")]");
    By Sırala = By.xpath("//*[contains(@text, \"Sırala\")]");
    By EnÇokSatan = By.xpath("//*[contains(@text, \"En Çok Satanlar\")]");
    By SepeteEkle = By.xpath("(//*[@resource-id='com.solidict.ebebek:id/btAddToCart_'])[1]");
    By SepeteGit = By.xpath("//*[contains(@text, \"Sepetim\")]");

    By teklifiyat = By.xpath("(//*[@resource-id='com.solidict.ebebek:id/textView_CartProduct_Price'])");
    By PlusButton = By.xpath("(//*[@resource-id='com.solidict.ebebek:id/lytPlusQuantity'])");
    By AlışverişiTamamla = By.xpath("//*[contains(@text, \"Alışverişi Tamamla\")]");
    public void setup() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 4");
        caps.setCapability("udid", "emulator-5554");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "5.7");
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("appPackage", "com.solidict.ebebek");
        caps.setCapability("appActivity", "com.ebebek.android.view.MainActivity");
        //caps.setCapability("noReset", "false");
        //caps.setCapability("autoGrantPermissions", "true");

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
    }
    public void testbasla(){
        setup();
    }
    public void NotKabulEt(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(NotKabul)).click();
    }
    public void KategoriTıkla(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(KategoriTık)).click();
    }
    public void BebekOdasıTıkla() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(BebekOdasıTık)).click();
        Thread.sleep(300);
        wait.until(ExpectedConditions.visibilityOfElementLocated(BebekYatağıTık)).click();
    }
    public void Filtrele() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Filtrele)).click();
        Thread.sleep(300);
        wait.until(ExpectedConditions.visibilityOfElementLocated(FiyatAralığı)).click();
        Thread.sleep(300);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Fiyat5001000)).click();
        Thread.sleep(300);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Uygula)).click();
        Thread.sleep(300);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ÜrünleriGör)).click();
    }
    public void Sırala() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Sırala)).click();
        Thread.sleep(300);
        wait.until(ExpectedConditions.visibilityOfElementLocated(EnÇokSatan)).click();
        Thread.sleep(300);
        wait.until(ExpectedConditions.visibilityOfElementLocated(SepeteEkle)).click();
    }
    public static String getTextElement(By xpath){
        WebElement element = driver.findElement(xpath);
        return element.getText();
    }
    public void ArttırKontrolEt() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SepeteGit)).click();
        Thread.sleep(300);
        int ilkfiyat= Integer.parseInt(getTextElement(teklifiyat).replace(" TL","").replace(",","").replace(".",""));
        wait.until(ExpectedConditions.visibilityOfElementLocated(PlusButton)).click();
        Thread.sleep(300);
        int ikincifiyat= Integer.parseInt(getTextElement(teklifiyat).replace(" TL","").replace(",","").replace(".",""));

        if(ikincifiyat==(ilkfiyat*2)){
            wait.until(ExpectedConditions.visibilityOfElementLocated(AlışverişiTamamla)).click();
        }
       else{
            System.out.println("Fiyat Hatalı");
        }

    }

}
