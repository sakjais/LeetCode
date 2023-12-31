import java.util.Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0,j=0,k=0,flen=nums1.length,slen=nums2.length;
        int a[]=new int[flen+slen];
        while(i<flen && j<slen){
            if(nums1[i]>nums2[j]){
                a[k]=nums2[j];
                k++;
                j++;
            }
            else{
                a[k]=nums1[i];
                k++;
                i++;
            }
        }
        while(i<flen){
            a[k]=nums1[i];
            k++;
            i++;
        }
        while(j<slen){
            a[k]=nums2[j];
            k++;
            j++;
        }
        if((k)%2==0){
            int t=(a[(k/2)-1]+a[k/2]);
            if(t%2==0){
                return t/2;
            }
            else{
                return (t/2)+0.5;
            }
        }
        else{
            return a[k/2];
        }
    }
}