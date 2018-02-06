import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.io.File;


public class Matrix {
    private int numRows=0;
    private int numCols=0;
    private double [][] mat;
    public Matrix(double data[][]) {
        // TODO Auto-generated constructor stub
        mat = data.clone();
        
    }
    
    public Matrix(String filePath)
    {
        try
        {
            String line;
            int colsOnLine;            
            int rows = 0;
            int cols = -1;
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            while ((line = br.readLine()) != null)
            {
                rows++;
                colsOnLine = line.trim().split("\\s+").length;
                if (cols == -1)
                {
                    cols = colsOnLine;
                }
            }
            br.close();

            mat = new double[rows][cols];   
            for (numRows=0; numRows<mat.length; numRows++)
                {
                    for (numCols=0; numCols<mat[numRows].length; numCols++)
                    {
                        mat[numRows][numCols]=0;
                    }
                }     
            
            
            Scanner inputFile = new Scanner(new File(filePath));
            while (inputFile.hasNextLine())
            {
                for (numRows=0; numRows<mat.length; numRows++)
                {
                    for (numCols=0; numCols<mat[numRows].length; numCols++)
                    {
                        mat[numRows][numCols]=inputFile.nextDouble();
                    }
                }                
            } 

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    
    public Matrix transpose()
    {
        
        int i = mat.length;
        int j = mat[0].length;

        double [][] trPose = new double [j][i];
        for(int k=0;k<i;k++)
        {
            for(int l=0;l<j;l++)
            {
                trPose[l][k]=mat[k][l];
            }
        }
        
        
        return new Matrix(trPose);
    }
    public Matrix add(Matrix test)
    {
        int i = this.mat.length;
        int j = this.mat[0].length;
        int k = test.mat.length;
        int l = test.mat[0].length;
        double [][] addMat = new double [i][j];

        if(i==k && j==l)
        {
            for(int m=0;m<i;m++)
            {
                for(int n=0;n<j;n++)
                {
                    addMat[m][n]=this.mat[m][n] + test.mat[m][n];
                }
                
            }
        }
        else
        {
            System.out.println("Cannot do addition");
        }
        
        
        return new Matrix(addMat);
    }
    public Matrix sub(Matrix test)
    {
        int i = this.mat.length;
        int j = this.mat[0].length;
        int k = test.mat.length;
        int l = test.mat[0].length;
        double [][] subMat = new double [i][j];

        if(i==k && j==l)
        {
            for(int m=0;m<i;m++)
            {
                for(int n=0;n<j;n++)
                {
                    subMat[m][n]=this.mat[m][n] + test.mat[m][n];
                }
                
            }
        }
        else
        {
            System.out.println("Cannot do addition");
        }
        
        
        return new Matrix(subMat);
    }
    
    public Matrix mult(double a)
    {
        int i = this.mat.length;
        int j = this.mat[0].length;
        double [][] mulMat = new double [i][j];

        for(int m=0;m<i;m++)
        {
            for(int n=0;n<j;n++)
            {
                mulMat[m][n]= a * mat[m][n];
            }
        }
        return new   Matrix(mulMat);
    }
    
    public Matrix mult(Matrix test)
    {
        int i = this.mat.length;
        int j = this.mat[0].length;
        int k = test.mat.length;
        int l = test.mat[0].length;
        int a,b;
        if(i>k)
        {
            a=k;
        }
        else
        {
            a=i;
        }
        
        if(j>l)
        {
            b=l;
        }
        else
        {
            b=j;
        }
        
        double [][] mulMat = new double [a][b];
        
        for (int m = 0; m < i; m++) { // aRow
            for (int n = 0; n < l; n++) { // bColumn
                for (int o = 0; o < j; o++) { // aColumn
                    if(m<a && n<b)
                    {
                    mulMat[m][n] += this.mat[m][o] * test.mat[o][n];
                }
                }
            }
        }
        
        
        return new Matrix(mulMat);
    }
    
    
    
    
    public String toString()
    {
        int i = mat.length;
        int j = mat[0].length;
        System.out.println(i +" x " + j+ " Matrix");
        for(int k=0;k<i;k++)
        {
            for(int l=0;l<j;l++)
            {
                System.out.print((mat[k][l]) +"\t");
            }
            System.out.println();
        }
        return "";
    }
    public boolean equals(Matrix test)
    {
        int i = this.mat.length;
        int j = this.mat[0].length;
        int k = test.mat.length;
        int l = test.mat[0].length;
        int flag = 0;
        if(i==k && j==l)
        {
            for(int m=0;m<i;m++)
            {
                for(int n=0;n<j;n++)
                {
                    if(this.mat[m][n] != test.mat[m][n])
                    {
                        flag=1;
                    }
                }
                
            }
        }
        else
        {
            flag = 1;
        }
        if(flag==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    
    }
    
}
