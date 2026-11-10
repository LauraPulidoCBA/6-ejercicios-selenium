import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Ejercicio1 {
    public static void main (String[] args){
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            driver.get("https://demoqa.com/text-box");
            driver.manage().window().maximize();

            WebElement nombre = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
            nombre.sendKeys("Laura Martinez");

            driver.findElement(By.id("userEmail")).sendKeys("laura@gmail.com");
            driver.findElement(By.id("currentAddress")).sendKeys("Calle 25 # 10-20");
            driver.findElement(By.id("permanentAddress")).sendKeys("Carrera 15 #30-40");

            WebElement botonSubmit = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});",
                    botonSubmit
            );

            botonSubmit.click();

            WebElement salidaNombre = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
            WebElement salidaEmail = driver.findElement(By.id("email"));

            String textoNombre = salidaNombre.getText();
            String textoEmail = salidaEmail.getText();

            System.out.println("Resultado: " + textoNombre + " , " + textoEmail);

            // Se verificó que al diligenciar los campos del formulario de texto y hacer
            // clic en enviar, los datos ingresados se reflejan correctamente en el bloque de resultados
            if (textoNombre.contains("Laura Martinez") && textoEmail.contains("laura@gmail.com")) {
                System.out.println("Prueba exitosa");
            } else {
                System.out.println("Prueba fallida");
            }
        } finally {
            // driver.quit();
        }
    }
}
