package com.chanhtin.service.impl;

import com.chanhtin.model.MailSetting;
import com.chanhtin.service.MailSettingService;

import java.util.ArrayList;
import java.util.List;

public class MailSettingServiceIml implements MailSettingService {
    private static List<MailSetting> mailSettings=new ArrayList<>();

    @Override
    public List<MailSetting> findAll() {
        return new ArrayList<>(mailSettings);
    }

    @Override
    public MailSetting save(MailSetting mailSetting) {
        mailSettings.add(mailSetting);
        return mailSetting;
    }


}
