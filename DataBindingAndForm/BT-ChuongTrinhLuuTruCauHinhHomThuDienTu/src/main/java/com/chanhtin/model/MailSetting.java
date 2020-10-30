package com.chanhtin.model;

public class MailSetting implements Cloneable {
    private Long id;
    private String language;
    private int pageSize;
    private boolean spamFilter;
    private String signature;

    public MailSetting() {
    }

    public MailSetting(String language, int pageSize, boolean spamFilter, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.spamFilter = spamFilter;
        this.signature = signature;
    }

    public MailSetting(Long id, String language, int pageSize, boolean spamFilter, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.spamFilter = spamFilter;
        this.signature = signature;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isSpamFilter() {
        return spamFilter;
    }

    public void setSpamFilter(boolean spamFilter) {
        this.spamFilter = spamFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public MailSetting clone() {
        MailSetting mailSetting = new MailSetting();
        mailSetting.setId(id);
        mailSetting.setLanguage(language);
        mailSetting.setPageSize(pageSize);
        mailSetting.setSpamFilter(spamFilter);
        mailSetting.setSignature(signature);
        return mailSetting;
    }
}
