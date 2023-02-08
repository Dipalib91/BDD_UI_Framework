package utils;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;
import java.util.Random;

public class RandomGenerator {
	static Faker faker = new Faker();;

	/**
	 * @param length
	 * @return
	 */
	public static String generateRandomNumber(int length) {
		String string = "123456789";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(string.length());
			char randomChar = string.charAt(index);
			sb.append(randomChar);
		}
		return sb.toString();
	}

	public static String generateRandomFirstName() {
		return faker.name().firstName();
	}

	public static String generateRandomLastName() {
		return faker.name().lastName();
	}

	public static String generateRandomEmail() {
		FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-GB"), new RandomService());
		return fakeValuesService.bothify("????##@gmail.com");
	}

	public static String generateRandomUserName() {
		return faker.name().username();
	}
}
