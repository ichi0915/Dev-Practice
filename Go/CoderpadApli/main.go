/*
Dev Practice - coderpad.io:

	Sample coderpad question

	Get the value closest to 0 from the Array given

*/

package main

import (
	"fmt"
	"math"
)

func main() {
	// fmt.Println("Response: ", ComputeClosestToZero([]int{7, -10, 13, 8, -1, 7})) // response -1
	// fmt.Println("Response: ", ComputeClosestToZero([]int{7, -10, 13, 8, -1, 7, 5, 0})) // response 0
	fmt.Println("Response: ", ComputeClosestToZero([]int{-5, -4, -2, 12, -40, 4, 2, 18, 11, 5})) // response 2
}

func ComputeClosestToZero(ts []int) int {

	response := 9999999
	for _, val := range ts {
		// println("val", float64(response), math.Abs(float64(val)))
		if math.Abs(float64(response)) >= math.Abs(float64(val)) {
			response = val
			if response == (val * -1) {
				response = val * -1
			}
		}
	}

	if response == 9999999 {
		response = 0
	}

	return response
}
