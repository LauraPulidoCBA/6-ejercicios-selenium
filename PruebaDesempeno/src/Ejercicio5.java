import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Ejercicio5 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            driver.get("https://demoqa.com/webtables");
            driver.manage().window().maximize();

            wait.until(ExpectedConditions.elementToBeClickable(By.id("addNewRecordButton"))).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName"))).sendKeys("Carlos");
            driver.findElement(By.id("lastName")).sendKeys("Ramirez");
            driver.findElement(By.id("userEmail")).sendKeys("carlos@gmail.com");
            driver.findElement(By.id("age")).sendKeys("25");
            driver.findElement(By.id("salary")).sendKeys("2500000");
            driver.findElement(By.id("department")).sendKeys("Sistemas");

            driver.findElement(By.id("submit")).click();

            WebElement campoBusqueda = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchBox")));
            campoBusqueda.sendKeys("Carlos");
            campoBusqueda.sendKeys(Keys.ENTER);

            WebElement filaResultado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Carlos')]")));
            String textoFila = filaResultado.getText();

            System.out.println("Registro: " + textoFila);

            // Se verificó que tras registrar un nuevo usuario en la tabla y utilizar
            // el filtro de búsqueda por nombre, el sistema localiza correctamente la fila.
            if (textoFila.contains("Carlos") && textoFila.contains("Ramirez") && textoFila.contains("carlos@gmail.com")) {
                System.out.println("Prueba exitosa");
            } else {
                System.out.println("Prueba fallida");
            }
        } finally {
            // driver.quit();
        }
    }
}
