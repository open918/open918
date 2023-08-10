package org.open918.lib.domain.uic918_3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joel Haasnoot on 26/04/15.
 */
public class TicketContents extends TicketBlock {

    private String standard;
    private int numberOfFields;
    private List<TicketField> fields = new ArrayList<>();

    private String rawContents;

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

    public String getRawContents() {
        return rawContents;
    }

    public void setRawContents(String rawContents) {
        this.rawContents = rawContents;
    }
}
