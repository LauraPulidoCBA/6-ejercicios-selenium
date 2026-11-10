import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Ejercicio4 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            driver.get("https://demoqa.com/buttons");
            driver.manage().window().maximize();

            WebElement botonDobleClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("doubleClickBtn")));

            Actions acciones = new Actions(driver);
            acciones.doubleClick(botonDobleClick).perform();

            WebElement mensajeResultado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("doubleClickMessage")));
            String textoResultado = mensajeResultado.getText();

            System.out.println("Mensaje: " + textoResultado);

            // Se evaluó la interacción que a doble clic utilizando la clase Actions
            // sobre el botón específico.
            if (textoResultado.contains("You have done a double click")) {
                System.out.println("Prueba exitosa");
            } else {
                System.out.println("Prueba fallida");
            }
        } finally {
            // driver.quit();
        }
    }
}