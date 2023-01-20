/*
Dev Practice - Fruit Into Baskets:

	You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i]
	is the type of fruit the ith tree produces.

	You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

	You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
	Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right.
	The picked fruits must fit in one of your baskets.
	Once you reach a tree with fruit that cannot fit in your baskets, you must stop.

	Given the integer array fruits, return the maximum number of fruits you can pick.
*/

package main

import (
	"fmt"
)

func main() {
	// fmt.Println("Response: ", totalFruit([]int{1,2,1}))						// response 3
	// fmt.Println("Response: ", totalFruit([]int{0,1,2,2}))					// response 3
	// fmt.Println("Response: ", totalFruit([]int{1,2,3,2,2}))					// response 4
	// fmt.Println("Response: ", totalFruit([]int{3,3,3,1,2,1,1,2,3,3,4}))			// response 5
	// fmt.Println("Response: ", totalFruit([]int{1,1}))						// response 2
	fmt.Println("Response: ", totalFruit([]int{0,0,1,1}))						// response 4
	// fmt.Println("Response: ", totalFruit([]int{1,2,3,2,2,3,4}))
}

func totalFruit(fruits []int) int {
	response := 0
	currentFruitsAmount := 1
	prevFruitType := -1
	fruitTypes := [2]int{-1,-1} //var fruitTypes [2]int
	// fmt.Println("fruits:", fruits)

	if 1 == len(fruits) {
		return 1
	}

	for _, value := range fruits {
		if contains(fruitTypes, value) {
			currentFruitsAmount++
			fmt.Println("Contains value:", value, " currentFruitsAmount:", currentFruitsAmount)
		} else {
			fruitTypes = updateFruitTypes(fruitTypes, value, prevFruitType)
			fmt.Println("addAndSwipe:", fruitTypes)

			if response < currentFruitsAmount && !contains(fruitTypes, -1) {
				fmt.Println("if")
				response = currentFruitsAmount
				currentFruitsAmount = 2
			}

			if contains(fruitTypes, -1) {
				fmt.Println("if 2")
				currentFruitsAmount++
			}
		}

		fmt.Println("value:", value)
		prevFruitType = value
	}

	if response < currentFruitsAmount {
		response = currentFruitsAmount
	}

	return response
}

//Slice Contains
func contains(slice [2]int, valueToFind int) bool {
	for _, val := range slice {
		if val == valueToFind {
			return true
		}
	}
	return false
}

//Updates the slice to have the 2 values that are next to each other
func updateFruitTypes(slice [2]int, valueToAdd int, prevFruitType int) [2]int {
	if prevFruitType == slice[0] {
		slice[1] = valueToAdd
	} else {
		slice[0] = valueToAdd
	}

	return slice
}
