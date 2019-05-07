package wrikeTests.enums;

public enum QASectionElements {
    VERY_INTERESTED(0),
    JUST_LOOKING(1),

    ONE_TO_FIVE(0),
    SIX_TO_FIFTEEN(1),
    SIXTEEN_TO_TWENTY(2),
    TWENTY_SIX_TO_FIFTY(3),
    MORE_THAN_FIFTY(4),

    YES(0),
    NO(1),
    OTHER(2),
    ;

    public int number;

    QASectionElements(int number) {
        this.number = number;
    }
}
