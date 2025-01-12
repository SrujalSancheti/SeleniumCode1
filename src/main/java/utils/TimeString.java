package utils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeString {
	String str = LocalDateTime.now().toString();
	Matcher matcher = (Matcher) Pattern.compile("[0-9]").matcher(str);
	StringBuilder result = new StringBuilder();
	public String currentTimeString() {
		while(matcher.find()) {
			result.append(matcher.group());
		}
		return result.toString();
	}
}
