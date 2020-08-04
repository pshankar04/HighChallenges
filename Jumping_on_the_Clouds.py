import math
import os
import random
import re
import sys

# Complete the jumpingOnClouds function below.
def jumpingOnClouds(c):
	jump = 0
	pos = 0
	totalItems = len(c)
	print("TOTAL",totalItems)

	while pos < (totalItems - 1):
		print(pos)
		if (pos < (totalItems - 1)) and  (pos + 2) < (totalItems) and c[pos + 2] == 0:
			jump += 1
			pos = pos + 2
		elif (pos < (totalItems - 1)) and c[pos + 1] == 0:
			jump += 1
			pos = pos + 1
		else:
			pos = pos + 1
				

	return jump			

		

if __name__ == '__main__':
	bitsArray = [

					 0,1,0,0,0,0,0,1,0,1,
					 0,0,0,1,0,0,1,0,1,0,
					 0,0,0,1,0,0,1,0,0,1,
					 0,1,0,1,0,1,0,0,0,1,
					 0,1,0,0,0,1,0,1,0,1,
					 0,0,0,1,0,1,0,0,0,1,
					 0,1,0,0,0,1,0,0,1,0,
					 1,0,1,0,1,0,1,0,1,0,
					 1,0,0,1,0,1,0,1,0,1,
					 0,0,0,0,0,0,1,0,0,0

				 ]
	result = jumpingOnClouds(bitsArray)
	print("Minimum Jumps required: ",result)


    