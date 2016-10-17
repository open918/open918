package org.open918.lib.encodings;

import org.open918.lib.domain.GenericTicketDetails;
import org.open918.lib.domain.TicketField;
import org.open918.lib.util.ConverterUtil;

import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Converter for the UIC RCT2 standard for tickets. Most UIC 918.2 tickets will conform to this standard
 */
public class Rct2Converter extends TicketConverter {

    private static final int TICKET_LINE_LENGTH = 72;
    private static final int TICKET_LINES = 18 + 1;

    private final boolean appendUicLines;

    /**
     * @param fields input for this converter in the form of TicketsFields obtained from the UicTicketParser
     */
    public Rct2Converter(List<TicketField> fields) {
        super(fields);
        this.appendUicLines = true;
    }

    /**
     * @param fields input for this converter in the form of TicketsFields obtained from the UicTicketParser
     * @param appendUicLines true if arrows, 'date', 'time', and 'class' labels) should be added when ticket is converted to a text representation
     */
    public Rct2Converter(List<TicketField> fields, boolean appendUicLines) {
        super(fields);
        this.appendUicLines = appendUicLines;
    }

    @Override
    public String toText() {
        StringBuffer lines = new StringBuffer();

        // Initialize
        for (int i = 0; i < TICKET_LINES; i++) {
            lines.append('|');
            char repl = ' ';
            if (i == 0 || i == TICKET_LINES - 1) {
                repl = '-';
            }
            lines.append(CharBuffer.allocate(TICKET_LINE_LENGTH - 2).toString().replace('\0', repl));
            lines.append("|\r\n");
        }

        if (appendUicLines) {
            appendUicTicketLines(lines);
        }

        for (TicketField f : fields) {
            addField(lines, f.getLine(), f.getColumn(), f.getText(), f.getLength());
        }

        return lines.toString();
    }

    @Override
    public GenericTicketDetails toDetails() {
        GenericTicketDetails ticket = new GenericTicketDetails();
        ticket.setTicketTitle(findField(0, 19, 51));
        ticket.setValidity(findField(3, 19, 51));
        ticket.setPassengerName(findField(0, 53, 71));

        ticket.setOutwardDeparture(findField(6, 14, 32));
        ticket.setOutwardArrival(findField(6, 36, 51));

        ticket.setReturnDeparture(findField(7, 14, 32));
        ticket.setReturnArrival(findField(7, 36, 51));

        ticket.setTravelClass(findField(6, 67, 71));

        ticket.setRouteDetails(findField(12, 1, 51) + " " + findField(13, 1, 51) + " " + findField(14, 1, 51));

        ticket.setPrice(findField(13, 57, 71).replace('*', ' '));

        return ticket;
    }

    private String findField(int line, int column, int column_end) {
        ArrayList<TicketField> matches = new ArrayList<>();
        for (TicketField f : fields) {
            if (f.getLine() == line && ConverterUtil.isBetween(column, column_end, f.getColumn(), f.getColumn() + f.getLength())) {
                matches.add(f);
            }
        }

        if (matches.size() == 0) {
            return "";
        }

        // Sort by start column
        Collections.sort(matches, new Comparator<TicketField>() {
            @Override
            public int compare(TicketField o1, TicketField o2) {
                return o1.getColumn() - o2.getColumn();
            }
        });

        // Join text
        // TODO: Split optional beginning and end off
        StringBuilder sb = new StringBuilder();
        for (TicketField f : matches) {
            sb.append(f.getText());
        }
        return sb.toString();
    }

    /*
    Add lines normally printed on card stock
     */
    private void appendUicTicketLines(StringBuffer lines) {
        addField(lines, 5, 2, "DATE");
        addField(lines, 5, 8, "TIME");
        addField(lines, 5, 14, "FROM");
        addField(lines, 5, 33, ">");
        addField(lines, 7, 33, ">");
        addField(lines, 8, 33, ">");
        addField(lines, 5, 35, "TO");

        addField(lines, 5, 53, "DATE");
        addField(lines, 5, 59, "TIME");

        addField(lines, 5, 66, "CLASS");
    }

    private void addField(StringBuffer buffer, int line, int column, String text) {
        addField(buffer, line, column, text, text.length());
    }

    private void addField(StringBuffer buffer, int line, int column, String text, int length) {
        int offset = (line + 1) * (TICKET_LINE_LENGTH + 2) + column;
        buffer.replace(offset, offset + length, text);
    }

}
