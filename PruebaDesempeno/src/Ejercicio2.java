import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Ejercicio2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            driver.get("https://demoqa.com/radio-button");
            driver.manage().window().maximize();

            WebElement labelImpressive = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("label[for='impressiveRadio']")));
            labelImpressive.click();

            WebElement mensajeExito = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("text-success")));
            String textoMensaje = mensajeExito.getText();

            System.out.println("Mensaje: " + textoMensaje);

            // Se comprobó que al seleccionar la opción de tipo radio "Impressive", el sistema
            // reconoce la selección e imprime en pantalla un mensaje de confirmación visible.
            if (textoMensaje.equals("Impressive")) {
                System.out.println("Prueba exitosa");
            } else {
                System.out.println("Prueba fallida");
            }
        } finally {
            // driver.quit();
        }
    }
}
