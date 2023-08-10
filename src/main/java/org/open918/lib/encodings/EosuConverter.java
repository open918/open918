package org.open918.lib.encodings;

import org.open918.lib.domain.GenericTicketDetails;
import org.open918.lib.domain.uic918_3.TicketField;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Converter for the 'EOSU' standard - used in Hamburg by transport company HVV (and others?)
 * Only one sample was available for this type of ticket, support is limited
 */
public class EosuConverter extends TicketConverter {

    public EosuConverter(List<TicketField> fields) {
        super(fields);
    }

    @Override
    public String toText() {
        StringBuilder lines = new StringBuilder();

        Collections.sort(fields, new TicketFieldLineComparator());

        for (TicketField f : fields) {
            lines.append(f.getText());
            lines.append("\r\n");
        }

        return lines.toString();
    }

    @Override
    public GenericTicketDetails toDetails() {
        GenericTicketDetails ticket = new GenericTicketDetails();

        for (TicketField f : fields) {
            if (f.getLine() == 0) {
                ticket.setPassengerName(f.getText());
            } else if (f.getLine() == 1) {
                ticket.setTicketTitle(f.getText());
            } else if (f.getLine() == 2) {
                ticket.setRouteDetails(f.getText());
            } else if (f.getLine() == 3) {
                ticket.setValidity(f.getText());
            }
        }

        return ticket;
    }

    private static class TicketFieldLineComparator implements Comparator<TicketField> {
        @Override
        public int compare(TicketField o1, TicketField o2) {
            return o1.getLine() - o2.getLine();
        }
    }
}
