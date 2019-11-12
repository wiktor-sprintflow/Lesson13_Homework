package task04;

class NonPositiveCodeValueException extends RuntimeException {
    NonPositiveCodeValueException() {
        super("Szyfr musi być liczbą dodatnią.");
    }
}
