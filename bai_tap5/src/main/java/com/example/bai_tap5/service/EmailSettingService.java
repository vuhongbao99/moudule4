package com.example.bai_tap5.service;

import com.example.bai_tap5.entity.EmailSetting;
import org.springframework.stereotype.Service;

@Service

public class EmailSettingService implements IEmailSettingService {
    private EmailSetting currentSetting = new EmailSetting("English", 25, true, "King, Asgard");

    @Override
    public EmailSetting getSetting() {
        return null;
    }

    @Override
    public void update(EmailSetting setting) {
        this.currentSetting = setting;
    }
}
