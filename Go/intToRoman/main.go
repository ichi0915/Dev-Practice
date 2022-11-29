/*
Dev Practice - Integer to Roman:

	Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

	Symbol       Value
	I             1
	V             5
	X             10
	L             50
	C             100
	D             500
	M             1000

	Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

	I can be placed before V (5) and X (10) to make 4 and 9.
	X can be placed before L (50) and C (100) to make 40 and 90.
	C can be placed before D (500) and M (1000) to make 400 and 900.

	Given an integer, convert it to a roman numeral.
*/

package main

import (
	"fmt"
	"strconv"
	"strings"
)

func main() {
	fmt.Println("Response: ", intToRoman(58)) 		// response LVIII --- L = 50, V = 5, III = 3.
	fmt.Println("Response: ", intToRoman(1994)) 	// response MCMXCIV --- M = 1000, CM = 900, XC = 90 and IV = 4.
}

func intToRoman(num int) string {
	response := ""
	counter := 0

	numString := intToString(num)
	amount := strings.Count(numString, "") - 2
	// fmt.Println("numString:", numString)

	for i := amount; i>=0; i-- {
		// fmt.Println("i:", i)
		response = getRoman([]rune(numString)[i], counter) + response
		counter+=1
	}

	return response
}

func intToString(value int) string {
	return strconv.FormatInt(int64(value), 10)
}

func getRoman(num rune, pos int) string {
	var response, one, five, nextOne string

	//convert the rune to int
	val, _ := strconv.Atoi(string(num))

	switch {
		case 0 == pos:
			one="I"
			five="V"
			nextOne="X"
		case 1 == pos:
			one="X"
			five="L"
			nextOne="C"
		case 2 == pos:
			one="C"
			five="D"
			nextOne="M"
		default:
			one="M"
			five="V"
			nextOne="M"
	}

	// fmt.Println("pos:", pos)
	// fmt.Println("val:", val)
	// fmt.Println("one:", one)
	// fmt.Println("five:", five)

	if val < 4 {
		for i:=0; i<val; i++{
			response = response+ one
		}
	} else if val == 4 {
		response = one + five
	} else if val < 9 {
		response = five
		for i:=5; i<val; i++ {
			response = response+one
		}
	} else {
		response = one + nextOne
	}

	// fmt.Println("response:", response)
	return response
}
