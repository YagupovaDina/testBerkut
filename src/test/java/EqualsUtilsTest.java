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
}
