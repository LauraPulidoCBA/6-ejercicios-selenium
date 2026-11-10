import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Ejercicio3 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            driver.get("https://www.selenium.dev/selenium/web/web-form.html");
            driver.manage().window().maximize();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("my-text"))).sendKeys("Prueba ADSO");
            driver.findElement(By.name("my-password")).sendKeys("Sena2026");
            driver.findElement(By.name("my-textarea")).sendKeys("Automatización con Selenium");

            driver.findElement(By.cssSelector("button[type='submit']")).click();

            WebElement mensaje = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
            String textoConfirmacion = mensaje.getText();

            System.out.println("Mensaje: " + textoConfirmacion);

            // Se validó que al completar el formulario con campos de texto,
            // contraseña y área de texto, y presionar el botón de envío, procesa la solicitud.
            if (textoConfirmacion.equals("Received!")) {
                System.out.println("Prueba exitosa");
            } else {
                System.out.println("Prueba fallida");
            }
        } finally {
            // driver.quit();
        }
    }
}