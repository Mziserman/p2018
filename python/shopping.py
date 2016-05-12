my_list = []

def show_list():
	for item in my_list:
		print(item)

def show_help():
	print("Tapez DONE pour quitter, SHOW pour voir la liste et HELP pour afficher l'aide")

def add_article(article):
	my_list.append(article)
	print("{} items. Dernier : {}".format(len(my_list), article))

show_help()

while True:
	try:
		item = input('>> ')

		if item == "DONE":
			show_list();
			break
		elif item == "SHOW":
			show_list()
			continue
		elif item == "HELP":
			show_help()
			continue
		else:
			add_article(item)

	except NameError:
		print('N\'oubliez pas les guillemets')

