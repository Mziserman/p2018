import random

from combat import Combat

COLORS = ["yellow", "blue", "green"]


class Monster(Combat):
	min_hit_points = 1
	max_hit_points = 1
	min_experience = 1
	max_experience = 1
	weapon = "sword"
	sound = "roar"

	def __init__(self, **kwargs):
		self.base_hit_points = random.randint(self.min_hit_points, self.max_hit_points)
		self.experience = random.randint(self.min_experience, self.max_experience)
		self.color = random.choice(COLORS)
		self.hit_points = self.base_hit_points
		
		if kwargs is not None:
			for key, value in kwargs.items():
				setattr(self, key, value)

	def __str__(self):
		return "{}, {}, HP: {}/{}, XP: {}".format(self.color.title(), self.__class__.__name__, self.hit_points, self.base_hit_points, self.experience)

	def battle_cry(self):
		return self.sound.upper()

class Goblin(Monster):
	max_hit_points = 3
	max_experience = 3
	sound = "squeak"
	pass

class Troll(Monster):
	min_hit_points = 5
	max_hit_points = 10
	min_experience = 5
	max_experience = 10
	sound = 'growl'
	pass

class Dragon(Monster):
	min_hit_points = 20
	max_hit_points = 50
	min_experience = 20
	max_experience = 50
	sound = "rrrr"