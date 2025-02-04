package engi3255.sort;

//Jamie Grasley #1164621

public class BubbleSort implements Sort  {
    long compares=0;
    public  <T extends Comparable<T>> void sort( T [ ] a )
    {
	compares=0;
	boolean sorted = false;
	for (int last = a.length-1; (last >= 1) && (!sorted) ; last--)
	{
	    sorted = true;
	    for (int i =0; i<last; i++){
			compares++;
			if (a[i].compareTo(a[i+1]) > 0)
			{ 	
				T tmp = a[i];
				a[i] = a[i+1];
				a[i+1] = tmp;
				sorted = false;
			}
			 //If statement compares 
			
	}
	
}

    }

    public long getCompares(){
        return compares;
    }
}
