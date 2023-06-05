/*
Dev Practice - Gas Station:

	There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].

	You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station.
	You begin the journey with an empty tank at one of the gas stations.

	Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once
	in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique



	Example 1:
	Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
	Output: 3
	Explanation:
		Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
		Travel to station 4. Your tank = 4 - 1 + 5 = 8
		Travel to station 0. Your tank = 8 - 2 + 1 = 7
		Travel to station 1. Your tank = 7 - 3 + 2 = 6
		Travel to station 2. Your tank = 6 - 4 + 3 = 5
		Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
	Therefore, return 3 as the starting index.

	Example 2:
	Input: gas = [2,3,4], cost = [3,4,3]
	Output: -1
	Explanation:
		You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
		Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
		Travel to station 0. Your tank = 4 - 3 + 2 = 3
		Travel to station 1. Your tank = 3 - 3 + 3 = 3
		You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
		Therefore, you can't travel around the circuit once no matter where you start.


	Constraints:
		n == gas.length == cost.length
		1 <= n <= 105
		0 <= gas[i], cost[i] <= 104

*/

package main

import (
	"fmt"
)

func main() {
	fmt.Println("Response: ", canCompleteCircuit([]int{1, 2, 3, 4, 5}, []int{3, 4, 5, 1, 2})) // response 3
	fmt.Println("Response: ", canCompleteCircuit([]int{5, 1, 2, 3, 4}, []int{4, 4, 1, 5, 1})) // response 4
	fmt.Println("Response: ", canCompleteCircuit([]int{2, 3, 4}, []int{3, 4, 3}))             // response -1
	fmt.Println("Response: ", canCompleteCircuit([]int{5, 8, 2, 8}, []int{6, 5, 6, 6}))       // response 3
	fmt.Println("Response: ", canCompleteCircuit([]int{1, 1, 3}, []int{2, 2, 1}))             // response 2
	fmt.Println("Response: ", canCompleteCircuit([]int{5}, []int{4}))                         // response 0
}

func canCompleteCircuit(gas []int, cost []int) int {
	response := -1
	lenArray := len(gas)

	if 1 == lenArray {
		if 0 <= gas[0]-cost[0] {
			response = 0
		}
		return response
	}

	for i := 0; i < lenArray; i++ {
		if 0 != gas[i] {
			if canCompleteCircuitAtPos(gas, cost, i, lenArray) {
				response = i
				break
			}
		}
	}

	return response
}

func canCompleteCircuitAtPos(gas []int, cost []int, startingPos int, lenArray int) bool {
	var currentPos int
	var prevPos int
	response := true
	amountGas := 0
	// fmt.Println("startingPos: ", startingPos)

	for i := 0; i <= lenArray; i++ {

		if startingPos+i < lenArray {
			currentPos = startingPos + i
			prevPos = currentPos - 1
		} else if prevPos == lenArray-2 {
			currentPos = 0
			prevPos = lenArray - 1
		} else if currentPos < lenArray {
			currentPos++
			prevPos = currentPos - 1
		}

		// The above prevPos is faster but this one is easier to read
		// if currentPos-1 >= 0 {
		// 	prevPos = currentPos - 1
		// } else {
		// 	prevPos = lenArray - 1
		// }

		// fmt.Println("-currentPos: ", currentPos)
		// fmt.Println("prevPos: ", prevPos)
		// fmt.Println("amountGas: ", amountGas)

		if 0 == i {
			amountGas += gas[currentPos]
		} else {
			amountGas += gas[currentPos] - cost[prevPos]
		}
		// fmt.Println("amountGas: ", amountGas)

		if amountGas < cost[currentPos] {
			response = false
			break
		}
	}

	// fmt.Println("\n")
	return response
}
