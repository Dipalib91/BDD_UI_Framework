package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class ConfigReader {
	private Properties properties;
	private static final Map<String, String> ConfigMap = new HashMap<>();
	
	public Properties initProperties() {
		properties = new Properties();
		
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/Config.properties");
			properties.load(ip);
			for (Map.Entry<Object, Object> entry : properties.entrySet()) {
				ConfigMap.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return properties;
	}
	public static String get(String key) throws Exception {
		if (Objects.isNull(key) || Objects.isNull(ConfigMap.get(key))) {
			throw new Exception("property name " + key + " is not found. Please check config.properties file");
		}
		return ConfigMap.get(key).trim();
	}

}
