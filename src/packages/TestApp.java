package packages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestApp {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Lenovo\\Desktop\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		
		driver.get("http://amazon.com");//Amazon.com sitesine git.
		Thread.sleep(5000);
		
		boolean state=driver.findElement(By.linkText("Amazon")).isDisplayed();
		//Amazon sayfasýnýn açýldýðýný onayla
		if(state==true) {//
			System.out.println("Sayfa baþarýyla yüklendi");
		}
		else {
			System.out.println("Sayfa belirlenen sürede yüklenemedi.");
		}
		
		driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span[1]")).click();
		driver.findElement(By.id("ap_email")).clear();
		driver.findElement(By.id("ap_email")).sendKeys("seleniumdeneme@outlook.com");
		//Açýlan TextBox'a mail adresi gönderilir.
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).clear();
	    driver.findElement(By.id("ap_password")).sendKeys("G123456789a+");
	    //Mail adresinden sonra açýlan TextBox'a þifre gönderilir.
	    driver.findElement(By.id("signInSubmit")).click();
	    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("samsung");
	    //Anasayfa'da bulunan arama kutucuðuna samsung yazýsý gönderilir.
	    driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input")).click();
	    boolean productState=driver.findElement(By.linkText("samsung")).isDisplayed();
	    //Samsung ile ilgili bir ürün bulunmasý durumunda aþaðýdaki if bloðu iþletilir.
	    if(productState==true) {
	    	System.out.println("Samsung için ürün bulundu.");
	    	
	    }
	    else {
	    	System.out.println("Samsung için ürün bulunamadý.");
	    }
	    
	    driver.findElement(By.xpath("//*[@id=\"pagn\"]/span[3]/a")).click();
	    Thread.sleep(5000);
	    boolean enableState=driver.findElement(By.id("result_16")).isDisplayed();
	    //Her sayfada 16 adet ürün listelenmektedir.Bu ürünlerin id'si result_0'dan baþlamaktadýr.
	    //result_16 id'li ürün 2.sayfada bulunan ilk ürün olduðu için 2.sayfanýn açýldýðý doðrulanmaktadýr.
	    if(enableState==true) {
	    	System.out.println("Sayfa 2 gösterimde.");
	    }
	    else {
	    	System.out.println("Sayfa yüklenemedi");
	    }
	    
	    driver.findElement(By.xpath("//*[@id=\"result_18\"]/div/div/div/div[1]/div/div/a/img")).click();
	    //2.sayfada bulunan  3.ürünün xPath'i her zaman ayný olduðundan bu þekilde kullanýldý.
	    driver.findElement(By.id("add-to-wishlist-button-submit")).click();
	    //Bir önceki adýmda izlemeye alýnan ürün listeye eklendi.
	    
	    
	    //driver.findElement(By.id("a-popover-content-8")).click();//Listeye eklenen ürünün açýldýðý popover'ý kapat.
	    Thread.sleep(3000);
	    
	    driver.get("http://amazon.com");//Anasayfaya yönlendir.
	    
	    Thread.sleep(3000);
	    
	    WebElement menu=driver.findElement(By.id("nav-link-accountList"));
	    //Account&List kýsmýnýn id'sini bulur. 
	    Thread.sleep(3000);
	    
	    Hover(driver,menu);
	    //Mouse'un Account&List üzerine gelmesini ve menünün açýlmasýný saðlar.(Mouse Hover)
	    //Driver ve menu parametrelerini Hover fonksiyonuna gönderir.
	    Thread.sleep(3000);
	    driver.findElement(By.linkText("Shopping List")).click();
	    //Alýþveriþ listesine gider.
	    Thread.sleep(3000);
	    driver.findElement(By.linkText("Delete item")).click();
	    //Eklenen ürünün silme iþlemi gerçekleþtirilir.
	    Thread.sleep(3000);
	    if(driver.findElement(By.id("write-review")).isDisplayed()==true) {
	    	System.out.println("Ürün baþarýyla silindi.");
	    	//Silme iþlemi yapýldýktan sonra sayfada üç adet link ortaya çýkar.Bu linkerden 
	    	//id'si write-review olan link görüldüðünde silme iþleminin baþarýyla yapýldýðý gözlenir.
	    }
		
	}
	public static void Hover(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
		//Bu fonksiyon belirlenen elementin Hover olayýný gerçekleþtirir.
		//Böylece mouse Account&List menüsü üzerine geldiðinde menü açýlýr.
	}

}
