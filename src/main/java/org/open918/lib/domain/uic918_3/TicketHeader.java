package org.open918.lib.domain.uic918_3;

import java.util.Date;
import java.util.EnumSet;

/**
 * Created by Joel Haasnoot on 26/04/15.
 */
public class TicketHeader extends TicketBlock {

    String language;
    String language2;
    long creationDate;
    int carrier;
    String orderNumber;
    EnumSet<TicketFlag> flags;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage2() {
        return language2;
    }

    public void setLanguage2(String language2) {
        this.language2 = language2;
    }

    public long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(long creationDate) {
        this.creationDate = creationDate;
    }

    public Date getCreationDateAsDate() {
        Date d = new Date();
        d.setTime(creationDate);
        return d;
    }

    public int getCarrier() {
        return carrier;
    }

    public void setCarrier(int carrier) {
        this.carrier = carrier;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public EnumSet<TicketFlag> getFlags() {
        return flags;
    }

    public void setFlags(EnumSet<TicketFlag> flags) {
        this.flags = flags;
    }
}
