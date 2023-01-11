public interface JsonObjectWriter {
    void writeJson(Object object, String path) throws IllegalAccessException;
}
