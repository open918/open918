package org.open918.lib.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joel Haasnoot on 26/04/15.
 */
public class TicketContents extends TicketBlock {

    String standard;
    int numberOfFields;
    List<TicketField> fields = new ArrayList<>();

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public int getNumberOfFields() {
        return numberOfFields;
    }

    public void setNumberOfFields(int numberOfFields) {
        this.numberOfFields = numberOfFields;
    }

    public List<TicketField> getFields() {
        return fields;
    }

    public void setFields(List<TicketField> fields) {
        this.fields = fields;
    }
}
