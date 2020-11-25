package reflectionexample.rabbit;

public class Rabbit {

    @Deprecated
    @RabbitAnnotation
    private String rabbitName;

    @Deprecated
    private String rabbitAge;

    public String getRabbitName() {
        return rabbitName;
    }

    public String getRabbitAge() {
        return rabbitAge;
    }
}
