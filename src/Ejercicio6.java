import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Ejercicio6 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
            driver.manage().window().maximize();

            wait.until(ExpectedConditions.elementToBeClickable(By.id("reveal"))).click();

            WebElement campoRevelado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("revealed")));

            String textoPrueba = "Prueba Selenium ADSO";
            campoRevelado.sendKeys(textoPrueba);

            String valorEscrito = campoRevelado.getDomProperty("value");
            System.out.println("Valor detectado en el campo: " + valorEscrito);

            // Se comprobó la interacción con un elemento inicialmente oculto que se revela
            // tras hacer clic en el botón dinámico

            if (valorEscrito.equals(textoPrueba)) {
                System.out.println("Prueba exitosa: El texto se escribió correctamente en el campo dinámico.");
            } else {
                System.out.println("Prueba fallida: El texto no coincide.");
            }

            File captura = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destino = new File("evidencia_selenium.png");
            FileHandler.copy(captura, destino);
            System.out.println("Captura guardada con éxito en: " + destino.getAbsolutePath());

        } catch (Exception e) {
            System.out.println("Error durante la prueba: " + e.getMessage());
        } finally {
            // driver.quit();
        }
    }
}