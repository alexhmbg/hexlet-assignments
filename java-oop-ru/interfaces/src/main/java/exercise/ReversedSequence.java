package exercise;

// BEGIN
class ReversedSequence implements CharSequence {
    CharSequence string;
    ReversedSequence(CharSequence string) {
        StringBuilder result = new StringBuilder();

        for (var i = string.length() - 1; i >= 0; i--) {
            result.append(string.charAt(i));
        }

        this.string = result;
    }

    public int length() {
        return string.length();
    }

    public char charAt(int index) {
        return string.charAt(index);
    }

    public CharSequence subSequence(int start, int end) {
        return string.subSequence(start, end);
    }

    public String toString() {
        return String.valueOf(string);
    }
}
// END
