package engi3255.sort;

//Jamie Grasley #1164621

public class SortAnalyzer {
    static final int INSERTION = 0, SELECTION = 1, 
	BUBBLE = 2, QUICK = 3;
    static Analyzer bigO = new AnalyzerImpl();
    static Sort[] sorts = {
	new InsertionSort(),
	new SelectionSort(),
	new BubbleSort(),
	new QuickSort(),
    };
    static String[] names = {
	"INSERTION",
	"SELECTION",
	"BUBBLE",
	"QUICK"
    };

    static int[] sizes = {
	100, 200, 400, 800, 1600
    };

    static final int SORTED = 0, REVERSE = 1, RANDOM = 2;
    static String[] types = { 
	"SORTED",
	"REVERSE",
	"RANDOM"
    };

    static Comparable<?>[][][] makeData(String[] types, int[] sizes) {
        Comparable[][][] data = new Comparable[types.length][][];
        java.util.Random r = new java.util.Random(0);
        for (int type = 0; type < types.length; type++) {
            data[type] = new Comparable[sizes.length][];
            for( int size = 0; size < sizes.length; size++ ) {
            data[type][size] = new Integer[sizes[size]];
            for( int i = 0; i < sizes[size]; i++ )
                switch(type) {
                case SORTED:
                data[type][size][i] = ( i );
                break;
                case REVERSE:
                data[type][size][i] = (sizes[size]-i);
                break;
                case RANDOM:
                data[type][size][i] = 
                    (r.nextInt(sizes[size]));
                break;
                }
            }
        }
        return data;
        }
        
        static void sortAnalyze() {
            for (int sort = 0; sort < sorts.length; sort++) {
                Comparable[][][] data = makeData(types, sizes);
                for (int type = 0; type < types.length; type++) {
                System.out.println(names[sort] + " sort with " +
                           types[type] + " data");
                long[] cmps = new long[sizes.length];
                for (int size = 0; size < sizes.length; size++) {
                    sorts[sort].sort(data[type][size]);
                    cmps[size] = sorts[sort].getCompares();
                    
                    }
                    bigO.analyze(sizes,cmps);
                    System.out.printf("Sizes: ");
                    for(int i=0; i<sizes.length;i++){
                        System.out.printf(" %d",sizes[i]);
                    }
                    System.out.printf("\nCompares: ");
                    for(int i=0; i<cmps.length;i++){
                        System.out.printf(" %d",cmps[i]);
                    }
                    double [] ratios=bigO.getRatios();
                    System.out.printf("\nRatios: ");
                    for(int i=0; i<ratios.length;i++){
                        System.out.printf(" %.4f",ratios[i]);
                    }
        
                    System.out.printf(" "+bigO.getBigOh()+" error %.4f", bigO.getError());
                    System.out.println("\n");


                }
                System.out.println();
                 }
            }


            public static void main (String[] args) {
                sortAnalyze();
            }
                
                 
                
}
