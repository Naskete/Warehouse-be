package com.naskete.manage.service.Imp;

import com.naskete.manage.dao.BackupDao;
import com.naskete.manage.entity.Backup;
import com.naskete.manage.service.BackupService;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Component
public class BackupServiceImp implements BackupService {
    private BackupDao backupDao;
    @Override
    public boolean backup() {
        Runtime runtime = Runtime.getRuntime();
        String cmd = getCommand();
        boolean ret = false;
        try {
            runtime.exec(cmd);
            ret = true;
        } catch (IOException e) {
            e.printStackTrace();
            ret = false;
        }
        return ret;
    }

    private String getCommand() {
        Backup backup = new Backup();
        StringBuilder cmd = new StringBuilder();
        String username = "root";
        String password = "123123";
        String host = "127.0.0.1";
        String port = "3306";
        String dbName = "store";
        Date cur = new Date();
        String date = getDate(cur);
        String savePath = "D:/";
        String fileName = date + "-" + dbName + ".sql";
        cmd.append("mysqldump -u").append(username).append(" -p").append(password)
                .append(" -h").append(host).append(" -P").append(port).append(" ").append(dbName)
                .append(" -r ").append(savePath).append(fileName);
        backup.setCmd(cmd.toString());
        backup.setIp(host);
        backup.setPort(port);
        backup.setCmd(username);
        backup.setDbName(dbName);
        backup.setFilePath(savePath);
        backup.setFileName(fileName);
        backup.setCreatTime(cur);
        backupDao.save(backup);
        return cmd.toString();
    }

    private String getDate(Date date) {
        String dataString = new SimpleDateFormat("yyyyMMddHHmmss").format(date);
        System.err.println(dataString);
        return dataString;
    }
}
