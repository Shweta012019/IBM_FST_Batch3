	
#  list of numbers	
numberList = list(input("Enter a sequence of numbers seperted by ,").split(","));
print("list = ", numberList) 		
# verify if first and last elements are qual
if (numberList[0] == numberList[-1]):	
    print(True)	
else:	
    print(False)