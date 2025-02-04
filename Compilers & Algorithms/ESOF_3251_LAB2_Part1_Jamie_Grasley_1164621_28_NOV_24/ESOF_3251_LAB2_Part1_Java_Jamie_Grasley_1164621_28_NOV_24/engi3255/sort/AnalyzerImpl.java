package engi3255.sort;


//Jamie Grasley #1164621

public class AnalyzerImpl implements Analyzer {
//Global variables for the return functions
double error; 
String BigOh; 
double [] bestRatio;

    public void analyze(int[] sizes, long[] data){
        //Array of all BigOh notations
        String[] notation={"O(1)","O(N)", "O(N^2)","O(N^3)","O(2^N)","O(log N)","O(N log N)"};
        //Create a 2D ratio array
        double[][] ratios=new double[7][sizes.length];
        //Create a control array for the sums
        double [] sum = {0,0,0,0,0,0,0};
        //Create a control array for the mean
        double [] mean=new double [7];
        //Initialize the global bestRatio array
        bestRatio=new double[sizes.length];
        
        //Get the ratios, sums, and means for each BigOh function
        for(int i=0;i<sizes.length;i++){
            //Ratios calculations in order of the notation array
            ratios[0][i]=(double)data[i]/1;
            ratios[1][i]=(double)data[i]/sizes[i];
            ratios[2][i]=(double)data[i]/Math.pow(sizes[i],2);
            ratios[3][i]=(double)data[i]/Math.pow(sizes[i],3);
            ratios[4][i]=(double)data[i]/Math.pow(2,sizes[i]);
            ratios[5][i]=(double)data[i]/(Math.log(sizes[i])/Math.log(2));
            ratios[6][i]=(double)data[i]/(sizes[i]*Math.log(sizes[i])/Math.log(2));

            //Sum for each BigOh
            sum[0]=sum[0]+ratios[0][i];
            sum[1]=sum[1]+ratios[1][i];
            sum[2]=sum[2]+ratios[2][i];
            sum[3]=sum[3]+ratios[3][i];
            sum[4]=sum[4]+ratios[4][i];
            sum[5]=sum[5]+ratios[5][i];
            sum[6]=sum[6]+ratios[6][i];
            
            //Calculate the mean after all sums are calculated
            if(i==(sizes.length-1)){
            mean[0]=sum[0]/sizes.length;
            mean[1]=sum[1]/sizes.length;
            mean[2]=sum[2]/sizes.length;
            mean[3]=sum[3]/sizes.length;
            mean[4]=sum[4]/sizes.length;
            mean[5]=sum[5]/sizes.length;
            mean[6]=sum[6]/sizes.length;
            }

        }
        //Create arrays for the relative calculations
        double relError[][] = new double [7][sizes.length];
        double relSum[] = new double [7];
        double relMean[] = new double [7];

        for(int i=0;i<sizes.length;i++){
            //Calculate relative error for each ratio for each BigOh
            relError[0][i]=Math.abs(ratios[0][i]-mean[0])/mean[0];
            relError[1][i]=Math.abs(ratios[1][i]-mean[1])/mean[1];
            relError[2][i]=Math.abs(ratios[2][i]-mean[2])/mean[2];
            relError[3][i]=Math.abs(ratios[3][i]-mean[3])/mean[3];
            relError[4][i]=Math.abs(ratios[4][i]-mean[4])/mean[4];
            relError[5][i]=Math.abs(ratios[5][i]-mean[5])/mean[5];
            relError[6][i]=Math.abs(ratios[6][i]-mean[6])/mean[6];

            //Calculate sums
            relSum[0]=relSum[0]+relError[0][i];
            relSum[1]=relSum[1]+relError[1][i];
            relSum[2]=relSum[2]+relError[2][i];
            relSum[3]=relSum[3]+relError[3][i];
            relSum[4]=relSum[4]+relError[4][i];
            relSum[5]=relSum[5]+relError[5][i];
            relSum[6]=relSum[6]+relError[6][i];

            //Calculate means if once sums are calculated
            if(i==(sizes.length-1)){
            relMean[0]=relSum[0]/sizes.length;
            relMean[1]=relSum[1]/sizes.length;
            relMean[2]=relSum[2]/sizes.length;
            relMean[3]=relSum[3]/sizes.length;
            relMean[4]=relSum[4]/sizes.length;
            relMean[5]=relSum[5]/sizes.length;
            relMean[6]=relSum[6]/sizes.length;
            }

        }
        //Control value to find the smallest error and index
        double smallError=relMean[0];
        int index=0;

        for(int i=1;i<7;i++){
            //Set value of smallest error
            if(smallError>relMean[i]){
                smallError=relMean[i];
                index=i;
            }
        }
        

        //Correct BigOh is at the index found from the previous for loop
        BigOh=notation[index];

        //Set the global error to the correct error based on the BigOh
        error=smallError;
        
        //Set the global bestRatio to the ratios of the correct BigOh
        for(int i=0;i<sizes.length;i++){
        bestRatio[i]=ratios[index][i];
        }
           
    }

    public double[] getRatios(){
        return bestRatio; //Return the ratio of the correct BigOh
    }

   public double getError(){
    return error; //Return the error of the correct BigOh
    }

   public String getBigOh(){
        return BigOh; //Return the BigOh selected
    }
    
}
