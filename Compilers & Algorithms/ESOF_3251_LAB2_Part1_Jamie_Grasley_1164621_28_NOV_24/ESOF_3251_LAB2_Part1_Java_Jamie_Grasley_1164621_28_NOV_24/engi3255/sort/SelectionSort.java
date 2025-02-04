package engi3255.sort;

//Jamie Grasley #1164621

public class SelectionSort implements Sort {
    long compares=0;
    public <T extends Comparable<T>> void sort(T [] a)
	{ compares=0;
		for (int last = a.length - 1; last >= 1; last--)
		{
			int max = 0;
			for (int i = 1; i <= last; i++){
				if (a[i].compareTo(a[max]) > 0){
					max = i;
				}
					compares++; //if compares
				}
				

			T tmp = a[max];
			a[max] = a[last];
			a[last] = tmp;
			
		}
		
		
        
	}
	
    public long getCompares(){
        return compares;
    }
}
