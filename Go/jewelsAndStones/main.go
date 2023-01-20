/*
Dev Practice - Jewels and Stones:

	You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have.
	Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.

	Letters are case sensitive, so "a" is considered a different type of stone from "A".

	Input: jewels = "aA", stones = "aAAbbbb"
	Output: 3

	Input: jewels = "z", stones = "ZZ"
	Output: 0
*/

package main

import (
	"fmt"
	"strings"
)

func main() {
	fmt.Println("Response: ", numJewelsInStones("aA", "aAAbbbb"))    // response 3
	fmt.Println("Response: ", numJewelsInStones("aAb", "aAAbCCcCB")) // response 4
}

func numJewelsInStones(jewels string, stones string) int {
	response := 0
	jewelsArray := strings.Split(jewels, "")

	for _, jewel := range jewelsArray {
		if strings.Contains(stones, jewel) {
			response += strings.Count(stones, jewel)
		}
	}

	return response
}
