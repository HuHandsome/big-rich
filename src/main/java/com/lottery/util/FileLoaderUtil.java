package com.lottery.util;

import java.io.IOException;
import java.net.URL;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

public class FileLoaderUtil {
    public static String loadFileAsString(String location) throws IOException{
        URL url = Resources.getResource(location);
        String json = Resources.toString(url, Charsets.UTF_8);
        return json;
    }
}
