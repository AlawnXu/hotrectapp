package com.anyapps.hotapp.utils;

import java.io.IOException;
import java.io.InputStream;

/**
 * 文件操作帮助类
 * Created by alawn.xu on 2018/10/8.
 */
public final class FileUtils {

    private FileUtils() throws InstantiationException {
        throw new InstantiationException("This utility class is not created for instantiation");
    }

    /**
     * 关闭输入流
     *
     * @param is
     */
    public static void closeInputStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

