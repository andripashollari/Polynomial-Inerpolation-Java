

public class Interpol {
    private static double gabimi;

    public static double merrGabimin() {
        return gabimi;
    }

    public static double solve(double number,double[] x, double[] y_initial) {
        if(Math.abs(number- x[0]) < Math.abs(number-x[x.length-1])) // nese eshte me prane x[0] se sa x[n-1]
            return perparme(number, x,y_initial);
        return prapme(number,x,y_initial);
    }

    public static double perparme(double number,double[] x, double[] y_initial) {
        int n = x.length; //x.length = y_i.length eshte numri i numrave

        double[][] y = new double[n][n];
        double hapi = x[1]-x[0];
        double q = (number - x[0])/hapi;

        for(int i=0; i<n; i++)
            y[0][i] = y_initial[i];
        for(int i=1; i<n; i++)
            for(int j=0; j<n-i; j++)
                y[i][j] = y[i-1][j+1] - y[i-1][j]; //i eshte treguesi i deltes
        double result = y[0][0];

        for(int i= 1; i<n; i++){
            result += (double) y[i][0]*shumezime(q,i-1)/factorial(i);
        }


        gabimi = y[n-1][0]*shumezime(q, n-1)/ factorial(n-1);

        return result;
    }
    public static double prapme(double number,double[] x, double[] y_initial) {

        int n = x.length;

        double[][] y = new double[n][n];
        double hapi = x[1]-x[0];
        double q = (number - x[n-1])/hapi;

        for(int i=0;i<n;i++)
            y[0][i] = y_initial[i];
        for(int i=1; i<n; i++)
            for(int j=i; j<n; j++)
                y[i][j] = y[i-1][j] - y[i-1][j-1];

        double result= y[0][n-1];
        for(int i= 1; i<n; i++)
            result += (double) y[i][n-1]*shumezim(q,i-1)/factorial(i);

        gabimi = y[n-1][n-1]*shumezime(q, n-1)/ factorial(n-1);

        return result;
    }

    public static int factorial(int nr) {
        int faktoriali =1;
        for(int i=2; i<=nr; i++)
            faktoriali*=i;
        return faktoriali;
    }
    public static double shumezime(double nr, int kufiriZbrites) {
        double rezultati = 1;
        for(double i = kufiriZbrites; i>=0; i--)
            rezultati *= (nr - i);
        return rezultati;
    }
    public static double shumezim(double nr, int kufiriZbrites) {
        double rezultati = 1.0;

        for(double i = (double)kufiriZbrites; i >= 0.0; --i) {
            rezultati *= nr + i;
        }

        return rezultati;
    }
}

