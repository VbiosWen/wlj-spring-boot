package org.geeksword.springboot.util.reflection;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;

/**
 * @author vbiso
 * @see
 */
@Slf4j
public class StandardClassLoader extends ClassLoader {

    private String filePath;

    private String jarPath;

    private static Map<String, byte[]> CLASS_CACHE_MAP = Maps.newConcurrentMap();

    public StandardClassLoader(String path) {
        if (path.endsWith(".jar")) {
            this.jarPath = path;
        } else {
            this.filePath = path;
        }
        preLoadFileClass(filePath);
        preLoadJarClass(jarPath);
    }

    private void preLoadJarClass(String jarPath) {
        if (StringUtils.isBlank(jarPath)) {
            return;
        }
    }

    private void preLoadFileClass(String filePath) {
        if (StringUtils.isBlank(filePath)) {
            return;
        }
        Path path = Paths.get(filePath);
        File file = path.toFile();
        scanFile(file);
    }

    private void scanFile(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (Objects.isNull(files)) {
                return;
            }
            for (File file1 : files) {
                scanFile(file1);
            }
        } else if (file.isFile() && file.getName().endsWith(".class")) {
            byte[] bytes = readFile(file);
            String path = file.getPath();
        }
    }

    private byte[] readFile(File file) {
        InputStream inputStream = null;
        ByteArrayOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(file);
            outputStream = new ByteArrayOutputStream();
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            int bufferIndex = 0;
            while ((bufferIndex = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bufferIndex);
            }
            return outputStream.toByteArray();
        } catch (IOException e) {
            log.error("");
        } finally {
            if (Objects.nonNull(inputStream)) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.error("");
                }
            }
        }
        return null;
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }

    public static void main(String[] args){
        StandardClassLoader classLoader = new StandardClassLoader("/Users/wenliujie/IdeaProjects/btime.webser.mall");

    }
}
