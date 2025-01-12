package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	public static void takeWindowScreenShot(WebDriver driver,String fileName) throws IOException {
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Path directoryPath = Paths.get("screenshots");
		if(!Files.exists(directoryPath)) {
			Files.createDirectory(directoryPath);
		}
		Path destinationPath = FileSystems.getDefault().getPath("screenshots", fileName );
		Files.copy(screenshot.toPath(), destinationPath);
	}
}
