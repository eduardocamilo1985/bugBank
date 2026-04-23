package util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.github.javafaker.Faker;

import io.qameta.allure.Allure;


public class Util {
	
	public static Faker faker = new Faker();
	
	public String generateName() {
		System.out.println("O nome � "+faker.name().fullName());
		return faker.name().fullName();
	}
	
	public String generateEmail() {
		String mailComplet="";
		mailComplet=faker.name().firstName()+"@ecs.com.br";
		System.out.println("O e-mail � "+mailComplet);
		return mailComplet.trim();
		
		
	}
	
	public static String getDateTime() {
		Date date = Calendar.getInstance().getTime();

		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss");
		String today = formatter.format(date);
		return today;
	}
	
	//##############################
	/*
	public static void savePageScreenshot(WebDriver webDriver, Path path) {
        File screenshotFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(screenshotFile.toPath(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("Can't copy the screenshot file:" + e.getMessage());
        }
    }

    public static void saveElementScreenshot(WebElement webElement, Path path) {
        File screenshotFile = webElement.getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(screenshotFile.toPath(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println("Can't copy the screenshot file:" + e.getMessage());
        }
    }

    public static void attachPageScreenshot(WebDriver webDriver, String name) {
        byte[] screenshotBytes = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
        Allure.attachment(name, new ByteArrayInputStream(screenshotBytes));
    }

    public static void attachElementScreenshot(WebElement webElement, String name) {
        byte[] screenshotBytes = webElement.getScreenshotAs(OutputType.BYTES);
        Allure.attachment(name, new ByteArrayInputStream(screenshotBytes));
    }*/

}
