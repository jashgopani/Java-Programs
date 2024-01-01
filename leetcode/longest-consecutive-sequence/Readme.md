# Decode String

:link: [Problem URL](https://leetcode.com/problems/longest-consecutive-subsequence/)

## Approach :brain:

### Brute Force O(NlogN)

Sort the array / Use heap data structure and then find the longest sequence length 

### Optimal

The biggest challenge is to identify the from a number whether it is the start of a sequence or a part of a sequence.
Since, for a remembering a sequence, we need some kind of memory, we use hashset to store all the elements of the input array

Now, if, for a number
    There is no `(number-1)` value present in the hashset, it means that the number is the start of a sequence
    else
    it is a part of a sequence

Based on this logic, we solve the problem using the below steps

1. Add all elements of input array in hashset
2. initialize max=0
3. foreach element in input array
   1. if the element is start of sequence
      1. initialize count=0
      2. while `(number+1)` is present in the set, count++
      3. max = max(count,max)
4. return max

