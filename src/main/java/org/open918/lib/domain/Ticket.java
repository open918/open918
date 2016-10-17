package org.open918.lib.domain;

public class Ticket {

    String messageType;
    int messageTypeVersion;
    int ricsCode;
    String signatureKeyId;
    String signature;
    int messageLength;
    byte[] compressedMessage;
    byte[] message;

    TicketHeader header = new TicketHeader();
	TicketContents contents = new TicketContents();

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
}
