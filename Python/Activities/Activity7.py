numbers = list(input("Enter sequence of number seperated by ,: ").split(","))	
sum = 0	
for number in numbers:	
 #Calculate Sum of numbers in the list
 sum += int(number)	
print(sum)