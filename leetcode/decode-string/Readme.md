# Decode String

:link: [Problem URL](https://leetcode.com/problems/decode-string/)

## Approach :brain:

The pattern of the input string is recursive. While iterating over the string character by character, there are 3 possibilities

1. We get a alphabet
2. We get an "[" or "]"
3. We get a digit

Based on these possibilities, we need to handle our state

1. Declare a variable to store our final string: `res`
2. Declare a variable to store the digits before a bracket: `num`
3. For character c in our string:
    1. if c is "["
        1. count = int(num)
        2. Find the closing bracket
        3. decode the substring between this pair of opening and closing bracket by passing it to this method itself i.e start from `step 1` with the input string as the substring
        4. repeat this decoded string for `count` number of times and append it to `res`
        5. Jump to the character after the closing bracket, set `num`=""
    2. else
        1. if c is a digit
            1. append it to `num`
        2. else if c is an alphabet
            1. just append it to `res`
4. return `res`
