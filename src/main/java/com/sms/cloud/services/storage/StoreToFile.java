package com.sms.cloud.services.storage;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class StoreToFile {

    public void storeToFile(String data) {
        try {
            String path = this.getClass().getResource("/smsdata.txt").getPath();
            File file = new File(path);
            FileUtils.write(file, data, "UTF-8", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getDataFromFile() {
        try {
            String path = this.getClass().getResource("/smsdata.txt").getPath();
            File file = new File(path);
            return FileUtils.readFileToString(file, "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
