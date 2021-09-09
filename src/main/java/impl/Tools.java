package impl;

public class Tools {
    public static <T> T ToDo() {
        return ToDo(null);
    }

    public static <T> T ToDo(String message) {
        throw new TODO(message != null ? message : "Not Implemented");
    }
}

