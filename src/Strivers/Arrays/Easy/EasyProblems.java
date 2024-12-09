package Strivers.Arrays.Easy;

import java.util.*;

public class EasyProblems {
    public static int largestElement(int[] arr){
        int n=arr.length;
        int largest=arr[0];

        for(int i=1;i<n;i++){
            if(arr[i]>=largest){
                largest=arr[i];
            }
        }

        return largest;
    }

    public static int secondLargest(int[] arr){
        int n=arr.length;
        int largest=arr[0];
        int slargest=-1;

        for(int i=1;i<n;i++){
            if(arr[i]>largest){
                slargest=largest;
                largest=arr[i];
            }else if(arr[i]>slargest && arr[i]!=largest){
                slargest=arr[i];
            }
        }

        return slargest;
    }

    public static boolean isSorted(int[] arr){
        int n=arr.length;

        for(int i=1;i<n;i++){
            if(arr[i]>=arr[i-1]){
                continue;
            }else{
                return false;
            }
        }

        return true;
    }

    public static void moveZeroesToEnd(int[] arr){
        int n=arr.length;
        int count=0;

        for(int i=0;i<n;i++){
            if(arr[i]!=0){
                int temp=arr[i];
                arr[i]=arr[count];
                arr[count]=temp;

                count+=1;
            }
        }
    }

    public static void leftRotateByOne(int[] arr){
        int n=arr.length;

        int temp=arr[0];
        for(int i=1;i<n;i++){
            arr[i-1]=arr[i];
        }
        arr[n-1]=temp;
    }

    public static void rightRotateByOne(int[] arr){
        int n=arr.length;

        int temp=arr[n-1];
        for(int i=n-2;i>=0;i--){
            arr[i+1]=arr[i];
        }
        arr[0]=temp;
    }

    public static void reverseArray(int[] arr, int l, int r){
        while(l<=r){
            int temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;

            l+=1;
            r-=1;
        }
    }

    public static void leftRotateByD(int[] arr, int d){
        int n=arr.length;
        d=d%n;

        reverseArray(arr, 0, d-1);
        reverseArray(arr, d, n-1);
        reverseArray(arr, 0, n-1);
    }

    public static void rightRotateByD(int[] arr, int d){
        int n=arr.length;
        d=d%n;

        reverseArray(arr, 0, d);
        reverseArray(arr, d+1, n-1);
        reverseArray(arr, 0, n-1);
    }

    public static boolean linearSearch(int[] arr, int x){
        boolean isFound=false;
        int n=arr.length;

        for(int i=0;i<n;i++){
            if(arr[i]==x){
                isFound=true;
                break;
            }
        }

        return isFound;
    }

    public static int removeDuplicatesInPlace(int[] arr){
        int n=arr.length;

        int i=0;
        for(int j=1;j<n;j++){
            if(arr[i]!=arr[j]){
                arr[i+1]=arr[j];
                i+=1;
            }
        }

        return i+1;
    }

    public static ArrayList<Integer> unionArrays(int[] a, int[] b){
        int n1=a.length;
        int n2=b.length;
        ArrayList<Integer> unionArr=new ArrayList<>();

        int i=0, j=0;
        while(i<n1 && j<n2){
            if(a[i]<=b[j]){
                if(unionArr.size()==0 || !unionArr.contains(a[i])){
                    unionArr.add(a[i]);
                }
                i+=1;
            }else{
                if(unionArr.size()==0 || !unionArr.contains(b[j])){
                    unionArr.add(b[j]);
                }
                j+=1;
            }
        }

        while(i<n1){
            if(unionArr.size()==0 || !unionArr.contains(a[i])){
                unionArr.add(a[i]);
            }
            i+=1;
        }

        while(j<n2){
            if(unionArr.size()==0 || !unionArr.contains(b[j])){
                unionArr.add(b[j]);
            }
            j+=1;
        }

        return unionArr;
    }

    public static ArrayList<Integer> intersectionArrays(int[] a, int[] b){
        int n1=a.length;
        int n2=b.length;
        ArrayList<Integer> intArr=new ArrayList<>();

        int i=0, j=0;
        while(i<n1 && j<n2){
            if(a[i]<b[j]){
                i+=1;
            }else if(b[j]<a[i]){
                j+=1;
            }else{
                intArr.add(a[i]);
                i+=1;
                j+=1;
            }
        }

        return intArr;
    }

    public static void main(String args[]){
        int arr1[]={0, 1, 0, 3, 12};

        int largest=largestElement(arr1);
        System.out.println("Largest element of array: "+largest);

        int slargest=secondLargest(arr1);
        System.out.println("Second largest element of array: "+slargest);

        boolean checkSorted=isSorted(arr1);
        System.out.println("Array is sorted or not: "+checkSorted);

        boolean isPresent=linearSearch(arr1, 12);
        System.out.println("Linear search in array: "+isPresent);

        leftRotateByD(arr1, 7);
        System.out.print("Array after left rotating by 7: ");
        for(int ele: arr1){
            System.out.print(ele+" ");
        }
        System.out.println();

        rightRotateByD(arr1, 7);
        System.out.print("Array after right rotating by 7: ");
        for(int ele: arr1){
            System.out.print(ele+" ");
        }
        System.out.println();
        
        leftRotateByOne(arr1);
        System.out.print("Array after left rotating by 1: ");
        for(int ele: arr1){
            System.out.print(ele+" ");
        }
        System.out.println();

        rightRotateByOne(arr1);
        System.out.print("Array after right rotating by 1: ");
        for(int ele: arr1){
            System.out.print(ele+" ");
        }
        System.out.println();

        moveZeroesToEnd(arr1);
        System.out.print("Array after moving 0s to end: ");
        for(int ele: arr1){
            System.out.print(ele+" ");
        }
        System.out.println();

        // Requiring sorted array
        int arr2[]={1, 1, 2, 2, 2, 2, 3, 3};
        int arr3[]={2, 2, 3, 4, 4, 5, 6};

        ArrayList<Integer> union=new ArrayList<>();
        union=unionArrays(arr2, arr3);
        System.out.println("Union of 2 arrays: "+union);

        ArrayList<Integer> intersection=new ArrayList<>();
        intersection=intersectionArrays(arr2, arr3);
        System.out.println("Union of 2 arrays: "+intersection);

        int arrSize=removeDuplicatesInPlace(arr2);
        System.out.println("Array size after removing duplicates: "+arrSize);
    }
}
