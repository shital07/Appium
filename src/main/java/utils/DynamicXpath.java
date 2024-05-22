package utils;

public final class DynamicXpath {
    private DynamicXpath(){

    }
    public static String getXpath(String xpath,String replace){

        return String.format(xpath,replace);
    }
}
