package org.open918.lib.encodings;

import org.open918.lib.domain.GenericTicketDetails;

/**
 * Convert the ticket fields in a UIC 918-2 ticket to a generic ticket details item
 */
public interface TicketFieldDetailsConverter {

    GenericTicketDetails toDetails();
}
