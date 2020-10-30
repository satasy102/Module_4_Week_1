package com.chanhtin.service;

import com.chanhtin.model.MailSetting;

import java.util.List;


public interface MailSettingService {

    List<MailSetting> findAll();

    MailSetting save(MailSetting mailSetting);


}
