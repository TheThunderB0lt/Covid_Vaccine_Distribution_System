package com.cvds.driver.dto.response;

public class GeneralMessageDTO {
    String mmsg;

    public GeneralMessageDTO() {
    }

    public GeneralMessageDTO(String mmsg) {
        this.mmsg = mmsg;
    }

    public String getMmsg() {
        return mmsg;
    }

    public void setMmsg(String mmsg) {
        this.mmsg = mmsg;
    }

    @Override
    public String toString() {
        return "GeneralMessageDTO{" +
                "mmsg='" + mmsg + '\'' +
                '}';
    }
}
