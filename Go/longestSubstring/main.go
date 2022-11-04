/*
Dev Practice - Longest Substring:

	Given a string s, find the length of the longest substring without repeating characters.

	Input: s = "abcabcbb"
	Output: 3
	Explanation: The answer is "abc", with the length of 3.
*/

package main

import (
	"fmt"
	"strconv"
	"strings"
)

func main() {
	fmt.Println("Response: ", lengthOfLongestSubstring("pwwkew")) // response 3 -- The answer is "wke", with the length of 3.
	// fmt.Println("Response: ", lengthOfLongestSubstring("dvdf")) // response 3
}

func lengthOfLongestSubstring(s string) int {
	response := 0
	currentMapPos := 0
	finalList := map[int]string{0: ""}
	var skipList []int

	for _, char := range s {
		// value, isMapContainsKey := current_list[currentMapPos]
		for i, _ := range finalList {

			// fmt.Println("\ni:", i)
			// fmt.Println("finalList", finalList)
			// fmt.Println("skipList", skipList)

			if !checkIfInSkipList(i, skipList) {
				if strings.Contains(finalList[i], string(char)) {
					// fmt.Println("adding to skipList", i)
					skipList = append(skipList, i)
				} else {
					finalList[i] = finalList[i] + string(char)
				}
			}
		}
		currentMapPos++
		finalList[currentMapPos] = ""
	}

	for _, value := range finalList {
		length := len(value)
		if length > response {
			response = length
		}
	}

	// fmt.Println("skipList: ", skipList)
	// fmt.Println("finalList: ", finalList)

	return response
}

func checkIfInSkipList(valueToCheck int, skipList []int) bool {
	for _, listValue := range skipList {
		if listValue == valueToCheck {
			return true
		}
	}
	return false
}

// Not used functions but cool
func intToString(value int) string {
	return strconv.FormatInt(int64(value), 10)
}

func fillFinalList(finalList *map[int]string, len int) {
	for i := 0; i < len; i++ {
		(*finalList)[i] = ""
	}
}
