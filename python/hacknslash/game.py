# -*- coding: utf-8 -*-

from character import Character
from monster import Goblin
from monster import Troll
from monster import Dragon


class Game:
	def set_up(self):
		self.player = Character()
		self.monsters = [
			Goblin(),
			Troll(),
			Dragon()
		]

	def get_next_monster(self):
		try:
			return self.monsters.pop(0)
		except IndexError:
			return None

	def monster_turn(self):
		if self.monster.attack():
			if self.player.dodge():
				print("{} vous attaque mais vous evitez le coup".format(self.monster))
			else:
				print("{} vous attaque et vous n'esquivez pas le coup".format(self.monster))
				self.player.hit_points -= 1
		else:
			print("{} n'a pas réussi à vous attaquer".format(self.monster))

	def choose_action(self):
		action = input("Choose your action : [A]ttack, [R]est, [Q]uit: ").lower()

		if action in 'arq':
			if action == 'a':
				return 'attack'
			elif action == 'r':
				return 'rest'
			else:
				return 'quit'
		else:
			return self.choose_action()

	def player_turn(self):
		action = self.choose_action()

		if action == "attack":
			if self.player.attack():
				if self.monster.dodge():
					print("Vous attaquez {} mais il arrive a esquiver".format(self.monster))
				else:
					print("Vous attaquez {} et lui enlevez 1 hp".format(self.monster))
					if self.monster.hit_points > 1:
						self.monster.hit_points -= 1
					else:
						self.clean_up()
			else:
				print("Vous ratez votre attaque")
		elif action == "rest":
			self.player.rest()
		else:
			self.quit()
		
	def clean_up(self):
		self.player.add_experience(self.monster.experience)
		print("Vous avez vaincu la {}".format(self.monster))
		self.monster = self.get_next_monster()

	def quit(self):
		return

	def __init__(self):
		self.set_up()
		self.monster = self.get_next_monster()

		while self.player.hit_points and (self.monster or self.monsters):
			print(self.player)
			self.monster_turn()
			self.player_turn()

		if self.player.hit_points:
			print('You win')
		else:
			print('You lose')