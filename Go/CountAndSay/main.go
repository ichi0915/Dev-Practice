/*
Dev Practice - Count and Say:

	The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

	countAndSay(1) = "1"
	countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
	To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit. Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.

	For example, the saying and conversion for digit string "3322251":
	Given a positive integer n, return the nth term of the count-and-say sequence.

	Input: n = 1
	Output: "1"

	Input: n = 4
	Output: "1211"
	Explanation:
	countAndSay(1) = "1"
	countAndSay(2) = say "1" = one 1 = "11"
	countAndSay(3) = say "11" = two 1's = "21"
	countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"

*/

package main

import (
	"fmt"
	"strconv"
)

func main() {
	// fmt.Println("Response: ", countAndSay(1))  // response 1
	// fmt.Println("Response: ", countAndSay(3))  // response 21
	// fmt.Println("Response: ", countAndSay(4))  // response 1211
	// fmt.Println("Response: ", countAndSay(5))  // response 111221
	// fmt.Println("Response: ", countAndSay(6))  // response 312211
	// fmt.Println("Response: ", countAndSay(7))  // response 13112221
	// fmt.Println("Response: ", countAndSay(8))  // response 1113213211
	// fmt.Println("Response: ", countAndSay(9))  // response 31131211131221
	// fmt.Println("Response: ", countAndSay(10)) // response 13211311123113112211
	fmt.Println("Response: ", countAndSay(11)) // response 11131221133112132113212221
}

func countAndSay(n int) string {
	var response string = "1"
	var responseStr string
	start := true

	for i := 0; i < n; i++ {
		responseStr = countAndSayLoop(response, start, i)
		response = responseStr
		start = false
	}

	return responseStr
}

func countAndSayLoop(values string, start bool, i int) string {
	response := ""
	var previousVal string = "-1"
	var count int64 = 1

	for _, value := range values {
		// fmt.Printf("%c \n", value)

		if previousVal == string(value) {
			count++
		} else if previousVal != "-1" {
			response += intToString(count) + previousVal
			count = 1
		}

		previousVal = string(value)
	}

	if !start {
		response += intToString(count) + previousVal
	} else {
		response += previousVal
	}

	return response
}

func intToString(value int64) string {
	return strconv.FormatInt(value, 10)
}
