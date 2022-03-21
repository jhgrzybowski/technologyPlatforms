package Message;

import java.io.Serial;
import java.io.Serializable;

public class Message implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private int number;
    private String content;

    public Message(int i, String s) {
        this.number = i;
        this.content = s;
    }

    public int getNumber() { return number; }

    public String getContent() { return content; }

    @Override
    public String toString() {
        return "Message{" +
                "number=" + number +
                ", content='" + content + '\'' +
                '}';
    }
}
