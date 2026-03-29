package chapter07;

public enum EnumClass {
}

enum SeasonYear {
    SUMEMR, FALL, WINTER, SPRING;

    String getWeather(SeasonYear value) {
        return switch (value) {
            case SUMEMR -> "Hot";
            case FALL -> "Cool";
            case WINTER -> "Cold";
            case SPRING -> "Mild";
        };
    }
}

class MyClas {

    public static void main(String[] args) {
        SeasonYear oneSeason = SeasonYear.SUMEMR;
        System.out.println(oneSeason.getWeather(oneSeason));
        System.out.println("The current season is: " + oneSeason);

        for (var season : SeasonYear.values()) {
            System.out.println(season.name() + " " + season.ordinal());
        }
        System.out.println(SeasonYear.valueOf("FALL"));
        //System.out.println(SeasonYear.getWeather(SeasonYear.FALL));

    }
}

interface ForEnum {
    int modifyValeu(int value);


}

enum ComplexEnum implements ForEnum {


    MONDAY(1, "worst day") {
        public void getDay() {
            System.out.println("Monday is the first day of the week.");
        }
    }, TUESDAY(2, "second worst day") {
        public void getDay() {
            System.out.println("Tuesday is the second day of the week.");
        }
    }, WEDNESDAY {
        public void getDay() {
            System.out.println("Tuesday is the second day of the week.");
        }
    }, THURSDAY {
        public void getDay() {
            System.out.println("Tuesday is the second day of the week.");
        }
    }, FRIDAY {
        public void getDay() {
            System.out.println("Tuesday is the second day of the week.");
        }
    }, SATURDAY{
        public void getDay() {
            System.out.println("Tuesday is the second day of the week.");
        }
    }, SUNDAY {
        public void getDay() {
            System.out.println("Tuesday is the second day of the week.");
        }
    };
    public int value;
    public String description;

    ComplexEnum() {
        this(1, "default");
        //System.out.println("Constructor of ComplexEnum called for " + this.name());
    }

    ComplexEnum(int valuer, String description) {
        this.value = valuer;
        this.description = description;
        //System.out.println(value);
        //System.out.println("Overloaded constructor of ComplexEnum called for " + this.name() + " with value: " + value);
    }

    @Override
    public int modifyValeu(int value) {
        return value + 1;
    }

    public abstract void getDay();

    public int getValue(){
        return value;
    }
    public String getDescription(){
        return description;
    }
}

class TestComplexEnum {
    public static void main(String[] args) {
        ComplexEnum monday = ComplexEnum.MONDAY;
        System.out.println(ComplexEnum.THURSDAY);
        ComplexEnum.SUNDAY.getDay();
        System.out.println(ComplexEnum.SUNDAY.getDescription());
        System.out.println(ComplexEnum.SUNDAY.getValue());
        ComplexEnum.SUNDAY.getDay();
        //System.out.println("The current day is: " + day);
        //System.out.println("Modified value: " + day.modifyValeu());
    }
}