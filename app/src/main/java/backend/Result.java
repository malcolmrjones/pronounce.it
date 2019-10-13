package backend;

public class Result {


    private int numberCorrect;
    private int numberTotalWords;

    public Result(int numberCorrect, int numberTotalWords) {
        this.numberCorrect = numberCorrect;
        this.numberTotalWords = numberTotalWords;
    }

    public int getNumberIncorrect() {
        return numberCorrect;
    }

    public int getNumberTotalWords() {
        return numberTotalWords;
    }





}
