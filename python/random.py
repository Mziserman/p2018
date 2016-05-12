import random

number = random.randint(0, 100)


print("Guess the number")
while True:
	user_input = int(input("> ")) 

	if (user_input > number):
		print("too high")
	elif (user_input < number):
		print("too low")
	else:
		print("gg")