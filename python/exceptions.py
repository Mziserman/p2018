try:
	count = int(input('give me a number: '))
except ValueError:
	print("That's not a number")
else:
	print("hi" * count)