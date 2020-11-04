import org.junit.Assert;
import org.junit.Test;


public class EqualsUtilsTest {

    @Test
    public void isDeletedSpecialSymbols() {
        PersonalData data = new PersonalData("na2!me###",
                "132312HKJH!@#@",
                "sdfjJSD*(&)_");
        data.deleteSpecialSymbols();
        Assert.assertEquals(data.toString(), "na2me 132312HKJH sdfjJSD");
    }

    @Test
    public void isConvertToLowerCase() {
        PersonalData data = new PersonalData("ASDNnnnASnn",
                "ASDKhdAKJj",
                "AUNduU");
        data.convertToLowerCase();
        Assert.assertEquals(data.toString(), "asdnnnnasnn asdkhdakjj aunduu");
    }


    @Test
    public void getMetricLevenstainTest() {
        EqualsUtils eq = new EqualsUtils();
        eq.setStr1("horse");
        eq.setStr2("horses");
        int res = eq.getMetricDamerauLevenstain();
        Assert.assertEquals(1, res);

        eq.setStr1("horse");
        eq.setStr2("ohsroe");
        res = eq.getMetricDamerauLevenstain();
        Assert.assertEquals(3, res);

        eq.setStr1("horse");
        eq.setStr2("ohsre");
        res = eq.getMetricDamerauLevenstain();
        Assert.assertEquals(2, res);

        eq.setStr1("horse");
        eq.setStr2("ohsroe");
        res = eq.getMetricDamerauLevenstain();
        Assert.assertEquals(3, res);


        eq.setStr1("horse");
        eq.setStr2("hores");
        res = eq.getMetricDamerauLevenstain();
        Assert.assertEquals(1, res);
    }

    @Test
    public void isValidTest(){
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
        Assert.assertFalse(eq.isValid());


        PersonalData pd3 = new PersonalData("horse", "horse", "horse");
        PersonalData pd4 = new PersonalData("horsoe", "ohrse", "horse");
        EqualsUtils eq1 = new EqualsUtils();
        eq1.setStr1(pd3.getFirstName());
        eq1.setStr2(pd4.getFirstName());
        eq1.getMetricDamerauLevenstain();
        eq1.setStr1(pd3.getSecondName());
        eq1.setStr2(pd4.getSecondName());
        eq1.getMetricDamerauLevenstain();
        eq1.setStr1(pd3.getPatronymicName());
        eq1.setStr2(pd4.getPatronymicName());
        eq1.getMetricDamerauLevenstain();
        Assert.assertFalse(eq1.isValid());

        PersonalData pd5 = new PersonalData("horse", "horse", "horse");
        PersonalData pd6 = new PersonalData("horse", "ohrse", "horse");
        EqualsUtils eq2 = new EqualsUtils();
        eq2.setStr1(pd5.getFirstName());
        eq2.setStr2(pd6.getFirstName());
        eq2.getMetricDamerauLevenstain();
        eq2.setStr1(pd5.getSecondName());
        eq2.setStr2(pd6.getSecondName());
        eq2.getMetricDamerauLevenstain();
        eq2.setStr1(pd5.getPatronymicName());
        eq2.setStr2(pd6.getPatronymicName());
        eq2.getMetricDamerauLevenstain();
        Assert.assertTrue(eq2.isValid());
    }
}
