package org.open918.lib.domain;

import java.util.ArrayList;
import java.util.List;

public class Ticket {

    private String messageType;
    private int messageTypeVersion;
    private int ricsCode;
    private String signatureKeyId;
    private String signature;
    private int messageLength;
    private byte[] compressedMessage;
    private byte[] message;

    private TicketHeader header = new TicketHeader();
	private TicketContents contents = new TicketContents();

	private List<TicketBlock> blocks = new ArrayList<>();

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public int getMessageTypeVersion() {
		return messageTypeVersion;
	}

	public void setMessageTypeVersion(int messageTypeVersion) {
		this.messageTypeVersion = messageTypeVersion;
	}

	public int getRicsCode() {
		return ricsCode;
	}

	public void setRicsCode(int ricsCode) {
		this.ricsCode = ricsCode;
	}

	public String getSignatureKeyId() {
		return signatureKeyId;
	}

	public void setSignatureKeyId(String signatureKeyId) {
		this.signatureKeyId = signatureKeyId;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public int getMessageLength() {
		return messageLength;
	}

	public void setMessageLength(int messageLength) {
		this.messageLength = messageLength;
	}

	public byte[] getCompressedMessage() {
		return compressedMessage;
	}

	public void setCompressedMessage(byte[] compressedMessage) {
		this.compressedMessage = compressedMessage;
	}

	public byte[] getMessage() {
		return message;
	}

	public void setMessage(byte[] message) {
		this.message = message;
	}

	public TicketHeader getHeader() {
		return header;
	}

	public void setHeader(TicketHeader header) {
		this.header = header;
	}

	public TicketContents getContents() {
		return contents;
	}

	public void setContents(TicketContents contents) {
		this.contents = contents;
	}

	public List<TicketBlock> getBlocks() {
		return blocks;
	}
}
