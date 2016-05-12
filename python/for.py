list = ["hi", "Martin"]
for word in list:
	print(word)

for num in [1,2,3,4]:
	if not num % 2 == 0:
		print(num)

names = ['yolo', 'yili', 'QUIT', 'ntm']

for name in names:
	if name == 'QUIT':
		break
	elif name == 'yolo':
		continue
	print(name)