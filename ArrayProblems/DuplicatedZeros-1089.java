class Solution {
    public void duplicateZeros(int[] arr) {
        int zeros = 0;
        for (int i : arr) {
            if (i == 0) {
                zeros++;
            }
        }
        int i = arr.length - 1;
        int j = arr.length + zeros - 1;

        while (i != j) {
            insert(arr, i, j);
            j--;
            if (arr[i] == 0) {
                insert(arr, i, j);
                j--;
            }
            i--;
        }
    }

    private void insert(int[] arr, int i, int j) {
        //check if we are within array bound
        if (j < arr.length) {
            arr[j] = arr[i];
        }
    }
}




/*

[0]  -> [0]
[0,1]-> [0,0]
[1,0]-> [1,0]
[0,1,0] -> [0,0,1]


                i   j
[0,1,0] -> [0,1,0,X,X]
     i   j    to write arr[j] = arr[i], only possible if j is in bound
[0,1,0,X,X]
   i   j      decrement j, as j is still not within the actual array
[0,1,0,X,X]
 i   j       arr[j] = arr[i],
[0,1,0,X,X]   => [0,1,0,X,X]
 i   j
[0,1,0,X,X]


knowing two things
First, if j index is in bound, we need to copy over the i index value to j's index
Second, if we have found a zero, we need to insert it right beside the found zero index

private void insert (int[] arr, int i, int j)
if (j < arr.length) {
    arr[j] = arr[i]
}

while (i !=j) {
    insert (arr, i , j)
    j--;
    if (arr[i] ==0) {
    insert (arr, i, j)
    j--;
    }
    i --;
}



Step 1 -> Scan through the array to count the number of zeros
Step 2 -> initiate two pointers, i, j , where i points at the last index in the array, and j = i + countOfZero
Step 3 -> we will attempt to shift element to the right as long as j is in bound, will check if j is in bound
          if j is in bound then arr[j] = arr[i], if not, we will decrement i and j
Step 4 -> if arr[i] ==0, and j is in bound, and assign arr[j] = arr[i] then decrement both i,j
Step 5 -> terminate when j<=i as we have looked through everything










Brute Force Solution 1
   i
[0,1,0]
 i,j        to avoid 1 being overriden -> copy 1 to next the index position
[0,1,0] -> [0,1,1]
i,j         copy over the 0 to index adjacent to its position
[0,1,1] -> [0,0,1] => next iteration j will be smaller than i we decrement i

[0,1,1] -> i <0 thus we have looked over everything within the array



class Solution {
    public void duplicateZeros(int[] arr) {
        int lastIndex = arr.length - 1;
        for (int i = lastIndex; i >= 0; i--) {
            // i index looking for the first 0 as long as i is not last index as it can not be overwrriten
            // i can not be shifted to the right when i = arr.length -1;
            if (arr[i] == 0 && i != lastIndex) {
            // j index pointer to shift everything to the right
            // as long as j index does not start at the last position as it will cause out of bound error
                for (int j = lastIndex; j > i; j--) {
                    if (j != lastIndex) {
                        arr[j + 1] = arr[j];
                    }
                }
            // once everything has been shifted to the right, insert a zero to the found zero index i
                arr[i + 1] = arr[i];
            }
        }

    }
}



 */