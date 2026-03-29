package com.kush.java.map;

import java.util.ArrayList;

public class TestClass {
public static void main(String[] args) {
	 int m[][]={{1, 0, 0, 0},
	         {1, 1, 0, 1}, 
	         {1, 1, 0, 0},
	         {0, 1, 1, 1}};
	 
	 ArrayList<String> ans=new ArrayList<>();
     int visited[][]=new int[m.length][m[0].length];
     pathUtils(m,4,ans,visited,0,0,"");
     System.out.println(ans.toString());
}
private static void pathUtils(int arr[][],int n, ArrayList<String> list,int [][]visited,int r,int c,String dir){
    if(r <0 || r >= n || c < 0 || c >=n || visited[r][c] == 1 || arr[r][c]==0) return;
    
    if(r== n-1 && c== n-1){
        list.add(dir);
        return;
    }
    visited[r][c]=1;
    pathUtils(arr,n,list,visited,r+1,c,dir+"D");
    //dir=dir.substring(0,dir.length()-1);
    pathUtils(arr,n,list,visited,r,c+1,dir+"R");
   // dir=dir.substring(0,dir.length()-1);
    pathUtils(arr,n,list,visited,r,c-1,dir+"L");
    // dir=dir.substring(0,dir.length()-1);
    pathUtils(arr,n,list,visited,r-1,c,dir+"U");
    // dir=dir.substring(0,dir.length()-1);
    visited[r][c]=0;

    }
}
