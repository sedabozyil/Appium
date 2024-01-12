package Steps;

import Pages.Page;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Steps {
    Page page = new Page();


 @Given("Testi Başlat")
    public void TestiBaslat(){
        page.testbasla();
}
@When("Notification Kabul Et")
    public void NotificationKabulEt(){
        page.NotKabulEt();
}
@When("Kategorilere Tıkla")
    public void KategorilereTıkla(){
        page.KategoriTıkla();
}
@When("Bebek Odası Bebek Yatağı Tıkla")
    public void BebekOdasınaTıkla() throws InterruptedException {
        page.BebekOdasıTıkla();
}
@When("Filtreleme Yap")
    public void FiltrelemeYap() throws InterruptedException {
        page.Filtrele();
}
@When("Sırala Sepete Ekle")
    public void SıralaSepeteEkle() throws InterruptedException {
        page.Sırala();
}
@When("Ürün Arttır Kontrol Et")
    public void ÜrünArttırKontrolEt() throws InterruptedException {
        page.ArttırKontrolEt();
}

}
