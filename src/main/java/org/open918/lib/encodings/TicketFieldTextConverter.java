package org.open918.lib.encodings;

/**
 * Convert the ticket fields in a UIC 918-2 ticket to a text representation
 * as it would be printed on card stock
 */
public interface TicketFieldTextConverter {

    public String toText();
}
