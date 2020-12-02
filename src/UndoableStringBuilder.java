import java.util.Stack;

public class UndoableStringBuilder {
    private StringBuilder stringBuilder;
    private Stack<Action> undoActions;

    public UndoableStringBuilder(){
        stringBuilder = new StringBuilder();
        undoActions = new Stack<>();
    }

    public UndoableStringBuilder(int capacity){
        stringBuilder = new StringBuilder(capacity);
        undoActions = new Stack<>();
    }

    public UndoableStringBuilder(String str){
        stringBuilder = new StringBuilder(str);
        undoActions = new Stack<>();
    }

    public UndoableStringBuilder(CharSequence seq){
        stringBuilder = new StringBuilder(seq);
        undoActions = new Stack<>();
    }

    public UndoableStringBuilder reverse(){
        undoActions.push(() -> stringBuilder.reverse());
        stringBuilder.reverse();
        return this;
    }

    public UndoableStringBuilder append(String str){
        undoActions.push(() -> stringBuilder.delete(stringBuilder.length() - str.length(), stringBuilder.length()));
        stringBuilder.append(str);
        return this;
    }

    public UndoableStringBuilder delete(int start, int end){
        String sbString = stringBuilder.substring(start, end);
        undoActions.push(() -> stringBuilder.insert(start, sbString));
        stringBuilder.delete(start, end);
        return this;
    }

    public UndoableStringBuilder insert(int offset, String str){
        undoActions.push(() -> stringBuilder.delete(offset, str.length() + 2));
        stringBuilder.insert(offset, str);
        return this;
    }

    public UndoableStringBuilder deleteCharAt(int index){
        char ch = stringBuilder.charAt(index);
        undoActions.push(() -> stringBuilder.insert(index, ch));
        stringBuilder.deleteCharAt(index);
        return this;
    }

    public UndoableStringBuilder setCharAt(int index, char ch){
        char charOnIndex = stringBuilder.charAt(index);
        undoActions.push(() -> stringBuilder.setCharAt(index, charOnIndex));
        stringBuilder.setCharAt(index, ch);
        return this;
    }

    public UndoableStringBuilder undo(){
        if(!undoActions.empty()) undoActions.pop().undo();
        return this;
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }

    interface Action{
        void undo();
    }
}

class Test{
    public static void main(String[] args){
        UndoableStringBuilder undoableStringBuilder = new UndoableStringBuilder("123456789abcdef");
        System.out.println(undoableStringBuilder.setCharAt(5, '@'));
        System.out.println(undoableStringBuilder.reverse());
        System.out.println(undoableStringBuilder.delete(3, 6));
        System.out.println(undoableStringBuilder.insert(2, "#$%^&*()"));
        System.out.println(undoableStringBuilder.undo());
        System.out.println(undoableStringBuilder.undo());
        System.out.println(undoableStringBuilder.undo());
        System.out.println(undoableStringBuilder.undo());
        System.out.println(undoableStringBuilder.undo());
    }
}
