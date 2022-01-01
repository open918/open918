package org.open918.lib.encodings;

import org.open918.lib.domain.GenericTicketDetails;
import org.open918.lib.domain.uic918_3.TicketField;

import java.util.List;

/**
 * Generic implementation of a ticket converter that stores fields for use in a converter
 */
public abstract class TicketConverter implements TicketFieldTextConverter, TicketFieldDetailsConverter {

    protected List<TicketField> fields;

    public TicketConverter(List<TicketField> fields) {
        this.fields = fields;
    }

    @Override
    public abstract GenericTicketDetails toDetails();

    @Override
    public abstract String toText();
}
