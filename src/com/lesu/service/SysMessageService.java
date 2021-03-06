package com.lesu.service;

import com.lesu.bean.SysMessage;
import com.lesu.dao.sysmessageDao.SysMessageDao;
import com.lesu.dao.sysmessageDao.SysMessageDaoImpl;

import java.sql.Connection;

/**
 * The service layer for System message
 */
public class SysMessageService {
    private Connection connection;

    public SysMessageService(Connection connection) {
        this.connection = connection;
    }

    public boolean deleteMessage(int myUid, int messageID) {
        SysMessageDao sysMessageDao = new SysMessageDaoImpl(connection);
        SysMessage sysMessageToBeDeleted = sysMessageDao.getMessage(messageID);

        if (sysMessageToBeDeleted == null) return false;
        if (sysMessageToBeDeleted.getReceiverUID() != myUid) return false;

        return sysMessageDao.deleteMessage(messageID);

    }
}
