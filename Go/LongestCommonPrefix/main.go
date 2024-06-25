/*
Dev Practice - Longest Common Prefix:

	Write a function to find the longest common prefix string amongst an array of strings.
	If there is no common prefix, return an empty string "".

	Example 1:
		Input: strs = ["flower","flow","flight"]
		Output: "fl"

	Example 2:
		Input: strs = ["dog","racecar","car"]
		Output: ""
		Explanation: There is no common prefix among the input strings.

	Constraints:
		1 <= strs.length <= 200
		0 <= strs[i].length <= 200
		strs[i] consists of only lowercase English letters.
*/

package main

import (
	"fmt"
)

func main() {
	// strs := []string{"flower", "flow", "flight"} // response: fl
	strs := []string{"dog", "racecar", "car"} // response: ""

	fmt.Println("Response: ", longestCommonPrefix(strs))
}

func longestCommonPrefix(strs []string) string {
	var currentChar byte = byte(0)
	response := ""
	amountStrings := len(strs)
	minStrLen := getMinLen(strs)

	fmt.Println("amountStrings: ", amountStrings)
	fmt.Println("lenFirstStr: ", minStrLen)

	for i := 0; i < minStrLen; i++ {
		notEqual := true
		for j := 0; j < amountStrings; j++ {
			if currentChar == 0 {
				currentChar = strs[j][i]
			} else if currentChar != strs[j][i] {
				notEqual = false
			}
		}

		if notEqual {
			response += string(currentChar)
		} else {
			break
		}
		currentChar = byte(0)
	}

	return response
}

func getMinLen(strs []string) int {
	amountStrings := len(strs)
	min := 999999

	for i := 0; i < amountStrings; i++ {
		currentLen := len(strs[i])
		if min > currentLen {
			min = currentLen
		}
	}

	return min
}

func getMaxLen(strs []string) int {
	amountStrings := len(strs)
	max := 0

	for i := 0; i < amountStrings; i++ {
		currentLen := len(strs[i])
		if max < currentLen {
			max = currentLen
		}
	}

	return max
}
