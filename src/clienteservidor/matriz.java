public class Matriz{
   static final int MAX = 100; 
    static int[][] mat = new int[MAX][MAX]; 
      
    
    static void fillRemaining(int i, int j, int n) 
    { 
        
        int x = 2; 
      
         
        for (int k = i + 1; k < n; k++) 
            mat[k][j] = x++; 
      
        
        for (int k = 0; k < i; k++) 
            mat[k][j] = x++; 
    } 
      
     
    static void constructMatrix(int n) 
    { 
        
        int right = n - 1, left = 0; 
        for (int i = 0; i < n; i++) 
        { 
             
            if (i % 2 == 0) 
            { 
                mat[i][right] = 1; 
      
                 
                fillRemaining(i, right, n); 
      
                // Move right one column back 
                right--; 
            } 
              
             
            else
            { 
                mat[i][left] = 1; 
      
                
                fillRemaining(i, left, n); 
      
               
                left++; 
            } 
        } 
    } 
      
    
    public static void main(String args[]) 
    { 
        int n = 2; 
      
        constructMatrix(n); 
      
        for (int i = 0; i < n; i++) 
        { 
            for (int j = 0 ; j < n; j++) 
            System.out.print(mat[i][j]+" "); 
            System.out.println(); 
        } 
    } 
} 
