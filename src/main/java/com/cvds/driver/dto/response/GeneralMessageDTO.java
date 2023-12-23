package com.cvds.driver.dto.response;

import lombok.ToString;

@ToString
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
}
