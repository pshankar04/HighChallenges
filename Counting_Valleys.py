import math
import os
import random
import re
import sys

# Complete the countingValleys function below.
def countingValleys(n, s):
	down = 0
	up = 0
	valley = 0
	valleyPos = 0

	for i in range(0,n):
		if s[i] == 'U':
			up += 1
			if up == 0:
				valley += 1

		elif s[i] == 'D':
			up -= 1
			
	return valley
			


if __name__ == '__main__':

    n = int(input())

    s = input()

    result = countingValleys(n, s)
