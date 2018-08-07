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
		//Amazon sayfas�n�n a��ld���n� onayla
		if(state==true) {//
			System.out.println("Sayfa ba�ar�yla y�klendi");
		}
		else {
			System.out.println("Sayfa belirlenen s�rede y�klenemedi.");
		}
		
		driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span[1]")).click();
		driver.findElement(By.id("ap_email")).clear();
		driver.findElement(By.id("ap_email")).sendKeys("seleniumdeneme@outlook.com");
		//A��lan TextBox'a mail adresi g�nderilir.
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).clear();
	    driver.findElement(By.id("ap_password")).sendKeys("G123456789a+");
	    //Mail adresinden sonra a��lan TextBox'a �ifre g�nderilir.
	    driver.findElement(By.id("signInSubmit")).click();
	    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("samsung");
	    //Anasayfa'da bulunan arama kutucu�una samsung yaz�s� g�nderilir.
	    driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input")).click();
	    boolean productState=driver.findElement(By.linkText("samsung")).isDisplayed();
	    //Samsung ile ilgili bir �r�n bulunmas� durumunda a�a��daki if blo�u i�letilir.
	    if(productState==true) {
	    	System.out.println("Samsung i�in �r�n bulundu.");
	    	
	    }
	    else {
	    	System.out.println("Samsung i�in �r�n bulunamad�.");
	    }
	    
	    driver.findElement(By.xpath("//*[@id=\"pagn\"]/span[3]/a")).click();
	    Thread.sleep(5000);
	    boolean enableState=driver.findElement(By.id("result_16")).isDisplayed();
	    //Her sayfada 16 adet �r�n listelenmektedir.Bu �r�nlerin id'si result_0'dan ba�lamaktad�r.
	    //result_16 id'li �r�n 2.sayfada bulunan ilk �r�n oldu�u i�in 2.sayfan�n a��ld��� do�rulanmaktad�r.
	    if(enableState==true) {
	    	System.out.println("Sayfa 2 g�sterimde.");
	    }
	    else {
	    	System.out.println("Sayfa y�klenemedi");
	    }
	    
	    driver.findElement(By.xpath("//*[@id=\"result_18\"]/div/div/div/div[1]/div/div/a/img")).click();
	    //2.sayfada bulunan  3.�r�n�n xPath'i her zaman ayn� oldu�undan bu �ekilde kullan�ld�.
	    driver.findElement(By.id("add-to-wishlist-button-submit")).click();
	    //Bir �nceki ad�mda izlemeye al�nan �r�n listeye eklendi.
	    
	    
	    //driver.findElement(By.id("a-popover-content-8")).click();//Listeye eklenen �r�n�n a��ld��� popover'� kapat.
	    Thread.sleep(3000);
	    
	    driver.get("http://amazon.com");//Anasayfaya y�nlendir.
	    
	    Thread.sleep(3000);
	    
	    WebElement menu=driver.findElement(By.id("nav-link-accountList"));
	    //Account&List k�sm�n�n id'sini bulur. 
	    Thread.sleep(3000);
	    
	    Hover(driver,menu);
	    //Mouse'un Account&List �zerine gelmesini ve men�n�n a��lmas�n� sa�lar.(Mouse Hover)
	    //Driver ve menu parametrelerini Hover fonksiyonuna g�nderir.
	    Thread.sleep(3000);
	    driver.findElement(By.linkText("Shopping List")).click();
	    //Al��veri� listesine gider.
	    Thread.sleep(3000);
	    driver.findElement(By.linkText("Delete item")).click();
	    //Eklenen �r�n�n silme i�lemi ger�ekle�tirilir.
	    Thread.sleep(3000);
	    if(driver.findElement(By.id("write-review")).isDisplayed()==true) {
	    	System.out.println("�r�n ba�ar�yla silindi.");
	    	//Silme i�lemi yap�ld�ktan sonra sayfada �� adet link ortaya ��kar.Bu linkerden 
	    	//id'si write-review olan link g�r�ld���nde silme i�leminin ba�ar�yla yap�ld��� g�zlenir.
	    }
		
	}
	public static void Hover(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
		//Bu fonksiyon belirlenen elementin Hover olay�n� ger�ekle�tirir.
		//B�ylece mouse Account&List men�s� �zerine geldi�inde men� a��l�r.
	}

}
