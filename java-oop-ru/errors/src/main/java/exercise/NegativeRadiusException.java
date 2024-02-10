package exercise;

// BEGIN
class NegativeRadiusException extends Exception {
    public String fieldName;

    public NegativeRadiusException(String fieldName) {
        this.fieldName = fieldName;
    }
}
// END
