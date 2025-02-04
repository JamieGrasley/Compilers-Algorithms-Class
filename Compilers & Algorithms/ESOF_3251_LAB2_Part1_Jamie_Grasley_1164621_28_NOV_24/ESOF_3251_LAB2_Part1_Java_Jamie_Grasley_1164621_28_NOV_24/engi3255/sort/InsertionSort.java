package engi3255.sort;

//Jamie Grasley #1164621

public class InsertionSort implements Sort{
	private static long compares=0;
	public <T extends Comparable<T>> void sort(T [] a){
		compares=0;
		insertionsort(a);
	}
    private static <T extends Comparable<T>> void insertionsort(T [] a){
		
        for( int p = 0; p < a.length; p++ )
        {
			int i = p;
			boolean sorted = false;
			while ((i>0) && (!sorted))
			{	compares++;
				if (a[i].compareTo(a[i-1])<0)
				{
					T tmp = a[i ];
					a[i]=a[i-1];
					a[i-1]=tmp;
					i--;
                    
				}
				else{
					sorted = true;
				}
				
				
			 }
			 
		  } 
		  
    }


    public long getCompares(){
        return compares;
    }
}
