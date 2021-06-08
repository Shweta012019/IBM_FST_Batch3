fruits = {
    "mango": 100,
    "banana": 150,
    "orange": 80,
    "apple": 158
}
key_to_check = input("Enter fruit name that you want to buy? ").lower()
if(key_to_check in fruits):
    print(key_to_check,"this is available")
else:
    print(key_to_check,"this is not available")
