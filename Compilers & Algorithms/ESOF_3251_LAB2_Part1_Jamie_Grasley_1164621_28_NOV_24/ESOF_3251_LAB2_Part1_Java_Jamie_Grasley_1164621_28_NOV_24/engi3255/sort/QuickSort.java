package engi3255.sort;

//Jamie Grasley #1164621

public class QuickSort implements Sort{
    private static long compares=0;
    public <T extends Comparable<T>> void sort(T [] a){
        compares=0;
        quicksort( a, 0, a.length - 1 );
    }

    private static final int CUTOFF = 10;

    /**
     * Method to swap to elements in an array.
     * @param a an array of objects.
     * @param index1 the index of the first object.
     * @param index2 the index of the second object.
     */
    public static final void swapReferences( Object [ ] a, int index1, int index2 )
    {
        Object tmp = a[ index1 ];
        a[ index1 ] = a[ index2 ];
        a[ index2 ] = tmp;
    }

    /**
     * Internal quicksort method that makes recursive calls.
     * Uses median-of-three partitioning and a cutoff of 10.
     * @param a an array of Comparable items.
     * @param low the left-most index of the subarray.
     * @param high the right-most index of the subarray.
     */
    private static <T extends Comparable<T>> void quicksort( T [ ] a, int low, int high )
    {
        if( low + CUTOFF > high ){
            insertionSort( a, low, high );
        }
        else
        {
            compares++;//If statement 1
            compares++;//If statement 2
            compares++;//If statement 3
                // Sort low, middle, high
            int middle = ( low + high ) / 2;
            if( a[ middle ].compareTo( a[ low ] ) < 0 ){
                swapReferences( a, low, middle );
            }
            
            
            if( a[ high ].compareTo( a[ low ] ) < 0 ){
                swapReferences( a, low, high );
            }
            
            if( a[ high ].compareTo( a[ middle ] ) < 0 ){
                swapReferences( a, middle, high );
            }
            

                // Place pivot at position high - 1
            swapReferences( a, middle, high - 1 );
            T pivot = a[ high - 1 ];

                // Begin partitioning
            int i, j;
            for( i = low, j = high - 1; ; )
            {
                while( a[ ++i ].compareTo( pivot ) < 0 ){
                    compares++;
                }
                compares++;
                while( pivot.compareTo( a[ --j ] ) < 0 ){
                    compares++;
                }
                compares++;
                if( i >= j ){
                    break;
                }
                
                swapReferences( a, i, j );
            }

                // Restore pivot
            swapReferences( a, i, high - 1 );

            quicksort( a, low, i - 1 );    // Sort small elements
            quicksort( a, i + 1, high );   // Sort large elements
        }
    }

    /**
     * Internal insertion sort routine for subarrays
     * that is used by quicksort.
     * @param a an array of Comparable items.
     * @param low the left-most index of the subarray.
     * @param n the number of items to sort.
     */
    private static <T extends Comparable<T>> void insertionSort( T [ ] a, int low, int high )
    {
        for( int p = low + 1; p <= high; p++ )
        {
            T tmp = a[ p ];
            int j;

            for( j = p; j > low ; j-- ){
                compares++;
                if (tmp.compareTo(a[j - 1]) < 0) {
                    a[j] = a[j - 1]; 
                } else {
                    break;
                }
            }
            
            a[ j ] = tmp;
            

            
        }

    }



    public long getCompares(){
        return compares;
    }
}