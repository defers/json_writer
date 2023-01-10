import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class FileJsonObjectWriter implements JsonObjectWriter {

    private StringBuilder jsonString;

    private FileJsonObjectWriter() {
    }

    public static FileJsonObjectWriter newFileJsonObjectWriter() {
        return new FileJsonObjectWriter();
    }

    @Override
    public void writeJson(Object object) throws IllegalAccessException {
        jsonString = new StringBuilder();
        String resultJsonString = getJsonStringFromObject(object);
        System.out.println(resultJsonString);
    }

    private String getJsonStringFromObject(Object object) throws IllegalAccessException {
        fillStringBuilderFromObject(object);

        return this.jsonString.toString();
    }

    private void fillStringBuilderFromObject(Object object) throws IllegalAccessException {
        addStartJson();
        addAllFields(object);
        addEndJson();
    }

    private void addAllFields(Object object) throws IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];

            addQuot();
            addFieldName(field);
            addQuot();
            addDelimeter();
            addFieldValue(field, object);

            if (i < fields.length-1) {
                addComma();
            }
        }
    }

    private void addFieldValue(Field field, Object object) throws IllegalAccessException {
        field.setAccessible(true);
        String fieldType = field.getType().getName();
        if (fieldType.equals(long.class.getName())) {
            jsonString.append(field.getLong(object));
        }
        else if (fieldType.equals(int.class.getName())) {
            jsonString.append(field.getInt(object));
        }
        else if (fieldType.equals(String.class.getName())) {
            addQuot();
            jsonString.append(field.get(object));
            addQuot();
        }
        else if (field.getType().isArray()) {
            addArrayStart();

            Object arr = field.get(object);
            int length = Array.getLength(arr);

            for (int i = 0; i < length; i++) {
                Object element = Array.get(arr, i);
                addFieldValue(element.getClass().getName(), element);
                if (i < length-1) {
                    addComma();
                }
            }
            addArrayEnd();
        }
        else {
            fillStringBuilderFromObject(field.get(object));
        }
    }

    private void addFieldValue(String fieldType, Object value) {
        if (fieldType.equals(String.class.getName())) {
            addQuot();
            jsonString.append(value);
            addQuot();
        }
        else {
            jsonString.append(value);
        }
    }

    private void addDelimeter() {
        jsonString.append(JsonMarks.DELIMETER.getValue());
    }

    private void addFieldName(Field field) {
        jsonString.append(field.getName());
    }

    private void addStartJson() {
        jsonString.append(JsonMarks.START.getValue());
    }

    private void addEndJson() {
        jsonString.append(JsonMarks.END.getValue());
    }

    private void addComma() {
        jsonString.append(JsonMarks.COMMA.getValue());
    }

    private void addQuot() {
        jsonString.append(JsonMarks.QUOT.getValue());
    }

    private void addArrayStart() {
        jsonString.append(JsonMarks.STARTARRAY.getValue());
    }

    private void addArrayEnd() {
        jsonString.append(JsonMarks.ENDARRAY.getValue());
    }

}
