public class EqualsUtils {
    private String str1;
    private String str2;
    private boolean valid;
    private int errCount;

    public int getErrCount() {
        return errCount;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }

    public int getMetricDamerauLevenstain() {
        if (str1 == null || str2 == null) {
            throw new IllegalArgumentException("Parameter must not be null");
        }
        int str1Length = str1.length();
        int str2Length = str2.length();
        if (str1Length == 0) return str2Length;
        if (str2Length == 0) return str1Length;
        int[][] dist = new int[str1Length + 1][str2Length + 1];
        for (int i = 0; i < str1Length + 1; i++) {
            dist[i][0] = i;
        }
        for (int j = 0; j < str2Length + 1; j++) {
            dist[0][j] = j;
        }
        for (int i = 1; i < str1Length + 1; i++) {
            for (int j = 1; j < str2Length + 1; j++) {
                int cost = str1.charAt(i - 1) == str2.charAt(j - 1) ? 0 : 1;
                dist[i][j] = Math.min(Math.min(dist[i - 1][j] + 1, dist[i][j - 1] + 1), dist[i - 1][j - 1] + cost);
                if (i > 1 &&
                        j > 1 &&
                        str1.charAt(i - 1) == str2.charAt(j - 2) &&
                        str1.charAt(i - 2) == str2.charAt(j - 1)) {
                    dist[i][j] = Math.min(dist[i][j], dist[i - 2][j - 2] + cost);//transposition
                }
            }
        }
        errCount += dist[str1Length][str2Length];
        return dist[str1Length][str2Length];
    }

    public boolean isValid() {
        if (errCount <= 1) {
            valid = true;
            return valid;
        }
        valid = false;
        return valid;
    }
}
