public enum JsonMarks {
    START("{"),
    END("}"),
    COMMA(","),
    DELIMETER(":"),
    QUOT("\""),
    STARTARRAY("["),
    ENDARRAY("]");

    private String value;

    JsonMarks(String value) {
        this.value = value;
    }

    String getValue() {
        return this.value;
    }
}
