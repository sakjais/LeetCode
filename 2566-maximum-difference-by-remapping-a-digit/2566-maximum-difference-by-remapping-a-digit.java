class Solution {
    public int minMaxDifference(int num) {
        //mapping the first non nine digit to 9 gives us the maximum number
        //mapping the first non zero digit to 0 gives us the minimum number
        String max, min, hold = Integer.toString(num);
        char check = 'a';
        boolean flag = true;
        char[] array = hold.toCharArray();
        //calculating the maximum number
        for(int i = 0; i<array.length; i++){
            if(array[i] == check){
                array[i] = '9';
                continue;
            }
            if(flag && array[i]!='9'){
                check = array[i];
                array[i] = '9';
                flag = false;
            }
        }
        max = String.valueOf(array);
        hold = Integer.toString(num);
        check = 'a';
        flag = true;
        array = hold.toCharArray();
        //calculating the minimum number
        for(int i = 0; i<array.length; i++){
            if(array[i] == check){
                array[i] = '0';
                continue;
            }
            if(flag && array[i]!='0'){
                check = array[i];
                array[i] = '0';
                flag = false;
            }
        }
        min = String.valueOf(array);
        return Integer.parseInt(max) - Integer.parseInt(min);
    }
}