package contants;

import lombok.Getter;

import java.util.Objects;

public class FrameworkContants {

    private static FrameworkContants frameworkContants;
    private static final String resourcePath = System.getProperty("user.dir") + "/src/main/resources/";
    private @Getter
    final String configFile = resourcePath + "config.properties";
    private @Getter
    final String apkFilePath = System.getProperty("user.dir") + "/ApiDemos-debug.apk";

    private @Getter final String reportPath = System.getProperty("user.dir") + "/extent-report.html";

    public static synchronized FrameworkContants getInstance() {

        if (Objects.isNull(frameworkContants)) {
            frameworkContants = new FrameworkContants();
        }
        return frameworkContants;
    }
}
