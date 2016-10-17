package org.open918.lib.domain;

/**
 * Created by Joel Haasnoot on 26/04/15.
 */
public class TicketField {

    private int line;
    private int column;
    private int height;
    private int width;
    private Rct2Format formatting;
    private int length;
    private String text;

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Rct2Format getFormatting() {
        return formatting;
    }

    public void setFormatting(Rct2Format formatting) {
        this.formatting = formatting;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
