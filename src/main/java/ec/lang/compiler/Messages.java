package ec.lang.compiler;

import java.util.ArrayList;
import java.util.List;



public class Messages {
    enum MessageType {info, warning, error}

    class Message {
        String message;
        MessageType messageType;

        public Message(String message, MessageType messageType) {
            this.message = message;
            this.messageType = messageType;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getEnclosingInstance().hashCode();
            result = prime * result + ((message == null) ? 0 : message.hashCode());
            result = prime * result + ((messageType == null) ? 0 : messageType.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Message other = (Message) obj;
            if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
                return false;
            if (message == null) {
                if (other.message != null)
                    return false;
            } else if (!message.equals(other.message))
                return false;
            if (messageType != other.messageType)
                return false;
            return true;
        }

        private Messages getEnclosingInstance() {
            return Messages.this;
        }
    
    }

    public static final Messages MESSAGES = new Messages();



    private final List<Message> messages  = new ArrayList<>();
    
    private String typeText(MessageType messageType) {
        if (messageType == MessageType.info) {
            return "[info] ";
        } else if (messageType == MessageType.warning) {
            return "[warning] ";
        } else {
            return "[error] ";
        }
    }

    public void printMessages() {
        for (Message msg : messages) {
            System.out.println(typeText(msg.messageType) + msg.message);
        }
    }

    public void addInfo(String message) {
        messageAdd(new Message(message, MessageType.info));
    }

    public void addWarning(String message) {
        messageAdd(new Message(message, MessageType.warning));
    }

    public void addError(String message) {
        messageAdd(new Message(message, MessageType.error));
    }

    private void messageAdd(Message message) {
        if (!messages.contains(message)) {
            messages.add(message);
        }
    }
}