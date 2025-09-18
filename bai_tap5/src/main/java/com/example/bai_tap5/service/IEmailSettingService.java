package com.example.bai_tap5.service;

import com.example.bai_tap5.entity.EmailSetting;

public interface IEmailSettingService {
    EmailSetting getSetting();
    void update(EmailSetting setting);
}
