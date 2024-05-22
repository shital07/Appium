package utils;

import contants.FrameworkContants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class ReadConfig {


    private static final Properties properties = new Properties();
    private static final Map<String, String> mp = new HashMap<>();

    private ReadConfig() {

    }

    static {
        try (BufferedReader reader = new BufferedReader(new FileReader(FrameworkContants.getInstance().getConfigFile()))) {
            properties.load(reader);
            properties.forEach((key, value) -> mp.put(String.valueOf(key), String.valueOf(value)));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }


    public static String getProperty(String key) {

        return mp.get(key);
    }

}
