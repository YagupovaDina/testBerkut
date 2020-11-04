public class Main {
    public static void main(String[] args) {
        PersonalData pd1 = new PersonalData("horse", "horse", "horse");
        PersonalData pd2 = new PersonalData("ohsroe", "horse", "horse");
        EqualsUtils eq = new EqualsUtils();
        eq.setStr1(pd1.getFirstName());
        eq.setStr2(pd2.getFirstName());
        eq.getMetricDamerauLevenstain();
        eq.setStr1(pd1.getSecondName());
        eq.setStr2(pd2.getSecondName());
        eq.getMetricDamerauLevenstain();
        eq.setStr1(pd1.getPatronymicName());
        eq.setStr2(pd2.getPatronymicName());
        eq.getMetricDamerauLevenstain();
        System.out.println(eq.isValid());

    }
}
